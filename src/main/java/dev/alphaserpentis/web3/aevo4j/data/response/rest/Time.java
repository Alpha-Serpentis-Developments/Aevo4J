package dev.alphaserpentis.web3.aevo4j.data.response.rest;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Time {
    @SerializedName("name")
    private String name;
    @SerializedName("timestamp")
    private long timestamp;
    @SerializedName("time")
    private String time;
    @SerializedName("sequence")
    private long sequence;
    @SerializedName("block")
    private String block;

    public String getName() {
        return name;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getTime() {
        return time;
    }

    public long getSequence() {
        return sequence;
    }

    public String getBlock() {
        return block;
    }

    @Override
    public String toString() {
        return "Time{" +
                "name='" + name + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", time='" + time + '\'' +
                ", sequence='" + sequence + '\'' +
                ", block='" + block + '\'' +
                '}';
    }
}
