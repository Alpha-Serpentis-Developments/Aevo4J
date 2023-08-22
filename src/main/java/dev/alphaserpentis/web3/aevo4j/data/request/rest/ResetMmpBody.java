package dev.alphaserpentis.web3.aevo4j.data.request.rest;

import com.google.gson.annotations.SerializedName;
import io.reactivex.rxjava3.annotations.NonNull;

@SuppressWarnings("unused")
public class ResetMmpBody {
    @SerializedName("asset")
    private final String asset;

    public ResetMmpBody(@NonNull String asset) {
        this.asset = asset;
    }
}
