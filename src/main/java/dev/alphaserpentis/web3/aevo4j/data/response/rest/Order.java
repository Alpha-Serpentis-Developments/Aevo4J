package dev.alphaserpentis.web3.aevo4j.data.response.rest;

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
    private String instrumentId;
    @SerializedName("instrument_name")
    private String instrumentName;
    @SerializedName("instrument_type")
    private String instrumentType;
    @SerializedName("order_type")
    private String orderType;
    @SerializedName("side")
    private String side;
    @SerializedName("amount")
    private String amount;
    @SerializedName("price")
    private String price;
    @SerializedName("avg_price")
    private String avgPrice;
    @SerializedName("filled")
    private String filled;
    @SerializedName("order_status")
    private String orderStatus;
    @SerializedName("reduce_only")
    private boolean reduceOnly;
    @SerializedName("initial_margin")
    private String initialMargin;
    @SerializedName("option_type")
    private String optionType;
    @SerializedName("iv")
    private String iv;
    @SerializedName("expiry")
    private String expiry;
    @SerializedName("created_timestamp")
    private String createdTimestamp;
    @SerializedName("timestamp")
    private String timestamp;
    @SerializedName("system_type")
    private String systemType;
    @SerializedName("stop")
    private String stop;
    @SerializedName("trigger")
    private String trigger;

    @NonNull
    public String getOrderId() {
        return orderId;
    }

    @NonNull
    public String getAccount() {
        return account;
    }

    @NonNull
    public String getInstrumentId() {
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

    @NonNull
    public String getAmount() {
        return amount;
    }

    @NonNull
    public String getPrice() {
        return price;
    }

    @Nullable
    public String getAvgPrice() {
        return avgPrice;
    }

    @NonNull
    public String getFilled() {
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
    public String getInitialMargin() {
        return initialMargin;
    }

    @Nullable
    public String getOptionType() {
        return optionType;
    }

    @Nullable
    public String getIv() {
        return iv;
    }

    @Nullable
    public String getExpiry() {
        return expiry;
    }

    @Nullable
    public String getCreatedTimestamp() {
        return createdTimestamp;
    }

    @NonNull
    public String getTimestamp() {
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
    public String getTrigger() {
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
