package dev.alphaserpentis.web3.aevo4j.data.response.wss;

import com.google.gson.annotations.SerializedName;

/**
 * Data returned from the server
 *
 * @see dev.alphaserpentis.web3.aevo4j.api.endpoints.websocket.PingListener
 * @see <a href="https://docs.aevo.xyz/reference/publish-ping">Aevo - PUBLISH Ping</a>
 */
public class Ping extends Response<Ping.Data> {
    public static class Data {
        @SerializedName("success")
        private boolean success;
        @SerializedName("timestamp")
        private String timestamp;

        public boolean getSuccess() {
            return success;
        }

        public String getTimestamp() {
            return timestamp;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "success='" + success + '\'' +
                    ", timestamp='" + timestamp + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "Ping{" +
                "channel='" + getChannel() + '\'' +
                ", data=" + getData() +
                '}';
    }
}
