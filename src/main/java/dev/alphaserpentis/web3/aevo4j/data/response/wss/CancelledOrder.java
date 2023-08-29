package dev.alphaserpentis.web3.aevo4j.data.response.wss;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class CancelledOrder extends Response<CancelledOrder.Data> {
    public static class Data {
        @SerializedName("order_id")
        public String orderId;
        @SerializedName("success")
        public boolean success;

        public String getOrderId() {
            return orderId;
        }

        public boolean isSuccess() {
            return success;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "orderId='" + orderId + '\'' +
                    ", success=" + success +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "CancelledOrder{" +
                "data=" + getData() +
                "id=" + getId() +
                '}';
    }
}
