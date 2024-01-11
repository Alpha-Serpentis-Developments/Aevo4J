package dev.alphaserpentis.web3.aevo4j.data.response.rest;

import com.google.gson.annotations.SerializedName;

public class SwapPreview {
    @SerializedName("quote_amount")
    private long quoteAmount;
    @SerializedName("fees")
    private double fees;
    @SerializedName("fee_rate")
    private double feeRate;
    @SerializedName("base_balance")
    private double baseBalance;
    @SerializedName("quote_balance")
    private double quoteBalance;
    @SerializedName("base_capacity")
    private double baseCapacity;
    @SerializedName("quote_capacity")
    private double quoteCapacity;
    @SerializedName("amount")
    private double amount;
    @SerializedName("price")
    private double price;

    public long getQuoteAmount() {
        return quoteAmount;
    }

    public double getFees() {
        return fees;
    }

    public double getFeeRate() {
        return feeRate;
    }

    public double getBaseBalance() {
        return baseBalance;
    }

    public double getQuoteBalance() {
        return quoteBalance;
    }

    public double getBaseCapacity() {
        return baseCapacity;
    }

    public double getQuoteCapacity() {
        return quoteCapacity;
    }

    public double getAmount() {
        return amount;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "SwapPreview{" +
                "quoteAmount=" + quoteAmount +
                ", fees=" + fees +
                ", feeRate=" + feeRate +
                ", baseBalance=" + baseBalance +
                ", quoteBalance=" + quoteBalance +
                ", baseCapacity=" + baseCapacity +
                ", quoteCapacity=" + quoteCapacity +
                ", amount=" + amount +
                ", price=" + price +
                '}';
    }
}
