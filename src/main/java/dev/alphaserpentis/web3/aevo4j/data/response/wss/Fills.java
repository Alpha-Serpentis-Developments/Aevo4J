package dev.alphaserpentis.web3.aevo4j.data.response.wss;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Fills extends Response<Fills.Data> {
    public static class Data {
        @SerializedName("timestamp")
        private long timestamp;
        @SerializedName("fill")
        private Fill fill;

        public static class Fill {
            @SerializedName("trade_id")
            private String tradeId;
            @SerializedName("order_id")
            private String orderId;
            @SerializedName("instrument_id")
            private long instrumentId;
            @SerializedName("instrument_name")
            private String instrumentName;
            @SerializedName("instrument_type")
            private String instrumentType;
            @SerializedName("price")
            private double price;
            @SerializedName("side")
            private double side;
            @SerializedName("fees")
            private double fees;
            @SerializedName("filled")
            private double filled;
            @SerializedName("order_status")
            private String orderStatus;
            @SerializedName("liquidity")
            private String liquidity;
            @SerializedName("created_timestamp")
            private long createdTimestamp;

            public String getTradeId() {
                return tradeId;
            }

            public String getOrderId() {
                return orderId;
            }

            public long getInstrumentId() {
                return instrumentId;
            }

            public String getInstrumentName() {
                return instrumentName;
            }

            public String getInstrumentType() {
                return instrumentType;
            }

            public double getPrice() {
                return price;
            }

            public double getSide() {
                return side;
            }

            public double getFees() {
                return fees;
            }

            public double getFilled() {
                return filled;
            }

            public String getOrderStatus() {
                return orderStatus;
            }

            public String getLiquidity() {
                return liquidity;
            }

            public long getCreatedTimestamp() {
                return createdTimestamp;
            }

            @Override
            public String toString() {
                return "Fill{" +
                        "tradeId='" + tradeId + '\'' +
                        ", orderId='" + orderId + '\'' +
                        ", instrumentId='" + instrumentId + '\'' +
                        ", instrumentName='" + instrumentName + '\'' +
                        ", instrumentType='" + instrumentType + '\'' +
                        ", price='" + price + '\'' +
                        ", side='" + side + '\'' +
                        ", fees='" + fees + '\'' +
                        ", filled='" + filled + '\'' +
                        ", orderStatus='" + orderStatus + '\'' +
                        ", liquidity='" + liquidity + '\'' +
                        ", createdTimestamp='" + createdTimestamp + '\'' +
                        '}';
            }
        }

        public long getTimestamp() {
            return timestamp;
        }

        public Fill getFill() {
            return fill;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "timestamp='" + timestamp + '\'' +
                    ", fill=" + fill +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "Fills{" +
                "data=" + getData() +
                ", channel='" + getChannel() + '\'' +
                ", id='" + getId() + '\''
                + '}';
    }
}
