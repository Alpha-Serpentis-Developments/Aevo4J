package dev.alphaserpentis.web3.aevo4j.data.response.common;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Position {
    @SerializedName("instrument_id")
    private String instrumentId;
    @SerializedName("instrument_name")
    private String instrumentName;
    @SerializedName("instrument_type")
    private String instrumentType;
    @SerializedName("option")
    private Option option;
    @SerializedName("iv")
    private String iv;
    @SerializedName("asset")
    private String asset;
    @SerializedName("amount")
    private String amount;
    @SerializedName("side")
    private String side;
    @SerializedName("mark_price")
    private String markPrice;
    @SerializedName("avg_entry_price")
    private String avgEntryPrice;
    @SerializedName("unrealized_pnl")
    private String unrealizedPnl;
    @SerializedName("maintenance_margin")
    private String maintenanceMargin;
    @SerializedName("liquidation_price")
    private String liquidationPrice;

    public String getInstrumentId() {
        return instrumentId;
    }

    public String getInstrumentName() {
        return instrumentName;
    }

    public String getInstrumentType() {
        return instrumentType;
    }

    public Option getOption() {
        return option;
    }

    public String getIv() {
        return iv;
    }

    public String getAsset() {
        return asset;
    }

    public String getAmount() {
        return amount;
    }

    public String getSide() {
        return side;
    }

    public String getMarkPrice() {
        return markPrice;
    }

    public String getAvgEntryPrice() {
        return avgEntryPrice;
    }

    public String getUnrealizedPnl() {
        return unrealizedPnl;
    }

    public String getMaintenanceMargin() {
        return maintenanceMargin;
    }

    public String getLiquidationPrice() {
        return liquidationPrice;
    }

    @Override
    public String toString() {
        return "Position{" +
                "instrumentId='" + instrumentId + '\'' +
                ", instrumentName='" + instrumentName + '\'' +
                ", instrumentType='" + instrumentType + '\'' +
                ", option=" + option +
                ", iv='" + iv + '\'' +
                ", asset='" + asset + '\'' +
                ", amount='" + amount + '\'' +
                ", side='" + side + '\'' +
                ", markPrice='" + markPrice + '\'' +
                ", avgEntryPrice='" + avgEntryPrice + '\'' +
                ", unrealizedPnl='" + unrealizedPnl + '\'' +
                ", maintenanceMargin='" + maintenanceMargin + '\'' +
                ", liquidationPrice='" + liquidationPrice + '\'' +
                '}';
    }
}
