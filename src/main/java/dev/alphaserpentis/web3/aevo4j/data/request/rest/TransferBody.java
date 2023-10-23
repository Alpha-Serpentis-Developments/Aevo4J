package dev.alphaserpentis.web3.aevo4j.data.request.rest;

import com.google.gson.annotations.SerializedName;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;

@SuppressWarnings("unused")
public class TransferBody {
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
    @SerializedName("label")
    private final String label;

    public TransferBody(
            @NonNull String account,
            @NonNull String collateral,
            @NonNull String to,
            @NonNull String amount,
            @NonNull String salt,
            @NonNull String signature,
            @Nullable String label
    ) {
        this.account = account;
        this.collateral = collateral;
        this.to = to;
        this.amount = amount;
        this.salt = salt;
        this.signature = signature;
        this.label = label;
    }

    public TransferBody(
            @NonNull String account,
            @NonNull String collateral,
            @NonNull String to,
            long amount,
            long salt,
            @NonNull String signature,
            @Nullable String label
    ) {
        this(account, collateral, to, String.valueOf(amount), String.valueOf(salt), signature, label);
    }

    public TransferBody(
            @NonNull String account,
            @NonNull String collateral,
            @NonNull String to,
            long amount,
            long salt,
            @NonNull String signature
    ) {
        this(account, collateral, to, String.valueOf(amount), String.valueOf(salt), signature, null);
    }
}
