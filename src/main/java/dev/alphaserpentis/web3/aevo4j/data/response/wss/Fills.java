package dev.alphaserpentis.web3.aevo4j.data.response.wss;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Fills extends Response<Fills.Data> {
    public static class Data {
        @SerializedName("timestamp")
        private String timestamp;
        @SerializedName("fill")
        private Fill fill;

        public static class Fill {
            @SerializedName("trade_id")
            private String tradeId;
            @SerializedName("order_id")
            private String orderId;
            @SerializedName("instrument_id")
            private String instrumentId;
            @SerializedName("instrument_name")
            private String instrumentName;
            @SerializedName("instrument_type")
            private String instrumentType;
            @SerializedName("price")
            private String price;
            @SerializedName("side")
            private String side;
            @SerializedName("fees")
            private String fees;
            @SerializedName("filled")
            private String filled;
            @SerializedName("order_status")
            private String orderStatus;
            @SerializedName("liquidity")
            private String liquidity;
            @SerializedName("created_timestamp")
            private String createdTimestamp;

            public String getTradeId() {
                return tradeId;
            }

            public String getOrderId() {
                return orderId;
            }

            public String getInstrumentId() {
                return instrumentId;
            }

            public String getInstrumentName() {
                return instrumentName;
            }

            public String getInstrumentType() {
                return instrumentType;
            }

            public String getPrice() {
                return price;
            }

            public String getSide() {
                return side;
            }

            public String getFees() {
                return fees;
            }

            public String getFilled() {
                return filled;
            }

            public String getOrderStatus() {
                return orderStatus;
            }

            public String getLiquidity() {
                return liquidity;
            }

            public String getCreatedTimestamp() {
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

        public String getTimestamp() {
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
