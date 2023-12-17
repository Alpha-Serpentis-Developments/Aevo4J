package dev.alphaserpentis.web3.aevo4j.data.misc;

import com.google.gson.annotations.SerializedName;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;

/**
 * @see <a href="https://api-docs.aevo.xyz/reference/signing-orders">Aevo - Signing Orders</a>
 */
@SuppressWarnings("unused")
public class SignedOrder extends UnsignedOrder {
    @SerializedName("signature")
    private final String signature;

    public static class Builder {
        private final String signature;
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
                long timestamp,
                @NonNull String signature
        ) {
            this.instrument = instrument;
            this.maker = maker;
            this.isBuy = isBuy;
            this.amount = amount;
            this.limitPrice = limitPrice;
            this.salt = salt;
            this.timestamp = timestamp;
            this.signature = signature;
        }

        public Builder orderId(@NonNull String orderId) {
            this.orderId = orderId;
            return this;
        }

        public Builder postOnly(@Nullable Boolean postOnly) {
            this.postOnly = postOnly;
            return this;
        }

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

        public Builder stop(@Nullable String stop) {
            this.stop = stop;
            return this;
        }

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

        public SignedOrder build() {
            return new SignedOrder(
                    instrument,
                    orderId,
                    maker,
                    isBuy,
                    amount,
                    limitPrice,
                    salt,
                    signature,
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
    }

    /**
     * @see Builder
     */
    public SignedOrder(
            long instrument,
            @Nullable String orderId,
            @NonNull String maker,
            boolean isBuy,
            long amount,
            long limitPrice,
            long salt,
            @NonNull String signature,
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
        super(
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
        this.signature = signature;
    }

    /**
     * @see Builder
     */
    public SignedOrder(
            long instrument,
            @NonNull String maker,
            boolean isBuy,
            long amount,
            long limitPrice,
            long salt,
            @NonNull String signature,
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
                signature,
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

    public SignedOrder(
            @NonNull UnsignedOrder unsignedorder,
            @NonNull String signature
    ) {
        this(
                unsignedorder.getInstrument(),
                unsignedorder.getOrderId(),
                unsignedorder.getMaker(),
                unsignedorder.isBuy(),
                unsignedorder.getAmount(),
                unsignedorder.getLimitPrice(),
                unsignedorder.getSalt(),
                signature,
                unsignedorder.getTimestamp(),
                unsignedorder.getPostOnly(),
                unsignedorder.getReduceOnly(),
                unsignedorder.getTimeInForce(),
                unsignedorder.getMmp(),
                unsignedorder.getStop(),
                unsignedorder.getTrigger(),
                unsignedorder.getClosePosition(),
                unsignedorder.getIsolatedMargin()
        );
    }
}
