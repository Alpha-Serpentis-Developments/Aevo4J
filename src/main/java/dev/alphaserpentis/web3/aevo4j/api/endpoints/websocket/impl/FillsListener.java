package dev.alphaserpentis.web3.aevo4j.api.endpoints.websocket.impl;

import dev.alphaserpentis.web3.aevo4j.data.request.wss.ChannelName;
import dev.alphaserpentis.web3.aevo4j.data.request.wss.WebSocketOperations;
import dev.alphaserpentis.web3.aevo4j.data.response.wss.Fills;
import io.reactivex.rxjava3.annotations.NonNull;

public class FillsListener extends PrivateListener<Fills> {
    public FillsListener(
            @NonNull String apiKey,
            @NonNull String apiSecret,
            boolean authorizeOnConnect,
            boolean isTestnet
    ) {
        super(
                WebSocketOperations.SUBSCRIBE.getOperation(),
                apiKey,
                apiSecret,
                isTestnet,
                authorizeOnConnect,
                Fills.class,
                ChannelName.ChannelType.FILLS
        );
    }
}
