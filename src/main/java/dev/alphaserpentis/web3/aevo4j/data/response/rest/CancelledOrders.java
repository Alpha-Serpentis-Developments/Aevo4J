package dev.alphaserpentis.web3.aevo4j.data.response.rest;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

@SuppressWarnings("unused")
public class CancelledOrders extends Success {
    @SerializedName("order_ids")
    private String[] orderIds;

    public String[] getOrderIds() {
        return orderIds;
    }

    @Override
    public String toString() {
        return "CancelledOrders{" +
                "orderIds=" + Arrays.toString(orderIds) +
                '}';
    }
}
