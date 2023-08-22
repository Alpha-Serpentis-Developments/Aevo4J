package dev.alphaserpentis.web3.aevo4j.data.response.rest;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Mmp {
    @SerializedName("enabled")
    private boolean enabled;
    @SerializedName("triggered")
    private boolean triggered;
    @SerializedName("interval")
    private String interval;
    @SerializedName("frozen")
    private String frozen;
    @SerializedName("frozen_end_time")
    private String frozenEndTime;
    @SerializedName("amount_limit")
    private String amountLimit;
    @SerializedName("delta_limit")
    private String deltaLimit;
    @SerializedName("amount_change")
    private String amountChange;
    @SerializedName("delta_change")
    private String deltaChange;
    @SerializedName("asset")
    private String asset;

    public boolean isEnabled() {
        return enabled;
    }

    public boolean isTriggered() {
        return triggered;
    }

    public String getInterval() {
        return interval;
    }

    public String getFrozen() {
        return frozen;
    }

    public String getFrozenEndTime() {
        return frozenEndTime;
    }

    public String getAmountLimit() {
        return amountLimit;
    }

    public String getDeltaLimit() {
        return deltaLimit;
    }

    public String getAmountChange() {
        return amountChange;
    }

    public String getDeltaChange() {
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
