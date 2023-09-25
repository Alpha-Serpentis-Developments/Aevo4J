package dev.alphaserpentis.web3.aevo4j.data.response.common;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Trade {
    @SerializedName("trade_id")
    private String tradeId;
    @SerializedName("instrument_id")
    private long instrumentId;
    @SerializedName("instrument_name")
    private String instrumentName;
    @SerializedName("instrument_type")
    private String instrumentType;
    @SerializedName("side")
    private String side;
    @SerializedName("price")
    private double price;
    @SerializedName("amount")
    private double amount;
    @SerializedName("created_timestamp")
    private long createdTimestamp;

    public String getTradeId() {
        return tradeId;
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

    public String getSide() {
        return side;
    }

    public double getPrice() {
        return price;
    }

    public double getAmount() {
        return amount;
    }

    public long getCreatedTimestamp() {
        return createdTimestamp;
    }

    @Override
    public String toString() {
        return "Trade{" +
                "tradeId='" + tradeId + '\'' +
                ", instrumentId='" + instrumentId + '\'' +
                ", instrumentName='" + instrumentName + '\'' +
                ", instrumentType='" + instrumentType + '\'' +
                ", side='" + side + '\'' +
                ", price='" + price + '\'' +
                ", amount='" + amount + '\'' +
                ", createdTimestamp='" + createdTimestamp + '\'' +
                '}';
    }
}
