package dev.alphaserpentis.web3.aevo4j.data.response.rest;

import com.google.gson.annotations.SerializedName;
import io.reactivex.rxjava3.annotations.Experimental;

@Experimental
public class StratPendingTX {
    @SerializedName("pending_transactions")
    private PendingTX[] pendingTransactions;
    @SerializedName("pps")
    private AmountType pps;
    @SerializedName("amount_type")
    private AmountType amountType;

    public static class PendingTX {
        @SerializedName("account")
        private String account;
        @SerializedName("amount")
        private long amount;

        public String getAccount() {
            return account;
        }

        public long getAmount() {
            return amount;
        }

        @Override
        public String toString() {
            return "PendingTX{" +
                    "account='" + account + '\'' +
                    ", amount=" + amount +
                    '}';
        }
    }

    public static class AmountType {
        @SerializedName("amount_type")
        private String amountType;

        public String getAmountType() {
            return amountType;
        }

        @Override
        public String toString() {
            return "AmountType{" +
                    "amountType='" + amountType + '\'' +
                    '}';
        }
    }
}
