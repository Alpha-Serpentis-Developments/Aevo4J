import dev.alphaserpentis.web3.aevo4j.api.endpoints.websocket.impl.ChannelsListener;
import dev.alphaserpentis.web3.aevo4j.api.endpoints.websocket.impl.IndexListener;
import dev.alphaserpentis.web3.aevo4j.api.endpoints.websocket.impl.OrderbookListener;
import dev.alphaserpentis.web3.aevo4j.api.endpoints.websocket.impl.PingListener;
import dev.alphaserpentis.web3.aevo4j.api.endpoints.websocket.impl.RFQsListener;
import dev.alphaserpentis.web3.aevo4j.api.endpoints.websocket.impl.TickerListener;
import dev.alphaserpentis.web3.aevo4j.api.endpoints.websocket.impl.TradesListener;
import dev.alphaserpentis.web3.aevo4j.data.response.common.Orderbook;
import okhttp3.WebSocket;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

/**
 * "Tests" for all the public websockets
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
        ChannelsListener listener = new ChannelsListener(
                false
        );

        listener.responseFlowable().subscribe(
                System.out::println,
                error -> System.err.println(error.getMessage()),
                () -> System.out.println("onComplete() called")
        );

        return listener.getWebSocket();
    }

    public static WebSocket test_PublishPing() {
        PingListener listener = new PingListener(
                false
        );

        listener.responseFlowable().subscribe(
                System.out::println,
                error -> System.err.println(error.getMessage()),
                () -> System.out.println("onComplete() called")
        );

        return listener.getWebSocket();
    }

    public static WebSocket test_SubscribedOrderbook() {
        OrderbookListener listener = new OrderbookListener(
                OrderbookListener.Filter.NONE,
                false,
                "ETH-PERP"
        );

        listener.responseFlowable().subscribe(
                System.out::println,
                error -> System.err.println(error.getMessage()),
                () -> System.out.println("onComplete() called")
        );

        return listener.getWebSocket();
    }

    public static WebSocket test_SubscribedOrderbookFiltered() {
        OrderbookListener listener = new OrderbookListener(
                OrderbookListener.Filter.UPDATE,
                false,
                "XRP-PERP", "OP-PERP", "ETH-PERP", "BTC-PERP", "BNB-PERP", "1000PEPE-PERP"
        );

        listener.responseFlowable().subscribe(
                System.out::println,
                error -> System.err.println(error.getMessage()),
                () -> System.out.println("onComplete() called")
        );

        return listener.getWebSocket();
    }

    public static WebSocket test_SubscribedOrderbookChecksum() {
        OrderbookListener listener = new OrderbookListener(
                OrderbookListener.Filter.NONE,
                false,
                "XRP-PERP", "OP-PERP", "ETH-PERP", "BTC-PERP", "BNB-PERP", "1000PEPE-PERP"
        );

        listener.responseFlowable().subscribe(
                orderbookData -> {
                    long genChecksum = Orderbook.generateChecksum(
                            orderbookData.getData().getBids(),
                            orderbookData.getData().getAsks()
                    );
                    long apiChecksum = orderbookData.getData().getChecksum();

                    System.out.printf(
                            "Generated checksum: %s\nAPI checksum: %s\nMatched: %s\n\n",
                            genChecksum, apiChecksum, genChecksum == apiChecksum
                    );
                },
                error -> System.err.println(error.getMessage()),
                () -> System.out.println("onComplete() called")
        );

        return listener.getWebSocket();
    }

    public static WebSocket test_SubscribedTicker() {
        final NumberFormat numberFormat = NumberFormat.getInstance();
        TickerListener listener = new TickerListener(
                false,
                "ETH:PERPETUAL"
        );

        listener.responseFlowable().subscribe(
                tickerData -> Arrays.stream(tickerData.getData().getTickers()).forEach(
                        ticker -> {
                            double ask = ticker.getAsk().getPrice();
                            double bid = ticker.getBid().getPrice();

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
                ),
                error -> System.err.println(error.getMessage()),
                () -> System.out.println("onComplete() called")
        );

        return listener.getWebSocket();
    }

    public static WebSocket test_SubscribedIndex() {
        IndexListener listener = new IndexListener(
                false,
                "ETH", "BTC", "OP", "ARB", "BNB"
        );

        listener.responseFlowable().subscribe(
                System.out::println,
                error -> System.out.println("Error: " + error.getMessage()),
                () -> System.out.println("onComplete() called")
        );

        return listener.getWebSocket();
    }

    public static WebSocket test_SubscribedTrades() {
        TradesListener listener = new TradesListener(
                false,
                "ETH", "BTC", "OP", "ARB", "BNB"
        );

        listener.responseFlowable().subscribe(
                System.out::println,
                error -> System.err.println(error.getMessage()),
                () -> System.out.println("onComplete() called")
        );

        return listener.getWebSocket();
    }

    public static WebSocket test_SubscribedRFQs() {
        RFQsListener listener = new RFQsListener(
                false
        );

        listener.responseFlowable().subscribe(
                System.out::println,
                error -> System.err.println(error.getMessage()),
                () -> System.out.println("onComplete() called")
        );

        return listener.getWebSocket();
    }
}

