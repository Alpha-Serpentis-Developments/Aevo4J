package dev.alphaserpentis.web3.aevo4j.data.response.rest;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

@SuppressWarnings("unused")
public class TransactionHistory {
    @SerializedName("count")
    private long count;
    @SerializedName("transaction_history")
    private HistoricalTransaction[] transactionHistory;

    public static class HistoricalTransaction {
        @SerializedName("account")
        private String account;
        @SerializedName("amount")
        private double amount;
        @SerializedName("collateral")
        private String collateral;
        @SerializedName("counter_party")
        private String counterParty;
        @SerializedName("transfer_details")
        private TransferDetails transferDetails;
        @SerializedName("finalized_timestamp")
        private long finalizedTimestamp;
        @SerializedName("initiated_timestamp")
        private long initiatedTimestamp;
        @SerializedName("l1_tx_hash")
        private String l1TxHash;
        @SerializedName("l2_tx_hash")
        private String l2TxHash;
        @SerializedName("chain_id")
        private long chainId;
        @SerializedName("tx_status")
        private String txStatus;
        @SerializedName("tx_type")
        private String txType;
        @SerializedName("label")
        private String label;

        public static class TransferDetails {
            @SerializedName("description")
            private String description;
            @SerializedName("link")
            private String link;

            public String getDescription() {
                return description;
            }

            public String getLink() {
                return link;
            }

            @Override
            public String toString() {
                return "TransferDetails{"
                        + "description='" + description + '\''
                        + ", link='" + link + '\''
                        + '}';
            }
        }

        public String getAccount() {
            return account;
        }

        public double getAmount() {
            return amount;
        }

        public String getCollateral() {
            return collateral;
        }

        public String getCounterParty() {
            return counterParty;
        }

        public TransferDetails getTransferDetails() {
            return transferDetails;
        }

        public long getFinalizedTimestamp() {
            return finalizedTimestamp;
        }

        public long getInitiatedTimestamp() {
            return initiatedTimestamp;
        }

        public String getL1TxHash() {
            return l1TxHash;
        }

        public String getL2TxHash() {
            return l2TxHash;
        }

        public String getTxStatus() {
            return txStatus;
        }

        public String getTxType() {
            return txType;
        }

        public String getLabel() {
            return label;
        }

        @Override
        public String toString() {
            return "HistoricalTransaction{"
                    + "account='" + account + '\''
                    + ", amount='" + amount + '\''
                    + ", collateral='" + collateral + '\''
                    + ", counterParty='" + counterParty + '\''
                    + ", transferDetails=" + transferDetails
                    + ", finalizedTimestamp='" + finalizedTimestamp + '\''
                    + ", initiatedTimestamp='" + initiatedTimestamp + '\''
                    + ", l1TxHash='" + l1TxHash + '\''
                    + ", l2TxHash='" + l2TxHash + '\''
                    + ", txStatus='" + txStatus + '\''
                    + ", txType='" + txType + '\''
                    + ", label='" + label + '\''
                    + '}';
        }
    }

    public long getCount() {
        return count;
    }

    public HistoricalTransaction[] getTransactionHistory() {
        return transactionHistory;
    }

    @Override
    public String toString() {
        return "TransactionHistory{"
                + "count='" + count + '\''
                + ", transactionHistory=" + Arrays.toString(transactionHistory)
                + '}';
    }
}
