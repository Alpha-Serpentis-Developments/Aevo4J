package dev.alphaserpentis.web3.aevo4j.data.request.rest;

import com.google.gson.annotations.SerializedName;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;

/**
 * Body used for {@code POST /register} endpoint.
 * @see <a href="https://docs.aevo.xyz/reference/postregister">Aevo - POST /register</a>
 */
@SuppressWarnings("unused")
public class RegisterBody {
    @SerializedName("account")
    private final String account;
    @SerializedName("signing_key")
    private final String signingKey;
    @SerializedName("expiry")
    private final String expiry;
    @SerializedName("account_signature")
    private final String accountSignature;
    @SerializedName("signing_key_signature")
    private final String signingKeySignature;
    @SerializedName("referral_code")
    private final String referralCode;

    public RegisterBody(
            @NonNull String account,
            @NonNull String signingKey,
            @NonNull String expiry,
            @NonNull String accountSignature,
            @NonNull String signingKeySignature,
            @Nullable String referralCode
    ) {
        this.account = account;
        this.signingKey = signingKey;
        this.expiry = expiry;
        this.accountSignature = accountSignature;
        this.signingKeySignature = signingKeySignature;
        this.referralCode = referralCode;
    }
}
