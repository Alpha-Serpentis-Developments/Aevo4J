package dev.alphaserpentis.web3.aevo4j.handler;

import com.google.gson.GsonBuilder;
import dev.alphaserpentis.web3.aevo4j.api.endpoints.rest.PublicEndpoints;
import dev.alphaserpentis.web3.aevo4j.api.endpoints.websocket.AevoListener;
import dev.alphaserpentis.web3.aevo4j.services.PublicService;
import io.reactivex.rxjava3.annotations.NonNull;
import okhttp3.OkHttpClient;
import okhttp3.WebSocket;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Static class containing methods to utilize Aevo's REST API or Websockets.
 */
public class AevoHandler {
    public static final String REST_API_URL = "https://api.aevo.xyz/";
    public static final String REST_API_URL_TESTNET = "https://api-testnet.aevo.xyz/";
    public static final String WS_API_URL = "wss://ws.aevo.xyz/";
    public static final String WS_API_URL_TESTNET = "wss://ws-testnet.aevo.xyz/";

    /**
     * Get the default {@link Retrofit} instance using RxJava3 and Gson.
     * @return {@link Retrofit}
     */
    public static Retrofit defaultRetrofit(boolean isTestnet) {
        return getCustomRetrofit(
                getDefaultRetrofitBuilder(isTestnet),
                RxJava3CallAdapterFactory.create(),
                GsonConverterFactory.create(
                        new GsonBuilder()
                                .setLenient()
                                .create()
                )
        );
    }

    /**
     * Get a custom Retrofit instance with the given CallAdapter and ConverterFactory.
     * @param callAdapter {@link CallAdapter.Factory}
     * @param converterFactory {@link Converter.Factory}
     * @return {@link Retrofit}
     */
    public static Retrofit getCustomRetrofit(
            @NonNull Retrofit.Builder retrofitBuilder,
            @NonNull CallAdapter.Factory callAdapter,
            @NonNull Converter.Factory converterFactory
    ) {
        return retrofitBuilder
                .addCallAdapterFactory(callAdapter)
                .addConverterFactory(converterFactory)
                .build();
    }

    public static Retrofit.Builder getDefaultRetrofitBuilder(boolean isTestnet) {
        return new Retrofit.Builder()
                .baseUrl(isTestnet ? REST_API_URL_TESTNET : REST_API_URL);
    }

    /**
     * Get a new {@link WebSocket} instance using the given {@link AevoListener}.
     * <p>
     * You might be looking for {@link AevoListener#openWebSocket(boolean)}
     * @param listener {@link AevoListener}
     * @return {@link WebSocket}
     */
    public static WebSocket createNewWebSocket(@NonNull AevoListener<?> listener, boolean isTestnet) {
        return new OkHttpClient().newWebSocket(
                new okhttp3.Request.Builder()
                        .url(isTestnet ? WS_API_URL_TESTNET : WS_API_URL)
                        .build(),
                listener
        );
    }

    public static PublicService getPublicService(@NonNull Retrofit retrofit) {
        return new PublicService(
                retrofit.create(PublicEndpoints.class)
        );
    }
}
