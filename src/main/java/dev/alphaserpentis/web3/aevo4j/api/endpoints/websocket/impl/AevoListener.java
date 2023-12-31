package dev.alphaserpentis.web3.aevo4j.api.endpoints.websocket.impl;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import dev.alphaserpentis.web3.aevo4j.data.request.wss.ChannelName;
import dev.alphaserpentis.web3.aevo4j.data.request.wss.PublishWebSocketRequest;
import dev.alphaserpentis.web3.aevo4j.data.request.wss.WebSocketOperations;
import dev.alphaserpentis.web3.aevo4j.data.request.wss.SubscribeWebSocketRequest;
import dev.alphaserpentis.web3.aevo4j.data.response.wss.Ack;
import dev.alphaserpentis.web3.aevo4j.data.response.wss.AevoWebSocketError;
import dev.alphaserpentis.web3.aevo4j.data.response.wss.Response;
import dev.alphaserpentis.web3.aevo4j.exception.AevoWebSocketException;
import dev.alphaserpentis.web3.aevo4j.handler.AevoHandler;
import io.reactivex.rxjava3.annotations.CheckReturnValue;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.BackpressureStrategy;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.subjects.PublishSubject;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;

import java.util.Arrays;

/**
 * Base class for all Aevo WebSocket listeners
 * @param <T> Response type
 */
public abstract class AevoListener<T extends Response<?>> extends WebSocketListener {

    protected final Gson GSON = new Gson();
    /**
     * Class of the response to deserialize the incoming JSON responses into
     */
    protected final Class<T> clazz;
    /**
     * {@link PublishSubject} to emit the parsed responses to
     */
    protected final PublishSubject<T> subject = PublishSubject.create();
    /**
     * {@link ChannelName.ChannelType} allowed for this listener
     */
    protected final ChannelName.ChannelType channelAllowed;
    /**
     * {@link WebSocket} this listener is attached to
     */
    protected WebSocket webSocket = null;

    /**
     * Creates a new {@link AevoListener} with the given response class
     * @param clazz Class of the response to deserialize the incoming JSON responses into
     * @param channelAllowed {@link ChannelName.ChannelType} allowed for this listener
     */
    public AevoListener(
            @NonNull Class<T> clazz,
            @Nullable ChannelName.ChannelType channelAllowed
    ) {
        this.clazz = clazz;
        this.channelAllowed = channelAllowed;
    }

    /**
     * Creates a new {@link AevoListener} with the given parameters and opens a new {@link WebSocket}
     * @param clazz Class of the response to deserialize the incoming JSON responses into
     * @param channelAllowed {@link ChannelName.ChannelType} allowed for this listener
     * @param operations {@link WebSocketOperations} to use
     * @param isTestnet Whether to use the testnet or not
     * @param symbols Symbols (e.g. "BTC-USD") to subscribe to
     */
    public AevoListener(
            @NonNull Class<T> clazz,
            @Nullable ChannelName.ChannelType channelAllowed,
            @NonNull WebSocketOperations operations,
            boolean isTestnet,
            @NonNull String... symbols
    ) {
        ChannelName[] arrayOfChannels = null;
        this.clazz = clazz;
        this.channelAllowed = channelAllowed;
        webSocket = AevoHandler.createNewWebSocket(this, isTestnet);

        if(channelAllowed != null) {
            arrayOfChannels = Arrays.stream(symbols)
                    .map(r -> new ChannelName(channelAllowed, r))
                    .toArray(ChannelName[]::new);
        }

        if(operations.equals(WebSocketOperations.SUBSCRIBE) || operations.equals(WebSocketOperations.UNSUBSCRIBE)) {
            sendWebSocketRequest(new SubscribeWebSocketRequest(operations, arrayOfChannels));
        } else {
            sendWebSocketRequest(new PublishWebSocketRequest<>(operations));
        }
    }

