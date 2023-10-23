package dev.alphaserpentis.web3.aevo4j.data.request.rest;

import com.google.gson.annotations.SerializedName;
import io.reactivex.rxjava3.annotations.Nullable;

@SuppressWarnings("unused")
public class RFQsBody {
    @SerializedName("legs")
    private final RFQLeg[] legs;
    @SerializedName("full_size")
    private final Boolean fullSize;
    @SerializedName("is_buy")
    private final Boolean isBuy;
    @SerializedName("amount")
    private final String amount;
    @SerializedName("duration")
    private final Long duration;
    @SerializedName("counterparties")
    private final String[] counterparties;

    public static class RFQLeg {
        @SerializedName("instrument")
        private final long instrument;
        @SerializedName("is_buy")
        private final boolean isBuy;
        @SerializedName("ratio")
        private final double ratio;

        public RFQLeg(long instrument, boolean isBuy, double ratio) {
            this.instrument = instrument;
            this.isBuy = isBuy;
            this.ratio = ratio;
        }
    }

    public RFQsBody(
            @Nullable RFQLeg[] legs,
            @Nullable Boolean fullSize,
            @Nullable Boolean isBuy,
            @Nullable String amount,
            @Nullable Long duration,
            @Nullable String[] counterparties
    ) {
        this.legs = legs;
        this.fullSize = fullSize;
        this.isBuy = isBuy;
        this.amount = amount;
        this.duration = duration;
        this.counterparties = counterparties;
    }

    public RFQsBody(
            @Nullable RFQLeg[] legs,
            @Nullable Boolean fullSize,
            @Nullable Boolean isBuy,
            @Nullable Long amount,
            @Nullable Long duration,
            @Nullable String[] counterparties
    ) {
        this.legs = legs;
        this.fullSize = fullSize;
        this.isBuy = isBuy;
        this.amount = String.valueOf(amount);
        this.duration = duration;
        this.counterparties = counterparties;
    }
}
