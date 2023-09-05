package dev.alphaserpentis.web3.aevo4j.data.request.rest;

import com.google.gson.annotations.SerializedName;
import io.reactivex.rxjava3.annotations.NonNull;

@SuppressWarnings("unused")
public class SigningKeyBody {
    @SerializedName("signing_key")
    private final String signingKey;

    public SigningKeyBody(@NonNull String signingKey) {
        this.signingKey = signingKey;
    }
}
