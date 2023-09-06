import dev.alphaserpentis.web3.aevo4j.data.misc.SignedOrder;
import dev.alphaserpentis.web3.aevo4j.data.misc.UnsignedOrder;
import dev.alphaserpentis.web3.aevo4j.data.response.common.Order;
import dev.alphaserpentis.web3.aevo4j.handler.AevoHandler;
import dev.alphaserpentis.web3.aevo4j.services.PrivateService;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class EditAnOrder {

    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException, IOException {
        if(args.length != 4) {
            throw new IllegalArgumentException("Please provide the API Key, API Secret, Aevo signing key, and maker address");
        }

        Scanner scanner = new Scanner(System.in);
        String orderId;
        Order order;

        PrivateService privateService = AevoHandler.getPrivateService(
                AevoHandler.defaultRetrofit(true),
                args[0],
                args[1],
                true
        );

        System.out.println("Order ID to Edit: ");
        orderId = scanner.nextLine();

        // Pull the order details
        order = privateService
                .getOrders()
                .stream()
                .filter(
                        o -> o.getOrderId().equals(orderId)
                ).findFirst()
                .orElse(null);

        if(order == null) {
            System.err.println("Order not found");
        } else {
            DecimalFormat df = new DecimalFormat("#.##");
            double newPrice;
            double newSize;

            // New price
            System.out.println("New Price: ");
            newPrice = scanner.nextDouble();

            // New size
            System.out.println("New Size: ");
            newSize = scanner.nextDouble();

            // Generate new order
            SignedOrder newOrder = new UnsignedOrder.Builder(
                    order.getInstrumentId(),
                    args[3],
                    order.getSide().equals("buy"),
                    (long) (Double.parseDouble(df.format(newSize)) * Math.pow(10,6)),
                    (long) (Double.parseDouble(df.format(newPrice)) * Math.pow(10,6))
            ).buildAndSign(true, args[2]);

            // Send the order
            System.out.println(privateService.postEditOrder(orderId, newOrder));
        }
    }
}
