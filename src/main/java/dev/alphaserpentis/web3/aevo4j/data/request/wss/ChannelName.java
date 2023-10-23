package dev.alphaserpentis.web3.aevo4j.data.request.wss;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;

public record ChannelName(
        @NonNull ChannelName.ChannelType channel,
        @Nullable String symbol,
        @Nullable String instrumentType
) {
    public ChannelName(@NonNull ChannelName.ChannelType channel) {
        this(channel, null, null);
    }

    public ChannelName(@NonNull ChannelName.ChannelType channel, @NonNull String symbol) {
        this(channel, symbol, null);
    }

    public enum ChannelType {
        ORDERBOOK("orderbook"),
        TICKER("ticker"),
        INDEX("index"),
        TRADES("trades"),
        RFQS("rfqs"),
        ORDERS("orders"),
        FILLS("fills"),
        POSITIONS("positions");

        private final String type;

        ChannelType(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }

        @Override
        public String toString() {
            return getType();
        }
    }

    /**
     * Converts the given string into a {@link ChannelName}
     * @param channelName The string to convert
     * @return The {@link ChannelName} parsed from the string
     * @throws IllegalArgumentException If the string is not in the format "channel:symbol" or
     * "channel:symbol:instrument_type"
     */
    public static ChannelName parseStringIntoChannelName(@NonNull String channelName) {
        String[] split = channelName.split(":");

        if(split[0].equals("rfqs")) {
            return new ChannelName(ChannelType.RFQS);
        }

        if (split.length > 3 || split.length < 2) {
            throw new IllegalArgumentException(
                    "Channel name must be in the format \"channel:symbol\" or \"channel:symbol:instrument_type\""
            );
        }

        if (split.length == 3) {
            return new ChannelName(ChannelType.valueOf(split[0].toUpperCase()), split[1], split[2]);
        } else {
            return new ChannelName(ChannelType.valueOf(split[0].toUpperCase()), split[1]);
        }
    }

    /**
     * Generates a channel name from the given parameters
     * @param channel The {@link ChannelType} of the channel
     * @param symbol The symbol of the channel (if any)
     * @param instrumentType The instrument type of the channel (if any)
     * @return The generated channel name
     */
    public static String generateChannelName(
            @NonNull ChannelName.ChannelType channel,
            @Nullable String symbol,
            @Nullable String instrumentType
    ) {
        if(symbol == null || channel.equals(ChannelType.RFQS)) {
            return "\"%s\"".formatted(channel);
        } else if(instrumentType != null) {
            return "\"%s:%s:%s\"".formatted(channel, symbol, instrumentType);
        } else {
            return "\"%s:%s\"".formatted(channel, symbol);
        }
    }

    @Override
    public String toString() {
        return generateChannelName(channel, symbol, instrumentType);
    }
}
