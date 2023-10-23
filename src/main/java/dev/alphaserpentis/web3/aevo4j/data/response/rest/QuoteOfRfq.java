package dev.alphaserpentis.web3.aevo4j.data.response.rest;

import com.google.gson.annotations.SerializedName;
import io.reactivex.rxjava3.annotations.Nullable;

import java.util.Arrays;

@SuppressWarnings("unused")
public class QuoteOfRfq {
    @SerializedName("block_id")
    private String blockId;
    @SerializedName("asks")
    private Quote[] asks;
    @SerializedName("bids")
    private Quote[] bids;

    public static class Quote {
        @SerializedName("quote_id")
        private String quoteId;
        @SerializedName("amount")
        private double amount;
        @SerializedName("is_buy")
        private boolean isBuy;
        @SerializedName("limit_price")
        private long limitPrice;
        @SerializedName("legs")
        private QuoteLeg[] legs;
        @SerializedName("quote_status")
        private String quoteStatus;
        @SerializedName("created_timestamp")
        private long createdTimestamp;

        public static class QuoteLeg {
            @SerializedName("instrument_id")
            private long instrumentId;
            @SerializedName("instrument_name")
            private String instrumentName;
            @SerializedName("side")
            private String side;
            @SerializedName("price")
            private double price;
            @SerializedName("iv")
            private Double iv;

            public long getInstrumentId() {
                return instrumentId;
            }

            public String getInstrumentName() {
                return instrumentName;
            }

            public String getSide() {
                return side;
            }

            public double getPrice() {
                return price;
            }

            @Nullable
            public Double getIv() {
                return iv;
            }

            @Override
            public String toString() {
                return "QuoteLeg{" +
                        "instrumentId=" + instrumentId +
                        ", instrumentName='" + instrumentName + '\'' +
                        ", side='" + side + '\'' +
                        ", price=" + price +
                        ", iv=" + iv +
                        '}';
            }
        }

        public String getQuoteId() {
            return quoteId;
        }

        public double getAmount() {
            return amount;
        }

        public boolean isBuy() {
            return isBuy;
        }

        public long getLimitPrice() {
            return limitPrice;
        }

        public QuoteLeg[] getLegs() {
            return legs;
        }

        public String getQuoteStatus() {
            return quoteStatus;
        }

        public long getCreatedTimestamp() {
            return createdTimestamp;
        }

        @Override
        public String toString() {
            return "Quote{" +
                    "quoteId='" + quoteId + '\'' +
                    ", amount=" + amount +
                    ", isBuy=" + isBuy +
                    ", limitPrice=" + limitPrice +
                    ", legs=" + Arrays.toString(legs) +
                    ", quoteStatus='" + quoteStatus + '\'' +
                    ", createdTimestamp=" + createdTimestamp +
                    '}';
        }
    }

    public String getBlockId() {
        return blockId;
    }

    public Quote[] getAsks() {
        return asks;
    }

    public Quote[] getBids() {
        return bids;
    }

    @Override
    public String toString() {
        return "QuoteOfRfq{" +
                "blockId='" + blockId + '\'' +
                ", asks=" + Arrays.toString(asks) +
                ", bids=" + Arrays.toString(bids) +
                '}';
    }
}
