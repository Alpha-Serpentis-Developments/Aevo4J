package dev.alphaserpentis.web3.aevo4j.api.endpoints.websocket;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import dev.alphaserpentis.web3.aevo4j.data.response.wss.AevoWebSocketError;
import dev.alphaserpentis.web3.aevo4j.data.response.wss.Ack;
import dev.alphaserpentis.web3.aevo4j.data.response.wss.Response;
import dev.alphaserpentis.web3.aevo4j.exception.AevoWebSocketException;
import io.reactivex.rxjava3.annotations.CheckReturnValue;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.BackpressureStrategy;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.subjects.PublishSubject;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;

/**
 * Base class for all Aevo WebSocket listeners
 * @param <T> Response type
 */
public abstract class AevoListener<T extends Response<?>> extends WebSocketListener {

    private final Gson GSON = new Gson();
    /**
     * Class of the response to deserialize the incoming JSON responses into
     */
    protected final Class<T> clazz;
    /**
     * {@link PublishSubject} to emit the parsed responses to
     */
    protected final PublishSubject<T> subject = PublishSubject.create();

    public AevoListener(@NonNull Class<T> clazz) {
        this.clazz = clazz;
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

    @Override
    @SuppressWarnings("unchecked")
    public void onMessage(@NonNull WebSocket webSocket, @NonNull String response) {
        try {
            Response<?> parsed = parseString(response);

            if(!(parsed instanceof Ack)) {
                subject.onNext((T) parsed);
            }
        } catch(Exception e) {
            subject.onError(e);
            webSocket.close(1000, "Unhandled exception");
        }
    }

    @Override
    public void onClosed(@NonNull WebSocket webSocket, int code, @NonNull String reason) {
        subject.onComplete();
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
