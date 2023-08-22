package dev.alphaserpentis.web3.aevo4j.data.response.rest;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class OrderHistory {
    @SerializedName("count")
    private String count;
    @SerializedName("order_history")
    private Order[] orderHistory;

    public String getCount() {
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
