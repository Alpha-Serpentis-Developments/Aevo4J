package dev.alphaserpentis.web3.aevo4j.data.response.rest;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

public class MarkHistory {
    @SerializedName("history")
    private String[][] history;

    public String[][] getHistory() {
        return history;
    }

    @Override
    public String toString() {
        return "MarkHistory{" +
                "history='" + Arrays.deepToString(history) + '\'' +
                '}';
    }
}
