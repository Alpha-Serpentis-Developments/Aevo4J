package dev.alphaserpentis.web3.aevo4j.data.response.rest;

import com.google.gson.annotations.SerializedName;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;

/**
 * Class representing the Greeks of an instrument.
 * This is shared between {@code GET /instrument/{instrument_name}}, {@code GET /markets}, and {@code GET /portfolio}
 */
@SuppressWarnings("unused")
public class Greeks {
    @SerializedName("asset")
    private String asset;
    @SerializedName("delta")
    private String delta;
    @SerializedName("gamma")
    private String gamma;
    @SerializedName("rho")
    private String rho;
    @SerializedName("theta")
    private String theta;
    @SerializedName("vega")
    private String vega;
    @SerializedName("iv")
    private String iv;

    @Nullable
    public String getAsset() {
        return asset;
    }

    @NonNull
    public String getDelta() {
        return delta;
    }

    @NonNull
    public String getGamma() {
        return gamma;
    }

    @NonNull
    public String getRho() {
        return rho;
    }

    @NonNull
    public String getTheta() {
        return theta;
    }

    @NonNull
    public String getVega() {
        return vega;
    }

    @Nullable
    public String getIv() {
        return iv;
    }

    @Override
    public String toString() {
        return "Greeks{" +
                "asset='" + asset + '\'' +
                ", delta='" + delta + '\'' +
                ", gamma='" + gamma + '\'' +
                ", rho='" + rho + '\'' +
                ", theta='" + theta + '\'' +
                ", vega='" + vega + '\'' +
                ", iv='" + iv + '\'' +
                '}';
    }
}
