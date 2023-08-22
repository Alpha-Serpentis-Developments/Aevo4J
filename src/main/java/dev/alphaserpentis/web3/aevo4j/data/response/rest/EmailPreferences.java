package dev.alphaserpentis.web3.aevo4j.data.response.rest;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class EmailPreferences {
    @SerializedName("email_preferences")
    private String emailPreferences;

    public String getEmailPreferences() {
        return emailPreferences;
    }

    @Override
    public String toString() {
        return "EmailPreferences{" +
                "emailPreferences='" + emailPreferences + '\'' +
                '}';
    }
}
