package dev.alphaserpentis.web3.aevo4j.data.response.rest;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class SocketCapacity {
    @SerializedName("socket_connector")
    private String socketConnector;
    @SerializedName("chain_id")
    private String chainId;
    @SerializedName("capacity")
    private String capacity;

    public String getSocketConnector() {
        return socketConnector;
    }

    public String getChainId() {
        return chainId;
    }

    public String getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return "SocketCapacity{" +
                "socketConnector='" + socketConnector + '\'' +
                ", chainId='" + chainId + '\'' +
                ", capacity='" + capacity + '\'' +
                '}';
    }
}
