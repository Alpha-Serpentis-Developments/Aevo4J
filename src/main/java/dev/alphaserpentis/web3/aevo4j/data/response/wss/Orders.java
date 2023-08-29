package dev.alphaserpentis.web3.aevo4j.data.response.wss;

import com.google.gson.annotations.SerializedName;
import dev.alphaserpentis.web3.aevo4j.data.response.common.Order;

import java.util.Arrays;

@SuppressWarnings("unused")
public class Orders extends Response<Orders.Data> {
    public static class Data {
        @SerializedName("timestamp")
        public String timestamp;
        @SerializedName("orders")
        public Order[] orders;

        public String getTimestamp() {
            return timestamp;
        }

        public Order[] getOrders() {
            return orders;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "timestamp='" + timestamp + '\'' +
                    ", orders=" + Arrays.toString(orders) +
                    '}';
        }
    }

    @Override
public String toString() {
        return "Orders{" +
                "data=" + getData() +
                ", channel='" + getChannel() + '\'' +
                ", id='" + getId() + '\''
                + '}';
    }
}
