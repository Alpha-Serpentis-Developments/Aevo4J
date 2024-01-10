package dev.alphaserpentis.web3.aevo4j.data.response.rest;

import com.google.gson.annotations.SerializedName;
import io.reactivex.rxjava3.annotations.Nullable;

public class Swap {
    @SerializedName("order_id")
    private String orderId;
    @SerializedName("account")
    private String account;
    @SerializedName("instrument_id")
    private long instrumentId;
    @SerializedName("instrument_name")
    private String instrumentName;
    @SerializedName("instrument_type")
    private String instrumentType;
    @SerializedName("order_type")
    private String orderType;
    @SerializedName("side")
    private String side;
    @SerializedName("amount")
    private long amount;
    @SerializedName("price")
    private double price;
    @SerializedName("avg_price")
    private double averagePrice;
    @SerializedName("filled")
    private double filled;
    @SerializedName("order_status")
    private String orderStatus;
    @SerializedName("reduce_only")
    private Boolean reduceOnly;
    @SerializedName("initial_margin")
    private Double initialMargin;
    @SerializedName("option_type")
    private String optionType;
    @SerializedName("iv")
    private Double iv;
    @SerializedName("expiry")
    private Long expiry;
    @SerializedName("strike")
    private Double strike;
    @SerializedName("created_timestamp")
    private Long createdTimestamp;
    @SerializedName("timestamp")
    private long timestamp;
    @SerializedName("system_type")
    private String systemType;
    @SerializedName("stop")
    private String stop;
    @SerializedName("trigger")
    private String trigger;
    @SerializedName("close_position")
    private Boolean closePosition;
    @SerializedName("isolated_margin")
    private Double isolatedMargin;

    public String getOrderId() {
        return orderId;
    }

    public String getAccount() {
        return account;
    }

    public long getInstrumentId() {
        return instrumentId;
    }

    public String getInstrumentName() {
        return instrumentName;
    }

    public String getInstrumentType() {
        return instrumentType;
    }

    public String getOrderType() {
        return orderType;
    }

    public String getSide() {
        return side;
    }

    public long getAmount() {
        return amount;
    }

    public double getPrice() {
        return price;
    }

    public double getAveragePrice() {
        return averagePrice;
    }

    public double getFilled() {
        return filled;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    @Nullable
    public Boolean getReduceOnly() {
        return reduceOnly;
    }

    @Nullable
    public Double getInitialMargin() {
        return initialMargin;
    }

    @Nullable
    public String getOptionType() {
        return optionType;
    }

    @Nullable
    public Double getIv() {
        return iv;
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
    public Long getCreatedTimestamp() {
        return createdTimestamp;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getSystemType() {
        return systemType;
    }

    @Nullable
    public String getStop() {
        return stop;
    }

    @Nullable
    public String getTrigger() {
        return trigger;
    }

    @Nullable
    public Boolean getClosePosition() {
        return closePosition;
    }

    @Nullable
    public Double getIsolatedMargin() {
        return isolatedMargin;
    }

    @Override
    public String toString() {
        return "Swap{" +
                "orderId='" + orderId + '\'' +
                ", account='" + account + '\'' +
                ", instrumentId=" + instrumentId +
                ", instrumentName='" + instrumentName + '\'' +
                ", instrumentType='" + instrumentType + '\'' +
                ", orderType='" + orderType + '\'' +
                ", side='" + side + '\'' +
                ", amount=" + amount +
                ", price=" + price +
                ", averagePrice=" + averagePrice +
                ", filled=" + filled +
                ", orderStatus='" + orderStatus + '\'' +
                ", reduceOnly=" + reduceOnly +
                ", initialMargin=" + initialMargin +
                ", optionType='" + optionType + '\'' +
                ", iv=" + iv +
                ", expiry=" + expiry +
                ", strike=" + strike +
                ", createdTimestamp=" + createdTimestamp +
                ", timestamp=" + timestamp +
                ", systemType='" + systemType + '\'' +
                ", stop='" + stop + '\'' +
                ", trigger='" + trigger + '\'' +
                ", closePosition=" + closePosition +
                ", isolatedMargin=" + isolatedMargin +
                '}';
    }
}
