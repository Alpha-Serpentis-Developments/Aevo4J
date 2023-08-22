package dev.alphaserpentis.web3.aevo4j.data.response.rest;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class EmailVerified {
    @SerializedName("email_verified")
    private boolean emailVerified;

    public boolean getEmailVerified() {
        return emailVerified;
    }

    @Override
    public String toString() {
        return "EmailVerified{" +
                "emailVerified=" + emailVerified +
                "}";
    }
}
