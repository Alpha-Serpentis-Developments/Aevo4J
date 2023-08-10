package dev.alphaserpentis.web3.aevo4j.data.response.wss;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

/**
 * Subscribe to the ticker channel.
 *
 * @see <a href="https://docs.aevo.xyz/reference/sub-ticker">Aevo - SUBSCRIBE Ticker</a>
 */
public class TickerData extends Response<TickerData.Data> {

    public static class Data {
        @SerializedName("timestamp")
        private String timestamp;
        @SerializedName("tickers")
        private Ticker[] tickers;

        public static class Ticker {
            @SerializedName("instrument_id")
            private String instrumentId;
            @SerializedName("instrument_name")
            private String instrumentName;
            @SerializedName("instrument_type")
            private String instrumentType;
            @SerializedName("mark")
            private Price mark;
            @SerializedName("bid")
            private Price bid;
            @SerializedName("ask")
            private Price ask;

            public static class Price {
                @SerializedName("price")
                private String price;
                @SerializedName("delta")
                private String delta;
                @SerializedName("theta")
                private String theta;
                @SerializedName("gamma")
                private String gamma;
                @SerializedName("rho")
                private String rho;
                @SerializedName("vega")
                private String vega;
                @SerializedName("iv")
                private String iv;
                @SerializedName("amount")
                private String amount;

                public String getPrice() {
                    return price;
                }

                public String getDelta() {
                    return delta;
                }

                public String getTheta() {
                    return theta;
                }

                public String getGamma() {
                    return gamma;
                }

                public String getRho() {
                    return rho;
                }

                public String getVega() {
                    return vega;
                }

                public String getIv() {
                    return iv;
                }

                public String getAmount() {
                    return amount;
                }

                @Override
                public String toString() {
                    return "Price{" +
                            "price='" + price + '\'' +
                            ", delta='" + delta + '\'' +
                            ", theta='" + theta + '\'' +
                            ", gamma='" + gamma + '\'' +
                            ", rho='" + rho + '\'' +
                            ", vega='" + vega + '\'' +
                            ", iv='" + iv + '\'' +
                            ", amount='" + amount + '\'' +
                            '}';
                }
            }

            public String getInstrumentId() {
                return instrumentId;
            }

            public String getInstrumentName() {
                return instrumentName;
            }

            public String getInstrumentType() {
                return instrumentType;
            }

            public Price getMark() {
                return mark;
            }

            public Price getBid() {
                return bid;
            }

            public Price getAsk() {
                return ask;
            }

            @Override
            public String toString() {
                return "Ticker{" +
                        "instrumentId='" + instrumentId + '\'' +
                        ", instrumentName='" + instrumentName + '\'' +
                        ", instrumentType='" + instrumentType + '\'' +
                        ", mark=" + mark +
                        '}';
            }
        }

        public String getTimestamp() {
            return timestamp;
        }

        public Ticker[] getTickers() {
            return tickers;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "timestamp='" + timestamp + '\'' +
                    ", tickers=" + Arrays.toString(tickers) +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "TickerData{" +
                "channel='" + getChannel() + '\'' +
                ", data=" + getData() +
                '}';
    }

}
