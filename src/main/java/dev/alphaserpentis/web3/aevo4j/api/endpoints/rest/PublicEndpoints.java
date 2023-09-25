package dev.alphaserpentis.web3.aevo4j.api.endpoints.rest;

import dev.alphaserpentis.web3.aevo4j.data.request.rest.AccountBody;
import dev.alphaserpentis.web3.aevo4j.data.response.common.Option;
import dev.alphaserpentis.web3.aevo4j.data.response.common.Orderbook;
import dev.alphaserpentis.web3.aevo4j.data.response.common.Index;
import dev.alphaserpentis.web3.aevo4j.data.response.rest.*;
import dev.alphaserpentis.web3.aevo4j.data.response.common.Trade;
import io.reactivex.rxjava3.core.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

import java.util.List;

/**
 * @see dev.alphaserpentis.web3.aevo4j.services.PublicService
 */
public interface PublicEndpoints {

    @Headers("Content-Type: application/json")
    @GET("assets")
    Single<List<String>> getAssets();

    @Headers("Content-Type: application/json")
    @GET("expiries")
    Single<List<Long>> getExpiries(
            @Query("asset") String asset
    );

    @Headers("Content-Type: application/json")
    @GET("index")
    Single<Index> getIndex(
            @Query("asset") String asset
    );

    @Headers("Content-Type: application/json")
    @GET("index-history")
    Single<IndexHistory> getIndexHistory(
            @Query("asset") String asset,
            @Query("resolution") Integer resolution,
            @Query("start_time") Integer startTime,
            @Query("end_time") Integer endTime
    );

    @Headers("Content-Type: application/json")
    @GET("mark-history")
    Single<MarkHistory> getMarkHistory(
            @Query("instrument_name") String instrumentName,
            @Query("resolution") Integer resolution,
            @Query("limit") Integer limit,
            @Query("start_time") Integer startTime,
            @Query("end_time") Integer endTime
    );

    @Headers("Content-Type: application/json")
    @GET("settlement-history")
    Single<List<SettlementHistory>> getSettlementHistory(
            @Query("asset") String asset,
            @Query("start_time") Integer startTime,
            @Query("end_time") Integer endTime,
            @Query("limit") Integer limit
    );

    @Headers("Content-Type: application/json")
    @GET("markets")
    Single<List<Markets>> getMarkets(
            @Query("asset") String asset,
            @Query("instrument_type") String instrumentType
    );

    @Headers("Content-Type: application/json")
    @GET("statistics")
    Single<Statistics> getStatistics(
            @Query("asset") String asset,
            @Query("instrument_type") String instrumentType,
            @Query("end_time") Integer endTime
    );

    @Headers("Content-Type: application/json")
    @GET("coingecko-statistics")
    Single<List<CoinGeckoStats>> getCoinGeckoStatistics();

    @Headers("Content-Type: application/json")
    @GET("orderbook")
    Single<Orderbook> getOrderbook(
            @Query("instrument_name") String instrumentName
    );

    @Headers("Content-Type: application/json")
    @GET("funding")
    Single<Funding> getFunding(
            @Query("instrument_name") String instrumentName
    );

    @Headers("Content-Type: application/json")
    @GET("funding-history")
    Single<FundingHistory> getFundingHistory(
            @Query("instrument_name") String instrumentName,
            @Query("start_time") Integer startTime,
            @Query("end_time") Integer endTime
    );

    @Headers("Content-Type: application/json")
    @GET("instrument/{instrument_name}")
    Single<InstrumentInfo> getInstrumentInformation(
            @Path("instrument_name") String instrumentName
    );

    @Headers("Content-Type: application/json")
    @GET("instrument/{instrument_name}/trade-history")
    Single<List<Trade>> getInstrumentTradeHistory(
            @Path("instrument_name") String instrumentName,
            @Query("start_time") Integer startTime,
            @Query("end_time") Integer endTime
    );

    @Headers("Content-Type: application/json")
    @GET("check-referral")
    Single<CheckReferral> getCheckReferral(
            @Query("account") String account,
            @Query("referral_code") String referralCode
    );

    @Headers("Content-Type: application/json")
    @POST("account/unsubscribe")
    Single<Success> postAccountUnsubscribe(
            @Body AccountBody body
    );

    @Headers("Content-Type: application/json")
    @GET("time")
    Single<Time> getTime();

    @Headers("Content-Type: application/json")
    @GET("options-history")
    Single<List<Option>> getOptionsHistory(
            @Query("asset") String account,
            @Query("start_time") Integer startTime,
            @Query("end_time") Integer endTime,
            @Query("option_type") String optionType,
            @Query("offset") Integer offset,
            @Query("limit") Integer limit
    );

    @Headers("Content-Type: application/json")
    @POST("account/email-verified")
    Single<Success> postEmailVerified(
        @Body AccountBody body
    );
}
