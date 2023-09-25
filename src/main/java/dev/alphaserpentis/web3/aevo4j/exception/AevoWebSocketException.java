package dev.alphaserpentis.web3.aevo4j.exception;

import dev.alphaserpentis.web3.aevo4j.data.response.wss.AevoWebSocketError;
import io.reactivex.rxjava3.annotations.NonNull;

public class AevoWebSocketException extends RuntimeException {
    private final AevoWebSocketError error;

    public AevoWebSocketException(@NonNull AevoWebSocketError error) {
        this.error = error;
    }

    public AevoWebSocketError getError() {
        return error;
    }

    @Override
    public String toString() {
        return "AevoWebSocketException: " + error;
    }
}
