package dev.alphaserpentis.web3.aevo4j.data.request.wss;

import com.google.gson.annotations.SerializedName;

public class CreateRFQ {
    @SerializedName("instrument_id")
    public final int instrumentId;
    @SerializedName("amount")
    public final String amount;

    public CreateRFQ(int instrumentId, String amount) {
        this.instrumentId = instrumentId;
        this.amount = amount;
    }
}
