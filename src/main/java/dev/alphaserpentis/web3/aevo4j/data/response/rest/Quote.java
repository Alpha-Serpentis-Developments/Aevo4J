package dev.alphaserpentis.web3.aevo4j.data.response.rest;

import com.google.gson.annotations.SerializedName;
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
    @SerializedName("legs")
    private Leg[] legs;
    @SerializedName("avg_price")
    private Double avgPrice;
    @SerializedName("created_timestamp")
    private long createdTimestamp;

    public static class Leg {
        @SerializedName("instrument_id")
        private long instrumentId;
        @SerializedName("instrument_name")
        private String instrumentName;
        @SerializedName("instrument_type")
        private String instrumentType;
        @SerializedName("side")
        private String side;
        @SerializedName("index_price")
        private double indexPrice;
        @SerializedName("mark_price")
        private double markPrice;
        @SerializedName("ratio")
        private double ratio;
        @SerializedName("price")
        private double price;
        @SerializedName("asset")
        private String asset;
        @SerializedName("expiry")
        private Long expiry;
        @SerializedName("strike")
        private Double strike;
        @SerializedName("option_type")
        private String optionType;
        @SerializedName("iv")
        private Double iv;

        public long getInstrumentId() {
            return instrumentId;
        }

        public String getInstrumentName() {
            return instrumentName;
        }

        public String getInstrumentType() {
            return instrumentType;
        }

        public String getSide() {
            return side;
        }

        public double getIndexPrice() {
            return indexPrice;
        }

        public double getMarkPrice() {
            return markPrice;
        }

        public double getRatio() {
            return ratio;
        }

        public double getPrice() {
            return price;
        }

        public String getAsset() {
            return asset;
        }

        @Nullable
        public Long getExpiry() {
            return expiry;
        }

        @Nullable
        public Double getStrike() {
            return strike;
        }

        @Nullable
        public String getOptionType() {
            return optionType;
        }

        @Nullable
        public Double getIv() {
            return iv;
        }

        @Override
        public String toString() {
            return "Leg{" +
                    "instrumentId=" + instrumentId +
                    ", instrumentName='" + instrumentName + '\'' +
                    ", instrumentType='" + instrumentType + '\'' +
                    ", side='" + side + '\'' +
                    ", indexPrice=" + indexPrice +
                    ", markPrice=" + markPrice +
                    ", ratio=" + ratio +
                    ", price=" + price +
                    ", asset='" + asset + '\'' +
                    ", expiry=" + expiry +
                    ", strike=" + strike +
                    ", optionType='" + optionType + '\'' +
                    ", iv=" + iv +
                    '}';
        }
    }

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
                ", legs=" + java.util.Arrays.toString(legs) +
                ", avgPrice=" + avgPrice +
                ", createdTimestamp=" + createdTimestamp +
                '}';
    }
}
