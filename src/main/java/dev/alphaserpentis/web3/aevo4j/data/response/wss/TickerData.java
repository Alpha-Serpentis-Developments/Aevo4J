package dev.alphaserpentis.web3.aevo4j.data.response.wss;

import com.google.gson.annotations.SerializedName;
import dev.alphaserpentis.web3.aevo4j.api.endpoints.websocket.impl.TickerListener;
import dev.alphaserpentis.web3.aevo4j.data.response.common.Greeks;

import java.util.Arrays;

/**
 * Data returned from the ticker channel
 * @see TickerListener
 * @see <a href="https://docs.aevo.xyz/reference/sub-ticker">Aevo - SUBSCRIBE Ticker</a>
 */
@SuppressWarnings("unused")
public class TickerData extends Response<TickerData.Data> {

    public static class Data {
        @SerializedName("timestamp")
        private String timestamp;
        @SerializedName("tickers")
        private Ticker[] tickers;

        public static class Ticker {
            @SerializedName("instrument_id")
            private long instrumentId;
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

            public static class Price extends Greeks {
                @SerializedName("price")
                private double price;
                @SerializedName("amount")
                private String amount;

                public double getPrice() {
                    return price;
                }

                public String getAmount() {
                    return amount;
                }

                @Override
                public String toString() {
                    return "Price{" +
                            "price='" + price + '\'' +
                            ", delta='" + getDelta() + '\'' +
                            ", theta='" + getTheta() + '\'' +
                            ", gamma='" + getGamma() + '\'' +
                            ", rho='" + getRho() + '\'' +
                            ", vega='" + getVega() + '\'' +
                            ", iv='" + getIv() + '\'' +
                            ", amount='" + amount + '\'' +
                            '}';
                }
            }

            public double getInstrumentId() {
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
                        ", bid=" + bid +
                        ", ask=" + ask +
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
