package dev.alphaserpentis.web3.aevo4j.data.response.wss;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

@SuppressWarnings("unused")
public class Status extends Response<Status.Data> {
    public static class Data {
        @SerializedName("account")
        private String account;
        @SerializedName("subscriptions")
        private String[] subscriptions;

        public String getAccount() {
            return account;
        }

        public String[] getSubscriptions() {
            return subscriptions;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "account='" + account + '\'' +
                    ", subscriptions=" + Arrays.toString(subscriptions) +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "Status{" +
                "id='" + getId() + '\'' +
                ", channel='" + getChannel() + '\'' +
                ", data=" + getData() +
                '}';
    }
}
