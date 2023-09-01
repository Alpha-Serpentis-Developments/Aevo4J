package dev.alphaserpentis.web3.aevo4j.data.response.common;

import com.google.gson.annotations.SerializedName;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;

@SuppressWarnings("unused")
public class Order {
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
    private double amount;
    @SerializedName("price")
    private double price;
    @SerializedName("avg_price")
    private double avgPrice;
    @SerializedName("filled")
    private double filled;
    @SerializedName("order_status")
    private String orderStatus;
    @SerializedName("reduce_only")
    private boolean reduceOnly;
    @SerializedName("initial_margin")
    private Double initialMargin;
    @SerializedName("option_type")
    private String optionType;
    @SerializedName("iv")
    private Double iv;
    @SerializedName("expiry")
    private Long expiry;
    @SerializedName("created_timestamp")
    private Long createdTimestamp;
    @SerializedName("timestamp")
    private long timestamp;
    @SerializedName("system_type")
    private String systemType;
    @SerializedName("stop")
    private String stop;
    @SerializedName("trigger")
    private Double trigger;

    @NonNull
    public String getOrderId() {
        return orderId;
    }

    @NonNull
    public String getAccount() {
        return account;
    }

    public long getInstrumentId() {
        return instrumentId;
    }

    @NonNull
    public String getInstrumentName() {
        return instrumentName;
    }

    @NonNull
    public String getInstrumentType() {
        return instrumentType;
    }

    @NonNull
    public String getOrderType() {
        return orderType;
    }

    @NonNull
    public String getSide() {
        return side;
    }

    public double getAmount() {
        return amount;
    }

    public double getPrice() {
        return price;
    }

    public double getAvgPrice() {
        return avgPrice;
    }

    public double getFilled() {
        return filled;
    }

    @NonNull
    public String getOrderStatus() {
        return orderStatus;
    }

    public boolean isReduceOnly() {
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
    public Long getCreatedTimestamp() {
        return createdTimestamp;
    }

    public long getTimestamp() {
        return timestamp;
    }

    @Nullable
    public String getSystemType() {
        return systemType;
    }

    @Nullable
    public String getStop() {
        return stop;
    }

    @Nullable
    public Double getTrigger() {
        return trigger;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", account='" + account + '\'' +
                ", instrumentId='" + instrumentId + '\'' +
                ", instrumentName='" + instrumentName + '\'' +
                ", instrumentType='" + instrumentType + '\'' +
                ", orderType='" + orderType + '\'' +
                ", side='" + side + '\'' +
                ", amount='" + amount + '\'' +
                ", price='" + price + '\'' +
                ", avgPrice='" + avgPrice + '\'' +
                ", filled='" + filled + '\'' +
                ", orderStatus='" + orderStatus + '\'' +
                ", reduceOnly=" + reduceOnly +
                ", initialMargin='" + initialMargin + '\'' +
                ", optionType='" + optionType + '\'' +
                ", iv='" + iv + '\'' +
                ", expiry='" + expiry + '\'' +
                ", createdTimestamp='" + createdTimestamp + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", systemType='" + systemType + '\'' +
                ", stop='" + stop + '\'' +
                ", trigger='" + trigger + '\'' +
                '}';
    }
}
