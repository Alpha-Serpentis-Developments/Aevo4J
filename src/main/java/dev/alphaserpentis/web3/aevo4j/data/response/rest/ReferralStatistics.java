package dev.alphaserpentis.web3.aevo4j.data.response.rest;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class ReferralStatistics {
    @SerializedName("referred")
    private long referred;
    @SerializedName("volume")
    private double volume;
    @SerializedName("total_rewards")
    private double totalRewards;
    @SerializedName("total_referral_bonus")
    private double totalReferralBonus;
    @SerializedName("total_referee_discount")
    private double totalRefereeDiscount;
    @SerializedName("total_rewards_unclaimed")
    private double totalRewardsUnclaimed;
    @SerializedName("total_referral_bonus_unclaimed")
    private double totalReferralBonusUnclaimed;
    @SerializedName("total_referee_discount_unclaimed")
    private double totalRefereeDiscountUnclaimed;

    public long getReferred() {
        return referred;
    }

    public double getVolume() {
        return volume;
    }

    public double getTotalRewards() {
        return totalRewards;
    }

    public double getTotalReferralBonus() {
        return totalReferralBonus;
    }

    public double getTotalRefereeDiscount() {
        return totalRefereeDiscount;
    }

    public double getTotalRewardsUnclaimed() {
        return totalRewardsUnclaimed;
    }

    public double getTotalReferralBonusUnclaimed() {
        return totalReferralBonusUnclaimed;
    }

    public double getTotalRefereeDiscountUnclaimed() {
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
