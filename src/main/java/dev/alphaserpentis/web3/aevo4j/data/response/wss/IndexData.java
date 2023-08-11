package dev.alphaserpentis.web3.aevo4j.data.response.wss;

import dev.alphaserpentis.web3.aevo4j.data.response.common.Index;

/**
 * Data returned from the index channel
 *
 * @see dev.alphaserpentis.web3.aevo4j.api.endpoints.websocket.IndexListener
 * @see <a href="https://docs.aevo.xyz/reference/subcribe-index">Aevo - SUBSCRIBE Index</a>
 */
public class IndexData extends Response<Index> {

    @Override
    public String toString() {
        return "IndexData{" +
                "data=" + getData() +
                '}';
    }
}
