package dev.alphaserpentis.web3.aevo4j.services;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import dev.alphaserpentis.web3.aevo4j.data.response.rest.AevoRestAPIError;
import dev.alphaserpentis.web3.aevo4j.exception.AevoRestException;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Single;
import retrofit2.HttpException;

import java.io.IOException;

public abstract class AbstractService<T> {
    private final T api;
    private final boolean autoRetryAfterRatelimit;

    public AbstractService(
            @NonNull T api
    ) {
        this.api = api;
        this.autoRetryAfterRatelimit = true;
    }

    public AbstractService(
            @NonNull T api,
            boolean autoRetryAfterRatelimit
    ) {
        this.api = api;
        this.autoRetryAfterRatelimit = autoRetryAfterRatelimit;
    }

    protected T getApi() {
        return api;
    }

    protected boolean isAutoRetryAfterRatelimit() {
        return autoRetryAfterRatelimit;
    }

    /**
     * Executes a call to the API and returns the corresponding result, if successful. Otherwise, throws an {@link AevoRestException}.
     * <p><b>This method might block the thread if it retries due to ratelimit!</b></p>
     * @param call The call to execute
     * @param retryAfterRatelimit Whether to retry the call after a ratelimit
     * @return The result of the call
     * @param <T> The type of the result
     */
    public static <T> T execute(@NonNull Single<T> call, boolean retryAfterRatelimit) throws AevoRestException {
        try {
            return call.blockingGet();
        } catch(HttpException e) {
            AevoRestAPIError error;

            try {
                error = new Gson().fromJson(e.response().errorBody().string(), AevoRestAPIError.class);

                if(retryAfterRatelimit && error.getRetryAfter() > 0) {
                    try {
                        Thread.sleep(error.getRetryAfter() / 1000000);
                    } catch (InterruptedException ignored) {}

                    return execute(call, false);
                }
            } catch (IOException | JsonSyntaxException ignored) {
                throw e;
            }

            throw new AevoRestException(error);
        }
    }
}
