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
                @NonNull String timestamp,
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

        public Builder trigger(@Nullable String trigger) {
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
            @NonNull Integer instrument,
            @NonNull String maker,
            boolean isBuy,
            @NonNull String amount,
            @NonNull String limitPrice,
            @NonNull String salt,
            @NonNull String signature,
            @NonNull String timestamp,
            @Nullable Boolean postOnly,
            @Nullable Boolean reduceOnly,
            @Nullable String timeInForce,
            @Nullable Boolean mmp,
            @Nullable String stop,
            @Nullable String trigger
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
            @NonNull Integer instrument,
            @NonNull String maker,
            boolean isBuy,
            @NonNull String amount,
            @NonNull String limitPrice,
            @NonNull String salt,
            @NonNull String signature,
            @NonNull String timestamp
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
