package dev.alphaserpentis.web3.aevo4j.api.endpoints.websocket;

import dev.alphaserpentis.web3.aevo4j.data.response.wss.RFQsData;

public class RFQsListener extends AevoListener<RFQsData> {
    public RFQsListener() {
        super(RFQsData.class);
    }
}
