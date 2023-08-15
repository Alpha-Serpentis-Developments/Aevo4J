package dev.alphaserpentis.web3.aevo4j.api.endpoints.websocket;

import dev.alphaserpentis.web3.aevo4j.data.request.ChannelName;
import dev.alphaserpentis.web3.aevo4j.data.request.WebSocketOperations;
import dev.alphaserpentis.web3.aevo4j.data.response.wss.TradesData;
import io.reactivex.rxjava3.annotations.NonNull;

/**
 * Get trades of an asset(s)
 *
 * @see <a href="https://docs.aevo.xyz/reference/subcribe-trades">Aevo - SUBSCRIBE Trades</a>
 */
public class TradesListener extends AevoListener<TradesData> {

    public TradesListener() {
        super(TradesData.class, ChannelName.Channels.TRADES);
    }

    public TradesListener(
            @NonNull WebSocketOperations operations,
            boolean isTestnet,
            @NonNull String... channels
    ) {
        super(TradesData.class, ChannelName.Channels.TRADES, operations, isTestnet, channels);
    }

    public TradesListener(
            @NonNull WebSocketOperations operations,
            boolean isTestnet,
            @NonNull ChannelName... channels
    ) {
        super(TradesData.class, ChannelName.Channels.TRADES, operations, isTestnet, channels);
    }
}
