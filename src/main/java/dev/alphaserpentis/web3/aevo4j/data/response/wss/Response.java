package dev.alphaserpentis.web3.aevo4j.data.response.wss;

import com.google.gson.annotations.SerializedName;

/**
 * Base class for all responses from the websocket
 * @param <T> The type of data returned by the response
 */
@SuppressWarnings("unused")
public abstract class Response<T> {
    @SerializedName("id")
    private long id;
    @SerializedName("channel")
    private String channel;
    @SerializedName("data")
    private T data;

    public long getId() {
        return id;
    }

    public String getChannel() {
        return channel;
    }

    public T getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Response{" +
                "id='" + id + '\'' +
                "channel='" + channel + '\'' +
                ", data=" + data +
                '}';
    }
}
