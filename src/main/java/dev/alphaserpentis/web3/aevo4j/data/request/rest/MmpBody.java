package dev.alphaserpentis.web3.aevo4j.data.request.rest;

import com.google.gson.annotations.SerializedName;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;

@SuppressWarnings("unused")
public class MmpBody {
    @SerializedName("interval")
    private final int interval;
    @SerializedName("frozen")
    private final int frozen;
    @SerializedName("amount_limit")
    private final String amountLimit;
    @SerializedName("delta_limit")
    private final Float deltaLimit;
    @SerializedName("asset")
    private final String asset;

    public MmpBody(
            int interval,
            int frozen,
            @NonNull String amountLimit,
            @Nullable Float deltaLimit,
            @NonNull String asset
    ) {
        this.interval = interval;
        this.frozen = frozen;
        this.amountLimit = amountLimit;
        this.deltaLimit = deltaLimit;
        this.asset = asset;
    }

    public MmpBody(
            int interval,
            int frozen,
            @NonNull String amountLimit,
            @NonNull String asset
    ) {
        this(interval, frozen, amountLimit, null, asset);
    }
}
