package dev.alphaserpentis.web3.aevo4j.data.response.wss;

import java.util.Arrays;

/**
 * Data returned from the channels channel
 *
 * @see dev.alphaserpentis.web3.aevo4j.api.endpoints.websocket.ChannelsListener
 * @see <a href="https://docs.aevo.xyz/reference/publish-channel">Aevo - PUBLISH Channels</a>
 */
public class ChannelsData extends Response<String[]> {

    @Override
    public String toString() {
        return "ChannelsData{" +
                "data=" + Arrays.toString(getData()) +
                '}';
    }
}
