package dev.alphaserpentis.web3.aevo4j.data.response.wss;

import java.util.Arrays;

public class ChannelsData extends Response<String[]> {

    @Override
    public String toString() {
        return "ChannelsData{" +
                "data=" + Arrays.toString(getData()) +
                '}';
    }
}
