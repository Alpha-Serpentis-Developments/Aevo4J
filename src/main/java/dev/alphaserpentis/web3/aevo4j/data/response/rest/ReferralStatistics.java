package dev.alphaserpentis.web3.aevo4j.data.response.rest;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class ReferralStatistics {
    @SerializedName("referred")
    private String referred;
    @SerializedName("volume")
    private String volume;
    @SerializedName("total_rewards")
    private String totalRewards;
    @SerializedName("total_referral_bonus")
    private String totalReferralBonus;
    @SerializedName("total_referee_discount")
    private String totalRefereeDiscount;
    @SerializedName("total_rewards_unclaimed")
    private String totalRewardsUnclaimed;
    @SerializedName("total_referral_bonus_unclaimed")
    private String totalReferralBonusUnclaimed;
    @SerializedName("total_referee_discount_unclaimed")
    private String totalRefereeDiscountUnclaimed;

    public String getReferred() {
        return referred;
    }

    public String getVolume() {
        return volume;
    }

    public String getTotalRewards() {
        return totalRewards;
    }

    public String getTotalReferralBonus() {
        return totalReferralBonus;
    }

    public String getTotalRefereeDiscount() {
        return totalRefereeDiscount;
    }

    public String getTotalRewardsUnclaimed() {
        return totalRewardsUnclaimed;
    }

    public String getTotalReferralBonusUnclaimed() {
        return totalReferralBonusUnclaimed;
    }

    public String getTotalRefereeDiscountUnclaimed() {
        return totalRefereeDiscountUnclaimed;
    }

    @Override
    public String toString() {
        return "ReferralStatistics{"
                + "referred='" + referred + '\''
                + ", volume='" + volume + '\''
                + ", totalRewards='" + totalRewards + '\''
                + ", totalReferralBonus='" + totalReferralBonus + '\''
                + ", totalRefereeDiscount='" + totalRefereeDiscount + '\''
                + ", totalRewardsUnclaimed='" + totalRewardsUnclaimed + '\''
                + ", totalReferralBonusUnclaimed='" + totalReferralBonusUnclaimed + '\''
                + ", totalRefereeDiscountUnclaimed='" + totalRefereeDiscountUnclaimed + '\''
                + '}';
    }
}
