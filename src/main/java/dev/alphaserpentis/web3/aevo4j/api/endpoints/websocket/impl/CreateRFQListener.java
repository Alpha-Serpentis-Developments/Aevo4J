package dev.alphaserpentis.web3.aevo4j.api.endpoints.websocket.impl;

import dev.alphaserpentis.web3.aevo4j.data.request.wss.CreateRFQ;
import dev.alphaserpentis.web3.aevo4j.data.request.wss.PublishWebSocketRequest;
import dev.alphaserpentis.web3.aevo4j.data.request.wss.WebSocketOperations;
import dev.alphaserpentis.web3.aevo4j.data.response.wss.CreatedRFQ;
import io.reactivex.rxjava3.annotations.NonNull;

/**
 * @see <a href="https://api-docs.aevo.xyz/reference/publish-create-rfq">Aevo - PUBLISH Create RFQ</a>
 */
public class CreateRFQListener extends PrivateListener<CreatedRFQ> {
    public CreateRFQListener(
            @NonNull String apiKey,
            @NonNull String apiSecret,
            boolean authorizeOnConnect,
            boolean isTestnet,
            long instrumentId,
            @NonNull String amount
    ) {
        super(
                WebSocketOperations.CREATE_RFQ.getOperation(),
                apiKey,
                apiSecret,
                isTestnet,
                authorizeOnConnect,
                CreatedRFQ.class,
                null
        );

        this.sendWebSocketRequest(
                new PublishWebSocketRequest<>(
                        WebSocketOperations.CREATE_RFQ,
                        new CreateRFQ(
                                instrumentId,
                                amount
                        )
                )
        );
    }
}
