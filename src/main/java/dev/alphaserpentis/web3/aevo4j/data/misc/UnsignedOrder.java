package dev.alphaserpentis.web3.aevo4j.data.misc;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.ECKeyPair;
import org.web3j.crypto.Sign;
import org.web3j.utils.Numeric;

import java.io.IOException;
import java.time.Instant;

/**
 * An order payload without a signature
 * @see <a href="https://api-docs.aevo.xyz/reference/signing-orders">Aevo - Signing Orders</a>
 */
@SuppressWarnings("unused")
public class UnsignedOrder {

    @SerializedName("maker")
    protected final String maker;
    @SerializedName("instrument")
    protected final long instrument;
    @SerializedName("order_id")
    protected final String orderId;
    @SerializedName("is_buy")
    protected final boolean isBuy;
    @SerializedName("amount")
    protected final long amount;
    @SerializedName("limit_price")
    protected final long limitPrice;
    @SerializedName("salt")
    protected final long salt;
    @SerializedName("timestamp")
    protected final long timestamp;
    @SerializedName("post_only")
    protected final Boolean postOnly;
    @SerializedName("reduce_only")
    protected final Boolean reduceOnly;
    @SerializedName("time_in_force")
    protected final String timeInForce;
    @SerializedName("mmp")
    protected final Boolean mmp;
    @SerializedName("stop")
    protected final String stop;
    @SerializedName("trigger")
    protected final Double trigger;
    @SerializedName("close_position")
    private Boolean closePosition;
    @SerializedName("isolated_margin")
    private String isolatedMargin;

    public static class Builder {
        private final long instrument;
        private final String maker;
        private final boolean isBuy;
        private final long amount;
        private final long limitPrice;
        private final long salt;
        private final long timestamp;
        private String orderId = null;
        private Boolean postOnly;
        private Boolean reduceOnly;
        private String timeInForce;
        private Boolean mmp;
        private String stop;
        private Double trigger;
        private Boolean closePosition;
        private String isolatedMargin;

        public Builder(
                long instrument,
                @NonNull String maker,
                boolean isBuy,
                long amount,
                long limitPrice,
                long salt,
                long timestamp
        ) {
            this.instrument = instrument;
            this.maker = maker;
            this.isBuy = isBuy;
            this.amount = amount;
            this.limitPrice = limitPrice;
            this.salt = salt;
            this.timestamp = timestamp;
        }

        public Builder(
                long instrument,
                @NonNull String maker,
                boolean isBuy,
                long amount,
                long limitPrice
        ) {
            this.instrument = instrument;
            this.maker = maker;
            this.isBuy = isBuy;
            this.amount = amount;
            this.limitPrice = limitPrice;
            this.salt = (long) (Math.random() * 100000);
            this.timestamp = Instant.now().getEpochSecond();
        }

        public Builder orderId(@Nullable String orderId) {
            this.orderId = orderId;
            return this;
        }

        public Builder postOnly(@Nullable Boolean postOnly) {
            this.postOnly = postOnly;
            return this;
        }

        /**
         * <b>Note:</b> This may or may not apply for the websocket request!
         */
        public Builder reduceOnly(@Nullable Boolean reduceOnly) {
            this.reduceOnly = reduceOnly;
            return this;
        }

        public Builder timeInForce(@Nullable String timeInForce) {
            this.timeInForce = timeInForce;
            return this;
        }

        public Builder mmp(@Nullable Boolean mmp) {
            this.mmp = mmp;
            return this;
        }

        /**
         * <b>Note:</b> This may or may not apply for the websocket request!
         */
        public Builder stop(@Nullable String stop) {
            this.stop = stop;
            return this;
        }

        /**
         * <b>Note:</b> This may or may not apply for the websocket request!
         */
        public Builder trigger(@Nullable Double trigger) {
            this.trigger = trigger;
            return this;
        }

        public Builder closePosition(@Nullable Boolean closePosition) {
            this.closePosition = closePosition;
            return this;
        }

        public Builder isolatedMargin(@Nullable String isolatedMargin) {
            this.isolatedMargin = isolatedMargin;
            return this;
        }

        /**
         * Builds an {@link UnsignedOrder} from the given parameters
         * @return {@link UnsignedOrder}
         */
        public UnsignedOrder build() {
            return new UnsignedOrder(
                    instrument,
                    orderId,
                    maker,
                    isBuy,
                    amount,
                    limitPrice,
                    salt,
                    timestamp,
                    postOnly,
                    reduceOnly,
                    timeInForce,
                    mmp,
                    stop,
                    trigger,
                    closePosition,
                    isolatedMargin
            );
        }

        /**
         * Builds and signs an {@link UnsignedOrder} using the given signing key
         * @param isTestnet Whether to use the testnet domain
         * @param signingKey Signing key provided by Aevo when you enabled trading
         * @return {@link SignedOrder}
         */
        public SignedOrder buildAndSign(boolean isTestnet, @NonNull String signingKey) throws IOException {
            return UnsignedOrder.signOrder(
                    this.build(),
                    isTestnet,
                    signingKey
            );
        }

        /**
         * Builds and signs an {@link UnsignedOrder} using the given signing key
         * @param isTestnet Whether to use the testnet domain
         * @param signingKey {@link ECKeyPair} of the signing key which was provided by Aevo when you enabled trading
         * @return {@link SignedOrder}
         */
        public SignedOrder buildAndSign(boolean isTestnet, @NonNull ECKeyPair signingKey) throws IOException {
            return UnsignedOrder.signOrder(
                    this.build(),
                    isTestnet,
                    signingKey
            );
        }
    }

