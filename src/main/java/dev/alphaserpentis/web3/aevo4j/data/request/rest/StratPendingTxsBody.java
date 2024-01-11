package dev.alphaserpentis.web3.aevo4j.data.request.rest;

import com.google.gson.annotations.SerializedName;
import io.reactivex.rxjava3.annotations.NonNull;

@SuppressWarnings("unused")
public class StratPendingTxsBody {
    @SerializedName("strategy_transaction_type")
    private final String stratTransactionType;

    public StratPendingTxsBody(@NonNull String type) {
        this.stratTransactionType = type;
    }

    public String getStratTransactionType() {
        return stratTransactionType;
    }
}
