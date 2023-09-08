package dev.alphaserpentis.web3.aevo4j.data.response.rest;

import com.google.gson.annotations.SerializedName;
import dev.alphaserpentis.web3.aevo4j.data.response.common.Position;

import java.util.Arrays;

@SuppressWarnings("unused")
public class Account {
    @SerializedName("account")
    private String account;
    @SerializedName("username")
    private String username;
    @SerializedName("equity")
    private double equity;
    @SerializedName("available_balance")
    private double availableBalance;
    @SerializedName("balance")
    private double balance;
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
    private double initialMargin;
    @SerializedName("maintenance_margin")
    private String maintenanceMargin;
    @SerializedName("email_address")
    private String emailAddress;
    @SerializedName("intercom_hash")
    private String intercomHash;
    @SerializedName("credit")
    private double credit;
    @SerializedName("credited")
    private boolean credited;
    @SerializedName("has_been_referred")
    private boolean hasBeenReferred;

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
        private double collateralValue;
        @SerializedName("balance")
        private double balance;
        @SerializedName("available_balance")
        private double availableBalance;

        public String getCollateralAsset() {
            return collateralAsset;
        }

        public double getCollateralValue() {
            return collateralValue;
        }

        public double getBalance() {
            return balance;
        }

        public double getAvailableBalance() {
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

    public static class FeeStructure {
        @SerializedName("asset")
        private String asset;
        @SerializedName("instrument_type")
        private String instrumentType;
        @SerializedName("taker_fee")
        private double takerFee;
        @SerializedName("maker_fee")
        private double makerFee;

        public String getAsset() {
            return asset;
        }

        public String getInstrumentType() {
            return instrumentType;
        }

        public double getTakerFee() {
            return takerFee;
        }

        public double getMakerFee() {
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

    public double getEquity() {
        return equity;
    }

    public double getAvailableBalance() {
        return availableBalance;
    }

    public double getBalance() {
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

    public double getInitialMargin() {
        return initialMargin;
    }

    public String getMaintenanceMargin() {
        return maintenanceMargin;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getIntercomHash() {
        return intercomHash;
    }

    public double getCredit() {
        return credit;
    }

    public boolean isCredited() {
        return credited;
    }

    public boolean isHasBeenReferred() {
        return hasBeenReferred;
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
                ", emailAddress='" + emailAddress + '\'' +
                ", intercomHash='" + intercomHash + '\'' +
                ", credit='" + credit + '\'' +
                ", credited=" + credited +
                ", hasBeenReferred=" + hasBeenReferred +
                '}';
    }
}
