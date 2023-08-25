package dev.alphaserpentis.web3.aevo4j.data.request.rest;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class EmailAddressBody {
    @SerializedName("email_address")
    private final String emailAddress;

    public EmailAddressBody(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
