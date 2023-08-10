package dev.alphaserpentis.web3.aevo4j.data.response.rest;

import com.google.gson.annotations.SerializedName;

public class InstrumentInfo {

    @SerializedName("asset")
    private String asset;
    @SerializedName("instrument_id")
    private String instrumentId;
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
        private String dailyVolume;
        @SerializedName("daily_volume_contracts")
        private String dailyVolumeContracts;
        @SerializedName("total_volume")
        private String totalVolume;
        @SerializedName("total_volume_contracts")
        private String totalVolumeContracts;
        @SerializedName("total_oi")
        private String totalOi;

        public String getDailyVolume() {
            return dailyVolume;
        }

        public String getDailyVolumeContracts() {
            return dailyVolumeContracts;
        }

        public String getTotalVolume() {
            return totalVolume;
        }

        public String getTotalVolumeContracts() {
            return totalVolumeContracts;
        }

        public String getTotalOi() {
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

    public static class Greeks {
        @SerializedName("delta")
        private String delta;
        @SerializedName("gamma")
        private String gamma;
        @SerializedName("rho")
        private String rho;
        @SerializedName("theta")
        private String theta;
        @SerializedName("vega")
        private String vega;
        @SerializedName("iv")
        private String iv;

        public String getDelta() {
            return delta;
        }

        public String getGamma() {
            return gamma;
        }

        public String getRho() {
            return rho;
        }

        public String getTheta() {
            return theta;
        }

        public String getVega() {
            return vega;
        }

        public String getIv() {
            return iv;
        }

        @Override
        public String toString() {
            return "Greeks{" +
                    "delta='" + delta + '\'' +
                    ", gamma='" + gamma + '\'' +
                    ", rho='" + rho + '\'' +
                    ", theta='" + theta + '\'' +
                    ", vega='" + vega + '\'' +
                    ", iv='" + iv + '\'' +
                    '}';
        }
    }

    public String getAsset() {
        return asset;
    }

    public String getInstrumentId() {
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
