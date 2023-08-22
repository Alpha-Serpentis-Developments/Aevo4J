package dev.alphaserpentis.web3.aevo4j.data.response.rest;

import com.google.gson.annotations.SerializedName;
import dev.alphaserpentis.web3.aevo4j.data.response.common.Trade;

import java.util.Arrays;

@SuppressWarnings("unused")
public class TradeHistory extends Trade {

    @SerializedName("count")
    private String count;
    @SerializedName("trade_history")
    private HistoricalTrade[] tradeHistory;

    public static class HistoricalTrade extends Trade {
        @SerializedName("order_id")
        private String orderId;
        @SerializedName("account")
        private String account;
        @SerializedName("asset")
        private String asset;
        @SerializedName("spot_price")
        private String spotPrice;
        @SerializedName("avg_price")
        private String avgPrice;
        @SerializedName("mark_price")
        private String markPrice;
        @SerializedName("fees")
        private String fees;
        @SerializedName("liquidity")
        private String liquidity;
        @SerializedName("iv")
        private String iv;
        @SerializedName("fee_rate")
        private String feeRate;
        @SerializedName("pnl")
        private String pnl;
        @SerializedName("payout")
        private String payout;
        @SerializedName("strike")
        private String strike;
        @SerializedName("option_type")
        private String optionType;
        @SerializedName("agg_order_id")
        private String aggOrderId;
        @SerializedName("trade_status")
        private String tradeStatus;
        @SerializedName("settlement_price")
        private String settlementPrice;
        @SerializedName("liquidation_fee")
        private String liquidationFee;

        public String getOrderId() {
            return orderId;
        }

        public String getAccount() {
            return account;
        }

        public String getAsset() {
            return asset;
        }

        public String getSpotPrice() {
            return spotPrice;
        }

        public String getAvgPrice() {
            return avgPrice;
        }

        public String getMarkPrice() {
            return markPrice;
        }

        public String getFees() {
            return fees;
        }

        public String getLiquidity() {
            return liquidity;
        }

        public String getIv() {
            return iv;
        }

        public String getFeeRate() {
            return feeRate;
        }

        public String getPnl() {
            return pnl;
        }

        public String getPayout() {
            return payout;
        }

        public String getStrike() {
            return strike;
        }

        public String getOptionType() {
            return optionType;
        }

        public String getAggOrderId() {
            return aggOrderId;
        }

        public String getTradeStatus() {
            return tradeStatus;
        }

        public String getSettlementPrice() {
            return settlementPrice;
        }

        public String getLiquidationFee() {
            return liquidationFee;
        }

        @Override
        public String toString() {
            return "HistoricalTrade{"
                    + "tradeId='" + getTradeId() + '\''
                    + ", instrumentId='" + getInstrumentId() + '\''
                    + ", instrumentName='" + getInstrumentName() + '\''
                    + ", instrumentType='" + getInstrumentType() + '\''
                    + ", side='" + getSide() + '\''
                    + ", price='" + getPrice() + '\''
                    + ", amount='" + getAmount() + '\''
                    + ", createdTimestamp='" + getCreatedTimestamp() + '\''
                    + ", orderId='" + orderId + '\''
                    + ", account='" + account + '\''
                    + ", asset='" + asset + '\''
                    + ", spotPrice='" + spotPrice + '\''
                    + ", avgPrice='" + avgPrice + '\''
                    + ", markPrice='" + markPrice + '\''
                    + ", fees='" + fees + '\''
                    + ", liquidity='" + liquidity + '\''
                    + ", iv='" + iv + '\''
                    + ", feeRate='" + feeRate + '\''
                    + ", pnl='" + pnl + '\''
                    + ", payout='" + payout + '\''
                    + ", strike='" + strike + '\''
                    + ", optionType='" + optionType + '\''
                    + ", aggOrderId='" + aggOrderId + '\''
                    + ", tradeStatus='" + tradeStatus + '\''
                    + ", settlementPrice='" + settlementPrice + '\''
                    + ", liquidationFee='" + liquidationFee + '\''
                    + '}';
        }
    }

    public String getCount() {
        return count;
    }

    public HistoricalTrade[] getTradeHistory() {
        return tradeHistory;
    }

    @Override
    public String toString() {
        return "TradeHistory{"
                + "count='" + count + '\''
                + ", tradeHistory=" + Arrays.toString(tradeHistory)
                + '}';
    }
}
