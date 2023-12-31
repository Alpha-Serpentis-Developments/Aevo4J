package dev.alphaserpentis.web3.aevo4j.data.response.rest;

import com.google.gson.annotations.SerializedName;
import dev.alphaserpentis.web3.aevo4j.data.response.common.Order;

@SuppressWarnings("unused")
public class OrderHistory {
    @SerializedName("count")
    private long count;
    @SerializedName("order_history")
    private Order[] orderHistory;

    public long getCount() {
        return count;
    }

    public Order[] getOrderHistory() {
        return orderHistory;
    }

    @Override
    public String toString() {
        return "OrderHistory{"
                + "count='" + count + '\''
                + ", orderHistory=" + java.util.Arrays.toString(orderHistory)
                + '}';
    }
}
