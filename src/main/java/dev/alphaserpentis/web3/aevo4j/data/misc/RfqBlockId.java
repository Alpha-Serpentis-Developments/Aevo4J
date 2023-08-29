package dev.alphaserpentis.web3.aevo4j.data.misc;

import com.google.gson.annotations.SerializedName;

public class RfqBlockId {
    @SerializedName("rfq_block_id")
    public final String rfqBlockId;

    public RfqBlockId(String rfqBlockId) {
        this.rfqBlockId = rfqBlockId;
    }
}
