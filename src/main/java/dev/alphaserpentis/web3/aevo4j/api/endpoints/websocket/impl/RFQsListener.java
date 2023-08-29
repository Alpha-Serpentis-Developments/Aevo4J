package dev.alphaserpentis.web3.aevo4j.api.endpoints.websocket.impl;

import dev.alphaserpentis.web3.aevo4j.data.request.wss.ChannelName;
import dev.alphaserpentis.web3.aevo4j.data.request.wss.WebSocketOperations;
import dev.alphaserpentis.web3.aevo4j.data.response.wss.RFQsData;

/**
 * @see <a href="https://docs.aevo.xyz/reference/subscribe-rfqs">Aevo - SUBSCRIBE RFQs</a>
 */
public class RFQsListener extends AevoListener<RFQsData> {
    public RFQsListener() {
        super(RFQsData.class, ChannelName.Channels.RFQS);
    }

    public RFQsListener(
            boolean isTestnet
    ) {
        super(
                RFQsData.class,
                ChannelName.Channels.RFQS,
                WebSocketOperations.SUBSCRIBE,
                isTestnet,
                new ChannelName(ChannelName.Channels.RFQS)
        );
    }
}
