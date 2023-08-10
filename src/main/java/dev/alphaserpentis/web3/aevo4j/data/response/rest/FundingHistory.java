package dev.alphaserpentis.web3.aevo4j.data.response.rest;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

public class FundingHistory {
    @SerializedName("funding_history")
    private String[][] fundingHistory;

    public String[][] getFundingHistory() {
        return fundingHistory;
    }

    @Override
    public String toString() {
        return "FundingHistory{" +
                "fundingHistory='" + Arrays.deepToString(fundingHistory) + '\'' +
                '}';
    }
}
