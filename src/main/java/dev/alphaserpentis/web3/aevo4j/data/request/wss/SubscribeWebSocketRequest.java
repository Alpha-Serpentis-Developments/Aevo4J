package dev.alphaserpentis.web3.aevo4j.data.request.wss;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;

import java.util.Arrays;

/**
 * Submit a request to the Aevo websocket.
 * @param op The websocket operation to perform.
 * @param data The data to send.
 * @param id The id of the request.
 * @param auth The authentication data.
 */
public record SubscribeWebSocketRequest(
        @NonNull WebSocketOperations op,
        @Nullable ChannelName[] data,
        @Nullable Integer id,
        @Nullable WebsocketAuthData auth
) {
    public SubscribeWebSocketRequest(@NonNull WebSocketOperations operation) {
        this(operation, null, null, null);
    }

    public SubscribeWebSocketRequest(@NonNull WebSocketOperations operation, @Nullable WebsocketAuthData auth) {
        this(operation, null, null, auth);
    }

    public SubscribeWebSocketRequest(@NonNull WebSocketOperations operation, @Nullable ChannelName[] data) {
        this(operation, data, null, null);
    }

    public SubscribeWebSocketRequest(@NonNull WebSocketOperations operation, @Nullable ChannelName[] data, @Nullable WebsocketAuthData auth) {
        this(operation, data, null, auth);
    }

    @Override
    public String toString() {
        return "{" +
                "\"op\":\"" + op + "\"" +
                (data != null ? ",\"data\":" + Arrays.toString(data) : "") +
                (id != null ? ",\"id\":" + id : "") +
                '}';
    }
}
