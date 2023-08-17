package dev.alphaserpentis.web3.aevo4j.data.request.wss;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;

public record ChannelName(
        @NonNull Channels channel,
        @Nullable String symbol,
        @Nullable String type
) {
    public ChannelName(@NonNull Channels channel) {
        this(channel, null, null);
    }

    public ChannelName(@NonNull Channels channel, @NonNull String symbol) {
        this(channel, symbol, null);
    }

    public enum Channels {
        ORDERBOOK("orderbook"),
        TICKER("ticker"),
        INDEX("index"),
        TRADES("trades"),
        RFQS("rfqs"),
        ORDERS("orders"),
        FILLS("fills"),
        POSITIONS("positions");

        private final String channel;

        Channels(String channel) {
            this.channel = channel;
        }

        public String getChannel() {
            return channel;
        }

        @Override
        public String toString() {
            return getChannel();
        }
    }

    public static ChannelName parseStringIntoChannelName(@NonNull String channelName) {
        String[] split = channelName.split(":");

        if(split[0].equals("rfqs")) {
            return new ChannelName(Channels.RFQS);
        }

        if (split.length > 3 || split.length < 2) {
            throw new IllegalArgumentException("Channel name must be in the format \"channel:symbol\" or \"channel:symbol:type\"");
        }

        if (split.length == 3) {
            return new ChannelName(Channels.valueOf(split[0].toUpperCase()), split[1], split[2]);
        } else {
            return new ChannelName(Channels.valueOf(split[0].toUpperCase()), split[1]);
        }
    }

    public static String generateChannelName(@NonNull Channels channel, @Nullable String symbol, @Nullable String type) {
        if(symbol == null) {
            return "\"%s\"".formatted(channel.getChannel());
        } else if(type != null) {
            return "\"%s:%s:%s\"".formatted(channel, symbol, type);
        } else {
            return "\"%s:%s\"".formatted(channel, symbol);
        }
    }

    @Override
    public String toString() {
        return generateChannelName(channel, symbol, type);
    }
}
