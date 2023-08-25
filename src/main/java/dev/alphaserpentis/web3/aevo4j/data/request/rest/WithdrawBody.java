package dev.alphaserpentis.web3.aevo4j.data.request.rest;

import com.google.gson.annotations.SerializedName;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;

@SuppressWarnings("unused")
public class WithdrawBody {
    @SerializedName("account")
    private final String account;
    @SerializedName("collateral")
    private final String collateral;
    @SerializedName("to")
    private final String to;
    @SerializedName("amount")
    private final String amount;
    @SerializedName("salt")
    private final String salt;
    @SerializedName("signature")
    private final String signature;
    @SerializedName("recipient")
    private final String recipient;
    @SerializedName("socket_fees")
    private final String socketFees;
    @SerializedName("socket_msg_gas_limit")
    private final String socketMsgGasLimit;
    @SerializedName("socket_connector")
    private final String socketConnector;

    public static class Builder {
        private final String account;
        private final String collateral;
        private final String to;
        private final String amount;
        private final String salt;
        private final String signature;
        private String recipient;
        private String socketFees;
        private String socketMsgGasLimit;
        private String socketConnector;

        public Builder(
                @NonNull String account,
                @NonNull String collateral,
                @NonNull String to,
                @NonNull String amount,
                @NonNull String salt,
                @NonNull String signature
        ) {
            this.account = account;
            this.collateral = collateral;
            this.to = to;
            this.amount = amount;
            this.salt = salt;
            this.signature = signature;
        }

        public Builder recipient(String recipient) {
            this.recipient = recipient;
            return this;
        }

        public Builder socketFees(String socketFees) {
            this.socketFees = socketFees;
            return this;
        }

        public Builder socketMsgGasLimit(String socketMsgGasLimit) {
            this.socketMsgGasLimit = socketMsgGasLimit;
            return this;
        }

        public Builder socketConnector(String socketConnector) {
            this.socketConnector = socketConnector;
            return this;
        }

        public WithdrawBody build() {
            return new WithdrawBody(
                    account,
                    collateral,
                    to,
                    amount,
                    salt,
                    signature,
                    recipient,
                    socketFees,
                    socketMsgGasLimit,
                    socketConnector
            );
        }
    }

    public WithdrawBody(
            @NonNull String account,
            @NonNull String collateral,
            @NonNull String to,
            @NonNull String amount,
            @NonNull String salt,
            @NonNull String signature
    ) {
        this(
                account,
                collateral,
                to,
                amount,
                salt,
                signature,
                null,
                null,
                null,
                null
        );
    }

    public WithdrawBody(
            @NonNull String account,
            @NonNull String collateral,
            @NonNull String to,
            @NonNull String amount,
            @NonNull String salt,
            @NonNull String signature,
            @Nullable String recipient,
            @Nullable String socketFees,
            @Nullable String socketMsgGasLimit,
            @Nullable String socketConnector
    ) {
        this.account = account;
        this.collateral = collateral;
        this.to = to;
        this.amount = amount;
        this.salt = salt;
        this.signature = signature;
        this.recipient = recipient;
        this.socketFees = socketFees;
        this.socketMsgGasLimit = socketMsgGasLimit;
        this.socketConnector = socketConnector;
    }
}
