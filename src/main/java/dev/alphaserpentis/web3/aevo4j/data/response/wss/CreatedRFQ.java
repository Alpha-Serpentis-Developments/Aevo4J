package dev.alphaserpentis.web3.aevo4j.data.response.wss;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class CreatedRFQ extends Response<CreatedRFQ.Data> {
    public static class Data {
        @SerializedName("rfq_block_id")
        public String rfqBlockId;
        @SerializedName("rfqs")
        public RFQ[] rfqs;

        public static class RFQ {
            @SerializedName("amount")
            public String amount;
            @SerializedName("instrument_id")
            public String instrumentId;

            public String getAmount() {
                return amount;
            }

            public String getInstrumentId() {
                return instrumentId;
            }

            @Override
            public String toString() {
                return "RFQ{" +
                        "amount='" + amount + '\'' +
                        ", instrumentId='" + instrumentId + '\'' +
                        '}';
            }
        }
    }

    @Override
    public String toString() {
        return "CreatedRFQ{" +
                "data=" + getData() +
                "id=" + getId() +
                '}';
    }
}
