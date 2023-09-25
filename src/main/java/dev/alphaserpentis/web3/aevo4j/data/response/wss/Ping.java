package dev.alphaserpentis.web3.aevo4j.data.response.wss;

import com.google.gson.annotations.SerializedName;
import dev.alphaserpentis.web3.aevo4j.api.endpoints.websocket.impl.PingListener;

/**
 * Data returned from the server
 *
 * @see PingListener
 * @see <a href="https://docs.aevo.xyz/reference/publish-ping">Aevo - PUBLISH Ping</a>
 */
@SuppressWarnings("unused")
public class Ping extends Response<Ping.Data> {
    public static class Data {
        @SerializedName("success")
        private boolean success;
        @SerializedName("timestamp")
        private long timestamp;

        public boolean getSuccess() {
            return success;
        }

        public long getTimestamp() {
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