    /**
     * @see Builder
     */
    public UnsignedOrder(
            long instrument,
            @Nullable String orderId,
            @NonNull String maker,
            boolean isBuy,
            long amount,
            long limitPrice,
            long salt,
            long timestamp,
            @Nullable Boolean postOnly,
            @Nullable Boolean reduceOnly,
            @Nullable String timeInForce,
            @Nullable Boolean mmp,
            @Nullable String stop,
            @Nullable Double trigger,
            @Nullable Boolean closePosition,
            @Nullable String isolatedMargin
    ) {
        this.instrument = instrument;
        this.orderId = orderId;
        this.maker = maker;
        this.isBuy = isBuy;
        this.amount = amount;
        this.limitPrice = limitPrice;
        this.salt = salt;
        this.timestamp = timestamp;
        this.postOnly = postOnly;
        this.reduceOnly = reduceOnly;
        this.timeInForce = timeInForce;
        this.mmp = mmp;
        this.stop = stop;
        this.trigger = trigger;
        this.closePosition = closePosition;
        this.isolatedMargin = isolatedMargin;
    }

    /**
     * @see Builder
     */
    public UnsignedOrder(
            long instrument,
            @NonNull String maker,
            boolean isBuy,
            long amount,
            long limitPrice,
            long salt,
            long timestamp
    ) {
        this(
                instrument,
                null,
                maker,
                isBuy,
                amount,
                limitPrice,
                salt,
                timestamp,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null
        );
    }

    /**
     * Signs an order using the given signing key.
     * <p>
     * <b>This might be a very heavy operation! We suggest to
     * use {@link #signOrder(UnsignedOrder, boolean, ECKeyPair)}</b>
     * @param order The unsigned order to sign
     * @param isTestnet Whether to use the testnet domain
     * @param signingKey Signing key provided by Aevo when you enabled trading
     * @return {@link SignedOrder}
     * @see <a href="https://api-docs.aevo.xyz/reference/signing-orders">Aevo - Signing Orders</a>
     */
    public static SignedOrder signOrder(
            @NonNull UnsignedOrder order,
            boolean isTestnet,
            @NonNull String signingKey
    ) throws IOException {
        String orderEIP712 = new OrderEIP712(
                isTestnet ? OrderEIP712.TESTNET_DOMAIN : OrderEIP712.MAINNET_DOMAIN,
                OrderEIP712.Order.fromUnsignedOrder(order)
        ).toString();
        Sign.SignatureData signature = Sign.signTypedData(orderEIP712, Credentials.create(signingKey).getEcKeyPair());
        byte[] retval = new byte[65];

        System.arraycopy(signature.getR(), 0, retval, 0, 32);
        System.arraycopy(signature.getS(), 0, retval, 32, 32);
        System.arraycopy(signature.getV(), 0, retval, 64, 1);

        return new SignedOrder(
                order,
                Numeric.toHexString(retval)
        );
    }

    /**
     * Signs an order using the given signing key
     * @param order The unsigned order to sign
     * @param isTestnet Whether to use the testnet domain
     * @param signingKey {@link ECKeyPair} of the signing key which was provided by Aevo when you enabled trading
     * @return {@link SignedOrder}
     * @see <a href="https://api-docs.aevo.xyz/reference/signing-orders">Aevo - Signing Orders</a>
     */
    public static SignedOrder signOrder(
            @NonNull UnsignedOrder order,
            boolean isTestnet,
            @NonNull ECKeyPair signingKey
    ) throws IOException {
        String orderEIP712 = new OrderEIP712(
                isTestnet ? OrderEIP712.TESTNET_DOMAIN : OrderEIP712.MAINNET_DOMAIN,
                OrderEIP712.Order.fromUnsignedOrder(order)
        ).toString();
        Sign.SignatureData signature = Sign.signTypedData(orderEIP712, signingKey);
        byte[] retval = new byte[65];

        System.arraycopy(signature.getR(), 0, retval, 0, 32);
        System.arraycopy(signature.getS(), 0, retval, 32, 32);
        System.arraycopy(signature.getV(), 0, retval, 64, 1);

        return new SignedOrder(
                order,
                Numeric.toHexString(retval)
        );
    }

    public long getInstrument() {
        return instrument;
    }

    @Nullable
    public String getOrderId() {
        return orderId;
    }

    @NonNull
    public String getMaker() {
        return maker;
    }

    public boolean isBuy() {
        return isBuy;
    }

    public long getAmount() {
        return amount;
    }

    public long getLimitPrice() {
        return limitPrice;
    }

    public long getSalt() {
        return salt;
    }

    public long getTimestamp() {
        return timestamp;
    }

    @Nullable
    public Boolean getPostOnly() {
        return postOnly;
    }

    @Nullable
    public Boolean getReduceOnly() {
        return reduceOnly;
    }

    @Nullable
    public String getTimeInForce() {
        return timeInForce;
    }

    @Nullable
    public Boolean getMmp() {
        return mmp;
    }

    @Nullable
    public String getStop() {
        return stop;
    }

    @Nullable
    public Double getTrigger() {
        return trigger;
    }

    @Nullable
    public Boolean getClosePosition() {
        return closePosition;
    }

    @Nullable
    public String getIsolatedMargin() {
        return isolatedMargin;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
