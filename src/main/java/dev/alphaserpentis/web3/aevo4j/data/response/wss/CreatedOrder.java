package dev.alphaserpentis.web3.aevo4j.data.response.wss;

import com.google.gson.annotations.SerializedName;

/**
 * @see <a href="https://api-docs.aevo.xyz/reference/publish-create-order">Aevo - PUBLISH Create Order</a>
 */
@SuppressWarnings("unused")
public class CreatedOrder extends Response<CreatedOrder.Data> {
    public static class Data {
        @SerializedName("order_id")
        private String orderId;
        @SerializedName("account")
        private String account;
        @SerializedName("instrument_id")
        private String instrumentId;
        @SerializedName("instrument_name")
        private String instrumentName;
        @SerializedName("instrument_type")
        private String instrumentType;
        @SerializedName("option_type")
        private String optionType;
        @SerializedName("expiry")
        private String expiry;
        @SerializedName("strike")
        private String strike;
        @SerializedName("order_type")
        private String orderType;
        @SerializedName("order_status")
        private String orderStatus;
        @SerializedName("side")
        private String side;
        @SerializedName("amount")
        private String amount;
        @SerializedName("price")
        private String price;
        @SerializedName("filled")
        private String filled;
        @SerializedName("initial_margin")
        private String initialMargin;
        @SerializedName("avg_price")
        private String avgPrice;
        @SerializedName("created_timestamp")
        private String createdTimestamp;
        @SerializedName("timestamp")
        private String timestamp;
        @SerializedName("system_type")
        private String systemType;

        public String getOrderId() {
            return orderId;
        }

        public String getAccount() {
            return account;
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

        public String getOptionType() {
            return optionType;
        }

        public String getExpiry() {
            return expiry;
        }

        public String getStrike() {
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

        public String getAmount() {
            return amount;
        }

        public String getPrice() {
            return price;
        }

        public String getFilled() {
            return filled;
        }

        public String getInitialMargin() {
            return initialMargin;
        }

        public String getAvgPrice() {
            return avgPrice;
        }

        public String getCreatedTimestamp() {
            return createdTimestamp;
        }

        public String getTimestamp() {
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
        return "CreatedOrder{" +
                "id='" + getId() + '\'' +
                ", data=" + getData() +
                '}';
    }
}
