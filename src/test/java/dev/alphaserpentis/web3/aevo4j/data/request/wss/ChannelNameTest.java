package dev.alphaserpentis.web3.aevo4j.data.request.wss;

import dev.alphaserpentis.web3.aevo4j.data.response.rest.Markets;
import dev.alphaserpentis.web3.aevo4j.handler.AevoHandler;
import dev.alphaserpentis.web3.aevo4j.services.PublicService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ChannelNameTest {
    private static String randomInstrumentName;

    @BeforeAll
    static void setUp() {
        PublicService publicService = AevoHandler.getPublicService(AevoHandler.defaultRetrofit(false));
        List<Markets> listOfMarkets = publicService.getMarkets("ETH", "OPTION");

        // Grab a random instrument name
        randomInstrumentName = listOfMarkets.get((int) (Math.random() * listOfMarkets.size())).getInstrumentName();

        System.out.println("Random instrument name: " + randomInstrumentName);
    }

    @Test
    void parseStringIntoChannelName() {
        assertAll(
                () -> assertEquals(
                        new ChannelName(ChannelName.ChannelType.ORDERBOOK, "ETH-PERP"),
                        ChannelName.parseStringIntoChannelName("orderbook:ETH-PERP")
                ),
                () -> assertEquals(
                        new ChannelName(ChannelName.ChannelType.ORDERBOOK, randomInstrumentName),
                        ChannelName.parseStringIntoChannelName("orderbook:" + randomInstrumentName)
                ),
                () -> assertEquals(
                        new ChannelName(ChannelName.ChannelType.TICKER, "ETH-PERP"),
                        ChannelName.parseStringIntoChannelName("ticker:ETH-PERP")
                ),
                () -> assertEquals(
                        new ChannelName(ChannelName.ChannelType.TICKER, randomInstrumentName),
                        ChannelName.parseStringIntoChannelName("ticker:" + randomInstrumentName)
                ),
                () -> assertEquals(
                        new ChannelName(ChannelName.ChannelType.TICKER, "ETH", "OPTION"),
                        ChannelName.parseStringIntoChannelName("ticker:ETH:OPTION")
                ),
                () -> assertEquals(
                        new ChannelName(ChannelName.ChannelType.TICKER, "ETH", "PERPETUAL"),
                        ChannelName.parseStringIntoChannelName("ticker:ETH:PERPETUAL")
                ),
                () -> assertEquals(
                        new ChannelName(ChannelName.ChannelType.INDEX, "ETH"),
                        ChannelName.parseStringIntoChannelName("index:ETH")
                ),
                () -> assertEquals(
                        new ChannelName(ChannelName.ChannelType.TRADES, "ETH"),
                        ChannelName.parseStringIntoChannelName("trades:ETH")
                ),
                () -> assertEquals(
                        new ChannelName(ChannelName.ChannelType.TRADES, "ETH-PERP"),
                        ChannelName.parseStringIntoChannelName("trades:ETH-PERP")
                ),
                () -> assertEquals(
                        new ChannelName(ChannelName.ChannelType.TRADES, randomInstrumentName),
                        ChannelName.parseStringIntoChannelName("trades:" + randomInstrumentName)
                ),
                () -> assertEquals(
                        new ChannelName(ChannelName.ChannelType.RFQS),
                        ChannelName.parseStringIntoChannelName("rfqs")
                ),
                () -> assertThrows(
                        IllegalArgumentException.class,
                        () -> ChannelName.parseStringIntoChannelName("orderbook:ETH:OPTION:PERPETUAL")
                ),
                () -> assertThrows(
                        IllegalArgumentException.class,
                        () -> ChannelName.parseStringIntoChannelName("orderbook")
                ),
                () -> assertDoesNotThrow(
                        () -> ChannelName.parseStringIntoChannelName("rfqs")
                )
        );
    }

    @Test
    void generateChannelName() {
        assertAll(
                () -> assertEquals(
                        new ChannelName(ChannelName.ChannelType.ORDERBOOK, "ETH-PERP").toString(),
                        ChannelName.generateChannelName(ChannelName.ChannelType.ORDERBOOK, "ETH-PERP", null)
                ),
                () -> assertEquals(
                        new ChannelName(ChannelName.ChannelType.RFQS).toString(),
                        ChannelName.generateChannelName(ChannelName.ChannelType.RFQS, null, null)
                ),
                () -> assertEquals(
                        new ChannelName(ChannelName.ChannelType.RFQS).toString(),
                        ChannelName.generateChannelName(ChannelName.ChannelType.RFQS, null, "OPTION")
                ),
                () -> assertEquals(
                        new ChannelName(ChannelName.ChannelType.RFQS).toString(),
                        ChannelName.generateChannelName(ChannelName.ChannelType.RFQS, "ETH", null)
                )
        );
    }
}