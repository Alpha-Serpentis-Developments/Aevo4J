package dev.alphaserpentis.web3.aevo4j.data.response.rest;

import com.google.gson.annotations.SerializedName;
import dev.alphaserpentis.web3.aevo4j.data.response.common.Option;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;

@SuppressWarnings("unused")
public class AccountUpdateMargin {
    @SerializedName("success")
    private Success success;
    @SerializedName("position")
    private Position position;

    public static class Success {
        @SerializedName("instrument_id")
        private Long instrumentId;
        @SerializedName("instrument_name")
        private String instrumentName;
        @SerializedName("instrument_type")
        private String instrumentType;
        @SerializedName("option")
        private Option option;
        @SerializedName("iv")
        private Double iv;
        @SerializedName("asset")
        private String asset;
        @SerializedName("amount")
        private Double amount;
        @SerializedName("side")
        private String side;
        @SerializedName("mark_price")
        private Double markPrice;
        @SerializedName("avg_entry_price")
        private Double avgEntryPrice;
        @SerializedName("unrealized_pnl")
        private Double unrealizedPnl;
        @SerializedName("maintenance_margin")
        private Double maintenanceMargin;
        @SerializedName("liquidation_price")
        private Double liquidationPrice;
        @SerializedName("isolated_margin")
        private Double isolatedMargin;
        @SerializedName("leverage")
        private Double leverage;

        @Nullable
        public Long getInstrumentId() {
            return instrumentId;
        }

        @Nullable
        public String getInstrumentName() {
            return instrumentName;
        }

        @Nullable
        public String getInstrumentType() {
            return instrumentType;
        }

        @Nullable
        public Option getOption() {
            return option;
        }

        @Nullable
        public Double getIv() {
            return iv;
        }

        @Nullable
        public String getAsset() {
            return asset;
        }

        @Nullable
        public Double getAmount() {
            return amount;
        }

        @Nullable
        public String getSide() {
            return side;
        }

        @Nullable
        public Double getMarkPrice() {
            return markPrice;
        }

        @Nullable
        public Double getAvgEntryPrice() {
            return avgEntryPrice;
        }

        @Nullable
        public Double getUnrealizedPnl() {
            return unrealizedPnl;
        }

        @Nullable
        public Double getMaintenanceMargin() {
            return maintenanceMargin;
        }

        @Nullable
        public Double getLiquidationPrice() {
            return liquidationPrice;
        }

        @Nullable
        public Double getIsolatedMargin() {
            return isolatedMargin;
        }

        @Nullable
        public Double getLeverage() {
            return leverage;
        }

        @Override
        public String toString() {
            return "Success{" +
                    "instrumentId='" + instrumentId + '\'' +
                    ", instrumentName='" + instrumentName + '\'' +
                    ", instrumentType='" + instrumentType + '\'' +
                    ", option='" + option + '\'' +
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

    public static class Position {
        @SerializedName("instrument_id")
        private long instrumentId;
        @SerializedName("instrument_name")
        private String instrumentName;
        @SerializedName("instrument_type")
        private String instrumentType;
        @SerializedName("option")
        private Option option;
        @SerializedName("iv")
        private Double iv;
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
        private Double liquidationPrice;
        @SerializedName("isolated_margin")
        private Double isolatedMargin;
        @SerializedName("leverage")
        private Double leverage;

        public long getInstrumentId() {
            return instrumentId;
        }

        @NonNull
        public String getInstrumentName() {
            return instrumentName;
        }

        @NonNull
        public String getInstrumentType() {
            return instrumentType;
        }

        @Nullable
        public Option getOption() {
            return option;
        }

        @Nullable
        public Double getIv() {
            return iv;
        }

        @NonNull
        public String getAsset() {
            return asset;
        }

        public double getAmount() {
            return amount;
        }

        @NonNull
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

        @Nullable
        public Double getLiquidationPrice() {
            return liquidationPrice;
        }

        @Nullable
        public Double getIsolatedMargin() {
            return isolatedMargin;
        }

        @Nullable
        public Double getLeverage() {
            return leverage;
        }

        @Override
        public String toString() {
            return "Position{" +
                    "instrumentId='" + instrumentId + '\'' +
                    ", instrumentName='" + instrumentName + '\'' +
                    ", instrumentType='" + instrumentType + '\'' +
                    ", option='" + option + '\'' +
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

    @Nullable
    public Success getSuccess() {
        return success;
    }

    @Nullable
    public Position getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "AccountUpdateMargin{" +
                "success='" + success + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}
