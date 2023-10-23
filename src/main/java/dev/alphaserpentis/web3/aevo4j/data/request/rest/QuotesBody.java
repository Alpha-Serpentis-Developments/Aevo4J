package dev.alphaserpentis.web3.aevo4j.data.request.rest;

import com.google.gson.annotations.SerializedName;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;

/**
 * @see <a href="https://api-docs.aevo.xyz/reference/postquotes">Aevo - POST /quotes</a>
 */
@SuppressWarnings("unused")
public class QuotesBody {
    @SerializedName("block_id")
    private final String blockId;
    @SerializedName("account")
    private final String account;
    @SerializedName("amount")
    private final String amount;
    @SerializedName("is_buy")
    private final boolean isBuy;
    @SerializedName("salt")
    private final String salt;
    @SerializedName("timestamp")
    private final String timestamp;
    @SerializedName("signature")
    private final String signature;
    @SerializedName("legs")
    private final QuoteLeg[] legs;
    @SerializedName("limit_price")
    private final String limitPrice;

    public static class QuoteLeg {
        @SerializedName("instrument")
        private final long instrument;
        @SerializedName("price")
        private final String price;

        public QuoteLeg(long instrument, @NonNull String price) {
            this.instrument = instrument;
            this.price = price;
        }
    }

    public QuotesBody(
            @NonNull String blockId,
            @NonNull String account,
            @NonNull String amount,
            boolean isBuy,
            @NonNull String salt,
            @NonNull String timestamp,
            @NonNull String signature,
            @Nullable QuoteLeg[] legs,
            @Nullable String limitPrice
    ) {
        this.blockId = blockId;
        this.account = account;
        this.amount = amount;
        this.isBuy = isBuy;
        this.salt = salt;
        this.timestamp = timestamp;
        this.signature = signature;
        this.legs = legs;
        this.limitPrice = limitPrice;
    }

    public QuotesBody(
            @NonNull String blockId,
            @NonNull String account,
            @NonNull String amount,
            boolean isBuy,
            @NonNull String salt,
            @NonNull String timestamp,
            @NonNull String signature
    ) {
        this(blockId, account, amount, isBuy, salt, timestamp, signature, null, null);
    }

    public QuotesBody(
            @NonNull String blockId,
            @NonNull String account,
            long amount,
            boolean isBuy,
            long salt,
            long timestamp,
            @NonNull String signature
    ) {
        this(
                blockId,
                account,
                String.valueOf(amount),
                isBuy,
                String.valueOf(salt),
                String.valueOf(timestamp),
                signature,
                null,
                null
        );
    }
}
