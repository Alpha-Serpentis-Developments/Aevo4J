import dev.alphaserpentis.web3.aevo4j.api.endpoints.websocket.ChannelsListener;
import dev.alphaserpentis.web3.aevo4j.api.endpoints.websocket.OrderbookListener;
import dev.alphaserpentis.web3.aevo4j.api.endpoints.websocket.PingListener;
import dev.alphaserpentis.web3.aevo4j.api.endpoints.websocket.TickerListener;
import dev.alphaserpentis.web3.aevo4j.data.request.WebSocketOperations;
import dev.alphaserpentis.web3.aevo4j.data.response.common.Orderbook;
import dev.alphaserpentis.web3.aevo4j.handler.AevoHandler;
import okhttp3.WebSocket;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

/**
 * "Tests" for all the websockets
 */
public class WebsocketTests {

    private static final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
    private static final List<Supplier<WebSocket>> tests = List.of(
            WebsocketTests::test_PublishChannels,
            WebsocketTests::test_PublishPing,
            WebsocketTests::test_SubscribedOrderbook,
            WebsocketTests::test_SubscribedOrderbookFiltered,
            WebsocketTests::test_SubscribedOrderbookChecksum,
            WebsocketTests::test_SubscribedTicker,
            WebsocketTests::test_SubscribedIndex,
            WebsocketTests::test_SubscribedTrades,
            WebsocketTests::test_SubscribedRFQs
    );
    private static final Iterator<Supplier<WebSocket>> testIterator = tests.iterator();

    public static void main(String[] args) {
        runTests();
    }

    public static void runTests() {
        if (!testIterator.hasNext()) {
            executor.shutdown();
            return;
        }

        Supplier<WebSocket> currentTest = testIterator.next();
        WebSocket ws = currentTest.get();

        executor.schedule(() -> {
            if (ws != null) {
                ws.close(1000, "Test duration ended");
            }
            runTests();
        }, 10, TimeUnit.SECONDS);
    }

    public static WebSocket test_PublishChannels() {
        ChannelsListener listener = new ChannelsListener();
        WebSocket ws = AevoHandler.getWebsocketWithRequests(
                WebSocketOperations.CHANNELS,
                new String[]{},
                listener
        );

        listener.responseFlowable().subscribe(
                System.out::println,
                error -> System.out.println("Error: " + error.getMessage()),
                () -> System.out.println("onComplete() called")
        );

        return ws;
    }

    public static WebSocket test_PublishPing() {
        PingListener listener = new PingListener();
        WebSocket ws = AevoHandler.getWebsocketWithRequests(
                WebSocketOperations.PING,
                new String[]{},
                listener
        );

        listener.responseFlowable().subscribe(
                System.out::println,
                error -> System.out.println("Error: " + error.getMessage()),
                () -> System.out.println("onComplete() called")
        );

        return ws;
    }

    public static WebSocket test_SubscribedOrderbook() {
        OrderbookListener listener = new OrderbookListener(OrderbookListener.Filter.NONE);
        WebSocket ws = AevoHandler.getWebsocketWithRequests(
                WebSocketOperations.SUBSCRIBE,
                new String[]{"orderbook:ETH-PERP"},
                listener
        );

        listener.responseFlowable().subscribe(
                System.out::println,
                error -> System.out.println("Error: " + error.getMessage()),
                () -> System.out.println("onComplete() called")
        );

        return ws;
    }

    public static WebSocket test_SubscribedOrderbookFiltered() {
        OrderbookListener listener = new OrderbookListener(OrderbookListener.Filter.UPDATE);
        WebSocket ws = AevoHandler.getWebsocketWithRequests(
                WebSocketOperations.SUBSCRIBE,
                new String[]{"orderbook:ETH-PERP"},
                listener
        );

        listener.responseFlowable().subscribe(
                System.out::println,
                error -> System.out.println("Error: " + error.getMessage()),
                () -> System.out.println("onComplete() called")
        );

        return ws;
    }

    public static WebSocket test_SubscribedOrderbookChecksum() {
        OrderbookListener listener = new OrderbookListener();
        WebSocket ws = AevoHandler.getWebsocketWithRequests(
                WebSocketOperations.SUBSCRIBE,
                new String[]{"orderbook:ETH-PERP", "orderbook:BTC-PERP", "orderbook:BNB-PERP"},
                listener
        );

        listener.responseFlowable().subscribe(
                orderbookData -> {
                    String genChecksum = Orderbook.generateChecksum(
                            orderbookData.getData().getBids(),
                            orderbookData.getData().getAsks()
                    );
                    String apiChecksum = orderbookData.getData().getChecksum();

                    System.out.printf(
                            "Generated checksum: %s\nAPI checksum: %s\nMatched: %s\n\n",
                            genChecksum, apiChecksum, genChecksum.equals(apiChecksum)
                    );
                },
                error -> System.out.println("Error: " + error.getMessage()),
                () -> System.out.println("onComplete() called")
        );

        return ws;
    }

    public static WebSocket test_SubscribedTicker() {
        TickerListener listener = new TickerListener();
        WebSocket ws = AevoHandler.getWebsocketWithRequests(
                WebSocketOperations.SUBSCRIBE,
                new String[]{"ticker:SEI:PERPETUAL"},
                listener
        );

        final NumberFormat numberFormat = NumberFormat.getInstance();

        listener.responseFlowable().subscribe(
                tickerData -> Arrays.stream(tickerData.getData().getTickers()).forEach(
                        ticker -> {
                            double ask = Double.parseDouble(
                                    Objects.requireNonNullElse(
                                            ticker.getAsk().getPrice(),
                                            "0"
                                    )
                            );
                            double bid = Double.parseDouble(
                                    Objects.requireNonNullElse(
                                            ticker.getBid().getPrice(),
                                            "0"
                                    )
                            );

                            System.out.printf(
                                    """
                                    Name: %s
                                    Mark: $%s
                                    Spread: $%s
                                    
                                    """,
                                    ticker.getInstrumentName(),
                                    ticker.getMark().getPrice(),
                                    numberFormat.format(ask - bid)
                            );
                        }
                )
        );

        return ws;
    }

    public static WebSocket test_SubscribedIndex() {
        // Your test code here
        return null; // return WebSocket
    }

    public static WebSocket test_SubscribedTrades() {
        // Your test code here
        return null; // return WebSocket
    }

    public static WebSocket test_SubscribedRFQs() {
        // Your test code here
        return null; // return WebSocket
    }
}

