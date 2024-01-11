package dev.alphaserpentis.web3.aevo4j.data.response.rest;

import com.google.gson.annotations.SerializedName;
import io.reactivex.rxjava3.annotations.Nullable;

public class YieldVault {
    @SerializedName("aum")
    private double aum;
    @SerializedName("aum_liquid")
    private double aumLiquid;
    @SerializedName("cap")
    private double cap;
    @SerializedName("pps")
    private double pps;
    @SerializedName("apy")
    private double apy;
    @SerializedName("pending_withdrawals")
    private double pendingWithdrawals;
    @SerializedName("is_paused")
    private Boolean isPaused;

    public double getAum() {
        return aum;
    }
    public double getAumLiquid() {
        return aumLiquid;
    }

    public double getCap() {
        return cap;
    }

    public double getPps() {
        return pps;
    }

    public double getApy() {
        return apy;
    }

    public double getPendingWithdrawals() {
        return pendingWithdrawals;
    }

    @Nullable
    public Boolean getPaused() {
        return isPaused;
    }
}
