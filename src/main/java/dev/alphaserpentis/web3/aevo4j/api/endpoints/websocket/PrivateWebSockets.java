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
@SuppressWarnings("unused")
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

    /**
     * Get the currently subscribed channels
     * @param isTestnet Whether to use the testnet
     * @return {@link StatusListener}
     * @see <a href="https://api-docs.aevo.xyz/reference/get-status">Aevo - PUBLISH Status</a>
     */
    @NonNull
    public StatusListener status(boolean isTestnet) {
        return new StatusListener(apiKey, apiSecret, isTestnet);
    }

    /**
     * Create an order
     * @param isTestnet Whether to use the testnet
     * @param instrumentId The instrument id
     * @param maker Account's Ethereum address
     * @param isBuy Whether the order is a buy or sell
     * @param amount Number of contracts in 6 decimal fixed number
     * @param limitPrice The limit price of the order in 6 decimal fixed number
     * @param salt Randomly generated number for the order
     * @param timestamp Unix timestamp in seconds
     * @param signature Signature of the order
     * @param postOnly Whether the order is post only
     * @param timeInForce Time in force of the order (GTC default)
     * @param mmp Flag to include the order into MMP (false by default)
     * @return {@link CreateOrderListener}
     * @see <a href="https://api-docs.aevo.xyz/reference/publish-create-order">Aevo - PUBLISH Create Order</a>
     */
    @NonNull
    public CreateOrderListener createOrder(
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
        return new CreateOrderListener(
                apiKey,
                apiSecret,
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

    /**
     * Create an order
     * @param isTestnet Whether to use the testnet
     * @param signedOrder The signed order
     * @return {@link CreateOrderListener}
     * @see <a href="https://api-docs.aevo.xyz/reference/publish-create-order">Aevo - PUBLISH Create Order</a>
     */
    @NonNull
    public CreateOrderListener createOrder(
            boolean isTestnet,
            @NonNull SignedOrder signedOrder
    ) {
        return new CreateOrderListener(
                apiKey,
                apiSecret,
                isTestnet,
                signedOrder
        );
    }

    /**
     * Edits an existing order
     * @param isTestnet Whether to use the testnet
     * @param orderId The order id
     * @param instrumentId The instrument id
     * @param maker Account's Ethereum address
     * @param isBuy Whether the order is a buy or sell
     * @param amount Number of contracts in 6 decimal fixed number
     * @param limitPrice The limit price of the order in 6 decimal fixed number
     * @param salt Randomly generated number for the order
     * @param timestamp Unix timestamp in seconds
     * @param signature Signature of the order
     * @param postOnly Whether the order is post only
     * @param timeInForce Time in force of the order (GTC default)
     * @param mmp Flag to include the order into MMP (false by default)
     * @return {@link EditOrderListener}
     * @see <a href="https://api-docs.aevo.xyz/reference/publish-edit-order">Aevo - PUBLISH Edit Order</a>
     */
    @NonNull
    public EditOrderListener editOrder(
            boolean isTestnet,
            @NonNull String orderId,
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
        return new EditOrderListener(
                apiKey,
                apiSecret,
                isTestnet,
                orderId,
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

    /**
     * Edits an existing order
     * @param isTestnet Whether to use the testnet
     * @param signedOrder The signed order
     * @return {@link EditOrderListener}
     * @see <a href="https://api-docs.aevo.xyz/reference/publish-edit-order">Aevo - PUBLISH Edit Order</a>
     */
    @NonNull
    public EditOrderListener editOrder(
            boolean isTestnet,
            @NonNull SignedOrder signedOrder
    ) {
        return new EditOrderListener(
                apiKey,
                apiSecret,
                isTestnet,
                signedOrder
        );
    }

    /**
     * Cancels an existing order
     * @param isTestnet Whether to use the testnet
     * @param orderId The order id
     * @return {@link CancelOrderListener}
     * @see <a href="https://api-docs.aevo.xyz/reference/publish-cancel-order">Aevo - PUBLISH Cancel Order</a>
     */
    @NonNull
    public CancelOrderListener cancelOrder(
            boolean isTestnet,
            @NonNull String orderId
    ) {
        return new CancelOrderListener(
                apiKey,
                apiSecret,
                isTestnet,
                orderId
        );
    }

    /**
     * Cancel all orders. Optionally, an instrument type (OPTION or PERPETUAL) can be specified.
     * @param isTestnet Whether to use the testnet
     * @param instrumentType The instrument type
     * @return {@link CancelAllOrdersListener}
     * @see <a href="https://api-docs.aevo.xyz/reference/publish-cancel-all-orders">Aevo - PUBLISH Cancel All Orders</a>
     */
    @NonNull
    public CancelAllOrdersListener cancelAllOrders(
            boolean isTestnet,
            @Nullable String instrumentType
    ) {
        return new CancelAllOrdersListener(
                apiKey,
                apiSecret,
                isTestnet,
                instrumentType
        );
    }

    /**
     * Cancel all orders.
     * @param isTestnet Whether to use the testnet
     * @return {@link CancelAllOrdersListener}
     * @see <a href="https://api-docs.aevo.xyz/reference/publish-cancel-all-orders">Aevo - PUBLISH Cancel All Orders</a>
     */
    @NonNull
    public CancelAllOrdersListener cancelAllOrders(
            boolean isTestnet
    ) {
        return new CancelAllOrdersListener(
                apiKey,
                apiSecret,
                isTestnet
        );
    }

    /**
     * Creates an RFQ
     * @param isTestnet Whether to use the testnet
     * @param instrumentId The instrument id
     * @param amount Number of contracts in 6 decimal fixed number
     * @return {@link CreateRFQListener}
     * @see <a href="https://api-docs.aevo.xyz/reference/publish-create-rfq">Aevo - PUBLISH Create RFQ</a>
     */
    @NonNull
    public CreateRFQListener createRFQ(
            boolean isTestnet,
            long instrumentId,
            @NonNull String amount
    ) {
        return new CreateRFQListener(
                apiKey,
                apiSecret,
                isTestnet,
                instrumentId,
                amount
        );
    }

    /**
     * Cancels an RFQ
     * @param isTestnet Whether to use the testnet
     * @param rfqId The RFQ block id
     * @return {@link CancelRFQListener}
     * @see <a href="https://api-docs.aevo.xyz/reference/publish-cancel-rfq">Aevo - PUBLISH Cancel RFQ</a>
     */
    @NonNull
    public CancelRFQListener cancelRFQ(
            boolean isTestnet,
            @NonNull String rfqId
    ) {
        return new CancelRFQListener(
                apiKey,
                apiSecret,
                isTestnet,
                rfqId
        );
    }

    /**
     * Create a quote RFQ
     * @param isTestnet Whether to use the testnet
     * @param rfqBlockId The RFQ block id
     * @param instrumentId The instrument id
     * @param maker Account's Ethereum address
     * @param isBuy Whether the order is a buy or sell
     * @param amount Number of contracts in 6 decimal fixed number
     * @param limitPrice The limit price of the order in 6 decimal fixed number
     * @param salt Randomly generated number for the order
     * @param timestamp Unix timestamp in seconds
     * @param signature Signature of the order
     * @param postOnly Whether the order is post only
     * @param timeInForce Time in force of the order (GTC default)
     * @param mmp Flag to include the order into MMP (false by default)
     * @return {@link CreateQuoteRFQListener}
     * @see <a href="https://api-docs.aevo.xyz/reference/publish-create-quote-rfq">Aevo - PUBLISH Create Quote RFQ</a>
     */
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

    /**
     * Create a quote RFQ
     * @param isTestnet Whether to use the testnet
     * @param rfqBlockId The RFQ block id
     * @param instrumentId The instrument id
     * @param maker Account's Ethereum address
     * @param isBuy Whether the order is a buy or sell
     * @param amount Number of contracts in 6 decimal fixed number
     * @param limitPrice The limit price of the order in 6 decimal fixed number
     * @param salt Randomly generated number for the order
     * @param signature Signature of the order
     * @return {@link CreateQuoteRFQListener}
     * @see <a href="https://api-docs.aevo.xyz/reference/publish-create-quote-rfq">Aevo - PUBLISH Create Quote RFQ</a>
     */
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

    /**
     * Create a quote RFQ
     * @param isTestnet Whether to use the testnet
     * @param quoteRFQ The quote RFQ
     * @return {@link CreateQuoteRFQListener}
     * @see <a href="https://api-docs.aevo.xyz/reference/publish-create-quote-rfq">Aevo - PUBLISH Create Quote RFQ</a>
     */
    @NonNull
    public CreateQuoteRFQListener createQuoteRFQ(
            boolean isTestnet,
            @NonNull QuoteRFQ quoteRFQ
    ) {
        return new CreateQuoteRFQListener(
                apiKey,
                apiSecret,
                isTestnet,
                quoteRFQ
        );
    }

    /**
     * Listen to any order status updates if it occurs
     * @param isTestnet Whether to use the testnet
     * @return {@link OrdersListener}
     * @see <a href="https://api-docs.aevo.xyz/reference/subcribe-orders">Aevo - SUBSCRIBE Orders</a>
     */
    @NonNull
    public OrdersListener orders(boolean isTestnet) {
        return new OrdersListener(
                apiKey,
                apiSecret,
                isTestnet
        );
    }

    /**
     * Listen to any order fills
     * @param isTestnet Whether to use the testnet
     * @return {@link FillsListener}
     * @see <a href="https://api-docs.aevo.xyz/reference/subcribe-fills">Aevo - SUBSCRIBE Fills</a>
     */
    @NonNull
    public FillsListener fills(boolean isTestnet) {
        return new FillsListener(
                apiKey,
                apiSecret,
                isTestnet
        );
    }

    /**
     * Listen to relevant position updates if any changes occur
     * @param isTestnet Whether to use the testnet
     * @return {@link PositionsListener}
     * @see <a href="https://api-docs.aevo.xyz/reference/subcribe-positions">Aevo - SUBSCRIBE Positions</a>
     */
    @NonNull
    public PositionsListener positions(boolean isTestnet) {
        return new PositionsListener(
                apiKey,
                apiSecret,
                isTestnet
        );
    }
}
