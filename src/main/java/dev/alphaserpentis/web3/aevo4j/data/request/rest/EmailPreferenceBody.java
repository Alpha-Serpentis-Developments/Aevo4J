package dev.alphaserpentis.web3.aevo4j.data.request.rest;

import com.google.gson.annotations.SerializedName;
import io.reactivex.rxjava3.annotations.NonNull;

@SuppressWarnings("unused")
public class EmailPreferenceBody {
    @SerializedName("email_type")
    private final String emailType;
    @SerializedName("enabled")
    private final boolean enabled;

    public EmailPreferenceBody(@NonNull String emailType, boolean enabled) {
        this.emailType = emailType;
        this.enabled = enabled;
    }
}
