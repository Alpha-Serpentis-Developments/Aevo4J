package dev.alphaserpentis.web3.aevo4j.data.request.rest;

import com.google.gson.annotations.SerializedName;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;

@SuppressWarnings("unused")
public class PostApiKeyBody {
    @SerializedName("name")
    private final String name;
    @SerializedName("ip_addresses")
    private final String[] ipAddresses;
    @SerializedName("read_only")
    private final Boolean readOnly;

    public PostApiKeyBody(
            @NonNull String name,
            @Nullable String[] ipAddresses,
            @Nullable Boolean readOnly
    ) {
        this.name = name;
        this.ipAddresses = ipAddresses;
        this.readOnly = readOnly;
    }

    public PostApiKeyBody(
            @NonNull String name
    ) {
        this(name, null, null);
    }
}
