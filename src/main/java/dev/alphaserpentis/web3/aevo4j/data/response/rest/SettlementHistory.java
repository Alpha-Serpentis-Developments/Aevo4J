package dev.alphaserpentis.web3.aevo4j.data.response.rest;

import com.google.gson.annotations.SerializedName;

public class SettlementHistory {
    @SerializedName("assset")
    private String asset;
    @SerializedName("expiry")
    private String expiry;
    @SerializedName("settlement_price")
    private String settlementPrice;
    @SerializedName("settlement_timestamp")
    private String settlementTimestamp;

    public String getAsset() {
        return asset;
    }

    public String getExpiry() {
        return expiry;
    }

    public String getSettlementPrice() {
        return settlementPrice;
    }

    public String getSettlementTimestamp() {
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
