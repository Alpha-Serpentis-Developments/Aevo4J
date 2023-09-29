package dev.alphaserpentis.web3.aevo4j.api.endpoints.websocket.impl;

import dev.alphaserpentis.web3.aevo4j.data.request.wss.ChannelName;
import dev.alphaserpentis.web3.aevo4j.data.request.wss.WebSocketOperations;
import dev.alphaserpentis.web3.aevo4j.data.response.wss.Positions;
import io.reactivex.rxjava3.annotations.NonNull;

public class PositionsListener extends PrivateListener<Positions> {
    public PositionsListener(
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
                Positions.class,
                ChannelName.ChannelType.POSITIONS
        );
    }
}
