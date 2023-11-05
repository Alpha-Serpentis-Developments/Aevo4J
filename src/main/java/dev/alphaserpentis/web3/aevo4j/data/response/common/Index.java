package dev.alphaserpentis.web3.aevo4j.data.response.common;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Index {
    @SerializedName("price")
    private double price;
    @SerializedName("timestamp")
    private long timestamp;

    public double getPrice() {
        return price;
    }

    public long getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "Index{" +
                "price='" + price + '\'' +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
}
