package dev.alphaserpentis.web3.aevo4j.data.response.rest;

import com.google.gson.annotations.SerializedName;
import dev.alphaserpentis.web3.aevo4j.data.response.common.Greeks;

@SuppressWarnings("unused")
public class InstrumentInfo {

    @SerializedName("asset")
    private String asset;
    @SerializedName("instrument_id")
    private long instrumentId;
    @SerializedName("instrument_name")
    private String instrumentName;
    @SerializedName("instrument_type")
    private String instrumentType;
    @SerializedName("markets")
    private Markets markets;
    @SerializedName("greeks")
    private Greeks greeks;

    public static class Markets {
        @SerializedName("daily_volume")
        private double dailyVolume;
        @SerializedName("daily_volume_contracts")
        private double dailyVolumeContracts;
        @SerializedName("total_volume")
        private double totalVolume;
        @SerializedName("total_volume_contracts")
        private double totalVolumeContracts;
        @SerializedName("total_oi")
        private double totalOi;

        public double getDailyVolume() {
            return dailyVolume;
        }

        public double getDailyVolumeContracts() {
            return dailyVolumeContracts;
        }

        public double getTotalVolume() {
            return totalVolume;
        }

        public double getTotalVolumeContracts() {
            return totalVolumeContracts;
        }

        public double getTotalOi() {
            return totalOi;
        }

        @Override
        public String toString() {
            return "Markets{" +
                    "dailyVolume='" + dailyVolume + '\'' +
                    ", dailyVolumeContracts='" + dailyVolumeContracts + '\'' +
                    ", totalVolume='" + totalVolume + '\'' +
                    ", totalVolumeContracts='" + totalVolumeContracts + '\'' +
                    ", totalOi='" + totalOi + '\'' +
                    '}';
        }
    }

    public String getAsset() {
        return asset;
    }

    public long getInstrumentId() {
        return instrumentId;
    }

    public String getInstrumentName() {
        return instrumentName;
    }

    public String getInstrumentType() {
        return instrumentType;
    }

    public Markets getMarkets() {
        return markets;
    }

    public Greeks getGreeks() {
        return greeks;
    }

    @Override
    public String toString() {
        return "GetInstrumentInformationResponse{" +
                "asset='" + asset + '\'' +
                ", instrumentId='" + instrumentId + '\'' +
                ", instrumentName='" + instrumentName + '\'' +
                ", instrumentType='" + instrumentType + '\'' +
                ", markets=" + markets +
                ", greeks=" + greeks +
                '}';
    }
}
