package dev.alphaserpentis.web3.aevo4j.data.response.rest;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Statistics {
    @SerializedName("asset")
    private String asset;
    @SerializedName("open_interest")
    private OpenInterest openInterest;
    @SerializedName("daily_volume")
    private double dailyVolume;
    @SerializedName("daily_volume_premium")
    private double dailyVolumePremium;
    @SerializedName("total_volume")
    private double totalVolume;
    @SerializedName("total_volume_premium")
    private double totalVolumePremium;
    @SerializedName("daily_volume_contracts")
    private double dailyVolumeContracts;
    @SerializedName("index_price")
    private double indexPrice;
    @SerializedName("index_daily_change")
    private double indexDailyChange;
    @SerializedName("mark_price")
    private double markPrice;
    @SerializedName("mark_daily_change")
    private double markDailyChange;
    @SerializedName("funding_daily_avg")
    private double fundingDailyAvg;
    @SerializedName("put_call_ratio")
    private double putCallRatio;

    public static class OpenInterest {
        @SerializedName("calls")
        private double calls;
        @SerializedName("puts")
        private double puts;
        @SerializedName("total")
        private double total;

        public double getCalls() {
            return calls;
        }

        public double getPuts() {
            return puts;
        }

        public double getTotal() {
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

    public double getDailyVolume() {
        return dailyVolume;
    }

    public double getDailyVolumePremium() {
        return dailyVolumePremium;
    }

    public double getTotalVolume() {
        return totalVolume;
    }

    public double getTotalVolumePremium() {
        return totalVolumePremium;
    }

    public double getDailyVolumeContracts() {
        return dailyVolumeContracts;
    }

    public double getIndexPrice() {
        return indexPrice;
    }

    public double getIndexDailyChange() {
        return indexDailyChange;
    }

    public double getMarkPrice() {
        return markPrice;
    }

    public double getMarkDailyChange() {
        return markDailyChange;
    }

    public double getFundingDailyAvg() {
        return fundingDailyAvg;
    }

    public double getPutCallRatio() {
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
