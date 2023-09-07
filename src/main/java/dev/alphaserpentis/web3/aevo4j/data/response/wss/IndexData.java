package dev.alphaserpentis.web3.aevo4j.data.response.wss;

import dev.alphaserpentis.web3.aevo4j.api.endpoints.websocket.impl.IndexListener;
import dev.alphaserpentis.web3.aevo4j.data.response.common.Index;

/**
 * Data returned from the index channel
 *
 * @see IndexListener
 * @see <a href="https://docs.aevo.xyz/reference/subcribe-index">Aevo - SUBSCRIBE Index</a>
 */
@SuppressWarnings("unused")
public class IndexData extends Response<Index> {

    @Override
    public String toString() {
        return "IndexData{" +
                "channel='" + getChannel() + '\'' +
                "data=" + getData() +
                '}';
    }
}
