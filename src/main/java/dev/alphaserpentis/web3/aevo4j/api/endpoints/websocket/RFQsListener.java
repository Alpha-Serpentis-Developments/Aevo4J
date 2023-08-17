package dev.alphaserpentis.web3.aevo4j.api.endpoints.websocket;

import dev.alphaserpentis.web3.aevo4j.data.request.wss.ChannelName;
import dev.alphaserpentis.web3.aevo4j.data.request.wss.WebSocketOperations;
import dev.alphaserpentis.web3.aevo4j.data.response.wss.RFQsData;
import io.reactivex.rxjava3.annotations.NonNull;

/**
 * @see <a href="https://docs.aevo.xyz/reference/subscribe-rfqs">Aevo - SUBSCRIBE RFQs</a>
 */
public class RFQsListener extends AevoListener<RFQsData> {
    public RFQsListener() {
        super(RFQsData.class, ChannelName.Channels.RFQS);
    }

    public RFQsListener(
            @NonNull WebSocketOperations operations,
            boolean isTestnet
    ) {
        super(RFQsData.class, ChannelName.Channels.RFQS, operations, isTestnet, "rfqs");
    }
}
