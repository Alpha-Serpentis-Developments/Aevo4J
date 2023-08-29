package dev.alphaserpentis.web3.aevo4j.data.response.wss;

import dev.alphaserpentis.web3.aevo4j.api.endpoints.websocket.impl.TradesListener;
import dev.alphaserpentis.web3.aevo4j.data.response.common.Trade;

/**
 * Data returned from the trades channel
 *
 * @see TradesListener
 * @see <a href="https://docs.aevo.xyz/reference/subcribe-trades">Aevo - SUBSCRIBE Trades</a>
 */
@SuppressWarnings("unused")
public class TradesData extends Response<Trade> {

    @Override
    public String toString() {
        return "SubscribedTradesData{" +
                "channel='" + getChannel() + '\'' +
                ", data=" + getData() +
                '}';
    }
}
