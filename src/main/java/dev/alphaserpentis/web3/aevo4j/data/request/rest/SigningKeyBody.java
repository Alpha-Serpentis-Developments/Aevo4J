package dev.alphaserpentis.web3.aevo4j.data.request.rest;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class SigningKeyBody {
    @SerializedName("signing_key")
    private final String signingKey;

    public SigningKeyBody(String signingKey) {
        this.signingKey = signingKey;
    }
}
