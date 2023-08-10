package dev.alphaserpentis.web3.aevo4j.data.response.rest;

import com.google.gson.annotations.SerializedName;

public class Options {
    @SerializedName("instrument_name")
    private String instrumentName;
    @SerializedName("option_type")
    private String optionType;
    @SerializedName("expiry")
    private String expiry;
    @SerializedName("strike")
    private String strike;
    @SerializedName("iv")
    private String iv;
    @SerializedName("order_type")
    private String orderType;
    @SerializedName("side")
    private String side;
    @SerializedName("avg_price")
    private String avgPrice;
    @SerializedName("amount")
    private String amount;
    @SerializedName("trade_status")
    private String tradeStatus;
    @SerializedName("created_timestamp")
    private String createdTimestamp;

    public String getInstrumentName() {
        return instrumentName;
    }

    public String getOptionType() {
        return optionType;
    }

    public String getExpiry() {
        return expiry;
    }

    public String getStrike() {
        return strike;
    }

    public String getIv() {
        return iv;
    }

    public String getOrderType() {
        return orderType;
    }

    public String getSide() {
        return side;
    }

    public String getAvgPrice() {
        return avgPrice;
    }

    public String getAmount() {
        return amount;
    }

    public String getTradeStatus() {
        return tradeStatus;
    }

    public String getCreatedTimestamp() {
        return createdTimestamp;
    }

    @Override
    public String toString() {
        return "Options{" +
                "instrumentName='" + instrumentName + '\'' +
                ", optionType='" + optionType + '\'' +
                ", expiry='" + expiry + '\'' +
                ", strike='" + strike + '\'' +
                ", iv='" + iv + '\'' +
                ", orderType='" + orderType + '\'' +
                ", side='" + side + '\'' +
                ", avgPrice='" + avgPrice + '\'' +
                ", amount='" + amount + '\'' +
                ", tradeStatus='" + tradeStatus + '\'' +
                ", createdTimestamp='" + createdTimestamp + '\'' +
                '}';
    }
}
