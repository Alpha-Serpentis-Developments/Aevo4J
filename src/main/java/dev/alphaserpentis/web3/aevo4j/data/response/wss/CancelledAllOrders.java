package dev.alphaserpentis.web3.aevo4j.data.response.wss;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

@SuppressWarnings("unused")
public class CancelledAllOrders extends Response<CancelledAllOrders.Data> {
    public static class Data {
        @SerializedName("success")
        public boolean success;
        @SerializedName("orders_ids")
        public String[] ordersIds;

        public boolean isSuccess() {
            return success;
        }

        public String[] getOrdersIds() {
            return ordersIds;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "success=" + success +
                    ", ordersIds=" + Arrays.toString(ordersIds) +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "CancelledAllOrders{" +
                "data=" + getData() +
                "id=" + getId() +
                '}';
    }
}
