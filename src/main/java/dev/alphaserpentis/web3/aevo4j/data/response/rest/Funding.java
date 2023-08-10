package dev.alphaserpentis.web3.aevo4j.data.response.rest;

import com.google.gson.annotations.SerializedName;

public class Funding {
    @SerializedName("funding_rate")
    private String fundingRate;
    @SerializedName("next_epoch")
    private String nextEpoch;

    public String getFundingRate() {
        return fundingRate;
    }

    public String getNextEpoch() {
        return nextEpoch;
    }

    @Override
    public String toString() {
        return "Funding{" +
                "fundingRate='" + fundingRate + '\'' +
                ", nextEpoch='" + nextEpoch + '\'' +
                '}';
    }
}
