package dev.alphaserpentis.web3.aevo4j.data.response.rest;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

public class PostRegister {
    @SerializedName("success")
    private boolean success;
    @SerializedName("signing_keys")
    private SigningKey[] signingKeys;
    @SerializedName("api_key")
    private String apiKey;
    @SerializedName("api_secret")
    private String apiSecret;
    @SerializedName("read_only")
    private boolean readOnly;

    public static class SigningKey {
        @SerializedName("signing_key")
        private String signingKey;
        @SerializedName("expiry")
        private String expiry;
        @SerializedName("created_timestamp")
        private String createdTimestamp;

        public String getSigningKey() {
            return signingKey;
        }

        public String getExpiry() {
            return expiry;
        }

        public String getCreatedTimestamp() {
            return createdTimestamp;
        }

        @Override
        public String toString() {
            return "SigningKey{" +
                    "signingKey='" + signingKey + '\'' +
                    ", expiry='" + expiry + '\'' +
                    ", createdTimestamp='" + createdTimestamp + '\'' +
                    '}';
        }
    }

    public boolean isSuccess() {
        return success;
    }

    public SigningKey[] getSigningKeys() {
        return signingKeys;
    }

    public String getApiKey() {
        return apiKey;
    }

    public String getApiSecret() {
        return apiSecret;
    }

    public boolean isReadOnly() {
        return readOnly;
    }

    @Override
    public String toString() {
        return "Register{" +
                "success=" + success +
                ", signingKeys=" + Arrays.toString(signingKeys) +
                ", apiKey='" + apiKey + '\'' +
                ", apiSecret='" + apiSecret + '\'' +
                ", readOnly=" + readOnly +
                '}';
    }
}
