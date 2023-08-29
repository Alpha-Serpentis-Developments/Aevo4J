package dev.alphaserpentis.web3.aevo4j.data.request.wss;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;

public record PublishWebSocketRequest<T> (
        @NonNull WebSocketOperations op,
        @Nullable T data,
        @Nullable Integer id,
        @Nullable WebsocketAuthData auth
) {
    public PublishWebSocketRequest(@NonNull WebSocketOperations operation, @NonNull T data) {
        this(operation, data, null, null);
    }

    public PublishWebSocketRequest(@NonNull WebSocketOperations operation, @NonNull T data, @Nullable WebsocketAuthData auth) {
        this(operation, data, null, auth);
    }

    public PublishWebSocketRequest(@NonNull WebSocketOperations operation) {
        this(operation, null, null, null);
    }

    public PublishWebSocketRequest(@NonNull WebSocketOperations operation, @Nullable WebsocketAuthData auth) {
        this(operation, null, null, auth);
    }

    @Override
    public String toString() {
        return "{" +
                "\"op\":\"" + op + "\"" +
                (data != null ? ",\"data\":" + data : "") +
                (id != null ? ",\"id\":" + id : "") +
                (auth != null ? ",\"auth\":" + auth : "") +
                '}';
    }
}
