package dev.alphaserpentis.web3.aevo4j.data.response.common;

import com.google.gson.annotations.SerializedName;
import io.reactivex.rxjava3.annotations.Nullable;

@SuppressWarnings("unused")
public class Leg {
    @SerializedName("instrument_id")
    private long instrumentId;
    @SerializedName("instrument_name")
    private String instrumentName;
    @SerializedName("instrument_type")
    private String instrumentType;
    @SerializedName("side")
    private String side;
    @SerializedName("index_price")
    private double indexPrice;
    @SerializedName("mark_price")
    private double markPrice;
    @SerializedName("ratio")
    private double ratio;
    @SerializedName("price")
    private Double price;
    @SerializedName("asset")
    private String asset;
    @SerializedName("expiry")
    private Long expiry;
    @SerializedName("strike")
    private Double strike;
    @SerializedName("option_type")
    private String optionType;
    @SerializedName("iv")
    private Double iv;

    public long getInstrumentId() {
        return instrumentId;
    }

    public String getInstrumentName() {
        return instrumentName;
    }

    public String getInstrumentType() {
        return instrumentType;
    }

    public String getSide() {
        return side;
    }

    public double getIndexPrice() {
        return indexPrice;
    }

    public double getMarkPrice() {
        return markPrice;
    }

    public double getRatio() {
        return ratio;
    }

    @Nullable
    public Double getPrice() {
        return price;
    }

    public String getAsset() {
        return asset;
    }

    @Nullable
    public Long getExpiry() {
        return expiry;
    }

    @Nullable
    public Double getStrike() {
        return strike;
    }

    @Nullable
    public String getOptionType() {
        return optionType;
    }

    @Nullable
    public Double getIv() {
        return iv;
    }

    @Override
    public String toString() {
        return "Leg{" +
                "instrumentId=" + instrumentId +
                ", instrumentName='" + instrumentName + '\'' +
                ", instrumentType='" + instrumentType + '\'' +
                ", side='" + side + '\'' +
                ", indexPrice=" + indexPrice +
                ", markPrice=" + markPrice +
                ", ratio=" + ratio +
                ", price=" + price +
                ", asset='" + asset + '\'' +
                ", expiry=" + expiry +
                ", strike=" + strike +
                ", optionType='" + optionType + '\'' +
                ", iv=" + iv +
                '}';
    }
}
