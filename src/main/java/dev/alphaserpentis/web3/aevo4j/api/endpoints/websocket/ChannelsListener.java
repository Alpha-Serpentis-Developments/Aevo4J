package dev.alphaserpentis.web3.aevo4j.api.endpoints.websocket;

import dev.alphaserpentis.web3.aevo4j.data.response.wss.ChannelsData;

/**
 * Get available channels to subscribe to (similar to doing a GET/POST request)
 * @see <a href="https://docs.aevo.xyz/reference/publish-channel">Aevo - PUBLISH Channels</a>
 */
public class ChannelsListener extends AevoListener<ChannelsData> {

    public ChannelsListener() {
        super(ChannelsData.class);
    }
}
