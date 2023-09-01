package dev.alphaserpentis.web3.aevo4j.data.response.rest;

import com.google.gson.annotations.SerializedName;
import dev.alphaserpentis.web3.aevo4j.data.response.common.Greeks;

@SuppressWarnings("unused")
public class Markets {
    @SerializedName("instrument_id")
    private long instrumentId;
    @SerializedName("instrument_name")
    private String instrumentName;
    @SerializedName("instrument_type")
    private String instrumentType;
    @SerializedName("underlying_asset")
    private String underlyingAsset;
    @SerializedName("quote_asset")
    private String quoteAsset;
    @SerializedName("price_step")
    private double priceStep;
    @SerializedName("amount_step")
    private double amountStep;
    @SerializedName("min_order_value")
    private double minOrderValue;
    @SerializedName("mark_price")
    private double markPrice;
    @SerializedName("is_active")
    private boolean isActive;
    @SerializedName("option_type")
    private String optionType;
    @SerializedName("expiry")
    private String expiry;
    @SerializedName("strike")
    private double strike;
    @SerializedName("greeks")
    private Greeks greeks;

    public long getInstrumentId() {
        return instrumentId;
    }

    public String getInstrumentName() {
        return instrumentName;
    }

    public String getInstrumentType() {
        return instrumentType;
    }

    public String getUnderlyingAsset() {
        return underlyingAsset;
    }

    public String getQuoteAsset() {
        return quoteAsset;
    }

    public double getPriceStep() {
        return priceStep;
    }

    public double getAmountStep() {
        return amountStep;
    }

    public double getMinOrderValue() {
        return minOrderValue;
    }

    public double getMarkPrice() {
        return markPrice;
    }

    public boolean isActive() {
        return isActive;
    }

    public String getOptionType() {
        return optionType;
    }

    public String getExpiry() {
        return expiry;
    }

    public double getStrike() {
        return strike;
    }

    public Greeks getGreeks() {
        return greeks;
    }

    @Override
    public String toString() {
        return "Markets{" +
                "instrumentId='" + instrumentId + '\'' +
                ", instrumentName='" + instrumentName + '\'' +
                ", instrumentType='" + instrumentType + '\'' +
                ", underlyingAsset='" + underlyingAsset + '\'' +
                ", quoteAsset='" + quoteAsset + '\'' +
                ", priceStep='" + priceStep + '\'' +
                ", amountStep='" + amountStep + '\'' +
                ", minOrderValue='" + minOrderValue + '\'' +
                ", markPrice='" + markPrice + '\'' +
                ", isActive=" + isActive +
                ", optionType='" + optionType + '\'' +
                ", expiry='" + expiry + '\'' +
                ", strike='" + strike + '\'' +
                ", greeks=" + greeks +
                '}';
    }
}
