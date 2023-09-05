package dev.alphaserpentis.web3.aevo4j.api.endpoints.websocket.impl;

import dev.alphaserpentis.web3.aevo4j.data.request.wss.ChannelName;
import dev.alphaserpentis.web3.aevo4j.data.request.wss.WebSocketOperations;
import dev.alphaserpentis.web3.aevo4j.data.response.wss.Ack;
import dev.alphaserpentis.web3.aevo4j.data.response.wss.OrderbookData;
import dev.alphaserpentis.web3.aevo4j.data.response.wss.Response;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;

/**
 * Get the orderbook snapshots and updates
 * @see <a href="https://docs.aevo.xyz/reference/subscribe">Aevo - SUBSCRIBE Orderbook</a>
 */
public class OrderbookListener extends AevoListener<OrderbookData> {

    private Filter filter;

    /**
     * Filter the type of data received
     */
    public enum Filter {
        NONE("none"),
        SNAPSHOT("snapshot"),
        UPDATE("update");

        private final String value;

        Filter(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return getValue();
        }
    }

    public OrderbookListener() {
        this(Filter.NONE);
    }

    public OrderbookListener(@NonNull Filter filter) {
        super(OrderbookData.class, ChannelName.Channels.ORDERBOOK);

        this.filter = filter;
    }

    public OrderbookListener(
            @Nullable Filter filter,
            boolean isTestnet,
            @NonNull String... symbols
    ) {
        super(OrderbookData.class, ChannelName.Channels.ORDERBOOK, WebSocketOperations.SUBSCRIBE, isTestnet, symbols);

        this.filter = filter;
    }

    public OrderbookListener(
            @Nullable Filter filter,
            boolean isTestnet,
            @NonNull ChannelName... channels
    ) {
        super(OrderbookData.class, ChannelName.Channels.ORDERBOOK, WebSocketOperations.SUBSCRIBE, isTestnet, channels);

        this.filter = filter;
    }

    @NonNull
    public Filter getFilter() {
        return filter;
    }

    public void setFilter(@NonNull Filter filter) {
        this.filter = filter;
    }

    @Override
    protected void handleResponse(@NonNull String response) {
        Response<?> parsed = parseString(response);

        if(!(parsed instanceof Ack)) {
            if(filter == Filter.NONE || ((OrderbookData) parsed).getData().getType().equals(filter.getValue())) {
                subject.onNext((OrderbookData) parsed);
            }
        }
    }
}
