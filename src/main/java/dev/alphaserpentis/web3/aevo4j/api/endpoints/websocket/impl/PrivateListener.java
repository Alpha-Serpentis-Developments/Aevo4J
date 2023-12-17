package dev.alphaserpentis.web3.aevo4j.api.endpoints.websocket.impl;

import dev.alphaserpentis.web3.aevo4j.data.request.wss.ChannelName;
import dev.alphaserpentis.web3.aevo4j.data.request.wss.PublishWebSocketRequest;
import dev.alphaserpentis.web3.aevo4j.data.request.wss.WebSocketOperations;
import dev.alphaserpentis.web3.aevo4j.data.request.wss.WebsocketAuthData;
import dev.alphaserpentis.web3.aevo4j.data.response.wss.Response;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;

public abstract class PrivateListener<T extends Response<?>> extends AevoListener<T> {
    /**
     * The operation this listener is assigned to
     */
    private final String op;
    /**
     * The API key
     */
    private final String apiKey;
    /**
     * The API secret
     */
    private final String apiSecret;

    public PrivateListener(
            @NonNull String op,
            @NonNull String apiKey,
            @NonNull String apiSecret,
            boolean isTestnet,
            @NonNull Class<T> clazz,
            @Nullable ChannelName.ChannelType channelAllowed
    ) {
        super(clazz, channelAllowed);

        this.op = op;
        this.apiKey = apiKey;
        this.apiSecret = apiSecret;

        this.openWebSocket(isTestnet);

        sendWebSocketRequest(
                new PublishWebSocketRequest<>(
                        WebSocketOperations.AUTH,
                        GSON.toJson(
                                new WebsocketAuthData(
                                        apiKey,
                                        apiSecret
                                )
                        )
                )
        );
    }

    public PrivateListener(
            @NonNull String op,
            @NonNull String apiKey,
            @NonNull String apiSecret,
            boolean isTestnet,
            @NonNull Class<T> clazz
    ) {
        this(op, apiKey, apiSecret, isTestnet, clazz, null);
    }

    @Override
    public void sendWebSocketRequest(@NonNull PublishWebSocketRequest<?> request) {
        if(this.webSocket == null)
            throw new IllegalStateException("WebSocket is not open");

        webSocket.send(request.toString());
    }
}
