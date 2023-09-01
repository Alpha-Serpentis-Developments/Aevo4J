package dev.alphaserpentis.web3.aevo4j.data.response.rest;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class SettlementHistory {
    @SerializedName("assset")
    private String asset;
    @SerializedName("expiry")
    private long expiry;
    @SerializedName("settlement_price")
    private double settlementPrice;
    @SerializedName("settlement_timestamp")
    private long settlementTimestamp;

    public String getAsset() {
        return asset;
    }

    public long getExpiry() {
        return expiry;
    }

    public double getSettlementPrice() {
        return settlementPrice;
    }

    public long getSettlementTimestamp() {
        return settlementTimestamp;
    }

    @Override
    public String toString() {
        return "SettlementHistory{" +
                "asset='" + asset + '\'' +
                ", expiry='" + expiry + '\'' +
                ", settlementPrice='" + settlementPrice + '\'' +
                ", settlementTimestamp='" + settlementTimestamp + '\'' +
                '}';
    }
}
