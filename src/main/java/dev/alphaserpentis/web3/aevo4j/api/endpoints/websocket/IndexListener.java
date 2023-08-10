package dev.alphaserpentis.web3.aevo4j.api.endpoints.websocket;

import dev.alphaserpentis.web3.aevo4j.data.response.wss.IndexData;

public class IndexListener extends AevoListener<IndexData> {
    public IndexListener() {
        super(IndexData.class);
    }
}
