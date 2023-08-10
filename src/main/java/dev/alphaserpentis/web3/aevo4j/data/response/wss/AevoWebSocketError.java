package dev.alphaserpentis.web3.aevo4j.data.response.wss;

import com.google.gson.annotations.SerializedName;

public class AevoWebSocketError extends Response<AevoWebSocketError.Data> {
    @SerializedName("status")
    private String status;
    @SerializedName("timestamp")
    private String timestamp;
    @SerializedName("error")
    private String error;

    public static class Data {
        @SerializedName("retry_after")
        private long retryAfter;

        public long getRetryAfter() {
            return retryAfter;
        }
    }

    public String getStatus() {
        return status;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getError() {
        return error;
    }
}
