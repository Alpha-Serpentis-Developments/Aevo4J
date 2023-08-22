package dev.alphaserpentis.web3.aevo4j.data.response.rest;

import com.google.gson.annotations.SerializedName;

/**
 * @see <a href="https://docs.aevo.xyz/reference/rate-limits-1#rate-limits-on-rest-api">Aevo - Rate Limits on REST API</a>
 */
@SuppressWarnings("unused")
public class AevoRestAPIError {
    @SerializedName("error")
    private String error;
    @SerializedName("retry_after")
    private long retryAfter;

    public String getError() {
        return error;
    }

    public long getRetryAfter() {
        return retryAfter;
    }

    @Override
    public String toString() {
        return "{\"error\":\"" + error + "\"" + ", \"retryAfter\":" + retryAfter + "}";
    }
}
