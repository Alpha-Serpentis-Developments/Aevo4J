package dev.alphaserpentis.web3.aevo4j.data.request.wss;

import com.google.gson.annotations.SerializedName;

public class CreateRFQ {
    @SerializedName("instrument_id")
    public final long instrumentId;
    @SerializedName("amount")
    public final String amount;

    public CreateRFQ(long instrumentId, String amount) {
        this.instrumentId = instrumentId;
        this.amount = amount;
    }
}
