package dev.alphaserpentis.web3.aevo4j.data.response.wss;

import dev.alphaserpentis.web3.aevo4j.api.endpoints.websocket.impl.OrderbookListener;
import dev.alphaserpentis.web3.aevo4j.data.response.common.Orderbook;

/**
 * Data returned from the orderbook channel
 *
 * @see OrderbookListener
 * @see <a href="https://docs.aevo.xyz/reference/subscribe">Aevo - SUBSCRIBE Orderbook</a>
 */
@SuppressWarnings("unused")
public class OrderbookData extends Response<Orderbook> {

    @Override
    public String toString() {
        return "SubscribedOrderbookData{" +
                "channel='" + getChannel() + '\'' +
                ", data=" + getData() +
                '}';
    }
}
