package dev.alphaserpentis.web3.aevo4j.api.endpoints.websocket.impl;

import dev.alphaserpentis.web3.aevo4j.data.request.wss.ChannelName;
import dev.alphaserpentis.web3.aevo4j.data.request.wss.WebSocketOperations;
import dev.alphaserpentis.web3.aevo4j.data.response.wss.TradesData;
import io.reactivex.rxjava3.annotations.NonNull;

/**
 * Get trades of an asset(s)
 *
 * @see <a href="https://docs.aevo.xyz/reference/subcribe-trades">Aevo - SUBSCRIBE Trades</a>
 */
public class TradesListener extends AevoListener<TradesData> {

    public TradesListener() {
        super(TradesData.class, ChannelName.ChannelType.TRADES);
    }

    public TradesListener(
            boolean isTestnet,
            @NonNull String... symbols
    ) {
        super(TradesData.class, ChannelName.ChannelType.TRADES, WebSocketOperations.SUBSCRIBE, isTestnet, symbols);
    }

    public TradesListener(
            boolean isTestnet,
            @NonNull ChannelName... channels
    ) {
        super(TradesData.class, ChannelName.ChannelType.TRADES, WebSocketOperations.SUBSCRIBE, isTestnet, channels);
    }
}
