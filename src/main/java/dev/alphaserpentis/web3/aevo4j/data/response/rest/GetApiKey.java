package dev.alphaserpentis.web3.aevo4j.data.response.rest;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

public class GetApiKey {
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
    private String createdTimestamp;

    public String getName() {
        return name;
    }

    public String getApiKey() {
        return apiKey;
    }

    public String getApiSecret() {
        return apiSecret;
    }

    public String[] getIpAddresses() {
        return ipAddresses;
    }

    public boolean isReadOnly() {
        return readOnly;
    }

    public String getCreatedTimestamp() {
        return createdTimestamp;
    }

    @Override
    public String toString() {
        return "GetApiKey{" +
                "name='" + name + '\'' +
                ", apiKey=OMITTED" +
                ", apiSecret=OMITTED" +
                ", ipAddresses='" + Arrays.toString(ipAddresses) + '\'' +
                ", readOnly=" + readOnly +
                ", createdTimestamp='" + createdTimestamp + '\'' +
                '}';
    }
}
