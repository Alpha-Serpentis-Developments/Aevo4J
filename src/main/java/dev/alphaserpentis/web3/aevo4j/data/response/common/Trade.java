package dev.alphaserpentis.web3.aevo4j.data.response.common;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Trade {
    @SerializedName("trade_id")
    private String tradeId;
    @SerializedName("instrument_id")
    private String instrumentId;
    @SerializedName("instrument_name")
    private String instrumentName;
    @SerializedName("instrument_type")
    private String instrumentType;
    @SerializedName("side")
    private String side;
    @SerializedName("price")
    private String price;
    @SerializedName("amount")
    private String amount;
    @SerializedName("created_timestamp")
    private String createdTimestamp;

    public String getTradeId() {
        return tradeId;
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

    public String getSide() {
        return side;
    }

    public String getPrice() {
        return price;
    }

    public String getAmount() {
        return amount;
    }

    public String getCreatedTimestamp() {
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
