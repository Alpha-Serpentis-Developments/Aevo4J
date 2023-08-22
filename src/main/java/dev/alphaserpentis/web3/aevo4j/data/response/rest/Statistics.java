package dev.alphaserpentis.web3.aevo4j.data.response.rest;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Statistics {
    @SerializedName("asset")
    private String asset;
    @SerializedName("open_interest")
    private OpenInterest openInterest;
    @SerializedName("daily_volume")
    private String dailyVolume;
    @SerializedName("daily_volume_premium")
    private String dailyVolumePremium;
    @SerializedName("total_volume")
    private String totalVolume;
    @SerializedName("total_volume_premium")
    private String totalVolumePremium;
    @SerializedName("daily_volume_contracts")
    private String dailyVolumeContracts;
    @SerializedName("index_price")
    private String indexPrice;
    @SerializedName("index_daily_change")
    private String indexDailyChange;
    @SerializedName("mark_price")
    private String markPrice;
    @SerializedName("mark_daily_change")
    private String markDailyChange;
    @SerializedName("funding_daily_avg")
    private String fundingDailyAvg;
    @SerializedName("put_call_ratio")
    private String putCallRatio;

    public static class OpenInterest {
        @SerializedName("calls")
        private String calls;
        @SerializedName("puts")
        private String puts;
        @SerializedName("total")
        private String total;

        public String getCalls() {
            return calls;
        }

        public String getPuts() {
            return puts;
        }

        public String getTotal() {
            return total;
        }

        @Override
        public String toString() {
            return "OpenInterest{" +
                    "calls='" + calls + '\'' +
                    ", puts='" + puts + '\'' +
                    ", total='" + total + '\'' +
                    '}';
        }
    }

    public String getAsset() {
        return asset;
    }

    public OpenInterest getOpenInterest() {
        return openInterest;
    }

    public String getDailyVolume() {
        return dailyVolume;
    }

    public String getDailyVolumePremium() {
        return dailyVolumePremium;
    }

    public String getTotalVolume() {
        return totalVolume;
    }

    public String getTotalVolumePremium() {
        return totalVolumePremium;
    }

    public String getDailyVolumeContracts() {
        return dailyVolumeContracts;
    }

    public String getIndexPrice() {
        return indexPrice;
    }

    public String getIndexDailyChange() {
        return indexDailyChange;
    }

    public String getMarkPrice() {
        return markPrice;
    }

    public String getMarkDailyChange() {
        return markDailyChange;
    }

    public String getFundingDailyAvg() {
        return fundingDailyAvg;
    }

    public String getPutCallRatio() {
        return putCallRatio;
    }

    @Override
    public String toString() {
        return "Statistics{" +
                "asset='" + asset + '\'' +
                ", openInterest=" + openInterest +
                ", dailyVolume='" + dailyVolume + '\'' +
                ", dailyVolumePremium='" + dailyVolumePremium + '\'' +
                ", totalVolume='" + totalVolume + '\'' +
                ", totalVolumePremium='" + totalVolumePremium + '\'' +
                ", dailyVolumeContracts='" + dailyVolumeContracts + '\'' +
                ", indexPrice='" + indexPrice + '\'' +
                ", indexDailyChange='" + indexDailyChange + '\'' +
                ", markPrice='" + markPrice + '\'' +
                ", markDailyChange='" + markDailyChange + '\'' +
                ", fundingDailyAvg='" + fundingDailyAvg + '\'' +
                ", putCallRatio='" + putCallRatio + '\'' +
                '}';
    }
}
