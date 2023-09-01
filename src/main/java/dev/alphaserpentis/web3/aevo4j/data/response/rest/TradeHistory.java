package dev.alphaserpentis.web3.aevo4j.data.response.rest;

import com.google.gson.annotations.SerializedName;
import dev.alphaserpentis.web3.aevo4j.data.response.common.Trade;

import java.util.Arrays;

@SuppressWarnings("unused")
public class TradeHistory extends Trade {

    @SerializedName("count")
    private long count;
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
        private double spotPrice;
        @SerializedName("avg_price")
        private double avgPrice;
        @SerializedName("mark_price")
        private double markPrice;
        @SerializedName("fees")
        private double fees;
        @SerializedName("liquidity")
        private String liquidity;
        @SerializedName("iv")
        private double iv;
        @SerializedName("fee_rate")
        private double feeRate;
        @SerializedName("pnl")
        private double pnl;
        @SerializedName("payout")
        private double payout;
        @SerializedName("strike")
        private double strike;
        @SerializedName("option_type")
        private String optionType;
        @SerializedName("agg_order_id")
        private String aggOrderId;
        @SerializedName("trade_status")
        private String tradeStatus;
        @SerializedName("settlement_price")
        private double settlementPrice;
        @SerializedName("liquidation_fee")
        private double liquidationFee;

        public String getOrderId() {
            return orderId;
        }

        public String getAccount() {
            return account;
        }

        public String getAsset() {
            return asset;
        }

        public double getSpotPrice() {
            return spotPrice;
        }

        public double getAvgPrice() {
            return avgPrice;
        }

        public double getMarkPrice() {
            return markPrice;
        }

        public double getFees() {
            return fees;
        }

        public String getLiquidity() {
            return liquidity;
        }

        public double getIv() {
            return iv;
        }

        public double getFeeRate() {
            return feeRate;
        }

        public double getPnl() {
            return pnl;
        }

        public double getPayout() {
            return payout;
        }

        public double getStrike() {
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

        public double getSettlementPrice() {
            return settlementPrice;
        }

        public double getLiquidationFee() {
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

    public long getCount() {
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
