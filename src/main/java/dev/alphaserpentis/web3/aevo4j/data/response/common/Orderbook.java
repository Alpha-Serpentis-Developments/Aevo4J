package dev.alphaserpentis.web3.aevo4j.data.response.common;

import com.google.gson.annotations.SerializedName;
import io.reactivex.rxjava3.annotations.NonNull;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.zip.CRC32;

public class Orderbook {
    @SerializedName("type")
    private String type;
    @SerializedName("instrument_id")
    private String instrumentId;
    @SerializedName("instrument_name")
    private String instrumentName;
    @SerializedName("instrument_type")
    private String instrumentType;
    @SerializedName("bids")
    private String[][] bids;
    @SerializedName("asks")
    private String[][] asks;
    @SerializedName("last_updated")
    private String lastUpdated;
    @SerializedName("checksum")
    private String checksum;

    /**
     * Generates a checksum for the best 100 price levels of the orderbook. Use this to compare against the checksum provided by the API.
     * @param bids Bids in the orderbook
     * @param asks Asks in the orderbook
     * @return 32-bit integer checksum represented as a base-10 string
     * @see <a href="https://docs.aevo.xyz/reference/orderbook-checksum">Aevo - Orderbook Checksum</a>
     */
    public static String generateChecksum(@NonNull String[][] bids, @NonNull String[][] asks) {
        CRC32 crc32 = new CRC32();
        StringBuilder checksum = new StringBuilder();
        int iterations = Math.max(bids.length, asks.length);
        byte[] bytes;

        for(int i = 0; i < Math.min(iterations, 100); i++) {
            if(bids.length > i) {
                checksum.append(bids[i][0]); // price
                checksum.append(":");
                checksum.append(bids[i][1]); // size
                checksum.append(":");
            }
            if(asks.length > i) {
                checksum.append(asks[i][0]); // price
                checksum.append(":");
                checksum.append(asks[i][1]); // size
                checksum.append(":");
            }
        }

        checksum.deleteCharAt(checksum.length() - 1);
        bytes = checksum.toString().getBytes(StandardCharsets.UTF_8);
        crc32.update(bytes);

        return String.valueOf(crc32.getValue());
    }

    public String getType() {
        return type;
    }

    public String getInstrumentId() {
        return instrumentId;
    }

    public String getInstrumentName() {
        return instrumentName;
    }

    public String getInstrumentType() {
        return instrumentType;
    }

    public String[][] getBids() {
        return bids;
    }

    public String[][] getAsks() {
        return asks;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public String getChecksum() {
        return checksum;
    }

    @Override
    public String toString() {
        return "GetOrderbook{" +
                "type='" + type + '\'' +
                ", instrumentId='" + instrumentId + '\'' +
                ", instrumentName='" + instrumentName + '\'' +
                ", bids='" + Arrays.deepToString(bids) + '\'' +
                ", asks='" + Arrays.deepToString(asks) + '\'' +
                ", lastUpdated='" + lastUpdated + '\'' +
                ", checksum='" + checksum + '\'' +
                '}';
    }
}
