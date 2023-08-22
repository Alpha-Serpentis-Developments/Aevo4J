package dev.alphaserpentis.web3.aevo4j.exception;

import dev.alphaserpentis.web3.aevo4j.data.response.rest.AevoRestAPIError;
import io.reactivex.rxjava3.annotations.NonNull;

/**
 * An {@link AevoRestException} will be thrown if the Aevo REST API returns an error
 */
public class AevoRestException extends RuntimeException {
    private final AevoRestAPIError error;

    public AevoRestException(@NonNull AevoRestAPIError error) {
        this.error = error;
    }

    public AevoRestAPIError getError() {
        return error;
    }

    @Override
    public String toString() {
        return "AevoRestException: " + error;
    }
}
