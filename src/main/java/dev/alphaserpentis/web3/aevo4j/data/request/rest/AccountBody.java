package dev.alphaserpentis.web3.aevo4j.data.request.rest;

import com.google.gson.annotations.SerializedName;
import io.reactivex.rxjava3.annotations.NonNull;

@SuppressWarnings("unused")
public class AccountBody {
    @SerializedName("account")
    private final String account;
    @SerializedName("email_auth_token")
    private final String emailAuthToken;

    public AccountBody(@NonNull String account, @NonNull String emailAuthToken) {
        this.account = account;
        this.emailAuthToken = emailAuthToken;
    }
}
