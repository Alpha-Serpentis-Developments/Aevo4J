package dev.alphaserpentis.web3.aevo4j.data.misc;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.Sign;
import org.web3j.utils.Numeric;

import java.io.IOException;
import java.time.Instant;

/**
 * An order payload without a signature
 */
@SuppressWarnings("unused")
public class UnsignedOrder {

    @SerializedName("maker")
    protected final String maker;
    @SerializedName("instrument")
    protected final Integer instrument;
    @SerializedName("is_buy")
    protected final boolean isBuy;
    @SerializedName("amount")
    protected final String amount;
    @SerializedName("limit_price")
    protected final String limitPrice;
    @SerializedName("salt")
    protected final String salt;
    @SerializedName("timestamp")
    protected final String timestamp;
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
    protected final String trigger;

    public static class Builder {
        private final Integer instrument;
        private final String maker;
        private final boolean isBuy;
        private final String amount;
        private final String limitPrice;
        private final String salt;
        private final String timestamp;
        private Boolean postOnly;
        private Boolean reduceOnly;
        private String timeInForce;
        private Boolean mmp;
        private String stop;
        private String trigger;

        public Builder(
                @NonNull Integer instrument,
                @NonNull String maker,
                boolean isBuy,
                @NonNull String amount,
                @NonNull String limitPrice,
                @NonNull String salt,
                @NonNull String timestamp
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
                @NonNull Integer instrument,
                @NonNull String maker,
                boolean isBuy,
                @NonNull String amount,
                @NonNull String limitPrice
        ) {
            this.instrument = instrument;
            this.maker = maker;
            this.isBuy = isBuy;
            this.amount = amount;
            this.limitPrice = limitPrice;
            this.salt = String.valueOf((int) (Math.random() * 100000));
            this.timestamp = String.valueOf(Instant.now().getEpochSecond());
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
        public Builder trigger(@Nullable String trigger) {
            this.trigger = trigger;
            return this;
        }

        /**
         * Builds an {@link UnsignedOrder} from the given parameters
         * @return {@link UnsignedOrder}
         */
        public UnsignedOrder build() {
            return new UnsignedOrder(
                    instrument,
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
                    trigger
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
    }

    /**
     * @see Builder
     */
    public UnsignedOrder(
            @NonNull Integer instrument,
            @NonNull String maker,
            boolean isBuy,
            @NonNull String amount,
            @NonNull String limitPrice,
            @NonNull String salt,
            @NonNull String timestamp,
            @Nullable Boolean postOnly,
            @Nullable Boolean reduceOnly,
            @Nullable String timeInForce,
            @Nullable Boolean mmp,
            @Nullable String stop,
            @Nullable String trigger
    ) {
        this.instrument = instrument;
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
    }

    /**
     * @see Builder
     */
    public UnsignedOrder(
            @NonNull Integer instrument,
            @NonNull String maker,
            boolean isBuy,
            @NonNull String amount,
            @NonNull String limitPrice,
            @NonNull String salt,
            @NonNull String timestamp
    ) {
        this(
                instrument,
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
                null
        );
    }

    /**
     * Signs an order using the given signing key
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
        OrderEIP712 orderEIP712 = new OrderEIP712(
                isTestnet ? OrderEIP712.testnetDomain() : OrderEIP712.mainnetDomain(),
                OrderEIP712.Order.fromUnsignedOrder(order)
        );
        Credentials credentials = Credentials.create(signingKey);
        Sign.SignatureData signature = Sign.signTypedData(orderEIP712.toString(), credentials.getEcKeyPair());
        String signatureHex;
        byte[] retval = new byte[65];

        System.arraycopy(signature.getR(), 0, retval, 0, 32);
        System.arraycopy(signature.getS(), 0, retval, 32, 32);
        System.arraycopy(signature.getV(), 0, retval, 64, 1);
        signatureHex = Numeric.toHexString(retval);
        
        return new SignedOrder(
                order.getInstrument(),
                order.getMaker(),
                order.isBuy(),
                order.getAmount(),
                order.getLimitPrice(),
                order.getSalt(),
                signatureHex,
                order.getTimestamp(),
                order.getPostOnly(),
                order.getReduceOnly(),
                order.getTimeInForce(),
                order.getMmp(),
                order.getStop(),
                order.getTrigger()
        );
    }

    @NonNull
    public Integer getInstrument() {
        return instrument;
    }

    @NonNull
    public String getMaker() {
        return maker;
    }

    public boolean isBuy() {
        return isBuy;
    }

    @NonNull
    public String getAmount() {
        return amount;
    }

    @NonNull
    public String getLimitPrice() {
        return limitPrice;
    }

    @NonNull
    public String getSalt() {
        return salt;
    }

    @NonNull
    public String getTimestamp() {
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
    public String getTrigger() {
        return trigger;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
