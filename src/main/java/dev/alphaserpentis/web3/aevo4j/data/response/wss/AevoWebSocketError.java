package dev.alphaserpentis.web3.aevo4j.data.response.wss;

import com.google.gson.annotations.SerializedName;

/**
 * Error response from the websocket
 *
 * @see <a href="https://docs.aevo.xyz/reference/rate-limits-1#rate-limits-on-websocket-api">Aevo - Rate Limits on WebSocket API</a>
 * @see <a href="https://docs.aevo.xyz/reference/messaging-format-1#response-format">Aevo - Response Format</a>
 */
@SuppressWarnings("unused")
public class AevoWebSocketError extends Response<AevoWebSocketError.Data> {
    @SerializedName("status")
    private String status;
    @SerializedName("timestamp")
    private String timestamp;
    @SerializedName("error")
    private String error;

    public static class Data {
        @SerializedName("retry_after")
        private String retryAfter;

        /**
         * Get the number of nanoseconds to retry after if hitting the rate limit
         * @return the number of nanoseconds to retry after
         */
        public String getRetryAfter() {
            return retryAfter;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "retryAfter=" + retryAfter +
                    '}';
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

    @Override
    public String toString() {
        return "AevoWebSocketError{" +
                "id='" + getId() + '\'' +
                ", data=" + getData() +
                ", status='" + status + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", error='" + error + '\'' +
                '}';
    }
}
