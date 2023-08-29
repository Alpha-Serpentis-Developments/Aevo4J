package dev.alphaserpentis.web3.aevo4j.api.endpoints.websocket.impl;

import dev.alphaserpentis.web3.aevo4j.data.request.wss.WebSocketOperations;
import dev.alphaserpentis.web3.aevo4j.data.response.wss.ChannelsData;

/**
 * Get available channels to subscribe to (similar to doing a GET/POST request)
 * @see <a href="https://docs.aevo.xyz/reference/publish-channel">Aevo - PUBLISH Channels</a>
 */
public class ChannelsListener extends AevoListener<ChannelsData> {

    public ChannelsListener() {
        super(ChannelsData.class, null);
    }

    public ChannelsListener(
            boolean isTestnet
    ) {
        super(ChannelsData.class, null, WebSocketOperations.CHANNELS, isTestnet, new String[0]);
    }
}
