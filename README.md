# Aevo4J

## What is Aevo4J?
Aevo4J is an unofficial implementation of [Aevo's](https://aevo.xyz) REST APIs and WebSockets in Java.

## What is Supported?
REST APIs and WebSockets are currently supported.

## How Do I Use Aevo4J?
**Note**: Aevo4J requires Java 17 or higher!

### Importing from Maven or Gradle (not actually available yet)
#### Maven
```xml
<dependency>
    <groupId>dev.alphaserpentis.web3</groupId>
    <artifactId>aevo4j</artifactId>
    <version>1.0.0</version>
</dependency>
```

#### Gradle
```groovy
implementation 'dev.alphaserpentis.web3:aevo4j:1.0.0'
```

- - -

### REST APIs
You can get the `PublicService` class via `AevoHandler.getPublicService(Retrofit)` and access the API methods from there.
For Retrofit, you can either obtain a default `Retrofit` instance via `AevoHandler.defaultRetrofit()` and pass it inside the service.
Alternatively, if you need to customize Retrofit for your needs, you can call the `AevoHandler.getCustomRetrofit` method and pass in your needed arguments.

#### Private Operations
##### REST APIs
To authenticate a request, you have two methods:

1. Use API Key + API Secret
2. Use API Key + Signature + Timestamp (recommended)

If you are using the second method, you can use `PrivateService.generateSignature(...)` to generate the signature for you,
as well as `PrivateService.getTimestamp()` to get the String representation of the current timestamp needed to generate the signature.

#### Customizing Retrofit
The `AevoHandler` class has a method `getCustomRetrofit` available to pass in a custom call adapter factory and converter factory. However, you're not required to call this method if you need more customization.

- - -

### WebSockets

To obtain the needed websockets, refer to this table below:

| Channel                   | WebSocket Listener Class | API Type |
|---------------------------|--------------------------|----------|
| PUBLISH Channels          | `ChannelsListener`       | Public   |
| PUBLISH Ping              | `PingListener`           | Public   |
| SUBSCRIBE Orderbook       | `OrderBookListener`      | Public   |
| SUBSCRIBE Ticker          | `TickerListener`         | Public   |
| SUBSCRIBE Index           | `IndexListener`          | Public   |
| SUBSCRIBE Trades          | `TradesListener`         | Public   |
| SUBSCRIBE RFQs            | `RFQsListener`           | Public   |
| PUBLISH Status            | *Not Implemented Yet*    | Private  |
| PUBLISH Create Order      | *Not Implemented Yet*    | Private  |
| PUBLISH Edit Order        | *Not Implemented Yet*    | Private  |
| PUBLISH Cancel Order      | *Not Implemented Yet*    | Private  |
| PUBLISH Cancel All Orders | *Not Implemented Yet*    | Private  |
| PUBLISH Create RFQ        | *Not Implemented Yet*    | Private  |
| PUBLISH Cancel RFQ        | *Not Implemented Yet*    | Private  |
| PUBLISH Create Quote RFQ  | *Not Implemented Yet*    | Private  |
| SUBSCRIBE Orders          | *Not Implemented Yet*    | Private  |
| SUBSCRIBE Fills           | *Not Implemented Yet*    | Private  |
| SUBSCRIBE Positions       | *Not Implemented Yet*    | Private  |

#### Subscribing to a Websocket

## Dependencies
- [Gson](https://github.com/google/gson)
- [RxJava3](https://github.com/ReactiveX/RxJava)
- [OkHttp3](https://github.com/square/okhttp)
- [Retrofit](https://github.com/square/retrofit)
  - Retrofit Adapter RxJava3
  - Retrofit Converter Gson
- [web3j](https://github.com/web3j/web3j)