package dev.alphaserpentis.web3.aevo4j.data.request.wss;

import com.google.gson.annotations.SerializedName;

public class OrderId {
    @SerializedName("order_id")
    public String orderId;

    public OrderId(String orderId) {
        this.orderId = orderId;
    }
}
