package dev.alphaserpentis.web3.aevo4j.data.request.rest;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class EmailPreferenceBody {
    @SerializedName("email_type")
    private final String emailType;
    @SerializedName("enabled")
    private final boolean enabled;

    public EmailPreferenceBody(String emailType, boolean enabled) {
        this.emailType = emailType;
        this.enabled = enabled;
    }
}
