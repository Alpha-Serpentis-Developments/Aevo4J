package dev.alphaserpentis.web3.aevo4j.data.response.rest;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class EmailAddress {
    @SerializedName("email_address")
    private String emailAddress;

    public String getEmailAddress() {
        return emailAddress;
    }

    @Override
    public String toString() {
        return "EmailAddress{" +
                "emailAddress='" + emailAddress + '\'' +
                '}';
    }
}
