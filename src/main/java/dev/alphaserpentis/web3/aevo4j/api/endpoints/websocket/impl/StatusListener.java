package dev.alphaserpentis.web3.aevo4j.api.endpoints.websocket.impl;

import dev.alphaserpentis.web3.aevo4j.data.request.wss.PublishWebSocketRequest;
import dev.alphaserpentis.web3.aevo4j.data.request.wss.WebSocketOperations;
import dev.alphaserpentis.web3.aevo4j.data.response.wss.Status;
import io.reactivex.rxjava3.annotations.NonNull;

public class StatusListener extends PrivateListener<Status> {
    public StatusListener(
            @NonNull String apiKey,
            @NonNull String apiSecret,
            boolean authorizeOnConnect,
            boolean isTestnet
    ) {
        super(
                WebSocketOperations.STATUS.getOperation(),
                apiKey,
                apiSecret,
                isTestnet,
                authorizeOnConnect,
                Status.class,
                null
        );

        this.sendWebSocketRequest(
                new PublishWebSocketRequest<>(
                        WebSocketOperations.STATUS
                )
        );
    }
}
