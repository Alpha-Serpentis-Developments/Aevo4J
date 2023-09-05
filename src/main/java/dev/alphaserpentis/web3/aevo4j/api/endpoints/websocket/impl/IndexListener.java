package dev.alphaserpentis.web3.aevo4j.api.endpoints.websocket.impl;

import dev.alphaserpentis.web3.aevo4j.data.request.wss.ChannelName;
import dev.alphaserpentis.web3.aevo4j.data.request.wss.WebSocketOperations;
import dev.alphaserpentis.web3.aevo4j.data.response.wss.IndexData;
import io.reactivex.rxjava3.annotations.NonNull;

/**
 * Get the index price of an asset(s)
 *
 * @see <a href="https://docs.aevo.xyz/reference/subcribe-index">Aevo - SUBSCRIBE Index</a>
 */
public class IndexListener extends AevoListener<IndexData> {
    public IndexListener() {
        super(IndexData.class, ChannelName.Channels.INDEX);
    }

    public IndexListener(
            boolean isTestnet,
            @NonNull String... symbols
    ) {
        super(IndexData.class, ChannelName.Channels.INDEX, WebSocketOperations.SUBSCRIBE, isTestnet, symbols);
    }

    public IndexListener(
            boolean isTestnet,
            @NonNull ChannelName... channels
    ) {
        super(IndexData.class, ChannelName.Channels.INDEX, WebSocketOperations.SUBSCRIBE, isTestnet, channels);
    }
}
