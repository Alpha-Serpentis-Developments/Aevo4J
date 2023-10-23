package dev.alphaserpentis.web3.aevo4j.data.response.common;

import com.google.gson.annotations.SerializedName;

import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.zip.CRC32;

@SuppressWarnings("unused")
public class Orderbook {
    private static final DecimalFormat DF = new DecimalFormat("0.######");
    @SerializedName("type")
    private String type;
    @SerializedName("instrument_id")
    private long instrumentId;
    @SerializedName("instrument_name")
    private String instrumentName;
    @SerializedName("instrument_type")
    private String instrumentType;
    @SerializedName("bids")
    private double[][] bids;
    @SerializedName("asks")
    private double[][] asks;
    @SerializedName("last_updated")
    private long lastUpdated;
    @SerializedName("checksum")
    private long checksum;

    /**
     * Generates a checksum for the best 100 price levels of the orderbook. Use this to compare against the checksum provided by the API.
     * @param bids Bids in the orderbook
     * @param asks Asks in the orderbook
     * @return 32-bit integer checksum represented as a long
     * @see <a href="https://docs.aevo.xyz/reference/orderbook-checksum">Aevo - Orderbook Checksum</a>
     */
    public static long generateChecksum(double[][] bids, double[][] asks) {
        CRC32 crc32 = new CRC32();
        StringBuilder checksum = new StringBuilder();
        int bidsLength = bids.length;
        int asksLength = asks.length;
        int iterations = Math.min(Math.max(bidsLength, asksLength), 100);
        byte[] bytes;

        for(int i = 0; i < iterations; i++) {
            if(bidsLength > i) {
                checksum
                        .append(DF.format(bids[i][0])).append(':') // price
                        .append(DF.format(bids[i][1])).append(':'); // size
            }
            if(asksLength > i) {
                checksum.append(DF.format(asks[i][0])).append(':') // price
                        .append(DF.format(asks[i][1])).append(':'); // size
            }
        }

        checksum.setLength(checksum.length() - 1);
        bytes = checksum.toString().getBytes(StandardCharsets.UTF_8);
        crc32.update(bytes);

        return crc32.getValue();
    }

    public String getType() {
        return type;
    }

    public long getInstrumentId() {
        return instrumentId;
    }

    public String getInstrumentName() {
        return instrumentName;
    }

    public String getInstrumentType() {
        return instrumentType;
    }

    public double[][] getBids() {
        return bids;
    }

    public double[][] getAsks() {
        return asks;
    }

    public long getLastUpdated() {
        return lastUpdated;
    }

    public long getChecksum() {
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
