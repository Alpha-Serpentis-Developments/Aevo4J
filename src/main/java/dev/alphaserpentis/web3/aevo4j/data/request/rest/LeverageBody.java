package dev.alphaserpentis.web3.aevo4j.data.request.rest;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class LeverageBody {
    @SerializedName("instrument")
    private long instrument;
    @SerializedName("leverage")
    private long leverage;

    public LeverageBody(long instrument, long leverage) {
        this.instrument = instrument;
        this.leverage = leverage;
    }
}
