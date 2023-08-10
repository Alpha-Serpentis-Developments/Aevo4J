package dev.alphaserpentis.web3.aevo4j.data.response.wss;

import java.util.Arrays;

/**
 * Acknowledgement response from the websocket (tends to be the second response after a subscribe request)
 */
public class Ack extends Response<String[]> {

    @Override
    public String toString() {
        return "Ack{" +
                "id='" + getId() + '\'' +
                ", data=" + Arrays.toString(getData()) +
                '}';
    }
}
