package dev.alphaserpentis.web3.aevo4j.api.endpoints.websocket;

import dev.alphaserpentis.web3.aevo4j.data.request.WebSocketOperations;
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
