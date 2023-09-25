package dev.alphaserpentis.web3.aevo4j.data.response.rest;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Funding {
    @SerializedName("funding_rate")
    private double fundingRate;
    @SerializedName("next_epoch")
    private long nextEpoch;

    public double getFundingRate() {
        return fundingRate;
    }

    public long getNextEpoch() {
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
