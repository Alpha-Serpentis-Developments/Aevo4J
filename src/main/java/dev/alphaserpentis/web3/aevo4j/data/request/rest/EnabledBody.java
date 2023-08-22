package dev.alphaserpentis.web3.aevo4j.data.request.rest;

import com.google.gson.annotations.SerializedName;

public class EnabledBody {
    @SerializedName("enabled")
    private final boolean enabled;

    public EnabledBody(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "{\"enabled\":" + enabled + "}";
    }
}
