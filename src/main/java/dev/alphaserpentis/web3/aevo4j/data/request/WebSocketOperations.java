package dev.alphaserpentis.web3.aevo4j.data.request;

public enum WebSocketOperations {
    CHANNELS("channels"),
    SUBSCRIBE("subscribe"),
    UNSUBSCRIBE("unsubscribe"),
    PING("ping");

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
