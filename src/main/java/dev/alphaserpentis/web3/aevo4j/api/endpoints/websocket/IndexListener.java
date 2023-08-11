package dev.alphaserpentis.web3.aevo4j.api.endpoints.websocket;

import dev.alphaserpentis.web3.aevo4j.data.response.wss.IndexData;

/**
 * Get the index price of an asset(s)
 *
 * @see <a href="https://docs.aevo.xyz/reference/subcribe-index">Aevo - SUBSCRIBE Index</a>
 */
public class IndexListener extends AevoListener<IndexData> {
    public IndexListener() {
        super(IndexData.class);
    }
}
