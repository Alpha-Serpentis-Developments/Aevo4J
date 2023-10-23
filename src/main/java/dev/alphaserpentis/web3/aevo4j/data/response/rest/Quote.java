package dev.alphaserpentis.web3.aevo4j.data.response.rest;

import com.google.gson.annotations.SerializedName;
import dev.alphaserpentis.web3.aevo4j.data.response.common.Leg;
import io.reactivex.rxjava3.annotations.Nullable;

@SuppressWarnings("unused")
public class Quote {

    @SerializedName("quote_id")
    private String quoteId;
    @SerializedName("block_id")
    private String blockId;
    @SerializedName("amount")
    private double amount;
    @SerializedName("initial_margin")
    private Double initialMargin;
    @SerializedName("filled")
    private Double filled;
    @SerializedName("limit_price")
    private double limitPrice;
    @SerializedName("quote_status")
    private String quoteStatus;
    @SerializedName("is_buy")
    private boolean isBuy;
    @SerializedName("legs")
    private Leg[] legs;
    @SerializedName("avg_price")
    private Double avgPrice;
    @SerializedName("created_timestamp")
    private long createdTimestamp;

    public String getQuoteId() {
        return quoteId;
    }

    public String getBlockId() {
        return blockId;
    }

    public double getAmount() {
        return amount;
    }

    @Nullable
    public Double getInitialMargin() {
        return initialMargin;
    }

    @Nullable
    public Double getFilled() {
        return filled;
    }

    public double getLimitPrice() {
        return limitPrice;
    }

    public String getQuoteStatus() {
        return quoteStatus;
    }

    public boolean isBuy() {
        return isBuy;
    }

    @Nullable
    public Leg[] getLegs() {
        return legs;
    }

    @Nullable
    public Double getAvgPrice() {
        return avgPrice;
    }

    public long getCreatedTimestamp() {
        return createdTimestamp;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "quoteId='" + quoteId + '\'' +
                ", blockId='" + blockId + '\'' +
                ", amount=" + amount +
                ", initialMargin=" + initialMargin +
                ", filled=" + filled +
                ", limitPrice=" + limitPrice +
                ", quoteStatus='" + quoteStatus + '\'' +
                ", isBuy=" + isBuy +
                ", legs=" + java.util.Arrays.toString(legs) +
                ", avgPrice=" + avgPrice +
                ", createdTimestamp=" + createdTimestamp +
                '}';
    }
}
