package dev.alphaserpentis.web3.aevo4j.data.response.common;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

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
