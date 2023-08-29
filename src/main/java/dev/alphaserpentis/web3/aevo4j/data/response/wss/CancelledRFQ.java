package dev.alphaserpentis.web3.aevo4j.data.response.wss;

import dev.alphaserpentis.web3.aevo4j.data.misc.RfqBlockId;

@SuppressWarnings("unused")
public class CancelledRFQ extends Response<RfqBlockId> {

    @Override
    public String toString() {
        return "CancelledRFQ{" +
                "data=" + getData() +
                "id=" + getId() +
                '}';
    }
}
