package dev.alphaserpentis.web3.aevo4j.data.response.rest;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Mmp {
    @SerializedName("enabled")
    private boolean enabled;
    @SerializedName("triggered")
    private boolean triggered;
    @SerializedName("interval")
    private double interval;
    @SerializedName("frozen")
    private double frozen;
    @SerializedName("frozen_end_time")
    private long frozenEndTime;
    @SerializedName("amount_limit")
    private long amountLimit;
    @SerializedName("delta_limit")
    private double deltaLimit;
    @SerializedName("amount_change")
    private double amountChange;
    @SerializedName("delta_change")
    private double deltaChange;
    @SerializedName("asset")
    private String asset;

    public boolean isEnabled() {
        return enabled;
    }

    public boolean isTriggered() {
        return triggered;
    }

    public double getInterval() {
        return interval;
    }

    public double getFrozen() {
        return frozen;
    }

    public long getFrozenEndTime() {
        return frozenEndTime;
    }

    public long getAmountLimit() {
        return amountLimit;
    }

    public double getDeltaLimit() {
        return deltaLimit;
    }

    public double getAmountChange() {
        return amountChange;
    }

    public double getDeltaChange() {
        return deltaChange;
    }

    public String getAsset() {
        return asset;
    }

    @Override
    public String toString() {
        return "Mmp{"
                + "enabled=" + enabled
                + ", triggered=" + triggered
                + ", interval='" + interval + '\''
                + ", frozen='" + frozen + '\''
                + ", frozenEndTime='" + frozenEndTime + '\''
                + ", amountLimit='" + amountLimit + '\''
                + ", deltaLimit='" + deltaLimit + '\''
                + ", amountChange='" + amountChange + '\''
                + ", deltaChange='" + deltaChange + '\''
                + ", asset='" + asset + '\''
                + '}';
    }
}
