package dev.alphaserpentis.web3.aevo4j.handler;

import com.google.gson.GsonBuilder;
import dev.alphaserpentis.web3.aevo4j.api.endpoints.rest.PublicEndpoints;
import dev.alphaserpentis.web3.aevo4j.api.endpoints.websocket.AevoListener;
import dev.alphaserpentis.web3.aevo4j.data.request.ChannelName;
import dev.alphaserpentis.web3.aevo4j.data.request.WebSocketOperations;
import dev.alphaserpentis.web3.aevo4j.data.request.WebSocketRequest;
import dev.alphaserpentis.web3.aevo4j.services.PublicService;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;
import okhttp3.OkHttpClient;
import okhttp3.WebSocket;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.Arrays;
import java.util.Objects;

/**
 * Static class containing methods to utilize Aevo's REST API or Websockets.
 */
public class AevoHandler {
    public static final String REST_API_URL = "https://api.aevo.xyz/";
    public static final String WS_API_URL = "wss://ws.aevo.xyz/";

    /**
     * Get the default {@link Retrofit} instance using RxJava3 and Gson.
     * @return {@link Retrofit}
     */
    public static Retrofit defaultRetrofit() {
        return getCustomRetrofit(
                getDefaultRetrofitBuilder(),
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

    public static Retrofit.Builder getDefaultRetrofitBuilder() {
        return new Retrofit.Builder()
                .baseUrl(REST_API_URL);
    }

    /**
     * Get a new {@link WebSocket} instance using the given {@link AevoListener}.
     * @param listener {@link AevoListener}
     * @return {@link WebSocket}
     */
    public static WebSocket getWebsocket(@NonNull AevoListener<?> listener) {
        return new OkHttpClient().newWebSocket(
                new okhttp3.Request.Builder()
                        .url(WS_API_URL)
                        .build(),
                listener
        );
    }

    /**
     * Get a new {@link WebSocket} instance using the given {@link AevoListener} and channel names, and send a request to it.
     * @param channels An array of {@link String} to subscribe to
     * @param listener {@link AevoListener}
     * @return {@link WebSocket}
     */
    public static WebSocket getWebsocketWithRequests(
            @NonNull WebSocketOperations operation,
            @Nullable String[] channels,
            @NonNull AevoListener<?> listener
    ) {
        WebSocket ws = getWebsocket(listener);
        ChannelName[] channelNames = Arrays.stream(channels).filter(Objects::nonNull)
                .map(ChannelName::parseStringIntoChannelName)
                .toArray(ChannelName[]::new);
        WebSocketRequest request = new WebSocketRequest(
                operation,
                channelNames
        );

        ws.send(request.toString());

        return ws;
    }

    /**
     * Get a new {@link WebSocket} instance using the given {@link AevoListener} and channel names, and send a request to it.
     * @param channels An array of {@link ChannelName} to subscribe to
     * @param listener {@link AevoListener}
     * @return {@link WebSocket}
     */
    public static WebSocket getWebsocketWithRequests(
            @NonNull WebSocketOperations operation,
            @Nullable ChannelName[] channels,
            @NonNull AevoListener<?> listener
    ) {
        WebSocket ws = getWebsocket(listener);
        WebSocketRequest request = new WebSocketRequest(
                operation,
                channels
        );

        ws.send(request.toString());

        return ws;
    }

    public static PublicService getPublicService(@NonNull Retrofit retrofit) {
        return new PublicService(
                retrofit.create(PublicEndpoints.class)
        );
    }
}
