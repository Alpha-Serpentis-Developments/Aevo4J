package dev.alphaserpentis.web3.aevo4j.data.response.rest;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

public class IndexHistory {
    @SerializedName("history")
    private String[][] history;

    public String[][] getHistory() {
        return history;
    }

    @Override
    public String toString() {
        return "IndexHistory{" +
                "history='" + Arrays.deepToString(history) + '\'' +
                '}';
    }
}
