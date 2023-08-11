package dev.alphaserpentis.web3.aevo4j.api.endpoints.websocket;

import dev.alphaserpentis.web3.aevo4j.data.response.wss.TickerData;

/**
 * Get the ticker information when the top of the book changes
 *
 * @see <a href="https://docs.aevo.xyz/reference/sub-ticker">Aevo - SUBSCRIBE Ticker</a>
 */
public class TickerListener extends AevoListener<TickerData> {
    public TickerListener() {
        super(TickerData.class);
    }
}
