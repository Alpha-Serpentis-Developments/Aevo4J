package dev.alphaserpentis.web3.aevo4j.data.misc;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import io.reactivex.rxjava3.annotations.NonNull;
import org.web3j.crypto.StructuredData;

import java.util.HashMap;
import java.util.List;

/**
 * EIP-712 data type for an Order
 */
@SuppressWarnings("unused")
public class OrderEIP712 {
    private static final Gson GSON = new Gson();
    public static final List<StructuredData.Entry> DOMAIN_ENTRY = List.of(
            new StructuredData.Entry("name", "string"),
            new StructuredData.Entry("version", "string"),
            new StructuredData.Entry("chainId", "uint256")
    );

    public static final List<StructuredData.Entry> ORDER_ENTRY = List.of(
            new StructuredData.Entry("maker", "address"),
            new StructuredData.Entry("isBuy", "bool"),
            new StructuredData.Entry("limitPrice", "uint256"),
            new StructuredData.Entry("amount", "uint256"),
            new StructuredData.Entry("salt", "uint256"),
            new StructuredData.Entry("instrument", "uint256"),
            new StructuredData.Entry("timestamp", "uint256")
    );

    public static final Domain MAINNET_DOMAIN = new Domain("Aevo Mainnet", "1", 1);

    public static final Domain TESTNET_DOMAIN = new Domain("Aevo Testnet", "1", 11155111);

    @SerializedName("domain")
    private Domain domain;
    @SerializedName("types")
    private final HashMap<String, List<StructuredData.Entry>> types = new HashMap<>();
    {
        types.put("EIP712Domain", DOMAIN_ENTRY);
        types.put("Order", ORDER_ENTRY);
    }
    @SerializedName("primaryType")
    private final String primaryType = "Order";
    @SerializedName("message")
    private Order order;

    public static class Domain {
        @SerializedName("name")
        private String name;
        @SerializedName("version")
        private String version;
        @SerializedName("chainId")
        private long chainId;

        public Domain(@NonNull String name, @NonNull String version, long chainId) {
            this.name = name;
            this.version = version;
            this.chainId = chainId;
        }
    }

    public static class Order {
        @SerializedName("maker")
        private String maker;
        @SerializedName("isBuy")
        private boolean isBuy;
        @SerializedName("limitPrice")
        private long limitPrice;
        @SerializedName("amount")
        private long amount;
        @SerializedName("salt")
        private long salt;
        @SerializedName("instrument")
        private long instrument;
        @SerializedName("timestamp")
        private long timestamp;

        public Order(
                @NonNull String maker,
                boolean isBuy,
                long limitPrice,
                long amount,
                long salt,
                long instrument,
                long timestamp
        ) {
            this.maker = maker;
            this.isBuy = isBuy;
            this.limitPrice = limitPrice;
            this.amount = amount;
            this.salt = salt;
            this.instrument = instrument;
            this.timestamp = timestamp;
        }

        public static Order fromUnsignedOrder(@NonNull UnsignedOrder unsignedOrder) {
            return new Order(
                    unsignedOrder.maker,
                    unsignedOrder.isBuy,
                    unsignedOrder.limitPrice,
                    unsignedOrder.amount,
                    unsignedOrder.salt,
                    unsignedOrder.instrument,
                    unsignedOrder.timestamp
            );
        }
    }

    public OrderEIP712(@NonNull Domain domain, @NonNull Order order) {
        this.domain = domain;
        this.order = order;
    }

    public HashMap<String, List<StructuredData.Entry>> getTypes() {
        return types;
    }

    public String getPrimaryType() {
        return primaryType;
    }

    @Override
    public String toString() {
        return GSON.toJson(this);
    }
}
