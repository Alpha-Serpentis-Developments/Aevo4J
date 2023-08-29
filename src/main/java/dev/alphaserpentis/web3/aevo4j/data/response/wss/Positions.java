package dev.alphaserpentis.web3.aevo4j.data.response.wss;

import com.google.gson.annotations.SerializedName;
import dev.alphaserpentis.web3.aevo4j.data.response.common.Position;

import java.util.Arrays;

@SuppressWarnings("unused")
public class Positions extends Response<Fills.Data> {
    public static class Data {
        @SerializedName("timestamp")
        public String timestamp;
        @SerializedName("positions")
        public Position[] positions;

        public String getTimestamp() {
            return timestamp;
        }

        public Position[] getPositions() {
            return positions;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "timestamp='" + timestamp + '\'' +
                    ", positions=" + Arrays.toString(positions) +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "Positions{" +
                "data=" + getData() +
                ", channel='" + getChannel() + '\'' +
                ", id='" + getId() + '\''
                + '}';
    }
}
