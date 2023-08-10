package dev.alphaserpentis.web3.aevo4j.services;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import dev.alphaserpentis.web3.aevo4j.data.response.rest.AevoRestAPIError;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Single;
import retrofit2.HttpException;

import java.io.IOException;

public abstract class AbstractService<T> {
    private final T api;

    public AbstractService(
            @NonNull T api
    ) {
        this.api = api;
    }

    protected T getApi() {
        return api;
    }

    public static <T> T execute(Single<T> call) {
        try {
            return call.blockingGet();
        } catch(HttpException e) {
            AevoRestAPIError error;
            try {
                error = new Gson().fromJson(e.response().errorBody().string(), AevoRestAPIError.class);
            } catch (IOException | JsonSyntaxException ignored) {
                throw e;
            }

            throw new RuntimeException(e);
        }
    }
}
