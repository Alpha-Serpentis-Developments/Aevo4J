package dev.alphaserpentis.web3.aevo4j.api.endpoints.websocket;

import dev.alphaserpentis.web3.aevo4j.api.endpoints.websocket.impl.CancelAllOrdersListener;
import dev.alphaserpentis.web3.aevo4j.api.endpoints.websocket.impl.CancelOrderListener;
import dev.alphaserpentis.web3.aevo4j.api.endpoints.websocket.impl.CancelRFQListener;
import dev.alphaserpentis.web3.aevo4j.api.endpoints.websocket.impl.CreateOrderListener;
import dev.alphaserpentis.web3.aevo4j.api.endpoints.websocket.impl.CreateQuoteRFQListener;
import dev.alphaserpentis.web3.aevo4j.api.endpoints.websocket.impl.CreateRFQListener;
import dev.alphaserpentis.web3.aevo4j.api.endpoints.websocket.impl.EditOrderListener;
import dev.alphaserpentis.web3.aevo4j.api.endpoints.websocket.impl.FillsListener;
import dev.alphaserpentis.web3.aevo4j.api.endpoints.websocket.impl.OrdersListener;
import dev.alphaserpentis.web3.aevo4j.api.endpoints.websocket.impl.PositionsListener;
import dev.alphaserpentis.web3.aevo4j.api.endpoints.websocket.impl.StatusListener;
import dev.alphaserpentis.web3.aevo4j.data.misc.SignedOrder;
import dev.alphaserpentis.web3.aevo4j.data.request.wss.QuoteRFQ;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;

/**
 * Class to easily grab the private websockets.
 *
 * @see <a href="https://api-docs.aevo.xyz/reference/websocket-authentication">Aevo - Websocket Authentication</a>
 */
public class PrivateWebSockets {
    private String apiKey;
    private String apiSecret;
    private boolean authorizeOnConnect;

    public PrivateWebSockets(@NonNull String apiKey, @NonNull String apiSecret, boolean authorizeOnConnect) {
        this.apiKey = apiKey;
        this.apiSecret = apiSecret;
        this.authorizeOnConnect = authorizeOnConnect;
    }

    public void setApiKey(@NonNull String apiKey) {
        this.apiKey = apiKey;
    }

    public void setApiSecret(@NonNull String apiSecret) {
        this.apiSecret = apiSecret;
    }

    public void setAuthorizeOnConnect(boolean authorizeOnConnect) {
        this.authorizeOnConnect = authorizeOnConnect;
    }

    @NonNull
    public StatusListener status(boolean isTestnet) {
        return new StatusListener(apiKey, apiSecret, authorizeOnConnect, isTestnet);
    }

    @NonNull
    public CreateOrderListener createOrder(
            boolean isTestnet,
            @NonNull Integer instrumentId,
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
        return new CreateOrderListener(
                apiKey,
                apiSecret,
                authorizeOnConnect,
                isTestnet,
                instrumentId,
                maker,
                isBuy,
                amount,
                limitPrice,
                salt,
                timestamp,
                signature,
                postOnly,
                timeInForce,
                mmp
        );
    }

    @NonNull
    public CreateOrderListener createOrder(
            boolean isTestnet,
            @NonNull SignedOrder signedOrder
    ) {
        return new CreateOrderListener(
                apiKey,
                apiSecret,
                authorizeOnConnect,
                isTestnet,
                signedOrder
        );
    }

    @NonNull
    public EditOrderListener editOrder(
            boolean isTestnet,
            @NonNull Integer instrumentId,
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
        return new EditOrderListener(
                apiKey,
                apiSecret,
                authorizeOnConnect,
                isTestnet,
                instrumentId,
                maker,
                isBuy,
                amount,
                limitPrice,
                salt,
                timestamp,
                signature,
                postOnly,
                timeInForce,
                mmp
        );
    }

    @NonNull
    public EditOrderListener editOrder(
            boolean isTestnet,
            @NonNull SignedOrder signedOrder
    ) {
        return new EditOrderListener(
                apiKey,
                apiSecret,
                authorizeOnConnect,
                isTestnet,
                signedOrder
        );
    }

    @NonNull
    public CancelOrderListener cancelOrder(
            boolean isTestnet,
            @NonNull String orderId
    ) {
        return new CancelOrderListener(
                apiKey,
                apiSecret,
                authorizeOnConnect,
                isTestnet,
                orderId
        );
    }

    @NonNull
    public CancelAllOrdersListener cancelAllOrders(
            boolean isTestnet,
            @Nullable String instrumentType
    ) {
        return new CancelAllOrdersListener(
                apiKey,
                apiSecret,
                authorizeOnConnect,
                isTestnet,
                instrumentType
        );
    }

    @NonNull
    public CancelAllOrdersListener cancelAllOrders(
            boolean isTestnet
    ) {
        return new CancelAllOrdersListener(
                apiKey,
                apiSecret,
                authorizeOnConnect,
                isTestnet
        );
    }

    @NonNull
    public CreateRFQListener createRFQ(
            boolean isTestnet,
            @NonNull Integer instrumentId,
            @NonNull String amount
    ) {
        return new CreateRFQListener(
                apiKey,
                apiSecret,
                authorizeOnConnect,
                isTestnet,
                instrumentId,
                amount
        );
    }

    @NonNull
    public CancelRFQListener cancelRFQ(
            boolean isTestnet,
            @NonNull String rfqId
    ) {
        return new CancelRFQListener(
                apiKey,
                apiSecret,
                authorizeOnConnect,
                isTestnet,
                rfqId
        );
    }

    @NonNull
    public CreateQuoteRFQListener createQuoteRFQ(
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
        return new CreateQuoteRFQListener(
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
                timestamp,
                signature,
                postOnly,
                timeInForce,
                mmp
        );
    }

    @NonNull
    public CreateQuoteRFQListener createQuoteRFQ(
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
        return new CreateQuoteRFQListener(
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

    @NonNull
    public CreateQuoteRFQListener createQuoteRFQ(
            boolean isTestnet,
            @NonNull QuoteRFQ quoteRFQ
    ) {
        return new CreateQuoteRFQListener(
                apiKey,
                apiSecret,
                authorizeOnConnect,
                isTestnet,
                quoteRFQ
        );
    }

    @NonNull
    public OrdersListener orders(boolean isTestnet) {
        return new OrdersListener(
                apiKey,
                apiSecret,
                authorizeOnConnect,
                isTestnet
        );
    }

    @NonNull
    public FillsListener fills(boolean isTestnet) {
        return new FillsListener(
                apiKey,
                apiSecret,
                authorizeOnConnect,
                isTestnet
        );
    }

    @NonNull
    public PositionsListener positions(boolean isTestnet) {
        return new PositionsListener(
                apiKey,
                apiSecret,
                authorizeOnConnect,
                isTestnet
        );
    }
}
