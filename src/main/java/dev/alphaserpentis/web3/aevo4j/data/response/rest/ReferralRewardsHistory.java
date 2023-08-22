package dev.alphaserpentis.web3.aevo4j.data.response.rest;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

@SuppressWarnings("unused")
public class ReferralRewardsHistory {
    @SerializedName("count")
    private String count;
    @SerializedName("referral_rewards_history")
    private HistoricalReferralReward[] referralRewardsHistory;

    public static class HistoricalReferralReward {
        @SerializedName("reward_type")
        private String rewardType;
        @SerializedName("rewards")
        private String rewards;
        @SerializedName("created_timestamp")
        private String createdTimestamp;

        public String getRewardType() {
            return rewardType;
        }

        public String getRewards() {
            return rewards;
        }

        public String getCreatedTimestamp() {
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

    public String getCount() {
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
