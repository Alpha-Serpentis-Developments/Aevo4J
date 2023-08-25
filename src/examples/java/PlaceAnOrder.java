import dev.alphaserpentis.web3.aevo4j.data.misc.UnsignedOrder;
import dev.alphaserpentis.web3.aevo4j.data.response.rest.Order;
import dev.alphaserpentis.web3.aevo4j.handler.AevoHandler;
import dev.alphaserpentis.web3.aevo4j.services.PrivateService;
import dev.alphaserpentis.web3.aevo4j.services.PublicService;
import io.reactivex.rxjava3.annotations.NonNull;

import java.io.IOException;
import java.math.RoundingMode;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;

/**
 * Example of an order being placed on the ETH-PERP market (testnet) using the REST API.
 * <p>
 * The order being placed is for 1 contract @ the best bid on the orderbook
 */
public class PlaceAnOrder {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, InvalidKeyException {
        if(args.length != 5) {
            throw new IllegalArgumentException("Please provide the API Key, API Secret, Aevo signing key, maker address, and true/false to use signatures as arguments");
        }

        PublicService publicService = AevoHandler.getPublicService(
                AevoHandler.defaultRetrofit(true)
        );
        PrivateService privateService = AevoHandler.getPrivateService(
                AevoHandler.defaultRetrofit(true),
                args[0],
                args[1],
                Boolean.parseBoolean(args[4])
        );
        UnsignedOrder order = new UnsignedOrder.Builder(
                2054, // Testnet ETH-PERP
                args[3],
                true,
                "1000000", // 1 Contract (1.000000)
                bestBid(publicService) // Matches the best bid at the time of calling
        )
                .timeInForce("GTC")
                .build();
        Order orderResponse = privateService.postOrders(
                UnsignedOrder.signOrder(order, true, args[2])
        );

        System.out.println(orderResponse);
    }

    public static String bestBid(@NonNull PublicService service) {
        double bestBid = Double.parseDouble(service.getOrderbook("ETH-PERP").getBids()[0][0]);
        DecimalFormat df = new DecimalFormat("#");
        df.setRoundingMode(RoundingMode.FLOOR); // Cleans up any decimals + stops scientific notation

        return df.format(bestBid * Math.pow(10, 6));
    }
}
