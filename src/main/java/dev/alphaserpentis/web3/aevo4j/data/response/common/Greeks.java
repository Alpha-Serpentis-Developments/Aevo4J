package dev.alphaserpentis.web3.aevo4j.data.response.common;

import com.google.gson.annotations.SerializedName;
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
    private double delta;
    @SerializedName("gamma")
    private double gamma;
    @SerializedName("rho")
    private double rho;
    @SerializedName("theta")
    private double theta;
    @SerializedName("vega")
    private double vega;
    @SerializedName("iv")
    private Double iv;

    @Nullable
    public String getAsset() {
        return asset;
    }

    public double getDelta() {
        return delta;
    }

    public double getGamma() {
        return gamma;
    }

    public double getRho() {
        return rho;
    }

    public double getTheta() {
        return theta;
    }

    public double getVega() {
        return vega;
    }

    @Nullable
    public Double getIv() {
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
