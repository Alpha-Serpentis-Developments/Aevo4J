package dev.alphaserpentis.web3.aevo4j.data.response.rest;

import com.google.gson.annotations.SerializedName;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;

import java.util.Arrays;

/**
 * Response after getting the API key or creating a new one. This is shared between {@code GET /api-key} and {@code POST /api-key}.
 * <p></p>
 * <b>Note:</b> The API Key and API Secret are omitted from the {@link #toString()} method. Call {@link #getApiKey()} and {@link #getApiSecret()} respectively.
 */
@SuppressWarnings("unused")
public class ApiKeyData {
    @SerializedName("name")
    private String name;
    @SerializedName("api_key")
    private String apiKey;
    @SerializedName("api_secret")
    private String apiSecret;
    @SerializedName("ip_addresses")
    private String[] ipAddresses;
    @SerializedName("read_only")
    private boolean readOnly;
    @SerializedName("created_timestamp")
    private Long createdTimestamp;

    @NonNull
    public String getName() {
        return name;
    }

    @NonNull
    public String getApiKey() {
        return apiKey;
    }

    @Nullable
    public String getApiSecret() {
        return apiSecret;
    }

    @NonNull
    public String[] getIpAddresses() {
        return ipAddresses;
    }

    public boolean isReadOnly() {
        return readOnly;
    }

    @Nullable
    public Long getCreatedTimestamp() {
        return createdTimestamp;
    }

    @Override
    public String toString() {
        return "ApiKeyData{" +
                "name='" + name + '\'' +
                ", apiKey=OMITTED" +
                ", apiSecret=" + (apiSecret == null ? "null" : "OMITTED") +
                ", ipAddresses='" + Arrays.toString(ipAddresses) + '\'' +
                ", readOnly=" + readOnly +
                ", createdTimestamp='" + createdTimestamp + '\'' +
                '}';
    }
}
