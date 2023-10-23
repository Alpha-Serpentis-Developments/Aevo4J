package dev.alphaserpentis.web3.aevo4j.data.request.rest;

import com.google.gson.annotations.SerializedName;
import io.reactivex.rxjava3.annotations.NonNull;

@SuppressWarnings("unused")
public class UpdateMarginBody {
    @SerializedName("instrument")
    private final long instrument;
    @SerializedName("isolated_margin")
    private final String isolatedMargin;

    public UpdateMarginBody(long instrument, @NonNull String isolatedMargin) {
        this.instrument = instrument;
        this.isolatedMargin = isolatedMargin;
    }
}
