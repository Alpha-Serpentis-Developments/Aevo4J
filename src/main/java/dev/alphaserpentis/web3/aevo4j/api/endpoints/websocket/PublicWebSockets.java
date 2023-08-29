package dev.alphaserpentis.web3.aevo4j.api.endpoints.websocket;

import dev.alphaserpentis.web3.aevo4j.api.endpoints.websocket.impl.ChannelsListener;
import dev.alphaserpentis.web3.aevo4j.api.endpoints.websocket.impl.IndexListener;
import dev.alphaserpentis.web3.aevo4j.api.endpoints.websocket.impl.OrderbookListener;
import dev.alphaserpentis.web3.aevo4j.api.endpoints.websocket.impl.PingListener;
import dev.alphaserpentis.web3.aevo4j.api.endpoints.websocket.impl.RFQsListener;
import dev.alphaserpentis.web3.aevo4j.api.endpoints.websocket.impl.TickerListener;
import dev.alphaserpentis.web3.aevo4j.api.endpoints.websocket.impl.TradesListener;
import dev.alphaserpentis.web3.aevo4j.data.request.wss.ChannelName;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;

/**
 * Class to easily get the public websockets.
 */
public class PublicWebSockets {

    @NonNull
    public ChannelsListener channels() {
        return new ChannelsListener();
    }

    @NonNull
    public PingListener ping() {
        return new PingListener();
    }

    @NonNull
    public OrderbookListener orderbook() {
        return new OrderbookListener();
    }

    @NonNull
    public OrderbookListener orderbook(@NonNull OrderbookListener.Filter filter) {
        return new OrderbookListener(filter);
    }

    @NonNull
    public OrderbookListener orderbook(
            @Nullable OrderbookListener.Filter filter,
            boolean isTestnet,
            @NonNull String... channels
    ) {
        return new OrderbookListener(filter, isTestnet, channels);
    }

    @NonNull
    public OrderbookListener orderbook(
            @Nullable OrderbookListener.Filter filter,
            boolean isTestnet,
            @NonNull ChannelName... channels
    ) {
        return new OrderbookListener(filter, isTestnet, channels);
    }

    @NonNull
    public TickerListener ticker() {
        return new TickerListener();
    }

    @NonNull
    public TickerListener ticker(
            boolean isTestnet,
            @NonNull String... channels
    ) {
        return new TickerListener(isTestnet, channels);
    }

    @NonNull
    public TickerListener ticker(
            boolean isTestnet,
            @NonNull ChannelName... channels
    ) {
        return new TickerListener(isTestnet, channels);
    }

    @NonNull
    public IndexListener index() {
        return new IndexListener();
    }

    @NonNull
    public IndexListener index(
            boolean isTestnet,
            @NonNull String... channels
    ) {
        return new IndexListener(isTestnet, channels);
    }

    @NonNull
    public IndexListener index(
            boolean isTestnet,
            @NonNull ChannelName... channels
    ) {
        return new IndexListener(isTestnet, channels);
    }

    @NonNull
    public TradesListener trades() {
        return new TradesListener();
    }

    @NonNull
    public TradesListener trades(
            boolean isTestnet,
            @NonNull String... channels
    ) {
        return new TradesListener(isTestnet, channels);
    }

    @NonNull
    public TradesListener trades(
            boolean isTestnet,
            @NonNull ChannelName... channels
    ) {
        return new TradesListener(isTestnet, channels);
    }

    @NonNull
    public RFQsListener rfqs() {
        return new RFQsListener();
    }

    @NonNull
    public RFQsListener rfqs(boolean isTestnet) {
        return new RFQsListener(isTestnet);
    }
}
