package dev.alphaserpentis.web3.aevo4j.services;

import dev.alphaserpentis.web3.aevo4j.api.endpoints.rest.PublicEndpoints;
import dev.alphaserpentis.web3.aevo4j.data.response.common.Orderbook;
import dev.alphaserpentis.web3.aevo4j.data.response.common.Trade;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;

import java.util.List;

public class PublicService extends AbstractService<PublicEndpoints> {
    public PublicService(PublicEndpoints api) {
        super(api);
    }

    public Orderbook getOrderbook(
            @NonNull String instrumentName
    ) {
        return execute(
                getApi().getOrderbook(
                        instrumentName
                )
        );
    }

    public List<Trade> getInstrumentTradeHistory(
            @NonNull String instrumentName,
            @Nullable Integer startTime,
            @Nullable Integer endTime
    ) {
        return execute(
                getApi().getInstrumentTradeHistory(
                        instrumentName,
                        startTime,
                        endTime
                )
        );
    }
}
