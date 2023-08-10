package dev.alphaserpentis.web3.aevo4j.data.response.wss;

import dev.alphaserpentis.web3.aevo4j.data.response.common.Trade;

public class TradesData extends Response<Trade> {

    @Override
    public String toString() {
        return "SubscribedTradesData{" +
                "channel='" + getChannel() + '\'' +
                ", data=" + getData() +
                '}';
    }
}
