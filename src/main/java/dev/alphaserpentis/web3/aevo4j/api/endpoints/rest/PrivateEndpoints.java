package dev.alphaserpentis.web3.aevo4j.api.endpoints.rest;

import dev.alphaserpentis.web3.aevo4j.data.request.rest.DeleteApiKeyBody;
import dev.alphaserpentis.web3.aevo4j.data.request.rest.PostApiKeyBody;
import dev.alphaserpentis.web3.aevo4j.data.request.rest.RegisterBody;
import dev.alphaserpentis.web3.aevo4j.data.response.rest.ApiKeyData;
import dev.alphaserpentis.web3.aevo4j.data.response.rest.PostRegister;
import dev.alphaserpentis.web3.aevo4j.data.response.rest.Success;
import io.reactivex.rxjava3.core.Single;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * @see <a href="https://docs.aevo.xyz/reference/rest-authentication">Aevo - REST Authentication</a>
 */
public interface PrivateEndpoints {

    @Headers("Content-Type: application/json")
    @POST("register")
    Single<PostRegister> register(
            @Header("AEVO-TIMESTAMP") String aevoTimestamp,
            @Header("AEVO-SIGNATURE") String aevoSignature,
            @Header("AEVO-KEY") String aevoKey,
            @Header("AEVO-SECRET") String aevoSecret,
            @Body RegisterBody body
    );

    @Headers("Content-Type: application/json")
    @DELETE("api-key")
    Single<Success> deleteApiKey(
            @Header("AEVO-TIMESTAMP") String aevoTimestamp,
            @Header("AEVO-SIGNATURE") String aevoSignature,
            @Header("AEVO-KEY") String aevoKey,
            @Header("AEVO-SECRET") String aevoSecret,
            @Body DeleteApiKeyBody body
    );

    @Headers("Content-Type: application/json")
    @GET("api-key")
    Single<ApiKeyData> getApiKey(
            @Header("AEVO-TIMESTAMP") String aevoTimestamp,
            @Header("AEVO-SIGNATURE") String aevoSignature,
            @Header("AEVO-KEY") String aevoKey,
            @Header("AEVO-SECRET") String aevoSecret,
            @Query("api_key") String apiKey,
            @Query("timestamp") String timestamp,
            @Query("signature") String signature
    );

    @Headers("Content-Type: application/json")
    @POST("api-key")
    Single<ApiKeyData> postApiKey(
            @Header("AEVO-TIMESTAMP") String aevoTimestamp,
            @Header("AEVO-SIGNATURE") String aevoSignature,
            @Header("AEVO-KEY") String aevoKey,
            @Header("AEVO-SECRET") String aevoSecret,
            @Body PostApiKeyBody body
    );

    @Headers("Content-Type: application/json")
    @DELETE("signing-key")
    Single<Success> deleteSigningKey(
            @Header("AEVO-TIMESTAMP") String aevoTimestamp,
            @Header("AEVO-SIGNATURE") String aevoSignature,
            @Header("AEVO-KEY") String aevoKey,
            @Header("AEVO-SECRET") String aevoSecret
    );

    @Headers("Content-Type: application/json")
    @GET("account")
    Single<?> getAccount(
            @Header("AEVO-TIMESTAMP") String aevoTimestamp,
            @Header("AEVO-SIGNATURE") String aevoSignature,
            @Header("AEVO-KEY") String aevoKey,
            @Header("AEVO-SECRET") String aevoSecret
    );

    @Headers("Content-Type: application/json")
    @GET("account/cancel-on-disconnect")
    Single<?> getCancelOnDisconnect(
            @Header("AEVO-TIMESTAMP") String aevoTimestamp,
            @Header("AEVO-SIGNATURE") String aevoSignature,
            @Header("AEVO-KEY") String aevoKey,
            @Header("AEVO-SECRET") String aevoSecret
    );

    @Headers("Content-Type: application/json")
    @POST("account/cancel-disconnect")
    Single<Success> postCancelDisconnect(
            @Header("AEVO-TIMESTAMP") String aevoTimestamp,
            @Header("AEVO-SIGNATURE") String aevoSignature,
            @Header("AEVO-KEY") String aevoKey,
            @Header("AEVO-SECRET") String aevoSecret
    );

    @Headers("Content-Type: application/json")
    @POST("account/portfolio-margin")
    Single<Success> postPortfolioMargin(
            @Header("AEVO-TIMESTAMP") String aevoTimestamp,
            @Header("AEVO-SIGNATURE") String aevoSignature,
            @Header("AEVO-KEY") String aevoKey,
            @Header("AEVO-SECRET") String aevoSecret
    );

