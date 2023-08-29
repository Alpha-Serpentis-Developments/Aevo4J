package dev.alphaserpentis.web3.aevo4j.data.request.wss;

import com.google.gson.annotations.SerializedName;
import dev.alphaserpentis.web3.aevo4j.data.misc.SignedOrder;

public class QuoteRFQ {
    @SerializedName("rfq_block_id")
    public final String rfqBlockId;
    @SerializedName("orders")
    public final SignedOrder[] orders;

    public QuoteRFQ(String rfqBlockId, SignedOrder[] orders) {
        this.rfqBlockId = rfqBlockId;
        this.orders = orders;
    }
}
