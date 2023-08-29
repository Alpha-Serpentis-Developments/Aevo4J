package dev.alphaserpentis.web3.aevo4j.data.response.wss;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Fills extends Response<Orders.Data> {
    public static class Data {
        @SerializedName("timestamp")
        public String timestamp;
        @SerializedName("fill")
        public Fill fill;

        public static class Fill {
            @SerializedName("trade_id")
            public String tradeId;
            @SerializedName("order_id")
            public String orderId;
            @SerializedName("instrument_id")
            public String instrumentId;
            @SerializedName("instrument_name")
            public String instrumentName;
            @SerializedName("instrument_type")
            public String instrumentType;
            @SerializedName("price")
            public String price;
            @SerializedName("side")
            public String side;
            @SerializedName("fees")
            public String fees;
            @SerializedName("order_status")
            public String orderStatus;
            @SerializedName("liquidity")
            public String liquidity;
            @SerializedName("created_timestamp")
            public String createdTimestamp;

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
