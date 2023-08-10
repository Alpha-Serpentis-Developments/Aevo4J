package dev.alphaserpentis.web3.aevo4j.api.endpoints.rest;

import dev.alphaserpentis.web3.aevo4j.data.request.rest.DeleteApiKeyBody;
import dev.alphaserpentis.web3.aevo4j.data.request.rest.RegisterBody;
import dev.alphaserpentis.web3.aevo4j.data.response.rest.GetApiKey;
import dev.alphaserpentis.web3.aevo4j.data.response.rest.PostRegister;
import io.reactivex.rxjava3.core.Single;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
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
            @Body RegisterBody body
    );

    @Headers("Content-Type: application/json")
    @DELETE("api-key")
    Single<?> deleteApiKey(
            @Body DeleteApiKeyBody body
    );

    @Headers("Content-Type: application/json")
    @GET("api-key")
    Single<GetApiKey> getApiKey(
            @Query("api_key") String apiKey,
            @Query("timestamp") String timestamp,
            @Query("signature") String signature
    );

    @Headers("Content-Type: application/json")
    @POST("api-key")
    Single<?> postApiKey(

    );

    @Headers("Content-Type: application/json")
    @DELETE("signing-key")
    Single<?> deleteSigningKey(

    );

    @Headers("Content-Type: application/json")
    @GET("account")
    Single<?> getAccount(

    );

    @Headers("Content-Type: application/json")
    @GET("account/cancel-on-disconnect")
    Single<?> getCancelOnDisconnect(

    );

    @Headers("Content-Type: application/json")
    @POST("account/cancel-disconnect")
    Single<?> postCancelDisconnect(

    );

    @Headers("Content-Type: application/json")
    @POST("account/portfolio-margin")
    Single<?> postPortfolioMargin(

    );

    @Headers("Content-Type: application/json")
    @GET("account/email-address")
    Single<?> getEmailAddress(

    );

    @Headers("Content-Type: application/json")
    @POST("account/email-address")
    Single<?> postEmailAddress(

    );

    @Headers("Content-Type: application/json")
    @GET("account/email-preference")
    Single<?> getEmailPreference(

    );

    @Headers("Content-Type: application/json")
    @POST("account/email-preference")
    Single<?> postEmailPreference(

    );

    @Headers("Content-Type: application/json")
    @GET("portfolio")
    Single<?> getPortfolio(

    );

    @Headers("Content-Type: application/json")
    @POST("withdraw")
    Single<?> postWithdraw(

    );

    @Headers("Content-Type: application/json")
    @POST("transfer")
    Single<?> postTransfer(

    );

    @Headers("Content-Type: application/json")
    @GET("orders")
    Single<?> getOrders(

    );

    @Headers("Content-Type: application/json")
    @POST("orders")
    Single<?> postOrders(

    );

    @Headers("Content-Type: application/json")
    @DELETE("orders/{order_id}")
    Single<?> deleteOrders(
            @Path("order_id") String orderId
    );

    @Headers("Content-Type: application/json")
    @POST("orders/{order_id}")
    Single<?> postOrders(
            @Path("order_id") String orderId
    );

    @Headers("Content-Type: application/json")
    @DELETE("orders-all")
    Single<?> deleteOrdersAll(

    );

    @Headers("Content-Type: application/json")
    @GET("order-history")
    Single<?> getOrderHistory(

    );

    @Headers("Content-Type: application/json")
    @GET("trade-history")
    Single<?> getTradeHistory(

    );

    @Headers("Content-Type: application/json")
    @GET("tranaction-history")
    Single<?> getTranactionHistory(

    );

    @Headers("Content-Type: application/json")
    @GET("referral-rewards-history")
    Single<?> getReferralRewardsHistory(

    );

    @Headers("Content-Type: application/json")
    @GET("referral-history")
    Single<?> getReferralHistory(

    );

    @Headers("Content-Type: application/json")
    @GET("referral-statistics")
    Single<?> getReferralStatistics(

    );

    @Headers("Content-Type: application/json")
    @POST("claim-referral-rewards")
    Single<?> postClaimReferralRewards(

    );

    @Headers("Content-Type: application/json")
    @GET("mmp")
    Single<?> getMmp(

    );

    @Headers("Content-Type: application/json")
    @POST("mmp")
    Single<?> postMmp(

    );

    @Headers("Content-Type: application/json")
    @POST("reset-mmp")
    Single<?> postResetMmp(

    );
}
