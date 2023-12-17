package dev.alphaserpentis.web3.aevo4j.api.endpoints.websocket.impl;

import dev.alphaserpentis.web3.aevo4j.data.misc.RfqBlockId;
import dev.alphaserpentis.web3.aevo4j.data.request.wss.PublishWebSocketRequest;
import dev.alphaserpentis.web3.aevo4j.data.request.wss.WebSocketOperations;
import dev.alphaserpentis.web3.aevo4j.data.response.wss.CancelledRFQ;
import io.reactivex.rxjava3.annotations.NonNull;

public class CancelRFQListener extends PrivateListener<CancelledRFQ> {
    public CancelRFQListener(
            @NonNull String apiKey,
            @NonNull String apiSecret,
            boolean isTestnet,
            @NonNull String rfqId
    ) {
        super(
                WebSocketOperations.CANCEL_RFQ.getOperation(),
                apiKey,
                apiSecret,
                isTestnet,
                CancelledRFQ.class,
                null
        );

        this.sendWebSocketRequest(
                new PublishWebSocketRequest<>(
                        WebSocketOperations.CANCEL_RFQ,
                        new RfqBlockId(rfqId)
                )
        );
    }
}
