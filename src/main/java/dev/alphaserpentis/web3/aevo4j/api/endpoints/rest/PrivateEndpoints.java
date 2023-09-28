package dev.alphaserpentis.web3.aevo4j.api.endpoints.rest;

import dev.alphaserpentis.web3.aevo4j.data.request.rest.DeleteApiKeyBody;
import dev.alphaserpentis.web3.aevo4j.data.request.rest.EmailAddressBody;
import dev.alphaserpentis.web3.aevo4j.data.request.rest.EmailPreferenceBody;
import dev.alphaserpentis.web3.aevo4j.data.request.rest.EnabledBody;
import dev.alphaserpentis.web3.aevo4j.data.request.rest.MmpBody;
import dev.alphaserpentis.web3.aevo4j.data.request.rest.OrdersAllBody;
import dev.alphaserpentis.web3.aevo4j.data.misc.SignedOrder;
import dev.alphaserpentis.web3.aevo4j.data.request.rest.PostApiKeyBody;
import dev.alphaserpentis.web3.aevo4j.data.request.rest.RegisterBody;
import dev.alphaserpentis.web3.aevo4j.data.request.rest.ResetMmpBody;
import dev.alphaserpentis.web3.aevo4j.data.request.rest.SigningKeyBody;
import dev.alphaserpentis.web3.aevo4j.data.request.rest.StrategyWithdrawBody;
import dev.alphaserpentis.web3.aevo4j.data.request.rest.TransferBody;
import dev.alphaserpentis.web3.aevo4j.data.request.rest.UpdateMarginBody;
import dev.alphaserpentis.web3.aevo4j.data.request.rest.WithdrawBody;
import dev.alphaserpentis.web3.aevo4j.data.response.rest.Account;
import dev.alphaserpentis.web3.aevo4j.data.response.rest.AccountUpdateMargin;
import dev.alphaserpentis.web3.aevo4j.data.response.rest.AccumulatedFunding;
import dev.alphaserpentis.web3.aevo4j.data.response.rest.ApiKeyData;
import dev.alphaserpentis.web3.aevo4j.data.response.rest.CancelledOrders;
import dev.alphaserpentis.web3.aevo4j.data.response.rest.EmailAddress;
import dev.alphaserpentis.web3.aevo4j.data.response.rest.EmailPreferences;
import dev.alphaserpentis.web3.aevo4j.data.response.rest.EmailVerified;
import dev.alphaserpentis.web3.aevo4j.data.response.rest.Enabled;
import dev.alphaserpentis.web3.aevo4j.data.response.rest.Mmp;
import dev.alphaserpentis.web3.aevo4j.data.response.common.Order;
import dev.alphaserpentis.web3.aevo4j.data.response.rest.OrderHistory;
import dev.alphaserpentis.web3.aevo4j.data.response.rest.OrderId;
import dev.alphaserpentis.web3.aevo4j.data.response.rest.Portfolio;
import dev.alphaserpentis.web3.aevo4j.data.response.rest.PostRegister;
import dev.alphaserpentis.web3.aevo4j.data.response.rest.Quote;
import dev.alphaserpentis.web3.aevo4j.data.response.rest.ReferralHistory;
import dev.alphaserpentis.web3.aevo4j.data.response.rest.ReferralRewardsHistory;
import dev.alphaserpentis.web3.aevo4j.data.response.rest.ReferralStatistics;
import dev.alphaserpentis.web3.aevo4j.data.response.rest.Success;
import dev.alphaserpentis.web3.aevo4j.data.response.rest.TradeHistory;
import dev.alphaserpentis.web3.aevo4j.data.response.rest.TransactionHistory;
import io.reactivex.rxjava3.core.Single;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

import java.util.List;

