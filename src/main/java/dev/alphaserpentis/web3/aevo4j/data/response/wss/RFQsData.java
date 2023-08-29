package dev.alphaserpentis.web3.aevo4j.data.response.wss;

import com.google.gson.annotations.SerializedName;
import dev.alphaserpentis.web3.aevo4j.api.endpoints.websocket.impl.RFQsListener;

import java.util.Arrays;

/**
 * Data returned from the RFQs channel
 *
 * @see RFQsListener
 * @see <a href="https://docs.aevo.xyz/reference/subscribe-rfqs">Aevo - SUBSCRIBE RFQs</a>
 */
@SuppressWarnings("unused")
public class RFQsData extends Response<RFQsData.Data> {

    public static class Data {
        @SerializedName("timestamp")
        private String timestamp;
        @SerializedName("rfqs")
        private RFQ[] rfqs;

        public static class RFQ {
            @SerializedName("status")
            private String status;
            @SerializedName("rfq_block_id")
            private String rfqBlockId;
            @SerializedName("instruments")
            private Instrument[] instruments;

            public static class Instrument {
                @SerializedName("amount")
                private String amount;
                @SerializedName("instrument_id")
                private String instrumentId;

                public String getAmount() {
                    return amount;
                }

                public String getInstrumentId() {
                    return instrumentId;
                }

                @Override
                public String toString() {
                    return "Instrument{" +
                            "amount='" + amount + '\'' +
                            ", instrumentId='" + instrumentId + '\'' +
                            '}';
                }
            }

            public String getStatus() {
                return status;
            }

            public String getRfqBlockId() {
                return rfqBlockId;
            }

            public Instrument[] getInstruments() {
                return instruments;
            }

            @Override
            public String toString() {
                return "RFQ{" +
                        "status='" + status + '\'' +
                        ", rfqBlockId='" + rfqBlockId + '\'' +
                        ", instruments=" + Arrays.toString(instruments) +
                        '}';
            }
        }

        public String getTimestamp() {
            return timestamp;
        }

        public RFQ[] getRfqs() {
            return rfqs;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "timestamp='" + timestamp + '\'' +
                    ", rfqs=" + Arrays.toString(rfqs) +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "RFQsData{" +
                "channel='" + getChannel() + '\'' +
                ", data=" + getData() +
                '}';
    }
}
