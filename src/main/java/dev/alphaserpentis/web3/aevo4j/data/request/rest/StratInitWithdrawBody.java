package dev.alphaserpentis.web3.aevo4j.data.request.rest;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class StratInitWithdrawBody {
    @SerializedName("strategy_address")
    private final String strategyAddress;
    @SerializedName("collateral")
    private final String collateral;
    @SerializedName("amount_float")
    private final double amountFloat;

    public StratInitWithdrawBody(String strategyAddress, String collateral, double amountFloat) {
        this.strategyAddress = strategyAddress;
        this.collateral = collateral;
        this.amountFloat = amountFloat;
    }
}