/**
 * @see dev.alphaserpentis.web3.aevo4j.handler.AevoHandler#getPrivateService(retrofit2.Retrofit, String, String, boolean)
 * @see dev.alphaserpentis.web3.aevo4j.services.PrivateService
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
    @HTTP(path = "api-key", method = "DELETE", hasBody = true)
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
    @HTTP(path = "signing-key", method = "DELETE", hasBody = true)
    Single<Success> deleteSigningKey(
            @Header("AEVO-TIMESTAMP") String aevoTimestamp,
            @Header("AEVO-SIGNATURE") String aevoSignature,
            @Header("AEVO-KEY") String aevoKey,
            @Header("AEVO-SECRET") String aevoSecret,
            @Body SigningKeyBody body
    );

    @Headers("Content-Type: application/json")
    @GET("account")
    Single<Account> getAccount(
            @Header("AEVO-TIMESTAMP") String aevoTimestamp,
            @Header("AEVO-SIGNATURE") String aevoSignature,
            @Header("AEVO-KEY") String aevoKey,
            @Header("AEVO-SECRET") String aevoSecret
    );

    @Headers("Content-Type: application/json")
    @GET("account/cancel-on-disconnect")
    Single<Enabled> getCancelOnDisconnect(
            @Header("AEVO-TIMESTAMP") String aevoTimestamp,
            @Header("AEVO-SIGNATURE") String aevoSignature,
            @Header("AEVO-KEY") String aevoKey,
            @Header("AEVO-SECRET") String aevoSecret
    );

    @Headers("Content-Type: application/json")
    @POST("account/cancel-on-disconnect")
    Single<Success> postCancelOnDisconnect(
            @Header("AEVO-TIMESTAMP") String aevoTimestamp,
            @Header("AEVO-SIGNATURE") String aevoSignature,
            @Header("AEVO-KEY") String aevoKey,
            @Header("AEVO-SECRET") String aevoSecret,
            @Body EnabledBody body
    );

    @Headers("Content-Type: application/json")
    @POST("account/portfolio-margin")
    Single<Success> postPortfolioMargin(
            @Header("AEVO-TIMESTAMP") String aevoTimestamp,
            @Header("AEVO-SIGNATURE") String aevoSignature,
            @Header("AEVO-KEY") String aevoKey,
            @Header("AEVO-SECRET") String aevoSecret,
            @Body EnabledBody body
    );

    @Headers("Content-Type: application/json")
    @GET("account/email-address")
    Single<EmailAddress> getEmailAddress(
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
            @Header("AEVO-SECRET") String aevoSecret,
            @Body EmailAddressBody body
    );

    @Headers("Content-Type: application/json")
    @GET("account/email-preference")
    Single<EmailPreferences> getEmailPreference(
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
            @Header("AEVO-SECRET") String aevoSecret,
            @Body EmailPreferenceBody body
    );

    @Headers("Content-Type: application/json")
    @GET("account/email-verified")
    Single<EmailVerified> getEmailVerified(
            @Header("AEVO-TIMESTAMP") String aevoTimestamp,
            @Header("AEVO-SIGNATURE") String aevoSignature,
            @Header("AEVO-KEY")  String aevoKey,
            @Header("AEVO-SECRET") String aevoSecret
    );

    @Headers("Content-Type: application/json")
    @GET("account/accumulated-fundings")
    Single<AccumulatedFunding> getAccumulatedFundings(
            @Header("AEVO-TIMESTAMP") String aevoTimestamp,
            @Header("AEVO-SIGNATURE") String aevoSignature,
            @Header("AEVO-KEY")  String aevoKey,
            @Header("AEVO-SECRET") String aevoSecret
    );

    @Headers("Content-Type: application/json")
    @POST("account/update-margin")
    Single<AccountUpdateMargin> postUpdateMargin(
            @Header("AEVO-TIMESTAMP") String aevoTimestamp,
            @Header("AEVO-SIGNATURE") String aevoSignature,
            @Header("AEVO-KEY") String aevoKey,
            @Header("AEVO-SECRET") String aevoSecret,
            @Body UpdateMarginBody body
    );

    @Headers("Content-Type: application/json")
    @GET("portfolio")
    Single<Portfolio> getPortfolio(
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
            @Header("AEVO-SECRET") String aevoSecret,
            @Body WithdrawBody body
    );

    @Headers("Content-Type: application/json")
    @POST("strategy/withdraw")
    Single<Success> postStrategyWithdraw(
            @Header("AEVO-TIMESTAMP") String aevoTimestamp,
            @Header("AEVO-SIGNATURE") String aevoSignature,
            @Header("AEVO-KEY") String aevoKey,
            @Header("AEVO-SECRET") String aevoSecret,
            @Body StrategyWithdrawBody body
    );

    @Headers("Content-Type: application/json")
    @POST("transfer")
    Single<Success> postTransfer(
            @Header("AEVO-TIMESTAMP") String aevoTimestamp,
            @Header("AEVO-SIGNATURE") String aevoSignature,
            @Header("AEVO-KEY") String aevoKey,
            @Header("AEVO-SECRET") String aevoSecret,
            @Body TransferBody body
    );

    @Headers("Content-Type: application/json")
    @GET("orders")
    Single<List<Order>> getOrders(
            @Header("AEVO-TIMESTAMP") String aevoTimestamp,
            @Header("AEVO-SIGNATURE") String aevoSignature,
            @Header("AEVO-KEY") String aevoKey,
            @Header("AEVO-SECRET") String aevoSecret
    );

    @Headers("Content-Type: application/json")
    @POST("orders")
    Single<Order> postOrders(
            @Header("AEVO-TIMESTAMP") String aevoTimestamp,
            @Header("AEVO-SIGNATURE") String aevoSignature,
            @Header("AEVO-KEY") String aevoKey,
            @Header("AEVO-SECRET") String aevoSecret,
            @Body SignedOrder body
    );

    @Headers("Content-Type: application/json")
    @DELETE("orders/{order_id}")
    Single<OrderId> deleteOrder(
            @Header("AEVO-TIMESTAMP") String aevoTimestamp,
            @Header("AEVO-SIGNATURE") String aevoSignature,
            @Header("AEVO-KEY")  String aevoKey,
            @Header("AEVO-SECRET") String aevoSecret,
            @Path("order_id") String orderId
    );

    @Headers("Content-Type: application/json")
    @POST("orders/{order_id}")
    Single<Order> postEditOrder(
            @Header("AEVO-TIMESTAMP") String aevoTimestamp,
            @Header("AEVO-SIGNATURE") String aevoSignature,
            @Header("AEVO-KEY") String aevoKey,
            @Header("AEVO-SECRET") String aevoSecret,
            @Path("order_id") String orderId,
            @Body SignedOrder body
    );

    @Headers("Content-Type: application/json")
    @HTTP(method = "DELETE", path = "orders-all", hasBody = true)
    Single<CancelledOrders> deleteOrdersAll(
            @Header("AEVO-TIMESTAMP") String aevoTimestamp,
            @Header("AEVO-SIGNATURE") String aevoSignature,
            @Header("AEVO-KEY") String aevoKey,
            @Header("AEVO-SECRET") String aevoSecret,
            @Body OrdersAllBody body
    );

    @Headers("Content-Type: application/json")
    @GET("order-history")
    Single<OrderHistory> getOrderHistory(
            @Header("AEVO-TIMESTAMP") String aevoTimestamp,
            @Header("AEVO-SIGNATURE") String aevoSignature,
            @Header("AEVO-KEY") String aevoKey,
            @Header("AEVO-SECRET") String aevoSecret,
            @Query("start_time") Long startTime,
            @Query("end_time") Long endTime,
            @Query("limit") Integer limit,
            @Query("offset") Integer offset
    );

    @Headers("Content-Type: application/json")
    @GET("trade-history")
    Single<TradeHistory> getTradeHistory(
            @Header("AEVO-TIMESTAMP") String aevoTimestamp,
            @Header("AEVO-SIGNATURE") String aevoSignature,
            @Header("AEVO-KEY") String aevoKey,
            @Header("AEVO-SECRET") String aevoSecret,
            @Query("start_time") Long startTime,
            @Query("asset") String asset,
            @Query("end_time") Long endTime,
            @Query("trade_types") String[] tradeTypes,
            @Query("instrument_type") String instrumentType,
            @Query("option_type") String optionType,
            @Query("limit") Integer limit,
            @Query("offset") Integer offset
    );

    @Headers("Content-Type: application/json")
    @GET("tranaction-history")
    Single<TransactionHistory> getTransactionHistory(
            @Header("AEVO-TIMESTAMP") String aevoTimestamp,
            @Header("AEVO-SIGNATURE") String aevoSignature,
            @Header("AEVO-KEY") String aevoKey,
            @Header("AEVO-SECRET") String aevoSecret,
            @Query("start_time") Long startTime,
            @Query("end_time") Long endTime,
            @Query("tx_type") String txType,
            @Query("tx_status") String txStatus,
            @Query("limit") Integer limit,
            @Query("offset") Integer offset
    );

    @Headers("Content-Type: application/json")
    @GET("referral-rewards-history")
    Single<ReferralRewardsHistory> getReferralRewardsHistory(
            @Header("AEVO-TIMESTAMP") String aevoTimestamp,
            @Header("AEVO-SIGNATURE") String aevoSignature,
            @Header("AEVO-KEY") String aevoKey,
            @Header("AEVO-SECRET") String aevoSecret,
            @Query("limit") Integer limit,
            @Query("offset") Integer offset
    );

    @Headers("Content-Type: application/json")
    @GET("referral-history")
    Single<ReferralHistory> getReferralHistory(
            @Header("AEVO-TIMESTAMP") String aevoTimestamp,
            @Header("AEVO-SIGNATURE") String aevoSignature,
            @Header("AEVO-KEY") String aevoKey,
            @Header("AEVO-SECRET") String aevoSecret,
            @Query("limit") Integer limit,
            @Query("offset") Integer offset
    );

    @Headers("Content-Type: application/json")
    @GET("referral-statistics")
    Single<ReferralStatistics> getReferralStatistics(
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
    Single<Mmp> getMmp(
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
            @Header("AEVO-SECRET") String aevoSecret,
            @Body MmpBody body
    );

    @Headers("Content-Type: application/json")
    @POST("reset-mmp")
    Single<Success> postResetMmp(
            @Header("AEVO-TIMESTAMP") String aevoTimestamp,
            @Header("AEVO-SIGNATURE") String aevoSignature,
            @Header("AEVO-KEY") String aevoKey,
            @Header("AEVO-SECRET") String aevoSecret,
            @Body ResetMmpBody body
    );

    @Headers("Content-Type: application/json")
    @GET("quotes")
    Single<List<Quote>> getQuotes(
            @Header("AEVO-TIMESTAMP") String aevoTimestamp,
            @Header("AEVO-SIGNATURE") String aevoSignature,
            @Header("AEVO-KEY")  String aevoKey,
            @Header("AEVO-SECRET") String aevoSecret
    );
}
