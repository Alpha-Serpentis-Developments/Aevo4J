package dev.alphaserpentis.web3.aevo4j.api.endpoints.websocket;

import dev.alphaserpentis.web3.aevo4j.data.response.wss.TradesData;

/**
 * Get trades of an asset(s)
 *
 * @see <a href="https://docs.aevo.xyz/reference/subcribe-trades">Aevo - SUBSCRIBE Trades</a>
 */
public class TradesListener extends AevoListener<TradesData> {

    public TradesListener() {
        super(TradesData.class);
    }
}
