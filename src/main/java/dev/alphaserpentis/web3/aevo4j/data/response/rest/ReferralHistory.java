package dev.alphaserpentis.web3.aevo4j.data.response.rest;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

@SuppressWarnings("unused")
public class ReferralHistory {
    @SerializedName("count")
    private String count;
    @SerializedName("referral_history")
    private HistoricalReferral[] referralHistory;

    public static class HistoricalReferral {
        @SerializedName("referee")
        private String referee;
        @SerializedName("referee_username")
        private String refereeUsername;
        @SerializedName("rewards")
        private String rewards;
        @SerializedName("created_timestamp")
        private String createdTimestamp;

        public String getReferee() {
            return referee;
        }

        public String getRefereeUsername() {
            return refereeUsername;
        }

        public String getRewards() {
            return rewards;
        }

        public String getCreatedTimestamp() {
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

    public String getCount() {
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
