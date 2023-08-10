package dev.alphaserpentis.web3.aevo4j.data.response.common;

import com.google.gson.annotations.SerializedName;

public class Index {
    @SerializedName("price")
    private String price;
    @SerializedName("timestamp")
    private String timestamp;

    public String getPrice() {
        return price;
    }

    public String getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "GetIndexResponse{" +
                "price='" + price + '\'' +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
}
