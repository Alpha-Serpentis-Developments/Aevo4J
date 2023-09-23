package dev.alphaserpentis.web3.aevo4j.data.request.rest;

import com.google.gson.annotations.SerializedName;
import io.reactivex.rxjava3.annotations.NonNull;

/**
 * @see <a href="https://api-docs.aevo.xyz/reference/poststrategywithdraw">POST /strategy/withdraw</a>
 */
@SuppressWarnings("unused")
public class StrategyWithdrawBody extends WithdrawBody {

    @SerializedName("label")
    private final String label;

    public StrategyWithdrawBody(
            @NonNull String account,
            @NonNull String collateral,
            @NonNull String to,
            @NonNull String amount,
            @NonNull String salt,
            @NonNull String signature,
            @NonNull String label
    ) {
        super(account, collateral, to, amount, salt, signature);

        this.label = label;
    }
}