    @Headers("Content-Type: application/json")
    @GET("account/email-address")
    Single<?> getEmailAddress(
            @Header("AEVO-TIMESTAMP") String aevoTimestamp,
            @Header("AEVO-SIGNATURE") String aevoSignature,
            @Header("AEVO-KEY") String aevoKey,
            @Header("AEVO-SECRET") String aevoSecret
    );

    @Headers("Content-Type: application/json")
    @POST("account/email-address")
    Single<Success> postEmailAddress(
            @Header("AEVO-TIMESTAMP") String aevoTimestamp,
            @Header("AEVO-SIGNATURE") String aevoSignature,
            @Header("AEVO-KEY") String aevoKey,
            @Header("AEVO-SECRET") String aevoSecret
    );

    @Headers("Content-Type: application/json")
    @GET("account/email-preference")
    Single<?> getEmailPreference(
            @Header("AEVO-TIMESTAMP") String aevoTimestamp,
            @Header("AEVO-SIGNATURE") String aevoSignature,
            @Header("AEVO-KEY") String aevoKey,
            @Header("AEVO-SECRET") String aevoSecret
    );

    @Headers("Content-Type: application/json")
    @POST("account/email-preference")
    Single<Success> postEmailPreference(
            @Header("AEVO-TIMESTAMP") String aevoTimestamp,
            @Header("AEVO-SIGNATURE") String aevoSignature,
            @Header("AEVO-KEY") String aevoKey,
            @Header("AEVO-SECRET") String aevoSecret
    );

    @Headers("Content-Type: application/json")
    @GET("portfolio")
    Single<?> getPortfolio(
            @Header("AEVO-TIMESTAMP") String aevoTimestamp,
            @Header("AEVO-SIGNATURE") String aevoSignature,
            @Header("AEVO-KEY") String aevoKey,
            @Header("AEVO-SECRET") String aevoSecret
    );

    @Headers("Content-Type: application/json")
    @POST("withdraw")
    Single<Success> postWithdraw(
            @Header("AEVO-TIMESTAMP") String aevoTimestamp,
            @Header("AEVO-SIGNATURE") String aevoSignature,
            @Header("AEVO-KEY") String aevoKey,
            @Header("AEVO-SECRET") String aevoSecret
    );

    @Headers("Content-Type: application/json")
    @POST("transfer")
    Single<Success> postTransfer(
            @Header("AEVO-TIMESTAMP") String aevoTimestamp,
            @Header("AEVO-SIGNATURE") String aevoSignature,
            @Header("AEVO-KEY") String aevoKey,
            @Header("AEVO-SECRET") String aevoSecret
    );

    @Headers("Content-Type: application/json")
    @GET("orders")
    Single<?> getOrders(
            @Header("AEVO-TIMESTAMP") String aevoTimestamp,
            @Header("AEVO-SIGNATURE") String aevoSignature,
            @Header("AEVO-KEY") String aevoKey,
            @Header("AEVO-SECRET") String aevoSecret
    );

    @Headers("Content-Type: application/json")
    @POST("orders")
    Single<?> postOrders(
            @Header("AEVO-TIMESTAMP") String aevoTimestamp,
            @Header("AEVO-SIGNATURE") String aevoSignature,
            @Header("AEVO-KEY") String aevoKey,
            @Header("AEVO-SECRET") String aevoSecret
    );

    @Headers("Content-Type: application/json")
    @DELETE("orders/{order_id}")
    Single<?> deleteOrders(
            @Header("AEVO-TIMESTAMP") String aevoTimestamp,
            @Header("AEVO-SIGNATURE") String aevoSignature,
            @Header("AEVO-KEY") String aevoKey,
            @Header("AEVO-SECRET") String aevoSecret,
            @Path("order_id") String orderId
    );

    @Headers("Content-Type: application/json")
    @POST("orders/{order_id}")
    Single<?> postOrders(
            @Header("AEVO-TIMESTAMP") String aevoTimestamp,
            @Header("AEVO-SIGNATURE") String aevoSignature,
            @Header("AEVO-KEY") String aevoKey,
            @Header("AEVO-SECRET") String aevoSecret,
            @Path("order_id") String orderId
    );

    @Headers("Content-Type: application/json")
    @DELETE("orders-all")
    Single<?> deleteOrdersAll(
            @Header("AEVO-TIMESTAMP") String aevoTimestamp,
            @Header("AEVO-SIGNATURE") String aevoSignature,
            @Header("AEVO-KEY") String aevoKey,
            @Header("AEVO-SECRET") String aevoSecret
    );

