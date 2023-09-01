package dev.alphaserpentis.web3.aevo4j.data.response.wss;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class EditedOrder extends Response<EditedOrder.Data>  {
    public static class Data {
        @SerializedName("order_id")
        private String orderId;
        @SerializedName("account")
        private String account;
        @SerializedName("instrument_id")
        private long instrumentId;
        @SerializedName("instrument_name")
        private String instrumentName;
        @SerializedName("instrument_type")
        private String instrumentType;
        @SerializedName("option_type")
        private String optionType;
        @SerializedName("expiry")
        private long expiry;
        @SerializedName("strike")
        private double strike;
        @SerializedName("order_type")
        private String orderType;
        @SerializedName("order_status")
        private String orderStatus;
        @SerializedName("side")
        private String side;
        @SerializedName("amount")
        private double amount;
        @SerializedName("price")
        private double price;
        @SerializedName("filled")
        private double filled;
        @SerializedName("initial_margin")
        private double initialMargin;
        @SerializedName("avg_price")
        private double avgPrice;
        @SerializedName("created_timestamp")
        private long createdTimestamp;
        @SerializedName("timestamp")
        private long timestamp;
        @SerializedName("system_type")
        private String systemType;

        public String getOrderId() {
            return orderId;
        }

        public String getAccount() {
            return account;
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

        public String getOptionType() {
            return optionType;
        }

        public long getExpiry() {
            return expiry;
        }

        public double getStrike() {
            return strike;
        }

        public String getOrderType() {
            return orderType;
        }

        public String getOrderStatus() {
            return orderStatus;
        }

        public String getSide() {
            return side;
        }

        public double getAmount() {
            return amount;
        }

        public double getPrice() {
            return price;
        }

        public double getFilled() {
            return filled;
        }

        public double getInitialMargin() {
            return initialMargin;
        }

        public double getAvgPrice() {
            return avgPrice;
        }

        public long getCreatedTimestamp() {
            return createdTimestamp;
        }

        public long getTimestamp() {
            return timestamp;
        }

        public String getSystemType() {
            return systemType;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "orderId='" + orderId + '\'' +
                    ", account='" + account + '\'' +
                    ", instrumentId='" + instrumentId + '\'' +
                    ", instrumentName='" + instrumentName + '\'' +
                    ", instrumentType='" + instrumentType + '\'' +
                    ", optionType='" + optionType + '\'' +
                    ", expiry='" + expiry + '\'' +
                    ", strike='" + strike + '\'' +
                    ", orderType='" + orderType + '\'' +
                    ", orderStatus='" + orderStatus + '\'' +
                    ", side='" + side + '\'' +
                    ", amount='" + amount + '\'' +
                    ", price='" + price + '\'' +
                    ", filled='" + filled + '\'' +
                    ", initialMargin='" + initialMargin + '\'' +
                    ", avgPrice='" + avgPrice + '\'' +
                    ", createdTimestamp='" + createdTimestamp + '\'' +
                    ", timestamp='" + timestamp + '\'' +
                    ", systemType='" + systemType + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "EditedOrder{" +
                "data=" + getData() +
                ", id=" + getId() +
                '}';
    }
}
