package dev.alphaserpentis.web3.aevo4j.data.request.wss;

import com.google.gson.annotations.SerializedName;
import io.reactivex.rxjava3.annotations.NonNull;

/**
 * @see <a href="https://api-docs.aevo.xyz/reference/websocket-authentication">Aevo - Websocket Authentication</a>
 */
public class WebsocketAuthData {
    @SerializedName("key")
    private String key;
    @SerializedName("secret")
    private String secret;
    @SerializedName("signature")
    private String signature;
    @SerializedName("timestamp")
    private String timestamp;

    public WebsocketAuthData(
            @NonNull String key,
            @NonNull String secret
    ) {
        this.key = key;
        this.secret = secret;
    }

    public WebsocketAuthData(
            @NonNull String key,
            @NonNull String signature,
            @NonNull String timestamp
    ) {
        this.key = key;
        this.signature = signature;
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "{" +
                "\"key\":\"" + key + "\"" +
                (secret != null ? ",\"secret\":\"" + secret + "\"" : "") +
                (signature != null ? ",\"signature\":\"" + signature + "\"" : "") +
                (timestamp != null ? ",\"timestamp\":\"" + timestamp + "\"" : "") +
                '}';
    }
}
