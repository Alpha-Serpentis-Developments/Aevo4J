package dev.alphaserpentis.web3.aevo4j.data.response.common;

import com.google.gson.annotations.SerializedName;

/**
 * Class representing an option. This is shared between {@code GET /account} and {@code GET /options-history}
 */
@SuppressWarnings("unused")
public class Option extends Greeks {
    @SerializedName("instrument_name")
    private String instrumentName;
    @SerializedName("option_type")
    private String optionType;
    @SerializedName("expiry")
    private long expiry;
    @SerializedName("strike")
    private double strike;
    @SerializedName("order_type")
    private String orderType;
    @SerializedName("side")
    private String side;
    @SerializedName("avg_price")
    private double avgPrice;
    @SerializedName("amount")
    private double amount;
    @SerializedName("trade_status")
    private String tradeStatus;
    @SerializedName("created_timestamp")
    private long createdTimestamp;

    public String getInstrumentName() {
        return instrumentName;
    }

    public String getOptionType() {
        return optionType;
    }

    public long getExpiry() {
        return expiry;
    }

    public String getOrderType() {
        return orderType;
    }

    public String getSide() {
        return side;
    }

    public double getAvgPrice() {
        return avgPrice;
    }

    public double getAmount() {
        return amount;
    }

    public String getTradeStatus() {
        return tradeStatus;
    }

    public long getCreatedTimestamp() {
        return createdTimestamp;
    }

    @Override
    public String toString() {
        return "Options{" +
                "instrumentName='" + instrumentName + '\'' +
                ", optionType='" + optionType + '\'' +
                ", expiry='" + expiry + '\'' +
                ", strike='" + strike + '\'' +
                ", iv='" + getIv() + '\'' +
                ", delta='" + getDelta() + '\'' +
                ", theta='" + getTheta() + '\'' +
                ", vega='" + getVega() + '\'' +
                ", rho='" + getRho() + '\'' +
                ", orderType='" + orderType + '\'' +
                ", side='" + side + '\'' +
                ", avgPrice='" + avgPrice + '\'' +
                ", amount='" + amount + '\'' +
                ", tradeStatus='" + tradeStatus + '\'' +
                ", createdTimestamp='" + createdTimestamp + '\'' +
                '}';
    }
}
