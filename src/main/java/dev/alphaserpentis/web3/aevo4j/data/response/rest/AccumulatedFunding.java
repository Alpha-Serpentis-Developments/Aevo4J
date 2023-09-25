package dev.alphaserpentis.web3.aevo4j.data.response.rest;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

@SuppressWarnings("unused")
public class AccumulatedFunding {
    @SerializedName("accumulated_fundings")
    private AccumulatedFundingData[] accumulatedFundings;

    public static class AccumulatedFundingData {
        @SerializedName("instrument_id")
        private long instrumentId;
        @SerializedName("accumulated_funding")
        private double accumulatedFunding;

        public long getInstrumentId() {
            return instrumentId;
        }

        public double getAccumulatedFunding() {
            return accumulatedFunding;
        }

        @Override
        public String toString() {
            return "AccumulatedFundingData{" +
                    "instrumentId=" + instrumentId +
                    ", accumulatedFunding=" + accumulatedFunding +
                    '}';
        }
    }

    public AccumulatedFundingData[] getAccumulatedFundings() {
        return accumulatedFundings;
    }

    @Override
    public String toString() {
        return "AccumulatedFunding{" +
                "accumulatedFundings=" + Arrays.toString(accumulatedFundings) +
                '}';
    }
}
