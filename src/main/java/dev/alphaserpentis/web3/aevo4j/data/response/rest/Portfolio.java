package dev.alphaserpentis.web3.aevo4j.data.response.rest;

import com.google.gson.annotations.SerializedName;
import dev.alphaserpentis.web3.aevo4j.data.response.common.Greeks;

import java.util.Arrays;

@SuppressWarnings("unused")
public class Portfolio {
    @SerializedName("balance")
    private double balance;
    @SerializedName("pnl")
    private double pnl;
    @SerializedName("realized_pnl")
    private double realizedPnl;
    @SerializedName("profit_factor")
    private double profitFactor;
    @SerializedName("win_rate")
    private double winRate;
    @SerializedName("sharpe_ratio")
    private double sharpeRatio;
    @SerializedName("greeks")
    private Greeks[] greeks;
    @SerializedName("user_margin")
    private UserMargin userMargin;

    public static class UserMargin {
        @SerializedName("used")
        private double used;
        @SerializedName("balance")
        private double balance;

        public double getUsed() {
            return used;
        }

        public double getBalance() {
            return balance;
        }

        @Override
        public String toString() {
            return "UserMargin{" +
                    "used='" + used + '\'' +
                    ", balance='" + balance + '\'' +
                    '}';
        }
    }

    public double getBalance() {
        return balance;
    }

    public double getPnl() {
        return pnl;
    }

    public double getRealizedPnl() {
        return realizedPnl;
    }

    public double getProfitFactor() {
        return profitFactor;
    }

    public double getWinRate() {
        return winRate;
    }

    public double getSharpeRatio() {
        return sharpeRatio;
    }

    public Greeks[] getGreeks() {
        return greeks;
    }

    public UserMargin getUserMargin() {
        return userMargin;
    }

    @Override
    public String toString() {
        return "Portfolio{" +
                "balance='" + balance + '\'' +
                ", pnl='" + pnl + '\'' +
                ", realizedPnl='" + realizedPnl + '\'' +
                ", profitFactor='" + profitFactor + '\'' +
                ", winRate='" + winRate + '\'' +
                ", sharpeRatio='" + sharpeRatio + '\'' +
                ", greeks='" + Arrays.toString(greeks) + '\'' +
                ", userMargin=" + userMargin +
                '}';
    }
}
