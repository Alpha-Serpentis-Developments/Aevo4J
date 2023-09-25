package dev.alphaserpentis.web3.aevo4j.data.response.rest;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

@SuppressWarnings("unused")
public class ReferralHistory {
    @SerializedName("count")
    private long count;
    @SerializedName("referral_history")
    private HistoricalReferral[] referralHistory;

    public static class HistoricalReferral {
        @SerializedName("referee")
        private String referee;
        @SerializedName("referee_username")
        private String refereeUsername;
        @SerializedName("rewards")
        private double rewards;
        @SerializedName("created_timestamp")
        private long createdTimestamp;

        public String getReferee() {
            return referee;
        }

        public String getRefereeUsername() {
            return refereeUsername;
        }

        public double getRewards() {
            return rewards;
        }

        public long getCreatedTimestamp() {
            return createdTimestamp;
        }

        @Override
        public String toString() {
            return "HistoricalReferral{"
                    + "referee='" + referee + '\''
                    + ", refereeUsername='" + refereeUsername + '\''
                    + ", rewards='" + rewards + '\''
                    + ", createdTimestamp='" + createdTimestamp + '\''
                    + '}';
        }
    }

    public long getCount() {
        return count;
    }

    public HistoricalReferral[] getReferralHistory() {
        return referralHistory;
    }

    @Override
    public String toString() {
        return "ReferralHistory{"
                + "count='" + count + '\''
                + ", referralHistory=" + Arrays.toString(referralHistory)
                + '}';
    }
}
