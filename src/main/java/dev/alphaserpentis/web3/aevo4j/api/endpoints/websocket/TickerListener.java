package dev.alphaserpentis.web3.aevo4j.api.endpoints.websocket;

import dev.alphaserpentis.web3.aevo4j.data.request.wss.ChannelName;
import dev.alphaserpentis.web3.aevo4j.data.request.wss.WebSocketOperations;
import dev.alphaserpentis.web3.aevo4j.data.response.wss.TickerData;
import io.reactivex.rxjava3.annotations.NonNull;

/**
 * Get the ticker information when the top of the book changes
 *
 * @see <a href="https://docs.aevo.xyz/reference/sub-ticker">Aevo - SUBSCRIBE Ticker</a>
 */
public class TickerListener extends AevoListener<TickerData> {
    public TickerListener() {
        super(TickerData.class, ChannelName.Channels.TICKER);
    }

    public TickerListener(
            @NonNull WebSocketOperations operations,
            boolean isTestnet,
            @NonNull String... channels
    ) {
        super(TickerData.class, ChannelName.Channels.TICKER, operations, isTestnet, channels);
    }

    public TickerListener(
            @NonNull WebSocketOperations operations,
            boolean isTestnet,
            @NonNull ChannelName... channels
    ) {
        super(TickerData.class, ChannelName.Channels.TICKER, operations, isTestnet, channels);
    }
}
