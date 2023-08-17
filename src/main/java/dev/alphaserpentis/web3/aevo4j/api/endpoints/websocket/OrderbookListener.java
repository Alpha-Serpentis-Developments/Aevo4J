package dev.alphaserpentis.web3.aevo4j.api.endpoints.websocket;

import dev.alphaserpentis.web3.aevo4j.data.request.wss.ChannelName;
import dev.alphaserpentis.web3.aevo4j.data.request.wss.WebSocketOperations;
import dev.alphaserpentis.web3.aevo4j.data.response.wss.OrderbookData;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;
import okhttp3.WebSocket;

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
            @NonNull WebSocketOperations operations,
            boolean isTestnet,
            @NonNull String... channels
    ) {
        super(OrderbookData.class, ChannelName.Channels.ORDERBOOK, operations, isTestnet, channels);

        this.filter = filter;
    }

    public OrderbookListener(
            @Nullable Filter filter,
            @NonNull WebSocketOperations operations,
            boolean isTestnet,
            @NonNull ChannelName... channels
    ) {
        super(OrderbookData.class, ChannelName.Channels.ORDERBOOK, operations, isTestnet, channels);

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
    public void onMessage(@NonNull WebSocket webSocket, @NonNull String response) {
        try {
            OrderbookData data = (OrderbookData) parseString(response);

            if (filter == Filter.NONE || data.getData().getType().equals(filter.getValue())) {
                subject.onNext(data);
            }
        } catch(Exception e) {
            subject.doOnError(ignored -> {});
        }
    }
}
