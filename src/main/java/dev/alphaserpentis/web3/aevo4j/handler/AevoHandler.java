package dev.alphaserpentis.web3.aevo4j.handler;

import com.google.gson.GsonBuilder;
import dev.alphaserpentis.web3.aevo4j.api.endpoints.rest.PrivateEndpoints;
import dev.alphaserpentis.web3.aevo4j.api.endpoints.rest.PublicEndpoints;
import dev.alphaserpentis.web3.aevo4j.api.endpoints.websocket.impl.AevoListener;
import dev.alphaserpentis.web3.aevo4j.services.PrivateService;
import dev.alphaserpentis.web3.aevo4j.services.PublicService;
import io.reactivex.rxjava3.annotations.NonNull;
import okhttp3.OkHttpClient;
import okhttp3.WebSocket;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

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

    /**
     * Get a new {@link PublicService} instance using the given {@link Retrofit} instance.
     * @param retrofit {@link Retrofit}
     * @return {@link PublicService}
     */
    public static PublicService getPublicService(@NonNull Retrofit retrofit) {
        return new PublicService(
                retrofit.create(PublicEndpoints.class)
        );
    }

    /**
     * Get a new {@link PrivateService} instance using the given {@link Retrofit} instance. You will need to supply your
     * API Key, API Secret, and whether you want to use signatures later on.
     * @param retrofit {@link Retrofit}
     * @return {@link PrivateService}
     */
    public static PrivateService getPrivateService(@NonNull Retrofit retrofit) {
        return new PrivateService(
                retrofit.create(PrivateEndpoints.class)
        );
    }

    /**
     * Get a new {@link PrivateService} instance using the given {@link Retrofit} instance
     * @param retrofit {@link Retrofit}
     * @param apiKey Aevo API Key
     * @param apiSecret Aevo API Secret
     * @param useSignature Whether to use signatures
     * @return {@link PrivateService}
     */
    public static PrivateService getPrivateService(
            @NonNull Retrofit retrofit,
            @NonNull String apiKey,
            @NonNull String apiSecret,
            boolean useSignature
    ) {
        return new PrivateService(
                retrofit.create(PrivateEndpoints.class),
                apiKey,
                apiSecret,
                useSignature
        );
    }

    /**
     * Generates a signature for authentication
     * @param timestamp Timestamp in nanoseconds
     * @param apiKey Aevo API key
     * @param apiSecret Aevo API secret
     * @param method Method (GET, POST, etc.). If using websockets, use "ws" lowercase
     * @param path Path of the request
     * @param body Body of the request (if any). If using websockets, use the data you're sending
     * @return Hexadecimal signature
     * @throws NoSuchAlgorithmException Algorithm not available on the system
     * @throws InvalidKeyException Invalid key
     */
    public static String generateAuthSignature(
            long timestamp,
            @NonNull String apiKey,
            @NonNull String apiSecret,
            @NonNull String method,
            @NonNull String path,
            @NonNull String body
    ) throws NoSuchAlgorithmException, InvalidKeyException {
        Mac sha256HMAC = Mac.getInstance("HmacSHA256");
        SecretKeySpec secretKeySpec;
        StringBuilder sb = new StringBuilder();
        final String message = apiKey + "," + timestamp + "," + method + "," + path + "," + body;
        byte[] hashBytes;

        secretKeySpec = new SecretKeySpec(apiSecret.getBytes(), message);
        sha256HMAC.init(secretKeySpec);

        hashBytes = sha256HMAC.doFinal(message.getBytes(StandardCharsets.UTF_8));

        for(byte b: hashBytes) {
            sb.append(String.format("%02x", b));
        }

        return sb.toString();
    }

    /**
     * Gets the current system timestamp in nanoseconds
     * @return {@link String} timestamp
     */
    public static String getTimestamp() {
        return String.valueOf(System.currentTimeMillis() * 1000000);
    }
}
