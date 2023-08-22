package dev.alphaserpentis.web3.aevo4j.data.response.rest;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class OrderId {
    @SerializedName("order_id")
    private String orderId;

    public String getOrderId() {
        return orderId;
    }

    @Override
    public String toString() {
        return "OrderId{"
                + "orderId='" + orderId + '\''
                + '}';
    }
}
