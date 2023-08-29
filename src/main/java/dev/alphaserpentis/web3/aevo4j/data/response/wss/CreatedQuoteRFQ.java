package dev.alphaserpentis.web3.aevo4j.data.response.wss;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

@SuppressWarnings("unused")
public class CreatedQuoteRFQ extends Response<CreatedQuoteRFQ.Data> {
    public static class Data {
        @SerializedName("rfq_block_id")
        public String rfqBlockId;
        @SerializedName("quote_rfq_block_id")
        public String quoteRfqBlockId;
        @SerializedName("orders")
        public CreatedOrder[] orders;

        public String getRfqBlockId() {
            return rfqBlockId;
        }

        public String getQuoteRfqBlockId() {
            return quoteRfqBlockId;
        }

        public CreatedOrder[] getOrders() {
            return orders;
        }

        @Override
        public String toString() {
            return "CreatedQuoteRFQ{" +
                    "rfqBlockId='" + rfqBlockId + '\'' +
                    ", quoteRfqBlockId='" + quoteRfqBlockId + '\'' +
                    ", orders=" + Arrays.toString(orders) +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "CreatedQuoteRFQ{" +
                "data=" + getData() +
                "id=" + getId() +
                '}';
    }
}
