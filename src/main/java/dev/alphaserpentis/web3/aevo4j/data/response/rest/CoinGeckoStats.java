package dev.alphaserpentis.web3.aevo4j.data.response.rest;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class CoinGeckoStats {
    @SerializedName("ticker_id")
    private String tickerId;
    @SerializedName("base_currency")
    private String baseCurrency;
    @SerializedName("target_currency")
    private String targetCurrency;
    @SerializedName("target_volume")
    private String targetVolume;
    @SerializedName("product_volume")
    private String productVolume;
    @SerializedName("open_interest")
    private String openInterest;
    @SerializedName("index_price")
    private String indexPrice;
    @SerializedName("index_currency")
    private String indexCurrency;
    @SerializedName("next_funding_rate_timestamp")
    private String nextFundingRateTimestamp;
    @SerializedName("funding_rate")
    private String fundingRate;
    @SerializedName("contract_type")
    private String contractType;
    @SerializedName("contract_price_currency")
    private String contractPriceCurrency;

    public String getTickerId() {
        return tickerId;
    }

    public String getBaseCurrency() {
        return baseCurrency;
    }

    public String getTargetCurrency() {
        return targetCurrency;
    }

    public String getTargetVolume() {
        return targetVolume;
    }

    public String getProductVolume() {
        return productVolume;
    }

    public String getOpenInterest() {
        return openInterest;
    }

    public String getIndexPrice() {
        return indexPrice;
    }

    public String getIndexCurrency() {
        return indexCurrency;
    }

    public String getNextFundingRateTimestamp() {
        return nextFundingRateTimestamp;
    }

    public String getFundingRate() {
        return fundingRate;
    }

    public String getContractType() {
        return contractType;
    }

    public String getContractPriceCurrency() {
        return contractPriceCurrency;
    }

    @Override
    public String toString() {
        return "CoinGeckoStats{" +
                "tickerId='" + tickerId + '\'' +
                ", baseCurrency='" + baseCurrency + '\'' +
                ", targetCurrency='" + targetCurrency + '\'' +
                ", targetVolume='" + targetVolume + '\'' +
                ", productVolume='" + productVolume + '\'' +
                ", openInterest='" + openInterest + '\'' +
                ", indexPrice='" + indexPrice + '\'' +
                ", indexCurrency='" + indexCurrency + '\'' +
                ", nextFundingRateTimestamp='" + nextFundingRateTimestamp + '\'' +
                ", fundingRate='" + fundingRate + '\'' +
                ", contractType='" + contractType + '\'' +
                ", contractPriceCurrency='" + contractPriceCurrency + '\'' +
                '}';
    }
}
