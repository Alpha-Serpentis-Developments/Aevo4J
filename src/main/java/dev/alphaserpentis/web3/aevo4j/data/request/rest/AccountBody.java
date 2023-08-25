package dev.alphaserpentis.web3.aevo4j.data.request.rest;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class AccountBody {
    @SerializedName("account")
    private final String account;
    @SerializedName("email_auth_token")
    private final String emailAuthToken;

    public AccountBody(String account, String emailAuthToken) {
        this.account = account;
        this.emailAuthToken = emailAuthToken;
    }
}