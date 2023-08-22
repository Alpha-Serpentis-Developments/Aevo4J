package dev.alphaserpentis.web3.aevo4j.data.response.rest;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Enabled {
    @SerializedName("enabled")
    private boolean enabled;

    public boolean getEnabled() {
        return enabled;
    }

    @Override
    public String toString() {
        return "Enabled{" +
                "enabled='" + enabled + '\'' +
                '}';
    }
}
