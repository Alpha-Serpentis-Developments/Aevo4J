package dev.alphaserpentis.web3.aevo4j.data.response.rest;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

@SuppressWarnings("unused")
public class Account {
    @SerializedName("account")
    private String account;
    @SerializedName("username")
    private String username;
    @SerializedName("equity")
    private String equity;
    @SerializedName("available_balance")
    private String availableBalance;
    @SerializedName("balance")
    private String balance;
    @SerializedName("signing_keys")
    private SigningKey[] signingKeys;
    @SerializedName("collaterals")
    private Collateral[] collaterals;
    @SerializedName("api_keys")
    private ApiKeyData[] apiKeys;
    @SerializedName("positions")
    private Position[] positions;
    @SerializedName("account_type")
    private String accountType;
    @SerializedName("fee_structures")
    private FeeStructure[] feeStructures;
    @SerializedName("portfolio")
    private boolean portfolio;
    @SerializedName("in_liquidation")
    private boolean inLiquidation;
    @SerializedName("initial_margin")
    private String initialMargin;
    @SerializedName("maintenance_margin")
    private String maintenanceMargin;

    public static class SigningKey {
        @SerializedName("signing_key")
        private String signingKey;
        @SerializedName("expiry")
        private String expiry;
        @SerializedName("created_timestamp")
        private String createdTimestamp;

        public String getSigningKey() {
            return signingKey;
        }

        public String getExpiry() {
            return expiry;
        }

        public String getCreatedTimestamp() {
            return createdTimestamp;
        }

        @Override
        public String toString() {
            return "SigningKey{" +
                    "signingKey='" + signingKey + '\'' +
                    ", expiry='" + expiry + '\'' +
                    ", createdTimestamp='" + createdTimestamp + '\'' +
                    '}';
        }
    }

    public static class Collateral {
        @SerializedName("collateral_asset")
        private String collateralAsset;
        @SerializedName("collateral_value")
        private String collateralValue;
        @SerializedName("balance")
        private String balance;
        @SerializedName("available_balance")
        private String availableBalance;

        public String getCollateralAsset() {
            return collateralAsset;
        }

        public String getCollateralValue() {
            return collateralValue;
        }

        public String getBalance() {
            return balance;
        }

        public String getAvailableBalance() {
            return availableBalance;
        }

        @Override
        public String toString() {
            return "Collateral{" +
                    "collateralAsset='" + collateralAsset + '\'' +
                    ", collateralValue='" + collateralValue + '\'' +
                    ", balance='" + balance + '\'' +
                    ", availableBalance='" + availableBalance + '\'' +
                    '}';
        }
    }

    public static class Position {
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

    public static class FeeStructure {
        @SerializedName("asset")
        private String asset;
        @SerializedName("instrument_type")
        private String instrumentType;
        @SerializedName("taker_fee")
        private String takerFee;
        @SerializedName("maker_fee")
        private String makerFee;

        public String getAsset() {
            return asset;
        }

        public String getInstrumentType() {
            return instrumentType;
        }

        public String getTakerFee() {
            return takerFee;
        }

        public String getMakerFee() {
            return makerFee;
        }

        @Override
        public String toString() {
            return "FeeStructure{" +
                    "asset='" + asset + '\'' +
                    ", instrumentType='" + instrumentType + '\'' +
                    ", takerFee='" + takerFee + '\'' +
                    ", makerFee='" + makerFee + '\'' +
                    '}';
        }
    }

    public String getAccount() {
        return account;
    }

    public String getUsername() {
        return username;
    }

    public String getEquity() {
        return equity;
    }

    public String getAvailableBalance() {
        return availableBalance;
    }

    public String getBalance() {
        return balance;
    }

    public SigningKey[] getSigningKeys() {
        return signingKeys;
    }

    public Collateral[] getCollaterals() {
        return collaterals;
    }

    public ApiKeyData[] getApiKeys() {
        return apiKeys;
    }

    public Position[] getPositions() {
        return positions;
    }

    public String getAccountType() {
        return accountType;
    }

    public FeeStructure[] getFeeStructures() {
        return feeStructures;
    }

    public boolean isPortfolio() {
        return portfolio;
    }

    public boolean isInLiquidation() {
        return inLiquidation;
    }

    public String getInitialMargin() {
        return initialMargin;
    }

    public String getMaintenanceMargin() {
        return maintenanceMargin;
    }

    @Override
    public String toString() {
        return "Account{" +
                "account='" + account + '\'' +
                ", username='" + username + '\'' +
                ", equity='" + equity + '\'' +
                ", availableBalance='" + availableBalance + '\'' +
                ", balance='" + balance + '\'' +
                ", signingKeys=" + Arrays.toString(signingKeys) +
                ", collaterals=" + Arrays.toString(collaterals) +
                ", apiKeys=" + Arrays.toString(apiKeys) +
                ", positions=" + Arrays.toString(positions) +
                ", accountType='" + accountType + '\'' +
                ", feeStructures=" + Arrays.toString(feeStructures) +
                ", portfolio=" + portfolio +
                ", inLiquidation=" + inLiquidation +
                ", initialMargin='" + initialMargin + '\'' +
                ", maintenanceMargin='" + maintenanceMargin + '\'' +
                '}';
    }
}
