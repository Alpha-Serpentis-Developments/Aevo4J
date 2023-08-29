package dev.alphaserpentis.web3.aevo4j.api.endpoints.websocket.impl;

import dev.alphaserpentis.web3.aevo4j.data.request.wss.WebSocketOperations;
import dev.alphaserpentis.web3.aevo4j.data.response.wss.Ping;

/**
 * Send a ping to the server through a websocket
 *
 * @see <a href="https://docs.aevo.xyz/reference/publish-ping">Aevo - PUBLISH Ping</a>
 */
public class PingListener extends AevoListener<Ping> {
    public PingListener() {
        super(Ping.class, null);
    }

    public PingListener(boolean isTestnet) {
        super(Ping.class, null, WebSocketOperations.PING, isTestnet, new String[0]);
    }
}
