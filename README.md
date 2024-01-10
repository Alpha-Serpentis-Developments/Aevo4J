[maven-central]: https://img.shields.io/maven-central/v/dev.alphaserpentis.web3/aevo4j?style=flat-square

[![Maven Central][maven-central]](https://search.maven.org/artifact/dev.alphaserpentis.web3/aevo4j)
# Aevo4J

## What is Aevo4J?
Aevo4J is an unofficial implementation of [Aevo's](https://aevo.xyz) REST APIs and WebSockets in Java.

## What is Aevo?
Aevo is a decentralized derivatives exchange built on Ethereum.

[**Receive a 10% discount on trading fees for 6 months + $25 credit after depositing $100+ by using our referral!**](https://app.aevo.xyz/r/Plum-Gossamer-Tepper)

## Features
- Full coverage of the REST APIs and WebSockets
- Automatic deserialization of responses into Java objects
- Automatic authentication for private endpoints (REST APIs and WebSockets)
- Orderbook checksum validator
- Built-in order-signing for placing/editing orders

## How Do I Use Aevo4J In My Project?
**Note**: Aevo4J requires Java 17 or higher!

### Importing from Maven or Gradle
#### Maven
```xml
<dependency>
    <groupId>dev.alphaserpentis.web3</groupId>
    <artifactId>aevo4j</artifactId>
    <version>1.2.0</version>
</dependency>
```

#### Gradle
```groovy
implementation 'dev.alphaserpentis.web3:aevo4j:1.2.0'
```

- - -

## REST APIs
The `PublicService` and `PrivateService` class contains the REST APIs for the public and private endpoints respectively.
These can be obtained via `AevoHandler.getPublicService(Retrofit)` or `AevoHandler.getPrivateService(Retrofit, String, String, Boolean)`.

For Retrofit, you can either obtain a default `Retrofit` instance via `AevoHandler.defaultRetrofit()` and pass it inside the service.
Alternatively, if you need to customize Retrofit for your needs, you can call the `AevoHandler.getCustomRetrofit` method and pass in your needed arguments.

### Private Operations
#### Authentication
To authenticate a request, you have two methods:

1. Use API Key + API Secret
2. Use API Key + Signature + Timestamp (recommended)

Both methods are automatically handled by the library.

See the [**REST Authentication**](https://api-docs.aevo.xyz/reference/rest-authentication) for more information.

### Customizing Retrofit
The `AevoHandler` class has a method `getCustomRetrofit` available to pass in a custom call adapter factory and converter factory.
However, you're not required to call this method if you need more customization.

- - -

## WebSockets
You can get the websockets from the methods found in `PublicWebSockets` and `PrivateWebSockets`.

Alternatively, you can obtain the needed websockets from this table below:

| Channel                   | WebSocket Listener Class                                                                                                            | API Type |
|---------------------------|-------------------------------------------------------------------------------------------------------------------------------------|----------|
| PUBLISH Channels          | [`ChannelsListener`](src/main/java/dev/alphaserpentis/web3/aevo4j/api/endpoints/websocket/impl/ChannelsListener.java)               | Public   |
| PUBLISH Ping              | [`PingListener`](src/main/java/dev/alphaserpentis/web3/aevo4j/api/endpoints/websocket/impl/PingListener.java)                       | Public   |
| SUBSCRIBE Orderbook       | [`OrderbookListener`](src/main/java/dev/alphaserpentis/web3/aevo4j/api/endpoints/websocket/impl/OrderbookListener.java)             | Public   |
| SUBSCRIBE Ticker          | [`TickerListener`](src/main/java/dev/alphaserpentis/web3/aevo4j/api/endpoints/websocket/impl/TickerListener.java)                   | Public   |
| SUBSCRIBE Index           | [`IndexListener`](src/main/java/dev/alphaserpentis/web3/aevo4j/api/endpoints/websocket/impl/IndexListener.java)                     | Public   |
| SUBSCRIBE Trades          | [`TradesListener`](src/main/java/dev/alphaserpentis/web3/aevo4j/api/endpoints/websocket/impl/TradesListener.java)                   | Public   |
| SUBSCRIBE RFQs            | [`RFQsListener`](src/main/java/dev/alphaserpentis/web3/aevo4j/api/endpoints/websocket/impl/RFQsListener.java)                       | Public   |
| PUBLISH Status            | [`StatusListener`](src/main/java/dev/alphaserpentis/web3/aevo4j/api/endpoints/websocket/impl/StatusListener.java)                   | Private  |
| PUBLISH Create Order      | [`CreateOrderListener`](src/main/java/dev/alphaserpentis/web3/aevo4j/api/endpoints/websocket/impl/CreateOrderListener.java)         | Private  |
| PUBLISH Edit Order        | [`EditOrderListener`](src/main/java/dev/alphaserpentis/web3/aevo4j/api/endpoints/websocket/impl/EditOrderListener.java)             | Private  |
| PUBLISH Cancel Order      | [`CancelOrderListener`](src/main/java/dev/alphaserpentis/web3/aevo4j/api/endpoints/websocket/impl/CancelOrderListener.java)         | Private  |
| PUBLISH Cancel All Orders | [`CancelAllOrdersListener`](src/main/java/dev/alphaserpentis/web3/aevo4j/api/endpoints/websocket/impl/CancelAllOrdersListener.java) | Private  |
| PUBLISH Create RFQ        | [`CreateRFQListener`](src/main/java/dev/alphaserpentis/web3/aevo4j/api/endpoints/websocket/impl/CreateRFQListener.java)             | Private  |
| PUBLISH Cancel RFQ        | [`CancelRFQListener`](src/main/java/dev/alphaserpentis/web3/aevo4j/api/endpoints/websocket/impl/CancelRFQListener.java)             | Private  |
| PUBLISH Create Quote RFQ  | [`CreateQuoteRFQListener`](src/main/java/dev/alphaserpentis/web3/aevo4j/api/endpoints/websocket/impl/CreateQuoteRFQListener.java)   | Private  |
| SUBSCRIBE Orders          | [`OrdersListener`](src/main/java/dev/alphaserpentis/web3/aevo4j/api/endpoints/websocket/impl/OrdersListener.java)                   | Private  |
| SUBSCRIBE Fills           | [`FillsListener`](src/main/java/dev/alphaserpentis/web3/aevo4j/api/endpoints/websocket/impl/FillsListener.java)                     | Private  |
| SUBSCRIBE Positions       | [`PositionsListener`](src/main/java/dev/alphaserpentis/web3/aevo4j/api/endpoints/websocket/impl/PositionsListener.java)             | Private  |

### Authentication
Requests using private websockets are automatically authenticated by the library.

- - -
## Order Signing
In order to place orders in either the REST APIs or WebSockets, you will need to be able to pass in a signature parameter.
This signature is generated by signing the order payload with the signing key that was generated from the Aevo website.

See the [**Signing Orders**](https://api-docs.aevo.xyz/reference/signing-orders) for more information.

### Example
- **Instrument ID**: `2054` (Testnet ETH-PERP)
- **Side**: `BUY`
- **Amount**: `1.0` (contracts)
- **Price**: `1000.0` (USD)

```java
// Create the order payload
UnsignedOrder order = new UnsignedOrder.Builder(
        2054, // Instrument ID
        "YOUR WALLET ADDRESS", // maker address
        true, // true = buy, false = sell
        1000000, // amount of contracts (1.0)
        1000000000 // price in USD (1000.0)
).build();

// Sign the unsigned order
SignedOrder signedOrder = UnsignedOrder.signOrder(
        order, // the unsigned order payload
        true, // true if testnet, false if mainnet
        "YOUR SIGNING KEY" // the signing key generated from the Aevo website
);
```

## Dependencies
- [Gson](https://github.com/google/gson)
- [RxJava3](https://github.com/ReactiveX/RxJava)
- [OkHttp3](https://github.com/square/okhttp)
- [Retrofit](https://github.com/square/retrofit)
  - Retrofit Adapter RxJava3
  - Retrofit Converter Gson
- [web3j](https://github.com/web3j/web3j)