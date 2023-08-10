package dev.alphaserpentis.web3.aevo4j.data.request;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;

import java.util.Arrays;

/**
 * Submit a request to the Aevo websocket.
 * @param operation The websocket operation to perform.
 * @param data The data to send.
 * @param id The id of the request.
 */
public record WebSocketRequest(
        @NonNull WebSocketOperations operation,
        @Nullable ChannelName[] data,
        @Nullable Integer id
) {
    public WebSocketRequest(@NonNull WebSocketOperations operation) {
        this(operation, null, null);
    }

    public WebSocketRequest(@NonNull WebSocketOperations operation, @Nullable ChannelName[] data) {
        this(operation, data, null);
    }

    @Override
    public String toString() {
        return "{" +
                "\"op\":\"" + operation + "\"" +
                (data != null ? ",\"data\":" + Arrays.toString(data) : "") +
                (id != null ? ",\"id\":" + id : "") +
                '}';
    }
}
