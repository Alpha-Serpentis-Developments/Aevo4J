package dev.alphaserpentis.web3.aevo4j.data.response.wss;

import dev.alphaserpentis.web3.aevo4j.data.response.common.Orderbook;

/**
 * Data returned from the orderbook channel
 *
 * @see dev.alphaserpentis.web3.aevo4j.api.endpoints.websocket.OrderbookListener
 * @see <a href="https://docs.aevo.xyz/reference/subscribe">Aevo - SUBSCRIBE Orderbook</a>
 */
public class OrderbookData extends Response<Orderbook> {

    @Override
    public String toString() {
        return "SubscribedOrderbookData{" +
                "channel='" + getChannel() + '\'' +
                ", data=" + getData() +
                '}';
    }
}
