package dev.alphaserpentis.web3.aevo4j.data.misc;

import com.google.gson.annotations.SerializedName;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;

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
        private Boolean postOnly;
        private Boolean reduceOnly;
        private String timeInForce;
        private Boolean mmp;
        private String stop;
        private Double trigger;

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

        public SignedOrder build() {
            return new SignedOrder(
                    instrument,
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
                    trigger
            );
        }
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
            long timestamp,
            @Nullable Boolean postOnly,
            @Nullable Boolean reduceOnly,
            @Nullable String timeInForce,
            @Nullable Boolean mmp,
            @Nullable String stop,
            @Nullable Double trigger
    ) {
        super(
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
                null
        );
    }

    public SignedOrder(
            @NonNull UnsignedOrder unsignedorder,
            @NonNull String signature
    ) {
        this(
                unsignedorder.getInstrument(),
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
                unsignedorder.getTrigger()
        );
    }
}
