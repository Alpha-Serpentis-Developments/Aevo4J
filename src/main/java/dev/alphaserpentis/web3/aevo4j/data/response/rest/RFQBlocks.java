package dev.alphaserpentis.web3.aevo4j.data.response.rest;

import com.google.gson.annotations.SerializedName;
import dev.alphaserpentis.web3.aevo4j.data.response.common.Leg;
import io.reactivex.rxjava3.annotations.Nullable;

import java.util.Arrays;

@SuppressWarnings("unused")
public class RFQBlocks {
    @SerializedName("blocks")
    private Block[] blocks;

    public static class Block {
        @SerializedName("block_id")
        private String blockId;
        @SerializedName("legs")
        private RFQLeg[] legs;
        @SerializedName("block_status")
        private String blockStatus;
        @SerializedName("created_timestamp")
        private long createdTimestamp;
        @SerializedName("deadline")
        private long deadline;
        @SerializedName("orderbook")
        private BidsAsks orderbook;
        @SerializedName("mark_price")
        private double markPrice;
        @SerializedName("amount")
        private double amount;
        @SerializedName("amount_precision")
        private double amountPrecision;
        @SerializedName("full_size")
        private boolean fullSize;
        @SerializedName("is_buy")
        private Boolean isBuy;
        @SerializedName("role")
        private String role;

        public static class RFQLeg extends Leg {
            @SerializedName("price_precision")
            private double pricePrecision;

            public double getPricePrecision() {
                return pricePrecision;
            }

            @Override
            public String toString() {
                return "RFQLeg{" +
                        "instrumentId=" + getInstrumentId() +
                        ", instrumentName='" + getInstrumentName() + '\'' +
                        ", instrumentType='" + getInstrumentType() + '\'' +
                        ", side='" + getSide() + '\'' +
                        ", indexPrice=" + getIndexPrice() +
                        ", markPrice=" + getMarkPrice() +
                        ", ratio=" + getRatio() +
                        ", price=" + getPrice() +
                        ", asset='" + getAsset() + '\'' +
                        ", expiry=" + getExpiry() +
                        ", strike=" + getStrike() +
                        ", optionType='" + getOptionType() + '\'' +
                        ", iv=" + getIv() +
                        ", pricePrecision=" + pricePrecision +
                        '}';
            }
        }

        public static class BidsAsks {
            @SerializedName("bids")
            private double[][] bids;
            @SerializedName("asks")
            private double[][] asks;

            public double[][] getBids() {
                return bids;
            }

            public double[][] getAsks() {
                return asks;
            }

            @Override
            public String toString() {
                return "BidsAsks{" +
                        "bids=" + Arrays.deepToString(bids) +
                        ", asks=" + Arrays.deepToString(asks) +
                        '}';
            }
        }

        public String getBlockId() {
            return blockId;
        }

        @Nullable
        public RFQLeg[] getLegs() {
            return legs;
        }

        public String getBlockStatus() {
            return blockStatus;
        }

        public long getCreatedTimestamp() {
            return createdTimestamp;
        }

        public long getDeadline() {
            return deadline;
        }

        @Nullable
        public BidsAsks getOrderbook() {
            return orderbook;
        }

        public double getMarkPrice() {
            return markPrice;
        }

        public double getAmount() {
            return amount;
        }

        public double getAmountPrecision() {
            return amountPrecision;
        }

        public boolean isFullSize() {
            return fullSize;
        }

        @Nullable
        public Boolean isBuy() {
            return isBuy;
        }

        @Nullable
        public String getRole() {
            return role;
        }

        @Override
        public String toString() {
            return "Block{" +
                    "blockId='" + blockId + '\'' +
                    ", legs=" + Arrays.toString(legs) +
                    ", blockStatus='" + blockStatus + '\'' +
                    ", createdTimestamp=" + createdTimestamp +
                    ", deadline=" + deadline +
                    ", orderbook=" + orderbook +
                    ", markPrice=" + markPrice +
                    ", amount=" + amount +
                    ", amountPrecision=" + amountPrecision +
                    ", fullSize=" + fullSize +
                    ", isBuy=" + isBuy +
                    ", role='" + role + '\'' +
                    '}';
        }
    }

    @Nullable
    public Block[] getBlocks() {
        return blocks;
    }

    @Override
    public String toString() {
        return "RFQBlocks{" +
                "blocks=" + Arrays.toString(blocks) +
                '}';
    }
}
