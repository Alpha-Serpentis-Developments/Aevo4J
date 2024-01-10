package dev.alphaserpentis.web3.aevo4j.data.request.rest;

import com.google.gson.annotations.SerializedName;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;

@SuppressWarnings("unused")
public class SwapBody {
    @SerializedName("collateral_asset")
    private final String collateralAsset;
    @SerializedName("is_buy")
    private final Boolean isBuy;
    @SerializedName("base_amount")
    private final String baseAmount;
    @SerializedName("quote_amount")
    private final Long quoteAmount;

    public SwapBody(
            @NonNull String collateralAsset,
            @Nullable Boolean isBuy,
            @Nullable String baseAmount,
            @Nullable Long quoteAmount
    ) {
        this.collateralAsset = collateralAsset;
        this.isBuy = isBuy;
        this.baseAmount = baseAmount;
        this.quoteAmount = quoteAmount;
    }
}
