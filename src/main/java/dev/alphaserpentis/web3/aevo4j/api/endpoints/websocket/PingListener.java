package dev.alphaserpentis.web3.aevo4j.api.endpoints.websocket;

import dev.alphaserpentis.web3.aevo4j.data.response.wss.Ping;

public class PingListener extends AevoListener<Ping> {
    public PingListener() {
        super(Ping.class);
    }
}
