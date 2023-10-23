package dev.alphaserpentis.web3.aevo4j.data.response.rest;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

@SuppressWarnings("unused")
public class Cancelled {
    @SerializedName("cancelled")
    private String[] cancelled;

    public String[] getCancelled() {
        return cancelled;
    }

    @Override
    public String toString() {
        return "Cancelled{" +
                "cancelled=" + Arrays.toString(cancelled) +
                '}';
    }
}
