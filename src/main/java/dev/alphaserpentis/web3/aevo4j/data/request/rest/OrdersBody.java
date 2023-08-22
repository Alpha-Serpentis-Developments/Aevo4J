package dev.alphaserpentis.web3.aevo4j.data.request.rest;

import com.google.gson.annotations.SerializedName;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;

@SuppressWarnings("unused")
public class OrdersBody {
    @SerializedName("instrument")
    private final String instrument;
    @SerializedName("maker")
    private final String maker;
    @SerializedName("is_buy")
    private final boolean isBuy;
    @SerializedName("amount")
    private final String amount;
    @SerializedName("limit_price")
    private final String limitPrice;
    @SerializedName("salt")
    private final String salt;
    @SerializedName("signature")
    private final String signature;
    @SerializedName("timestamp")
    private final String timestamp;
    @SerializedName("post_only")
    private final boolean postOnly;
    @SerializedName("reduce_only")
    private final boolean reduceOnly;
    @SerializedName("time_in_force")
    private final String timeInForce;
    @SerializedName("mmp")
    private final boolean mmp;
    @SerializedName("stop")
    private final String stop;
    @SerializedName("trigger")
    private final String trigger;

    public OrdersBody(
            @NonNull String instrument,
            @NonNull String maker,
            boolean isBuy,
            @NonNull String amount,
            @NonNull String limitPrice,
            @NonNull String salt,
            @NonNull String signature,
            @Nullable String timestamp,
            boolean postOnly,
            boolean reduceOnly,
            @Nullable String timeInForce,
            boolean mmp,
            @Nullable String stop,
            @Nullable String trigger
    ) {
        this.instrument = instrument;
        this.maker = maker;
        this.isBuy = isBuy;
        this.amount = amount;
        this.limitPrice = limitPrice;
        this.salt = salt;
        this.signature = signature;
        this.timestamp = timestamp;
        this.postOnly = postOnly;
        this.reduceOnly = reduceOnly;
        this.timeInForce = timeInForce;
        this.mmp = mmp;
        this.stop = stop;
        this.trigger = trigger;
    }

    public OrdersBody(
            @NonNull String instrument,
            @NonNull String maker,
            boolean isBuy,
            @NonNull String amount,
            @NonNull String limitPrice,
            @NonNull String salt,
            @NonNull String signature
    ) {
        this(
                instrument,
                maker,
                isBuy,
                amount,
                limitPrice,
                salt,
                signature,
                null,
                false,
                false,
                null,
                false,
                null,
                null
        );
    }

    @Override
    public String toString() {
        return "{\"instrument\":\"" + instrument + "\",\"maker\":\"" + maker + "\",\"is_buy\":" + isBuy
                + ",\"amount\":\"" + amount + "\",\"limit_price\":\"" + limitPrice + "\",\"salt\":\"" + salt
                + "\",\"signature\":\"" + signature + "\",\"timestamp\":\"" + timestamp + "\",\"post_only\":"
                + postOnly + ",\"reduce_only\":" + reduceOnly + ",\"time_in_force\":\"" + timeInForce + "\",\"mmp\":"
                + mmp + ",\"stop\":\"" + stop + "\",\"trigger\":\"" + trigger + "\"}";
    }
}
