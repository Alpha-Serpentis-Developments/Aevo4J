package dev.alphaserpentis.web3.aevo4j.data.request.wss;

/**
 * Enums storing the websocket op codes
 */
public enum WebSocketOperations {
    CHANNELS("channels"),
    SUBSCRIBE("subscribe"),
    UNSUBSCRIBE("unsubscribe"),
    PING("ping"),
    STATUS("status"),
    CREATE_ORDER("create_order"),
    EDIT_ORDER("edit_order"),
    CANCEL_ORDER("cancel_order"),
    CANCEL_ALL_ORDERS("cancel_all_orders"),
    CREATE_RFQ("create_rfq"),
    CANCEL_RFQ("cancel_rfq"),
    CREATE_QUOTE_RFQ("quote_rfq"),
    AUTH("auth");

    private final String operation;

    WebSocketOperations(String operation) {
        this.operation = operation;
    }

    public String getOperation() {
        return operation;
    }

    @Override
    public String toString() {
        return getOperation();
    }
}