    @Headers("Content-Type: application/json")
    @GET("order-history")
    Single<?> getOrderHistory(
            @Header("AEVO-TIMESTAMP") String aevoTimestamp,
            @Header("AEVO-SIGNATURE") String aevoSignature,
            @Header("AEVO-KEY") String aevoKey,
            @Header("AEVO-SECRET") String aevoSecret,
            @Query("start_time") Integer startTime,
            @Query("end_time") Integer endTime,
            @Query("limit") Integer limit,
            @Query("offset") Integer offset
    );

    @Headers("Content-Type: application/json")
    @GET("trade-history")
    Single<?> getTradeHistory(
            @Header("AEVO-TIMESTAMP") String aevoTimestamp,
            @Header("AEVO-SIGNATURE") String aevoSignature,
            @Header("AEVO-KEY") String aevoKey,
            @Header("AEVO-SECRET") String aevoSecret,
            @Query("start_time") Integer startTime,
            @Query("asset") String asset,
            @Query("end_time") Integer endTime,
            @Query("trade_types") String[] tradeTypes,
            @Query("instrument_type") String instrumentType,
            @Query("option_type") String optionType,
            @Query("limit") Integer limit,
            @Query("offset") Integer offset
    );

    @Headers("Content-Type: application/json")
    @GET("tranaction-history")
    Single<?> getTransactionHistory(
            @Header("AEVO-TIMESTAMP") String aevoTimestamp,
            @Header("AEVO-SIGNATURE") String aevoSignature,
            @Header("AEVO-KEY") String aevoKey,
            @Header("AEVO-SECRET") String aevoSecret,
            @Query("start_time") Integer startTime,
            @Query("end_time") Integer endTime,
            @Query("tx_type") String txType,
            @Query("tx_status") String txStatus,
            @Query("limit") Integer limit,
            @Query("offset") Integer offset
    );

    @Headers("Content-Type: application/json")
    @GET("referral-rewards-history")
    Single<?> getReferralRewardsHistory(
            @Header("AEVO-TIMESTAMP") String aevoTimestamp,
            @Header("AEVO-SIGNATURE") String aevoSignature,
            @Header("AEVO-KEY") String aevoKey,
            @Header("AEVO-SECRET") String aevoSecret,
            @Query("limit") Integer limit,
            @Query("offset") Integer offset
    );

    @Headers("Content-Type: application/json")
    @GET("referral-history")
    Single<?> getReferralHistory(
            @Header("AEVO-TIMESTAMP") String aevoTimestamp,
            @Header("AEVO-SIGNATURE") String aevoSignature,
            @Header("AEVO-KEY") String aevoKey,
            @Header("AEVO-SECRET") String aevoSecret,
            @Query("limit") Integer limit,
            @Query("offset") Integer offset
    );

    @Headers("Content-Type: application/json")
    @GET("referral-statistics")
    Single<?> getReferralStatistics(
            @Header("AEVO-TIMESTAMP") String aevoTimestamp,
            @Header("AEVO-SIGNATURE") String aevoSignature,
            @Header("AEVO-KEY") String aevoKey,
            @Header("AEVO-SECRET") String aevoSecret
    );

    @Headers("Content-Type: application/json")
    @POST("claim-referral-rewards")
    Single<Success> postClaimReferralRewards(
            @Header("AEVO-TIMESTAMP") String aevoTimestamp,
            @Header("AEVO-SIGNATURE") String aevoSignature,
            @Header("AEVO-KEY") String aevoKey,
            @Header("AEVO-SECRET") String aevoSecret
    );

    @Headers("Content-Type: application/json")
    @GET("mmp")
    Single<?> getMmp(
            @Header("AEVO-TIMESTAMP") String aevoTimestamp,
            @Header("AEVO-SIGNATURE") String aevoSignature,
            @Header("AEVO-KEY") String aevoKey,
            @Header("AEVO-SECRET") String aevoSecret,
            @Query("asset") String asset
    );

    @Headers("Content-Type: application/json")
    @POST("mmp")
    Single<Success> postMmp(
            @Header("AEVO-TIMESTAMP") String aevoTimestamp,
            @Header("AEVO-SIGNATURE") String aevoSignature,
            @Header("AEVO-KEY") String aevoKey,
            @Header("AEVO-SECRET") String aevoSecret
    );

    @Headers("Content-Type: application/json")
    @POST("reset-mmp")
    Single<Success> postResetMmp(
            @Header("AEVO-TIMESTAMP") String aevoTimestamp,
            @Header("AEVO-SIGNATURE") String aevoSignature,
            @Header("AEVO-KEY") String aevoKey,
            @Header("AEVO-SECRET") String aevoSecret
    );
}
