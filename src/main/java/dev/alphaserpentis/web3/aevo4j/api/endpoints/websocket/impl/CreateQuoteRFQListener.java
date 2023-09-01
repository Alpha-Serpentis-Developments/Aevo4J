package dev.alphaserpentis.web3.aevo4j.api.endpoints.websocket.impl;

import dev.alphaserpentis.web3.aevo4j.data.misc.SignedOrder;
import dev.alphaserpentis.web3.aevo4j.data.request.wss.PublishWebSocketRequest;
import dev.alphaserpentis.web3.aevo4j.data.request.wss.QuoteRFQ;
import dev.alphaserpentis.web3.aevo4j.data.request.wss.WebSocketOperations;
import dev.alphaserpentis.web3.aevo4j.data.response.wss.CreatedQuoteRFQ;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;

import java.time.Instant;
import java.util.Objects;

public class CreateQuoteRFQListener extends PrivateListener<CreatedQuoteRFQ> {
    public CreateQuoteRFQListener(
            @NonNull String apiKey,
            @NonNull String apiSecret,
            boolean authorizeOnConnect,
            boolean isTestnet,
            @NonNull QuoteRFQ quoteRFQ
    ) {
        super(
                WebSocketOperations.CREATE_QUOTE_RFQ.getOperation(),
                apiKey,
                apiSecret,
                isTestnet,
                authorizeOnConnect,
                CreatedQuoteRFQ.class
        );

        this.sendWebSocketRequest(
                new PublishWebSocketRequest<>(
                        WebSocketOperations.CREATE_QUOTE_RFQ,
                        quoteRFQ
                )
        );
    }

    public CreateQuoteRFQListener(
            @NonNull String apiKey,
            @NonNull String apiSecret,
            boolean authorizeOnConnect,
            boolean isTestnet,
            @NonNull String rfqBlockId,
            @NonNull String instrumentId,
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
                WebSocketOperations.CREATE_QUOTE_RFQ.getOperation(),
                apiKey,
                apiSecret,
                isTestnet,
                authorizeOnConnect,
                CreatedQuoteRFQ.class
        );

        SignedOrder signedOrder = new SignedOrder.Builder(
                Integer.parseInt(instrumentId),
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
                .build();
        QuoteRFQ quoteRfq = new QuoteRFQ(
                rfqBlockId,
                new SignedOrder[] {signedOrder}
        );

        this.sendWebSocketRequest(
                new PublishWebSocketRequest<>(
                        WebSocketOperations.CREATE_QUOTE_RFQ,
                        quoteRfq
                )
        );
    }

    public CreateQuoteRFQListener(
            @NonNull String apiKey,
            @NonNull String apiSecret,
            boolean authorizeOnConnect,
            boolean isTestnet,
            @NonNull String rfqBlockId,
            @NonNull String instrumentId,
            @NonNull String maker,
            boolean isBuy,
            long amount,
            long limitPrice,
            long salt,
            @NonNull String signature
    ) {
        this(
                apiKey,
                apiSecret,
                authorizeOnConnect,
                isTestnet,
                rfqBlockId,
                instrumentId,
                maker,
                isBuy,
                amount,
                limitPrice,
                salt,
                null,
                signature,
                null,
                null,
                null
        );
    }
}
