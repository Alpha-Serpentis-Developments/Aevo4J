package dev.alphaserpentis.web3.aevo4j.data.response.rest;

import com.google.gson.annotations.SerializedName;

public class CheckReferral {
    @SerializedName("is_referrable")
    private boolean isReferrable;
    @SerializedName("code")
    private String code;

    public boolean isReferrable() {
        return isReferrable;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "CheckReferral{" +
                "isReferrable='" + isReferrable + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
