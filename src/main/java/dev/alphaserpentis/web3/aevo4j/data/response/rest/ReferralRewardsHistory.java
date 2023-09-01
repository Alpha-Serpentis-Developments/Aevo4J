package dev.alphaserpentis.web3.aevo4j.data.response.rest;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

@SuppressWarnings("unused")
public class ReferralRewardsHistory {
    @SerializedName("count")
    private long count;
    @SerializedName("referral_rewards_history")
    private HistoricalReferralReward[] referralRewardsHistory;

    public static class HistoricalReferralReward {
        @SerializedName("reward_type")
        private String rewardType;
        @SerializedName("rewards")
        private double rewards;
        @SerializedName("created_timestamp")
        private long createdTimestamp;

        public String getRewardType() {
            return rewardType;
        }

        public double getRewards() {
            return rewards;
        }

        public long getCreatedTimestamp() {
            return createdTimestamp;
        }

        @Override
        public String toString() {
            return "HistoricalReferralReward{"
                    + "rewardType='" + rewardType + '\''
                    + ", rewards='" + rewards + '\''
                    + ", createdTimestamp='" + createdTimestamp + '\''
                    + '}';
        }
    }

    public long getCount() {
        return count;
    }

    public HistoricalReferralReward[] getReferralRewardsHistory() {
        return referralRewardsHistory;
    }

    @Override
    public String toString() {
        return "ReferralRewardsHistory{"
                + "count='" + count + '\''
                + ", referralRewardsHistory=" + Arrays.toString(referralRewardsHistory)
                + '}';
    }
}
