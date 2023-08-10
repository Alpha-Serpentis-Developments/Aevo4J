package dev.alphaserpentis.web3.aevo4j.data.response.rest;

import com.google.gson.annotations.SerializedName;

public class Markets {
    @SerializedName("instrument_id")
    private String instrumentId;
    @SerializedName("instrument_name")
    private String instrumentName;
    @SerializedName("instrument_type")
    private String instrumentType;
    @SerializedName("underlying_asset")
    private String underlyingAsset;
    @SerializedName("quote_asset")
    private String quoteAsset;
    @SerializedName("price_step")
    private String priceStep;
    @SerializedName("amount_step")
    private String amountStep;
    @SerializedName("min_order_value")
    private String minOrderValue;
    @SerializedName("mark_price")
    private String markPrice;
    @SerializedName("is_active")
    private boolean isActive;
    @SerializedName("option_type")
    private String optionType;
    @SerializedName("expiry")
    private String expiry;
    @SerializedName("strike")
    private String strike;
    @SerializedName("greeks")
    private Greeks greeks;

    public static class Greeks {
        @SerializedName("delta")
        private String delta;
        @SerializedName("gamma")
        private String gamma;
        @SerializedName("rho")
        private String rho;
        @SerializedName("theta")
        private String theta;
        @SerializedName("vega")
        private String vega;
        @SerializedName("iv")
        private String iv;

        public String getDelta() {
            return delta;
        }

        public String getGamma() {
            return gamma;
        }

        public String getRho() {
            return rho;
        }

        public String getTheta() {
            return theta;
        }

        public String getVega() {
            return vega;
        }

        public String getIv() {
            return iv;
        }

        @Override
        public String toString() {
            return "Greeks{" +
                    "delta='" + delta + '\'' +
                    ", gamma='" + gamma + '\'' +
                    ", rho='" + rho + '\'' +
                    ", theta='" + theta + '\'' +
                    ", vega='" + vega + '\'' +
                    ", iv='" + iv + '\'' +
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

    public String getUnderlyingAsset() {
        return underlyingAsset;
    }

    public String getQuoteAsset() {
        return quoteAsset;
    }

    public String getPriceStep() {
        return priceStep;
    }

    public String getAmountStep() {
        return amountStep;
    }

    public String getMinOrderValue() {
        return minOrderValue;
    }

    public String getMarkPrice() {
        return markPrice;
    }

    public boolean isActive() {
        return isActive;
    }

    public String getOptionType() {
        return optionType;
    }

    public String getExpiry() {
        return expiry;
    }

    public String getStrike() {
        return strike;
    }

    public Greeks getGreeks() {
        return greeks;
    }

    @Override
    public String toString() {
        return "Markets{" +
                "instrumentId='" + instrumentId + '\'' +
                ", instrumentName='" + instrumentName + '\'' +
                ", instrumentType='" + instrumentType + '\'' +
                ", underlyingAsset='" + underlyingAsset + '\'' +
                ", quoteAsset='" + quoteAsset + '\'' +
                ", priceStep='" + priceStep + '\'' +
                ", amountStep='" + amountStep + '\'' +
                ", minOrderValue='" + minOrderValue + '\'' +
                ", markPrice='" + markPrice + '\'' +
                ", isActive=" + isActive +
                ", optionType='" + optionType + '\'' +
                ", expiry='" + expiry + '\'' +
                ", strike='" + strike + '\'' +
                ", greeks=" + greeks +
                '}';
    }
}
