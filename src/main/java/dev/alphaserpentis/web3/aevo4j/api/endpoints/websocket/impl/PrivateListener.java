package dev.alphaserpentis.web3.aevo4j.api.endpoints.websocket.impl;

import dev.alphaserpentis.web3.aevo4j.data.request.wss.ChannelName;
import dev.alphaserpentis.web3.aevo4j.data.request.wss.PublishWebSocketRequest;
import dev.alphaserpentis.web3.aevo4j.data.request.wss.WebSocketOperations;
import dev.alphaserpentis.web3.aevo4j.data.request.wss.WebsocketAuthData;
import dev.alphaserpentis.web3.aevo4j.data.response.wss.Response;
import dev.alphaserpentis.web3.aevo4j.handler.AevoHandler;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

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
    /**
     * Whether to authorize on connect.
     * <p>
     * If true, it will send an AUTH operation on connect. If not, it will sign every
     * request to the websocket instead
     */
    private final boolean authorizeOnConnect;

    public PrivateListener(
            @NonNull String op,
            @NonNull String apiKey,
            @NonNull String apiSecret,
            boolean isTestnet,
            boolean authorizeOnConnect,
            @NonNull Class<T> clazz,
            @Nullable ChannelName.ChannelType channelAllowed
    ) {
        super(clazz, channelAllowed);

        this.op = op;
        this.apiKey = apiKey;
        this.apiSecret = apiSecret;
        this.authorizeOnConnect = authorizeOnConnect;

        this.openWebSocket(isTestnet);

        if(authorizeOnConnect) {
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
    }

    public PrivateListener(
            @NonNull String op,
            @NonNull String apiKey,
            @NonNull String apiSecret,
            boolean isTestnet,
            boolean authorizeOnConnect,
            @NonNull Class<T> clazz
    ) {
        this(op, apiKey, apiSecret, isTestnet, authorizeOnConnect, clazz, null);
    }

    /**
     * Get the authorization signature to sign websocket requests with
     * @param timestamp Timestamp in nanoseconds
     * @param data Data to sign
     * @return Hexadecimal signature
     * @see <a href="https://api-docs.aevo.xyz/reference/websocket-authentication">Aevo - WebSocket Authentication</a>
     */
    public String getSignature(
            @NonNull String timestamp,
            @NonNull String data
    ) throws NoSuchAlgorithmException, InvalidKeyException {
        return AevoHandler.generateAuthSignature(
                Long.parseLong(timestamp),
                this.apiKey,
                this.apiSecret,
                "ws",
                this.op,
                data
        );
    }

    @Override
    public void sendWebSocketRequest(@NonNull PublishWebSocketRequest<?> request) {
        if(this.webSocket == null)
            throw new IllegalStateException("WebSocket is not open");

        if(!authorizeOnConnect) {
            String timestamp = AevoHandler.getTimestamp();

            try {
                String signature = getSignature(
                        timestamp,
                        Objects.requireNonNullElse(request.data(), "").toString()
                );

                webSocket.send(
                        new PublishWebSocketRequest<>(
                                request.op(),
                                request.data(),
                                request.id(),
                                new WebsocketAuthData(
                                        apiKey,
                                        signature,
                                        timestamp
                                )
                        ).toString()
                );
            } catch (NoSuchAlgorithmException | InvalidKeyException e) {
                throw new RuntimeException(e);
            }
        } else {
            webSocket.send(request.toString());
        }
    }
}
