package dev.alphaserpentis.web3.aevo4j.data.response.rest;

import com.google.gson.annotations.SerializedName;

public class Success {
    @SerializedName("success")
    private boolean success;

    public boolean isSuccess() {
        return success;
    }

    @Override
    public String toString() {
        return "Success{" +
                "success=" + success +
                '}';
    }
}
