package dev.alphaserpentis.web3.aevo4j.api.endpoints.websocket.impl;

import dev.alphaserpentis.web3.aevo4j.data.request.wss.OrderId;
import dev.alphaserpentis.web3.aevo4j.data.request.wss.PublishWebSocketRequest;
import dev.alphaserpentis.web3.aevo4j.data.request.wss.WebSocketOperations;
import dev.alphaserpentis.web3.aevo4j.data.response.wss.CancelledOrder;
import io.reactivex.rxjava3.annotations.NonNull;

public class CancelOrderListener extends PrivateListener<CancelledOrder> {
    public CancelOrderListener(
            @NonNull String apiKey,
            @NonNull String apiSecret,
            boolean isTestnet,
            @NonNull String orderId
    ) {
        super(
                WebSocketOperations.CANCEL_ORDER.getOperation(),
                apiKey,
                apiSecret,
                isTestnet,
                CancelledOrder.class,
                null
        );

        this.sendWebSocketRequest(
                new PublishWebSocketRequest<>(
                        WebSocketOperations.CANCEL_ORDER,
                        new OrderId(orderId)
                )
        );
    }
}
