package dev.alphaserpentis.web3.aevo4j.api.endpoints.websocket;

import dev.alphaserpentis.web3.aevo4j.data.response.wss.TradesData;

public class TradesListener extends AevoListener<TradesData> {

    public TradesListener() {
        super(TradesData.class);
    }

//    @Override
//    public void onMessage(@NonNull WebSocket webSocket, @NonNull String text) {
//        try {
//            SubscribedTradesData data = parseString(text);
//            NumberFormat format = NumberFormat.getCurrencyInstance();
//
//            System.out.printf(
//                    """
//                    == Trade %s ==
//
//                    Price: $%s
//                    Amount: %s
//                    Volume: %s
//                    %n
//                    """,
//                    data.getData().getTradeId(),
//                    data.getData().getPrice(),
//                    data.getData().getAmount(),
//                    format.format(
//                            Double.parseDouble(data.getData().getPrice()) * Double.parseDouble(data.getData().getAmount())
//                    )
//            );
//        } catch(Exception e) {
//            e.printStackTrace();
//        }
//    }
}
