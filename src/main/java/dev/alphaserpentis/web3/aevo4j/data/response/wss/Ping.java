package dev.alphaserpentis.web3.aevo4j.data.response.wss;

import com.google.gson.annotations.SerializedName;

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
