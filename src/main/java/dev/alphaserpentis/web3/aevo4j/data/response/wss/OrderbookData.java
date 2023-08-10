package dev.alphaserpentis.web3.aevo4j.data.response.wss;

import dev.alphaserpentis.web3.aevo4j.data.response.common.Orderbook;

public class OrderbookData extends Response<Orderbook> {

    @Override
    public String toString() {
        return "SubscribedOrderbookData{" +
                "channel='" + getChannel() + '\'' +
                ", data=" + getData() +
                '}';
    }
}
