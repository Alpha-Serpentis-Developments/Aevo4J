package dev.alphaserpentis.web3.aevo4j.data.response.rest;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

@SuppressWarnings("unused")
public class Portfolio {
    @SerializedName("balance")
    private String balance;
    @SerializedName("pnl")
    private String pnl;
    @SerializedName("realized_pnl")
    private String realizedPnl;
    @SerializedName("profit_factor")
    private String profitFactor;
    @SerializedName("win_rate")
    private String winRate;
    @SerializedName("sharpe_ratio")
    private String sharpeRatio;
    @SerializedName("greeks")
    private Greeks[] greeks;
    @SerializedName("user_margin")
    private UserMargin userMargin;

    public static class UserMargin {
        @SerializedName("used")
        private String used;
        @SerializedName("balance")
        private String balance;

        public String getUsed() {
            return used;
        }

        public String getBalance() {
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

    public String getBalance() {
        return balance;
    }

    public String getPnl() {
        return pnl;
    }

    public String getRealizedPnl() {
        return realizedPnl;
    }

    public String getProfitFactor() {
        return profitFactor;
    }

    public String getWinRate() {
        return winRate;
    }

    public String getSharpeRatio() {
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
