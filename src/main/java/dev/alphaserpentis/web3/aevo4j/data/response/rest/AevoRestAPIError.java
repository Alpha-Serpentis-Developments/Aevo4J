package dev.alphaserpentis.web3.aevo4j.data.response.rest;

import com.google.gson.annotations.SerializedName;

public class AevoRestAPIError {
    @SerializedName("error")
    private String error;
    @SerializedName("retry_after")
    private long retryAfter;

    public String getError() {
        return error;
    }

    public long getRetryAfter() {
        return retryAfter;
    }

    @Override
    public String toString() {
        return "Error{" +
                "error='" + error + '\'' +
                '}';
    }
}
