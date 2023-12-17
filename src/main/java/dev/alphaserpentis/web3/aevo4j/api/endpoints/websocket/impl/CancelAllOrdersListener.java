package dev.alphaserpentis.web3.aevo4j.api.endpoints.websocket.impl;

import dev.alphaserpentis.web3.aevo4j.data.request.wss.InstrumentType;
import dev.alphaserpentis.web3.aevo4j.data.request.wss.PublishWebSocketRequest;
import dev.alphaserpentis.web3.aevo4j.data.request.wss.WebSocketOperations;
import dev.alphaserpentis.web3.aevo4j.data.response.wss.CancelledAllOrders;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;

/**
 * @see <a href="https://api-docs.aevo.xyz/reference/publish-cancel-all-orders">Aevo - PUBLISH Cancel All Orders</a>
 */
public class CancelAllOrdersListener extends PrivateListener<CancelledAllOrders> {
    public CancelAllOrdersListener(
            @NonNull String apiKey,
            @NonNull String apiSecret,
            boolean isTestnet,
            @Nullable String instrumentType
    ) {
        super(
                WebSocketOperations.CANCEL_ALL_ORDERS.getOperation(),
                apiKey,
                apiSecret,
                isTestnet,
                CancelledAllOrders.class
        );

        this.sendWebSocketRequest(
                new PublishWebSocketRequest<>(
                        WebSocketOperations.CANCEL_ALL_ORDERS,
                        new InstrumentType(instrumentType)
                )
        );
    }

    public CancelAllOrdersListener(
            @NonNull String apiKey,
            @NonNull String apiSecret,
            boolean isTestnet
    ) {
        this(apiKey, apiSecret, isTestnet, null);
    }
}