    /**
     * Creates a new {@link AevoListener} with the given parameters and opens a new {@link WebSocket}
     * @param clazz Class of the response to deserialize the incoming JSON responses into
     * @param channelAllowed {@link ChannelName.ChannelType} allowed for this listener
     * @param operations {@link WebSocketOperations} to use
     * @param isTestnet Whether to use the testnet or not
     * @param channels {@link ChannelName} to subscribe to
     */
    public AevoListener(
            @NonNull Class<T> clazz,
            @Nullable ChannelName.ChannelType channelAllowed,
            @NonNull WebSocketOperations operations,
            boolean isTestnet,
            @NonNull ChannelName... channels
    ) {
        this.clazz = clazz;
        this.channelAllowed = channelAllowed;
        webSocket = AevoHandler.createNewWebSocket(this, isTestnet);

        if(operations.equals(WebSocketOperations.SUBSCRIBE) || operations.equals(WebSocketOperations.UNSUBSCRIBE)) {
            sendWebSocketRequest(new SubscribeWebSocketRequest(operations, channels));
        } else {
            sendWebSocketRequest(new PublishWebSocketRequest<>(operations));
        }
    }

    /**
     * Returns a {@link Flowable} that emits the parsed response
     * @return {@link Flowable} with a {@link BackpressureStrategy#BUFFER}
     */
    @NonNull
    public Flowable<T> responseFlowable() {
        return subject.toFlowable(BackpressureStrategy.BUFFER);
    }

    /**
     * Returns a {@link Flowable} that emits the parsed response
     * @param strategy {@link BackpressureStrategy} to use
     * @return {@link Flowable} with the given {@link BackpressureStrategy}
     */
    @NonNull
    public Flowable<T> responseFlowable(@NonNull BackpressureStrategy strategy) {
        return subject.toFlowable(strategy);
    }

    @NonNull
    public ChannelName.ChannelType getChannelAllowed() {
        return channelAllowed;
    }

    /**
     * Returns the {@link WebSocket} this listener is attached to
     * @return {@link WebSocket}
     */
    @Nullable
    public WebSocket getWebSocket() {
        return webSocket;
    }

    /**
     * Opens a new {@link WebSocket} if it is not already open
     * @param isTestnet Whether to use the testnet or not
     * @return {@link WebSocket}
     */
    public WebSocket openWebSocket(boolean isTestnet) {
        if(webSocket == null) {
            webSocket = AevoHandler.createNewWebSocket(this, isTestnet);
        }

        return webSocket;
    }

    public void sendWebSocketRequest(@NonNull PublishWebSocketRequest<?> request) {
        if(webSocket == null) {
            throw new IllegalStateException("WebSocket is not open");
        }

        webSocket.send(request.toString());
    }

    public void sendWebSocketRequest(@NonNull SubscribeWebSocketRequest request) {
        if(webSocket == null) {
            throw new IllegalStateException("WebSocket is not open");
        }

        webSocket.send(request.toString());
    }

    /**
     * Clean way to unsubscribe from the given channels
     * @param channels {@link ChannelName} to unsubscribe from
     */
    public void unsubscribe(@NonNull ChannelName... channels) {
        sendWebSocketRequest(new SubscribeWebSocketRequest(WebSocketOperations.UNSUBSCRIBE, channels));
    }

    @Override
    public void onOpen(@NonNull WebSocket webSocket, @NonNull okhttp3.Response response) {
        this.webSocket = webSocket;
    }

    @Override
    public void onMessage(@NonNull WebSocket webSocket, @NonNull String response) {
        try {
            handleResponse(response);
        } catch(Exception e) {
            handleError(e);
        }
    }

    @Override
    public void onClosed(@NonNull WebSocket webSocket, int code, @NonNull String reason) {
        subject.onComplete();
    }

    @SuppressWarnings("unchecked")
    protected void handleResponse(@NonNull String response) {
        Response<?> parsed = parseString(response);

        if(!(parsed instanceof Ack)) {
            subject.onNext((T) parsed);
        }
    }

    protected void handleError(@NonNull Exception e) {
        subject.onError(e);
        webSocket.close(1000, "Unhandled exception");
    }

    /**
     * Parses the given string into the response class
     * @param string JSON to parse
     * @return {@link Response<T>} as defined in {@link AevoListener#clazz}, or potentially an {@link Ack}
     */
    @CheckReturnValue
    @NonNull
    protected Response<?> parseString(@NonNull String string) {
        try {
            return GSON.fromJson(string, clazz);
        } catch(JsonSyntaxException e) {
            try {
                return GSON.fromJson(string, Ack.class);
            } catch(JsonSyntaxException ignored) {
                throw new AevoWebSocketException(GSON.fromJson(string, AevoWebSocketError.class));
            }
        }
    }
}
