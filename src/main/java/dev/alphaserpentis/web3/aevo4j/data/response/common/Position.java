package dev.alphaserpentis.web3.aevo4j.data.response.common;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

@SuppressWarnings("unused")
public class Position {
    @SerializedName("instrument_id")
    private long instrumentId;
    @SerializedName("instrument_name")
    private String instrumentName;
    @SerializedName("instrument_type")
    private String instrumentType;
    @SerializedName("option")
    private Option option;
    @SerializedName("iv")
    private double iv;
    @SerializedName("asset")
    private String asset;
    @SerializedName("amount")
    private double amount;
    @SerializedName("side")
    private String side;
    @SerializedName("mark_price")
    private double markPrice;
    @SerializedName("avg_entry_price")
    private double avgEntryPrice;
    @SerializedName("unrealized_pnl")
    private double unrealizedPnl;
    @SerializedName("maintenance_margin")
    private double maintenanceMargin;
    @SerializedName("liquidation_price")
    private double liquidationPrice;
    @SerializedName("isolated_margin")
    private double isolatedMargin;
    @SerializedName("leverage")
    private double leverage;
    @SerializedName("triggers")
    private Map<String, Trigger> triggers;

    public static class Trigger {
        @SerializedName("order_id")
        private String orderId;
        @SerializedName("trigger")
        private double trigger;

        public String getOrderId() {
            return orderId;
        }

        public double getTrigger() {
            return trigger;
        }

        @Override
        public String toString() {
            return "Trigger{" +
                    "orderId='" + orderId + '\'' +
                    ", trigger=" + trigger +
                    '}';
        }
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

    public Option getOption() {
        return option;
    }

    public double getIv() {
        return iv;
    }

    public String getAsset() {
        return asset;
    }

    public double getAmount() {
        return amount;
    }

    public String getSide() {
        return side;
    }

    public double getMarkPrice() {
        return markPrice;
    }

    public double getAvgEntryPrice() {
        return avgEntryPrice;
    }

    public double getUnrealizedPnl() {
        return unrealizedPnl;
    }

    public double getMaintenanceMargin() {
        return maintenanceMargin;
    }

    public double getLiquidationPrice() {
        return liquidationPrice;
    }

    public double getIsolatedMargin() {
        return isolatedMargin;
    }

    public double getLeverage() {
        return leverage;
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
                ", isolatedMargin='" + isolatedMargin + '\'' +
                ", leverage='" + leverage + '\'' +
                '}';
    }
}
