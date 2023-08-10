package dev.alphaserpentis.web3.aevo4j.api.endpoints.websocket;

import dev.alphaserpentis.web3.aevo4j.data.response.wss.TickerData;

public class TickerListener extends AevoListener<TickerData> {
    public TickerListener() {
        super(TickerData.class);
    }
}
