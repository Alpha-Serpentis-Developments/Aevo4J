package dev.alphaserpentis.web3.aevo4j.api.endpoints.websocket.impl;

import dev.alphaserpentis.web3.aevo4j.data.misc.SignedOrder;
import dev.alphaserpentis.web3.aevo4j.data.request.wss.PublishWebSocketRequest;
import dev.alphaserpentis.web3.aevo4j.data.request.wss.WebSocketOperations;
import dev.alphaserpentis.web3.aevo4j.data.response.wss.CreatedOrder;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;

import java.time.Instant;
import java.util.Objects;

public class CreateOrderListener extends PrivateListener<CreatedOrder> {

    public CreateOrderListener(
            @NonNull String apiKey,
            @NonNull String apiSecret,
            boolean isTestnet,
            long instrumentId,
            @NonNull String maker,
            boolean isBuy,
            long amount,
            long limitPrice,
            long salt,
            @Nullable Long timestamp,
            @NonNull String signature,
            @Nullable Boolean postOnly,
            @Nullable String timeInForce,
            @Nullable Boolean mmp
    ) {
        super(
                apiKey,
                apiSecret,
                isTestnet,
                CreatedOrder.class,
                null
        );

        this.sendWebSocketRequest(
                new PublishWebSocketRequest<>(
                        WebSocketOperations.CREATE_ORDER,
                        new SignedOrder.Builder(
                                instrumentId,
                                maker,
                                isBuy,
                                amount,
                                limitPrice,
                                salt,
                                Objects.requireNonNullElse(timestamp, Instant.now().getEpochSecond()),
                                signature
                        )
                                .postOnly(postOnly)
                                .timeInForce(timeInForce)
                                .mmp(mmp)
                                .build()
                )
        );
    }

    public CreateOrderListener(
            @NonNull String apiKey,
            @NonNull String apiSecret,
            boolean isTestnet,
            @NonNull SignedOrder signedOrder
    ) {
        super(
                apiKey,
                apiSecret,
                isTestnet,
                CreatedOrder.class,
                null
        );

        this.sendWebSocketRequest(
                new PublishWebSocketRequest<>(
                        WebSocketOperations.CREATE_ORDER,
                        signedOrder
                )
        );
    }
}
