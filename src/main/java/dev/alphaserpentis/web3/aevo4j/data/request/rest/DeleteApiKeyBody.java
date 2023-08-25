package dev.alphaserpentis.web3.aevo4j.data.request.rest;

import com.google.gson.annotations.SerializedName;
import io.reactivex.rxjava3.annotations.NonNull;

@SuppressWarnings("unused")
public class DeleteApiKeyBody {
    @SerializedName("api_key")
    private final String apiKey;

    public DeleteApiKeyBody(@NonNull String apiKey) {
        this.apiKey = apiKey;
    }
}
