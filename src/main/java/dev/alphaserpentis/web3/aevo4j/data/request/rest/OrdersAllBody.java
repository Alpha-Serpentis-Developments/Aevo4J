package dev.alphaserpentis.web3.aevo4j.data.request.rest;

import com.google.gson.annotations.SerializedName;
import io.reactivex.rxjava3.annotations.Nullable;

@SuppressWarnings("unused")
public class OrdersAllBody {
    @SerializedName("asset")
    private final String asset;
    @SerializedName("instrument_type")
    private final String instrumentType;

    public OrdersAllBody(@Nullable String asset, @Nullable String instrumentType) {
        this.asset = asset;
        this.instrumentType = instrumentType;
    }
}
