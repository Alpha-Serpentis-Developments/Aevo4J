package dev.alphaserpentis.web3.aevo4j.services;

import com.google.gson.Gson;
import dev.alphaserpentis.web3.aevo4j.api.endpoints.rest.PrivateEndpoints;
import dev.alphaserpentis.web3.aevo4j.data.misc.SignedOrder;
import dev.alphaserpentis.web3.aevo4j.data.request.rest.DeleteApiKeyBody;
import dev.alphaserpentis.web3.aevo4j.data.request.rest.EmailAddressBody;
import dev.alphaserpentis.web3.aevo4j.data.request.rest.EmailPreferenceBody;
import dev.alphaserpentis.web3.aevo4j.data.request.rest.EnabledBody;
import dev.alphaserpentis.web3.aevo4j.data.request.rest.LeverageBody;
import dev.alphaserpentis.web3.aevo4j.data.request.rest.MmpBody;
import dev.alphaserpentis.web3.aevo4j.data.request.rest.OrdersAllBody;
import dev.alphaserpentis.web3.aevo4j.data.request.rest.PostApiKeyBody;
import dev.alphaserpentis.web3.aevo4j.data.request.rest.QuotesBody;
import dev.alphaserpentis.web3.aevo4j.data.request.rest.RFQsBody;
import dev.alphaserpentis.web3.aevo4j.data.request.rest.RegisterBody;
import dev.alphaserpentis.web3.aevo4j.data.request.rest.ResetMmpBody;
import dev.alphaserpentis.web3.aevo4j.data.request.rest.SigningKeyBody;
import dev.alphaserpentis.web3.aevo4j.data.request.rest.StratInitWithdrawBody;
import dev.alphaserpentis.web3.aevo4j.data.request.rest.StratPendingTxsBody;
import dev.alphaserpentis.web3.aevo4j.data.request.rest.StrategyWithdrawBody;
import dev.alphaserpentis.web3.aevo4j.data.request.rest.SwapBody;
import dev.alphaserpentis.web3.aevo4j.data.request.rest.TransferBody;
import dev.alphaserpentis.web3.aevo4j.data.request.rest.UpdateMarginBody;
import dev.alphaserpentis.web3.aevo4j.data.request.rest.WithdrawBody;
import dev.alphaserpentis.web3.aevo4j.data.response.common.Order;
import dev.alphaserpentis.web3.aevo4j.data.response.rest.Account;
import dev.alphaserpentis.web3.aevo4j.data.response.rest.AccountUpdateMargin;
import dev.alphaserpentis.web3.aevo4j.data.response.rest.AccumulatedFunding;
import dev.alphaserpentis.web3.aevo4j.data.response.rest.ApiKeyData;
import dev.alphaserpentis.web3.aevo4j.data.response.rest.Cancelled;
import dev.alphaserpentis.web3.aevo4j.data.response.rest.CancelledOrders;
import dev.alphaserpentis.web3.aevo4j.data.response.rest.EmailAddress;
import dev.alphaserpentis.web3.aevo4j.data.response.rest.EmailPreferences;
import dev.alphaserpentis.web3.aevo4j.data.response.rest.EmailVerified;
import dev.alphaserpentis.web3.aevo4j.data.response.rest.Enabled;
import dev.alphaserpentis.web3.aevo4j.data.response.rest.Mmp;
import dev.alphaserpentis.web3.aevo4j.data.response.rest.OrderHistory;
import dev.alphaserpentis.web3.aevo4j.data.response.rest.OrderId;
import dev.alphaserpentis.web3.aevo4j.data.response.rest.Portfolio;
import dev.alphaserpentis.web3.aevo4j.data.response.rest.PostRegister;
import dev.alphaserpentis.web3.aevo4j.data.response.rest.Quote;
import dev.alphaserpentis.web3.aevo4j.data.response.rest.QuoteOfRfq;
import dev.alphaserpentis.web3.aevo4j.data.response.rest.RFQBlocks;
import dev.alphaserpentis.web3.aevo4j.data.response.rest.ReferralHistory;
import dev.alphaserpentis.web3.aevo4j.data.response.rest.ReferralRewardsHistory;
import dev.alphaserpentis.web3.aevo4j.data.response.rest.ReferralStatistics;
import dev.alphaserpentis.web3.aevo4j.data.response.rest.StratPendingTX;
import dev.alphaserpentis.web3.aevo4j.data.response.rest.Success;
import dev.alphaserpentis.web3.aevo4j.data.response.rest.Swap;
import dev.alphaserpentis.web3.aevo4j.data.response.rest.SwapPreview;
import dev.alphaserpentis.web3.aevo4j.data.response.rest.TradeHistory;
import dev.alphaserpentis.web3.aevo4j.data.response.rest.TransactionHistory;
import dev.alphaserpentis.web3.aevo4j.exception.AevoRestException;
import dev.alphaserpentis.web3.aevo4j.handler.AevoHandler;
import io.reactivex.rxjava3.annotations.Experimental;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@SuppressWarnings({"unused", "UnusedReturnValue"})
public class PrivateService extends AbstractService<PrivateEndpoints> {
    protected Gson gson = new Gson();
    private String apiKey = null;
    private String apiSecret = null;
    private boolean useSignatures = false;

    public PrivateService(
            @NonNull PrivateEndpoints api,
            @NonNull String apiKey,
            @NonNull String apiSecret,
            boolean useSignatures,
            boolean autoRetryAfterRatelimit
    ) {
        super(api, autoRetryAfterRatelimit);

        this.apiKey = apiKey;
        this.apiSecret = apiSecret;
        this.useSignatures = useSignatures;
    }

    public PrivateService(
            @NonNull PrivateEndpoints api,
            @NonNull String apiKey,
            @NonNull String apiSecret,
            boolean useSignatures
    ) {
        super(api);

        this.apiKey = apiKey;
        this.apiSecret = apiSecret;
        this.useSignatures = useSignatures;
    }

    public PrivateService(
            @NonNull PrivateEndpoints api,
            boolean autoRetryAfterRatelimit
    ) {
        super(api, autoRetryAfterRatelimit);
    }

    public PrivateService(@NonNull PrivateEndpoints api) {
        super(api);
    }

    public void setApiKey(@NonNull String apiKey) {
        this.apiKey = apiKey;
    }

    public void setApiSecret(@NonNull String apiSecret) {
        this.apiSecret = apiSecret;
    }

    public void setUseSignatures(boolean useSignatures) {
        this.useSignatures = useSignatures;
    }

    /**
     * Registers a new account
     * @param account Ethereum address of the account
     * @param signingKey Ethereum address of the signing key
     * @param expiry UNIX expiry of the signing key in seconds
     * @param accountSignature Hash of EIP-712 signature signed by the account
     * @param signingKeySignature Hash of EIP-712 signature signed by the signing key
     * @param referralCode Referral code (if any)
     * @return {@link PostRegister}
     * @see <a href="https://api-docs.aevo.xyz/reference/postregister">Aevo - POST Register</a>
     */
    public PostRegister postRegister(
            @NonNull String account,
            @NonNull String signingKey,
            @NonNull String expiry,
            @NonNull String accountSignature,
            @NonNull String signingKeySignature,
            @Nullable String referralCode
    ) throws NoSuchAlgorithmException, InvalidKeyException, AevoRestException {
        RegisterBody body = new RegisterBody(
                account,
                signingKey,
                expiry,
                accountSignature,
                signingKeySignature,
                referralCode
        );
        String timestamp = useSignatures ? AevoHandler.getTimestamp() : null;
        String signature = useSignatures ? AevoHandler.generateAuthSignature(
                Long.parseLong(timestamp),
                apiKey,
                apiSecret,
                "POST",
                "/register",
                gson.toJson(body)
        ) : null;

        return execute(
                getApi().register(
                        timestamp,
                        signature,
                        apiKey,
                        useSignatures ? null : apiSecret,
                        body
                ),
                isAutoRetryAfterRatelimit()
        );
    }

    /**
     * Registers a new account
     * @param account Ethereum address of the account
     * @param signingKey Ethereum address of the signing key
     * @param expiry UNIX expiry of the signing key in seconds
     * @param accountSignature Hash of EIP-712 signature signed by the account
     * @param signingKeySignature Hash of EIP-712 signature signed by the signing key
     * @return {@link PostRegister}
     * @see <a href="https://api-docs.aevo.xyz/reference/postregister">Aevo - POST Register</a>
     */
    public PostRegister postRegister(
            @NonNull String account,
            @NonNull String signingKey,
            @NonNull String expiry,
            @NonNull String accountSignature,
            @NonNull String signingKeySignature
    ) throws NoSuchAlgorithmException, InvalidKeyException, AevoRestException {
        return postRegister(
                account,
                signingKey,
                expiry,
                accountSignature,
                signingKeySignature,
                null
        );
    }

    /**
     * Removes the account's API key. This will log the account out.
     * @param apiKeyToDelete API key to delete
     * @return {@link Success}
     * @see <a href="https://api-docs.aevo.xyz/reference/deleteapikey">Aevo - DELETE API Key</a>
     */
    public Success deleteApiKey(
            @NonNull String apiKeyToDelete
    ) throws NoSuchAlgorithmException, InvalidKeyException, AevoRestException {
        DeleteApiKeyBody body = new DeleteApiKeyBody(
                apiKeyToDelete
        );
        String timestamp = useSignatures ? AevoHandler.getTimestamp() : null;
        String signature = useSignatures ? AevoHandler.generateAuthSignature(
                Long.parseLong(timestamp),
                apiKey,
                apiSecret,
                "DELETE",
                "/api-key",
                gson.toJson(body)
        ) : null;

        return execute(
                getApi().deleteApiKey(
                        timestamp,
                        signature,
                        apiKey,
                        useSignatures ? null : apiSecret, 
                        body
                ),
                isAutoRetryAfterRatelimit()
        );
    }

    /**
     * Get the API key info
     * @param apiKeyToGet API key to get
     * @param queryTimestamp Timestamp of the query
     * @param querySignature Signature of the query
     * @return {@link ApiKeyData}
     * @see <a href="https://api-docs.aevo.xyz/reference/getapikey">Aevo - GET API Key</a>
     */
    public ApiKeyData getApiKey(
            @NonNull String apiKeyToGet,
            @NonNull String queryTimestamp,
            @NonNull String querySignature
    ) throws NoSuchAlgorithmException, InvalidKeyException, AevoRestException {
        String timestamp = useSignatures ? AevoHandler.getTimestamp() : null;
        String signature = useSignatures ? AevoHandler.generateAuthSignature(
                Long.parseLong(timestamp),
                apiKey,
                apiSecret,
                "GET",
                "/api-key",
                ""
        ) : null;

        return execute(
                getApi().getApiKey(
                        timestamp,
                        signature,
                        apiKey,
                        useSignatures ? null : apiSecret, 
                        apiKeyToGet,
                        queryTimestamp,
                        querySignature
                ),
                isAutoRetryAfterRatelimit()
        );
    }

    /**
     * Creates a new API key
     * @param name Name of the API key
     * @param ipAddresses IP addresses to whitelist
     * @param readOnly Whether the API key is read-only or not (default {@code false})
     * @return {@link ApiKeyData}
     * @see <a href="https://api-docs.aevo.xyz/reference/postapikey">Aevo - POST API Key</a>
     */
    public ApiKeyData postApiKey(
            @NonNull String name,
            @Nullable String[] ipAddresses,
            @Nullable Boolean readOnly
    ) throws NoSuchAlgorithmException, InvalidKeyException, AevoRestException {
        PostApiKeyBody body = new PostApiKeyBody(
                name,
                ipAddresses,
                readOnly
        );
        String timestamp = useSignatures ? AevoHandler.getTimestamp() : null;
        String signature = useSignatures ? AevoHandler.generateAuthSignature(
                Long.parseLong(timestamp),
                apiKey,
                apiSecret,
                "POST",
                "/api-key",
                gson.toJson(body)
        ) : null;

        return execute(
                getApi().postApiKey(
                        timestamp,
                        signature,
                        apiKey,
                        useSignatures ? null : apiSecret, 
                        body
                ),
                isAutoRetryAfterRatelimit()
        );
    }

    /**
     * Creates a new API key
     * @param name Name of the API key
     * @return {@link ApiKeyData}
     * @see <a href="https://api-docs.aevo.xyz/reference/postapikey">Aevo - POST API Key</a>
     */
    public ApiKeyData postApiKey(
            @NonNull String name
    ) throws NoSuchAlgorithmException, InvalidKeyException, AevoRestException {
        return postApiKey(
                name,
                null,
                null
        );
    }

    /**
     * Removes the account's signing key. This will log the account out.
     * @param signingKeyToDelete Signing key to delete
     * @return {@link Success}
     * @see <a href="https://api-docs.aevo.xyz/reference/deletesigningkey">Aevo - DELETE Signing Key</a>
     */
    public Success deleteSigningKey(
            @NonNull String signingKeyToDelete
    ) throws NoSuchAlgorithmException, InvalidKeyException, AevoRestException {
        SigningKeyBody body = new SigningKeyBody(
                signingKeyToDelete
        );
        String timestamp = useSignatures ? AevoHandler.getTimestamp() : null;
        String signature = useSignatures ? AevoHandler.generateAuthSignature(
                Long.parseLong(timestamp),
                apiKey,
                apiSecret,
                "POST",
                "/api-key",
                gson.toJson(body)
        ) : null;

        return execute(
                getApi().deleteSigningKey(
                        timestamp,
                        signature,
                        apiKey,
                        useSignatures ? null : apiSecret, 
                        body
                ),
                isAutoRetryAfterRatelimit()
        );
    }

    /**
     * Get the account info. This includes API keys, signing keys, and positions.
     * @return {@link Account}
     * @see <a href="https://api-docs.aevo.xyz/reference/getaccount">Aevo - GET Account</a>
     */
    public Account getAccount() throws NoSuchAlgorithmException, InvalidKeyException, AevoRestException {
        String timestamp = useSignatures ? AevoHandler.getTimestamp() : null;
        String signature = useSignatures ? AevoHandler.generateAuthSignature(
                Long.parseLong(timestamp),
                apiKey,
                apiSecret,
                "GET",
                "/account",
                ""
        ) : null;

        return execute(
                getApi().getAccount(
                        timestamp,
                        signature,
                        apiKey,
                        useSignatures ? null : apiSecret
                ),
                isAutoRetryAfterRatelimit()
        );
    }

    /**
     * Check the setting for cancel on disconnect
     * @return {@link Enabled}
     * @see <a href="https://api-docs.aevo.xyz/reference/getaccountcancelondisconnect">Aevo - GET Account Cancel on Disconnect</a>
     */
    public Enabled getCancelOnDisconnect() throws NoSuchAlgorithmException, InvalidKeyException, AevoRestException {
        String timestamp = useSignatures ? AevoHandler.getTimestamp() : null;
        String signature = useSignatures ? AevoHandler.generateAuthSignature(
                Long.parseLong(timestamp),
                apiKey,
                apiSecret,
                "GET",
                "/account/cancel-on-disconnect",
                ""
        ) : null;

        return execute(
                getApi().getCancelOnDisconnect(
                        timestamp,
                        signature,
                        apiKey,
                        useSignatures ? null : apiSecret
                ),
                isAutoRetryAfterRatelimit()
        );
    }

    /**
     * Enables or disables cancel on disconnect. If enabled, all orders placed through that connection will be cancelled if the connection is closed.
     * @param enabled Whether to enable or disable cancel on disconnect
     * @return {@link Success}
     * @see <a href="https://api-docs.aevo.xyz/reference/postaccountcancelondisconnect">Aevo - POST Account Cancel on Disconnect</a>
     */
    public Success postCancelOnDisconnect(
            boolean enabled
    ) throws NoSuchAlgorithmException, InvalidKeyException, AevoRestException {
        EnabledBody body = new EnabledBody(
                enabled
        );
        String timestamp = useSignatures ? AevoHandler.getTimestamp() : null;
        String signature = useSignatures ? AevoHandler.generateAuthSignature(
                Long.parseLong(timestamp),
                apiKey,
                apiSecret,
                "POST",
                "/account/cancel-on-disconnect",
                gson.toJson(body)
        ) : null;

        return execute(
                getApi().postCancelOnDisconnect(
                        timestamp,
                        signature,
                        apiKey,
                        useSignatures ? null : apiSecret, 
                        body
                ),
                isAutoRetryAfterRatelimit()
        );
    }

    /**
     * Enables or disables the portfolio margin
     * @param enabled Whether to enable or disable portfolio margin
     * @return {@link Success}
     * @see <a href="https://api-docs.aevo.xyz/reference/postaccountportfoliomargin">Aevo - POST Account Portfolio Margin</a>
     */
    public Success postPortfolioMargin(
            boolean enabled
    ) throws NoSuchAlgorithmException, InvalidKeyException, AevoRestException {
        String timestamp = useSignatures ? AevoHandler.getTimestamp() : null;
        String signature = useSignatures ? AevoHandler.generateAuthSignature(
                Long.parseLong(timestamp),
                apiKey,
                apiSecret,
                "POST",
                "/account/portfolio-margin",
                ""
        ) : null;

        return execute(
                getApi().postPortfolioMargin(
                        timestamp,
                        signature,
                        apiKey,
                        useSignatures ? null : apiSecret, 
                        new EnabledBody(
                                enabled
                        )
                ),
                isAutoRetryAfterRatelimit()
        );
    }

    /**
     * Get the account's email address
     * @return {@link EmailAddress}
     * @see <a href="https://api-docs.aevo.xyz/reference/getaccountemailaddress">Aevo - GET Account Email Address</a>
     */
    public EmailAddress getEmailAddress() throws NoSuchAlgorithmException, InvalidKeyException, AevoRestException {
        String timestamp = useSignatures ? AevoHandler.getTimestamp() : null;
        String signature = useSignatures ? AevoHandler.generateAuthSignature(
                Long.parseLong(timestamp),
                apiKey,
                apiSecret,
                "GET",
                "/account/email-address",
                ""
        ) : null;

        return execute(
                getApi().getEmailAddress(
                        timestamp,
                        signature,
                        apiKey,
                        useSignatures ? null : apiSecret
                ),
                isAutoRetryAfterRatelimit()
        );
    }

    /**
     * Sets the account's email address
     * @param emailAddress Email address to set
     * @return {@link Success}
     * @see <a href="https://api-docs.aevo.xyz/reference/postaccountemailaddress">Aevo - POST Account Email Address</a>
     */
    public Success postEmailAddress(
            @NonNull String emailAddress
    ) throws NoSuchAlgorithmException, InvalidKeyException, AevoRestException {
        EmailAddressBody body = new EmailAddressBody(
                emailAddress
        );
        String timestamp = useSignatures ? AevoHandler.getTimestamp() : null;
        String signature = useSignatures ? AevoHandler.generateAuthSignature(
                Long.parseLong(timestamp),
                apiKey,
                apiSecret,
                "POST",
                "/account/email-address",
                gson.toJson(body)
        ) : null;

        return execute(
                getApi().postEmailAddress(
                        timestamp,
                        signature,
                        apiKey,
                        useSignatures ? null : apiSecret, 
                        body
                ),
                isAutoRetryAfterRatelimit()
        );
    }

    /**
     * Sets up the account's email preferences
     * @param emailType Email type for email preferences
     * @param enabled Whether to enable or disable the email type
     * @return {@link Success}
     * @see <a href="https://api-docs.aevo.xyz/reference/postaccountemailpreferences">Aevo - POST Account Email Preferences</a>
     */
    public Success postEmailPreference(
            @NonNull String emailType,
            boolean enabled
    ) throws NoSuchAlgorithmException, InvalidKeyException, AevoRestException {
        EmailPreferenceBody body = new EmailPreferenceBody(
                emailType,
                enabled
        );
        String timestamp = useSignatures ? AevoHandler.getTimestamp() : null;
        String signature = useSignatures ? AevoHandler.generateAuthSignature(
            Long.parseLong(timestamp),
            apiKey,
            apiSecret,
            "POST",
            "/account/email-preference",
            gson.toJson(body)
        ) : null;

        return execute(
                getApi().postEmailPreference(
                        timestamp,
                        signature,
                        apiKey,
                        useSignatures ? null : apiSecret, 
                        body
                ),
                isAutoRetryAfterRatelimit()
        );
    }

    /**
     * Get the account's email preferences
     * @return {@link EmailPreferences}
     * @see <a href="https://api-docs.aevo.xyz/reference/getaccountemailpreferences">Aevo - GET Account Email Preferences</a>
     */
    public EmailPreferences getEmailPreference()
            throws NoSuchAlgorithmException, InvalidKeyException, AevoRestException {
        String timestamp = useSignatures ? AevoHandler.getTimestamp() : null;
        String signature = useSignatures ? AevoHandler.generateAuthSignature(
            Long.parseLong(timestamp),
            apiKey,
            apiSecret,
            "GET",
            "/account/email-preferences",
            ""
        ) : null;

        return execute(
                getApi().getEmailPreference(
                        timestamp,
                        signature,
                        apiKey,
                        useSignatures ? null : apiSecret
                ),
                isAutoRetryAfterRatelimit()
        );
    }

    /**
     * Check if the account's email is verified
     * @return {@link EmailVerified}
     * @see <a href="https://api-docs.aevo.xyz/reference/getaccountemailverified">Aevo - GET Account Email Verified</a>
     */
    public EmailVerified getEmailVerified() throws NoSuchAlgorithmException, InvalidKeyException, AevoRestException {
        String timestamp = useSignatures ? AevoHandler.getTimestamp() : null;
        String signature = useSignatures ? AevoHandler.generateAuthSignature(
            Long.parseLong(timestamp),
            apiKey,
            apiSecret,
            "GET",
            "/account/email-verified",
            ""
        ) : null;

        return execute(
                getApi().getEmailVerified(
                        timestamp,
                        signature,
                        apiKey,
                        useSignatures ? null : apiSecret
                ),
                isAutoRetryAfterRatelimit()
        );
    }

    /**
     * Get the accumulated funding for your account's positions
     * @return {@link AccumulatedFunding}
     * @see <a href="https://api-docs.aevo.xyz/reference/getaccountaccumulatedfundings">Aevo - GET Account Accumulated Fundings</a>
     */
    public AccumulatedFunding getAccumulatedFundings() throws NoSuchAlgorithmException, InvalidKeyException {
        String timestamp = useSignatures ? AevoHandler.getTimestamp() : null;
        String signature = useSignatures ? AevoHandler.generateAuthSignature(
            Long.parseLong(timestamp),
            apiKey,
            apiSecret,
            "GET",
            "/account/accumulated-fundings",
            ""
        ) : null;

        return execute(
                getApi().getAccumulatedFundings(
                        timestamp,
                        signature,
                        apiKey,
                        useSignatures ? null : apiSecret
                ),
                isAutoRetryAfterRatelimit()
        );
    }

    /**
     *
     * @param instrumentId Instrument ID number
     * @param margin The isolated margin of the position
     * @return {@link AccountUpdateMargin}
     * @see <a href="https://api-docs.aevo.xyz/reference/postaccountupdatemargin">Aevo - POST Account Update Margin</a>
     */
    public AccountUpdateMargin postUpdateMargin(
            long instrumentId,
            @NonNull String margin
    ) throws NoSuchAlgorithmException, InvalidKeyException {
        UpdateMarginBody body = new UpdateMarginBody(
                instrumentId,
                margin
        );

        String timestamp = useSignatures ? AevoHandler.getTimestamp() : null;
        String signature = useSignatures ? AevoHandler.generateAuthSignature(
            Long.parseLong(timestamp),
            apiKey,
            apiSecret,
            "POST",
            "/account/update-margin",
            gson.toJson(body)
        ) : null;

        return execute(
                getApi().postUpdateMargin(
                        timestamp,
                        signature,
                        apiKey,
                        useSignatures ? null : apiSecret,
                        body
                ),
                isAutoRetryAfterRatelimit()
        );
    }

    /**
     * Sets the leverage of an instrument for your account
     * @param instrumentId Instrument ID number
     * @param leverageMultiplier The leverage multiplier for an instrument
     * @return {@link Success}
     * @see <a href="https://api-docs.aevo.xyz/reference/postaccountleverage">Aevo - POST Account Leverage</a>
     */
    public Success postAccountLeverage(
            long instrumentId,
            long leverageMultiplier
    ) throws NoSuchAlgorithmException, InvalidKeyException {
        LeverageBody body = new LeverageBody(
                instrumentId,
                leverageMultiplier
        );
        String timestamp = useSignatures ? AevoHandler.getTimestamp() : null;
        String signature = useSignatures ? AevoHandler.generateAuthSignature(
            Long.parseLong(timestamp),
            apiKey,
            apiSecret,
            "POST",
            "/account/leverage",
            gson.toJson(body)
        ) : null;

        return execute(
                getApi().postAccountLeverage(
                        timestamp,
                        signature,
                        apiKey,
                        useSignatures ? null : apiSecret,
                        body
                ),
                isAutoRetryAfterRatelimit()
        );
    }

    /**
     * Get the portfolio of the account
     * @return {@link Portfolio}
     * @see <a href="https://api-docs.aevo.xyz/reference/getportfolio">Aevo - GET Portfolio</a>
     */
    public Portfolio getPortfolio() throws NoSuchAlgorithmException, InvalidKeyException, AevoRestException {
        String timestamp = useSignatures ? AevoHandler.getTimestamp() : null;
        String signature = useSignatures ? AevoHandler.generateAuthSignature(
                Long.parseLong(timestamp),
                apiKey,
                apiSecret,
                "GET",
                "/portfolio",
                ""
        ) : null;

        return execute(
                getApi().getPortfolio(
                        timestamp,
                        signature,
                        apiKey,
                        useSignatures ? null : apiSecret
                ),
                isAutoRetryAfterRatelimit()
        );
    }

    /**
     * Withdraws from the exchange to L1 Ethereum
     * @param account Ethereum address of the account
     * @param collateral Ethereum address of the collateral asset
     * @param to Ethereum address to withdraw to
     * @param amount Amount to withdraw
     * @param salt A randomly generated number to guarantee transaction uniqueness in 6 decimals fixed number
     * @param signature Hash of order payload signature signed by the account
     * @param recipient Ethereum address of the recipient (if any)
     * @param socketFees Socket gas fees
     * @param socketMsgGasLimit Socket message gas limit
     * @param socketConnector Socket connector address
     * @return {@link Success}
     * @see <a href="https://api-docs.aevo.xyz/reference/postwithdraw">Aevo - POST Withdraw</a>
     */
    public Success postWithdraw(
            @NonNull String account,
            @NonNull String collateral,
            @NonNull String to,
            @NonNull String amount,
            @NonNull String salt,
            @NonNull String signature,
            @Nullable String recipient,
            @Nullable String socketFees,
            @Nullable String socketMsgGasLimit,
            @Nullable String socketConnector
    ) throws NoSuchAlgorithmException, InvalidKeyException, AevoRestException {
        WithdrawBody body = new WithdrawBody(
                account,
                collateral,
                to,
                amount,
                salt,
                signature,
                recipient,
                socketFees,
                socketMsgGasLimit,
                socketConnector
        );
        String timestamp = useSignatures ? AevoHandler.getTimestamp() : null;
        String signature2 = useSignatures ? AevoHandler.generateAuthSignature(
                Long.parseLong(timestamp),
                apiKey,
                apiSecret,
                "POST",
                "/withdraw",
                gson.toJson(body)
        ) : null;

        return execute(
                getApi().postWithdraw(
                        timestamp,
                        signature2,
                        apiKey,
                        useSignatures ? null : apiSecret,
                        body
                ),
                isAutoRetryAfterRatelimit()
        );
    }

    /**
     * Withdraws from the exchange to L1 Ethereum
     * @param account Ethereum address of the account
     * @param collateral Ethereum address of the collateral asset
     * @param to Ethereum address to withdraw to
     * @param amount Amount to withdraw
     * @param salt A randomly generated number to guarantee transaction uniqueness in 6 decimals fixed number
     * @param signature Hash of order payload signature signed by the account
     * @return {@link Success}
     * @see <a href="https://api-docs.aevo.xyz/reference/postwithdraw">Aevo - POST Withdraw</a>
     */
    public Success postWithdraw(
            @NonNull String account,
            @NonNull String collateral,
            @NonNull String to,
            @NonNull String amount,
            @NonNull String salt,
            @NonNull String signature
    ) throws NoSuchAlgorithmException, InvalidKeyException, AevoRestException {
        return postWithdraw(
                account,
                collateral,
                to,
                amount,
                salt,
                signature,
                null,
                null,
                null,
                null
        );
    }

    /**
     * Withdraws from the exchange to L1 Ethereum
     * @param body {@link WithdrawBody}
     * @return {@link Success}
     * @see <a href="https://api-docs.aevo.xyz/reference/postwithdraw">Aevo - POST Withdraw</a>
     */
    public Success postWithdraw(
            @NonNull WithdrawBody body
    ) throws NoSuchAlgorithmException, InvalidKeyException, AevoRestException {
        String timestamp = useSignatures ? AevoHandler.getTimestamp() : null;
        String signature2 = useSignatures ? AevoHandler.generateAuthSignature(
                Long.parseLong(timestamp),
                apiKey,
                apiSecret,
                "POST",
                "/withdraw",
                gson.toJson(body)
        ) : null;

        return execute(
                getApi().postWithdraw(
                        timestamp,
                        signature2,
                        apiKey,
                        useSignatures ? null : apiSecret,
                        body
                ),
                isAutoRetryAfterRatelimit()
        );
    }

    /**
     * Withdraw USDC from the strategy
     * @param account Ethereum address of the account
     * @param collateral Ethereum address of the collateral asset
     * @param to Ethereum address to withdraw to
     * @param amount Amount to withdraw in USDC (6 decimals fixed number)
     * @param salt A randomly generated number to guarantee transaction uniqueness in 6 decimals fixed number
     * @param signature Hash of order payload signature signed by the account
     * @param label Label of the withdrawal
     * @return {@link Success}
     * @see <a href="https://api-docs.aevo.xyz/reference/poststrategywithdraw">Aevo - POST Strategy Withdraw</a>
     */
    @Experimental
    public Success postStrategyWithdraw(
            @NonNull String account,
            @NonNull String collateral,
            @NonNull String to,
            @NonNull String amount,
            @NonNull String salt,
            @NonNull String signature,
            @NonNull String label
    ) throws NoSuchAlgorithmException, InvalidKeyException {
        StrategyWithdrawBody body = new StrategyWithdrawBody(
                account,
                collateral,
                to,
                amount,
                salt,
                signature,
                label
        );
        String timestamp = useSignatures ? AevoHandler.getTimestamp() : null;
        String signature2 = useSignatures ? AevoHandler.generateAuthSignature(
                Long.parseLong(timestamp),
                apiKey,
                apiSecret,
                "POST",
                "/strategy/withdraw",
                gson.toJson(body)
        ) : null;

        return execute(
                getApi().postStrategyWithdraw(
                        timestamp,
                        signature2,
                        apiKey,
                        useSignatures ? null : apiSecret,
                        body
                ),
                isAutoRetryAfterRatelimit()
        );
    }

    /**
     * Withdraw USDC from the strategy
     * @param body {@link StrategyWithdrawBody} containing the parameters
     * @return {@link Success}
     * @see <a href="https://api-docs.aevo.xyz/reference/poststrategywithdraw">Aevo - POST Strategy Withdraw</a>
     */
    @Experimental
    public Success postStrategyWithdraw(
            @NonNull StrategyWithdrawBody body
    ) throws NoSuchAlgorithmException, InvalidKeyException, AevoRestException {
        String timestamp = useSignatures ? AevoHandler.getTimestamp() : null;
        String signature2 = useSignatures ? AevoHandler.generateAuthSignature(
                Long.parseLong(timestamp),
                apiKey,
                apiSecret,
                "POST",
                "/strategy/withdraw",
                gson.toJson(body)
        ) : null;

        return execute(
                getApi().postStrategyWithdraw(
                        timestamp,
                        signature2,
                        apiKey,
                        useSignatures ? null : apiSecret,
                        body
                ),
                isAutoRetryAfterRatelimit()
        );
    }

    /**
     * Initiate a USDC withdrawal from the strategy
     * @param body {@link StratInitWithdrawBody} containing the parameters
     * @return {@link Success}
     * @see <a href="https://api-docs.aevo.xyz/reference/poststrategyinitiatewithdraw">Aevo - POST Strategy Initiate Withdraw</a>
     */
    public Success postStrategyInitiateWithdraw(
            @NonNull StratInitWithdrawBody body
    ) throws NoSuchAlgorithmException, InvalidKeyException, AevoRestException {
        String timestamp = useSignatures ? AevoHandler.getTimestamp() : null;
        String signature2 = useSignatures ? AevoHandler.generateAuthSignature(
                Long.parseLong(timestamp),
                apiKey,
                apiSecret,
                "POST",
                "/strategy/initiate-withdraw",
                gson.toJson(body)
        ) : null;

        return execute(
                getApi().postStrategyInitiateWithdraw(
                        timestamp,
                        signature2,
                        apiKey,
                        useSignatures ? null : apiSecret,
                        body
                ),
                isAutoRetryAfterRatelimit()
        );
    }

    /**
     * Initiate a USDC withdrawal from the strategy
     * @param strategyAddress Strategy address
     * @param collateralAddress Collateral address
     * @param amount Amount to withdraw in USDC (6 decimals fixed number)
     * @return {@link Success}
     * @see <a href="https://api-docs.aevo.xyz/reference/poststrategyinitiatewithdraw">Aevo - POST Strategy Initiate Withdraw</a>
     */
    public Success postStrategyInitiateWithdraw(
            @NonNull String strategyAddress,
            @NonNull String collateralAddress,
            double amount
    ) throws NoSuchAlgorithmException, InvalidKeyException, AevoRestException {
        StratInitWithdrawBody body = new StratInitWithdrawBody(
                strategyAddress,
                collateralAddress,
                amount
        );
        return postStrategyInitiateWithdraw(body);
    }

    /**
     * Get pending transactions of a strategy of a certain type
     * @param body {@link StratPendingTxsBody}
     * @return {@link StratPendingTX}
     * @see <a href="https://api-docs.aevo.xyz/reference/poststrategypendingtransactions">Aevo - POST Strategy Pending Transactions</a>
     */
    public StratPendingTX postStrategyPendingTransactions(
            @NonNull StratPendingTxsBody body
    ) throws NoSuchAlgorithmException, InvalidKeyException, AevoRestException {
        String timestamp = useSignatures ? AevoHandler.getTimestamp() : null;
        String signature = useSignatures ? AevoHandler.generateAuthSignature(
                Long.parseLong(timestamp),
                apiKey,
                apiSecret,
                "POST",
                "/strategy/pending-transactions",
                gson.toJson(body)
        ) : null;

        return execute(
                getApi().postStrategyPendingTransactions(
                        timestamp,
                        signature,
                        apiKey,
                        useSignatures ? null : apiSecret,
                        body
                ),
                isAutoRetryAfterRatelimit()
        );
    }

    /**
     * Get pending transactions of a strategy of a certain type
     * @param type Transaction types for vault and strategy interactions
     * @return {@link StratPendingTX}
     * @see <a href="https://api-docs.aevo.xyz/reference/poststrategypendingtransactions">Aevo - POST Strategy Pending Transactions</a>
     */
    public StratPendingTX postStrategyPendingTransactions(
            @NonNull String type
    ) throws NoSuchAlgorithmException, InvalidKeyException, AevoRestException {
        return postStrategyPendingTransactions(new StratPendingTxsBody(type));
    }

    /**
     * Transfers assets between accounts
     * @param account Ethereum address of the account
     * @param collateral Ethereum address of the collateral asset
     * @param to Ethereum address to transfer to
     * @param amount Amount to transfer
     * @param salt A randomly generated number to guarantee transaction uniqueness in 6 decimals fixed number
     * @param signature Hash of order payload signature signed by the account
     * @param label Label of the transfer
     * @return {@link Success}
     * @see <a href="https://api-docs.aevo.xyz/reference/posttransfer">Aevo - POST Transfer</a>
     */
    public Success postTransfer(
            @NonNull String account,
            @NonNull String collateral,
            @NonNull String to,
            @NonNull String amount,
            @NonNull String salt,
            @NonNull String signature,
            @Nullable String label
    ) throws NoSuchAlgorithmException, InvalidKeyException, AevoRestException {
        TransferBody body = new TransferBody(
                account,
                collateral,
                to,
                amount,
                salt,
                signature,
                label
        );
        String timestamp = useSignatures ? AevoHandler.getTimestamp() : null;
        String signature2 = useSignatures ? AevoHandler.generateAuthSignature(
                Long.parseLong(timestamp),
                apiKey,
                apiSecret,
                "POST",
                "/transfer",
                gson.toJson(body)
        ) : null;

        return execute(
                getApi().postTransfer(
                        timestamp,
                        signature2,
                        apiKey,
                        useSignatures ? null : apiSecret,
                        body
                ),
                isAutoRetryAfterRatelimit()
        );
    }

    /**
     * Transfers assets between accounts
     * @param account Ethereum address of the account
     * @param collateral Ethereum address of the collateral asset
     * @param to Ethereum address to transfer to
     * @param amount Amount to transfer
     * @param salt A randomly generated number to guarantee transaction uniqueness in 6 decimals fixed number
     * @param signature Hash of order payload signature signed by the account
     * @return {@link Success}
     * @see <a href="https://api-docs.aevo.xyz/reference/posttransfer">Aevo - POST Transfer</a>
     */
    public Success postTransfer(
            @NonNull String account,
            @NonNull String collateral,
            @NonNull String to,
            @NonNull String amount,
            @NonNull String salt,
            @NonNull String signature
    ) throws NoSuchAlgorithmException, InvalidKeyException {
        return postTransfer(account, collateral, to, amount, salt, signature, null);
    }

    /**
     * Gets the account's orders
     * @return {@link List<Order>} of {@link Order}
     * @see <a href="https://api-docs.aevo.xyz/reference/getorders">Aevo - GET Orders</a>
     */
    public List<Order> getOrders() throws NoSuchAlgorithmException, InvalidKeyException, AevoRestException {
        String timestamp = useSignatures ? AevoHandler.getTimestamp() : null;
        String signature = useSignatures ? AevoHandler.generateAuthSignature(
            Long.parseLong(timestamp),
            apiKey,
            apiSecret,
            "GET",
            "/orders",
            ""
        ) : null;

        return execute(
                getApi().getOrders(
                        timestamp,
                        signature,
                        apiKey,
                        useSignatures ? null : apiSecret
                ),
                isAutoRetryAfterRatelimit()
        );
    }

    /**
     * Creates a new order
     * @param instrument Instrument ID number
     * @param maker Account's Ethereum address
     * @param isBuy Whether to get buy orders or sell orders
     * @param amount Amount to get orders for
     * @param limitPrice Limit price to get orders for
     * @param salt A randomly generated number to guarantee transaction uniqueness in 6 decimals fixed number
     * @param signature Hash of order payload signature signed by the account
     * @param timestamp Timestamp of the query in UNIX seconds
     * @param postOnly Whether to get post-only orders or not (default {@code false})
     * @param reduceOnly Whether to get reduce-only orders or not (default {@code false})
     * @param timeInForce Time in force of the orders (default {@code GTC})
     * @param mmp Whether to get market maker orders or not (default {@code false})
     * @param stop Stop price of the orders
     * @param trigger Trigger price of the orders
     * @param closePosition Is order a close position take-profit/stop-loss order
     * @param isolatedMargin The isolated margin of the position
     * @return {@link Order}
     * @see <a href="https://api-docs.aevo.xyz/reference/postorders">Aevo - POST Orders</a>
     */
    public Order postOrders(
            @NonNull Integer instrument,
            @NonNull String maker,
            boolean isBuy,
            long amount,
            long limitPrice,
            long salt,
            @NonNull String signature,
            long timestamp,
            @Nullable Boolean postOnly,
            @Nullable Boolean reduceOnly,
            @Nullable String timeInForce,
            @Nullable Boolean mmp,
            @Nullable String stop,
            @Nullable Double trigger,
            @Nullable Boolean closePosition,
            @Nullable String isolatedMargin
    ) throws NoSuchAlgorithmException, InvalidKeyException, AevoRestException {
        SignedOrder body = new SignedOrder(
                instrument,
                null,
                maker,
                isBuy,
                amount,
                limitPrice,
                salt,
                signature,
                timestamp,
                postOnly,
                reduceOnly,
                timeInForce,
                mmp,
                stop,
                trigger,
                closePosition,
                isolatedMargin
        );
        String timestamp2 = useSignatures ? AevoHandler.getTimestamp() : null;
        String signature2 = useSignatures ? AevoHandler.generateAuthSignature(
                Long.parseLong(timestamp2),
                apiKey,
                apiSecret,
                "POST",
                "/orders",
                gson.toJson(body)
        ) : null;

        return execute(
                getApi().postOrders(
                        timestamp2,
                        signature2,
                        apiKey,
                        useSignatures ? null : apiSecret,
                        body
                ),
                isAutoRetryAfterRatelimit()
        );
    }

    /**
     * Creates a new order
     * @param instrument Instrument ID number
     * @param maker Account's Ethereum address
     * @param isBuy Whether to get buy orders or sell orders
     * @param amount Amount to get orders for
     * @param limitPrice Limit price to get orders for
     * @param salt A randomly generated number to guarantee transaction uniqueness in 6 decimals fixed number
     * @param signature Hash of order payload signature signed by the account
     * @return {@link Order}
     * @see <a href="https://api-docs.aevo.xyz/reference/postorders">Aevo - POST Orders</a>
     */
    public Order postOrders(
            @NonNull Integer instrument,
            @NonNull String maker,
            boolean isBuy,
            long amount,
            long limitPrice,
            long salt,
            @NonNull String signature,
            long timestamp
    ) throws NoSuchAlgorithmException, InvalidKeyException, AevoRestException {
        return postOrders(
                instrument,
                maker,
                isBuy,
                amount,
                limitPrice,
                salt,
                signature,
                timestamp,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null
        );
    }

    /**
     * Creates a new order
     * @param body {@link SignedOrder} to create the order with
     * @return {@link Order}
     * @see <a href="https://api-docs.aevo.xyz/reference/postorders">Aevo - POST Orders</a>
     */
    public Order postOrders(
            @NonNull SignedOrder body
    ) throws NoSuchAlgorithmException, InvalidKeyException, AevoRestException {
        String timestamp = useSignatures ? AevoHandler.getTimestamp() : null;
        String signature = useSignatures ? AevoHandler.generateAuthSignature(
            Long.parseLong(timestamp),
            apiKey,
            apiSecret,
            "POST",
            "/orders",
            gson.toJson(body)
        ) : null;

        return execute(
                getApi().postOrders(
                        timestamp,
                        signature,
                        apiKey,
                        useSignatures ? null : apiSecret,
                        body
                ),
                isAutoRetryAfterRatelimit()
        );
    }

    /**
     * Deletes an order
     * @param orderId Order ID to delete
     * @return {@link OrderId}
     * @see <a href="https://api-docs.aevo.xyz/reference/deleteordersorderid">Aevo - DELETE Orders/{Order ID}</a>
     */
    public OrderId deleteOrder(
            @NonNull String orderId
    ) throws NoSuchAlgorithmException, InvalidKeyException, AevoRestException {
        String timestamp = useSignatures ? AevoHandler.getTimestamp() : null;
        String signature = useSignatures ? AevoHandler.generateAuthSignature(
            Long.parseLong(timestamp),
            apiKey,
            apiSecret,
            "DELETE",
            "/orders/" + orderId,
            ""
        ) : null;

        return execute(
                getApi().deleteOrder(
                        timestamp,
                        signature,
                        apiKey,
                        useSignatures ? null : apiSecret,
                        orderId
                ),
                isAutoRetryAfterRatelimit()
        );
    }

    /**
     * Edits an existing order
     * @param orderId Order ID to edit
     * @param instrument Instrument to edit the order for
     * @param maker Account's Ethereum address
     * @param isBuy Whether to edit a buy order or a sell order
     * @param amount Amount to edit the order for
     * @param limitPrice Limit price to edit the order for
     * @param salt A randomly generated number to guarantee transaction uniqueness in 6 decimals fixed number
     * @param signature Hash of order payload signature signed by the account
     * @param timestamp Timestamp of the query in UNIX seconds
     * @param postOnly Whether to edit the order to be post-only or not (default {@code false})
     * @param reduceOnly Whether to edit the order to be reduce-only or not (default {@code false})
     * @param timeInForce Time in force of the order (default {@code GTC})
     * @param mmp Whether to edit the order to be a market maker order or not (default {@code false})
     * @param stop Stop price of the order
     * @param trigger Trigger price of the order
     * @param closePosition Is order a close position take-profit/stop-loss order
     * @param isolatedMargin The isolated margin of the position
     * @return {@link Order}
     * @see <a href="https://api-docs.aevo.xyz/reference/postordersorderid">Aevo - POST Orders/{Order ID}</a>
     */
    public Order postEditOrder(
            @NonNull String orderId,
            @NonNull Integer instrument,
            @NonNull String maker,
            boolean isBuy,
            long amount,
            long limitPrice,
            long salt,
            @NonNull String signature,
            long timestamp,
            @Nullable Boolean postOnly,
            @Nullable Boolean reduceOnly,
            @Nullable String timeInForce,
            @Nullable Boolean mmp,
            @Nullable String stop,
            @Nullable Double trigger,
            @Nullable Boolean closePosition,
            @Nullable String isolatedMargin
    ) throws NoSuchAlgorithmException, InvalidKeyException, AevoRestException {
        SignedOrder body = new SignedOrder(
                instrument,
                orderId,
                maker,
                isBuy,
                amount,
                limitPrice,
                salt,
                signature,
                timestamp,
                postOnly != null && postOnly,
                reduceOnly != null && reduceOnly,
                timeInForce,
                mmp != null && mmp,
                stop,
                trigger,
                closePosition,
                isolatedMargin
        );
        String timestamp2 = useSignatures ? AevoHandler.getTimestamp() : null;
        String signature2 = useSignatures ? AevoHandler.generateAuthSignature(
                Long.parseLong(timestamp2),
                apiKey,
                apiSecret,
                "POST",
                "/orders/" + orderId,
                gson.toJson(body)
        ) : null;

        return execute(
                getApi().postEditOrder(
                        timestamp2,
                        signature2,
                        apiKey,
                        useSignatures ? null : apiSecret,
                        orderId,
                        body
                ),
                isAutoRetryAfterRatelimit()
        );
    }

    /**
     * Edits an existing order
     * @param orderId Order ID to edit
     * @param instrument Instrument to edit the order for
     * @param maker Account's Ethereum address
     * @param isBuy Whether to edit a buy order or a sell order
     * @param amount Amount to edit the order for
     * @param limitPrice Limit price to edit the order for
     * @param salt A randomly generated number to guarantee transaction uniqueness in 6 decimals fixed number
     * @param signature Hash of order payload signature signed by the account
     * @return {@link Order}
     * @see <a href="https://api-docs.aevo.xyz/reference/postordersorderid">Aevo - POST Orders/{Order ID}</a>
     */
    public Order postEditOrder(
            @NonNull String orderId,
            @NonNull Integer instrument,
            @NonNull String maker,
            boolean isBuy,
            long amount,
            long limitPrice,
            long salt,
            @NonNull String signature,
            long timestamp
    ) throws NoSuchAlgorithmException, InvalidKeyException, AevoRestException {
        return postEditOrder(
                orderId,
                instrument,
                maker,
                isBuy,
                amount,
                limitPrice,
                salt,
                signature,
                timestamp,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null
        );
    }

    /**
     * Edits an existing order
     * @param orderId Order ID to edit
     * @param body {@link SignedOrder} to edit the order with
     * @return {@link Order}
     * @see <a href="https://api-docs.aevo.xyz/reference/postordersorderid">Aevo - POST Orders/{Order ID}</a>
     */
    public Order postEditOrder(
            @NonNull String orderId,
            @NonNull SignedOrder body
    ) throws NoSuchAlgorithmException, InvalidKeyException, AevoRestException {
        String timestamp = useSignatures ? AevoHandler.getTimestamp() : null;
        String signature2 = useSignatures ? AevoHandler.generateAuthSignature(
                Long.parseLong(timestamp),
                apiKey,
                apiSecret,
                "POST",
                "/orders/" + orderId,
                gson.toJson(body)
        ) : null;

        return execute(
                getApi().postEditOrder(
                        timestamp,
                        signature2,
                        apiKey,
                        useSignatures ? null : apiSecret,
                        orderId,
                        body
                ),
                isAutoRetryAfterRatelimit()
        );
    }

    /**
     * Cancels all orders. Optionally, you can specify an asset and instrument type to cancel those orders only.
     * @param assetName Asset name to cancel orders for
     * @param instrumentType Instrument type to cancel orders for
     * @return {@link CancelledOrders}
     * @see <a href="https://api-docs.aevo.xyz/reference/deleteordersall">Aevo - DELETE Orders All</a>
     */
    public CancelledOrders deleteOrdersAll(
            @Nullable String assetName,
            @Nullable String instrumentType
    ) throws NoSuchAlgorithmException, InvalidKeyException, AevoRestException {
        OrdersAllBody body = new OrdersAllBody(
                assetName,
                instrumentType
        );
        String timestamp = useSignatures ? AevoHandler.getTimestamp() : null;
        String signature = useSignatures ? AevoHandler.generateAuthSignature(
            Long.parseLong(timestamp),
            apiKey,
            apiSecret,
            "DELETE",
            "/orders-all",
            gson.toJson(body)
        ) : null;

        return execute(
                getApi().deleteOrdersAll(
                        timestamp,
                        signature,
                        apiKey,
                        useSignatures ? null : apiSecret,
                        body
                ),
                isAutoRetryAfterRatelimit()
        );
    }

    /**
     * Cancels all orders.
     * @return {@link CancelledOrders}
     * @see <a href="https://api-docs.aevo.xyz/reference/deleteordersall">Aevo - DELETE Orders All</a>
     */
    public CancelledOrders deleteOrdersAll() throws NoSuchAlgorithmException, InvalidKeyException, AevoRestException {
        return deleteOrdersAll(null, null);
    }

    /**
     * Returns the order history of the account
     * @param startTime Entries created prior (less than) to the start time are excluded in UNIX timestamp in nanosecond (default 0)
     * @param endTime Entries created after (greater than) the end time are excluded in UNIX timestamp in nanosecond (default current time)
     * @param limit Limits the number of relevant entries in the response. Defaults to 50. Maximum is 1000.
     * @param offset Offset
     * @return {@link OrderHistory}
     * @see <a href="https://api-docs.aevo.xyz/reference/getorderhistory">Aevo - GET Order History</a>
     */
    public OrderHistory getOrderHistory(
            @NonNull Long startTime,
            @NonNull Long endTime,
            @NonNull Integer limit,
            @Nullable Integer offset
    ) throws NoSuchAlgorithmException, InvalidKeyException, AevoRestException {
        String timestamp = useSignatures ? AevoHandler.getTimestamp() : null;
        String signature = useSignatures ? AevoHandler.generateAuthSignature(
            Long.parseLong(timestamp),
            apiKey,
            apiSecret,
            "GET",
            "/order-history",
            ""
        ) : null;

        return execute(
                getApi().getOrderHistory(
                        timestamp,
                        signature,
                        apiKey,
                        useSignatures ? null : apiSecret,
                        startTime,
                        endTime,
                        limit,
                        offset
                ),
                isAutoRetryAfterRatelimit()
        );
    }

    /**
     * Returns the order history of the account
     * @param startTime Entries created prior (less than) to the start time are excluded in UNIX timestamp in nanosecond (default 0)
     * @param endTime Entries created after (greater than) the end time are excluded in UNIX timestamp in nanosecond (default current time)
     * @param limit Limits the number of relevant entries in the response. Defaults to 50. Maximum is 1000.
     * @return {@link OrderHistory}
     * @see <a href="https://api-docs.aevo.xyz/reference/getorderhistory">Aevo - GET Order History</a>
     */
    public OrderHistory getOrderHistory(
            @NonNull Long startTime,
            @NonNull Long endTime,
            @NonNull Integer limit
    ) throws NoSuchAlgorithmException, InvalidKeyException, AevoRestException {
        return getOrderHistory(startTime, endTime, limit, null);
    }

    /**
     * Returns the account's trade history
     * @param startTime Entries created prior (less than) to the start time are excluded in UNIX timestamp in nanosecond (default 0)
     * @param asset Asset to get trade history for
     * @param endTime Entries created after (greater than) the end time are excluded in UNIX timestamp in nanosecond (default current time)
     * @param tradeTypes Trade types to get trade history for
     * @param instrumentType Instrument type to get trade history for
     * @param optionType Option type to get trade history for
     * @param limit Limits the number of relevant entries in the response. Defaults to 50. Maximum is 1000.
     * @param offset Offset
     * @return {@link TradeHistory}
     * @see <a href="https://api-docs.aevo.xyz/reference/gettradehistory">Aevo - GET Trade History</a>
     */
    public TradeHistory getTradeHistory(
            @NonNull Long startTime,
            @Nullable String asset,
            @Nullable Long endTime,
            @Nullable String[] tradeTypes,
            @Nullable String instrumentType,
            @Nullable String optionType,
            @Nullable Integer limit,
            @Nullable Integer offset
    ) throws NoSuchAlgorithmException, InvalidKeyException, AevoRestException {
        String timestamp = useSignatures ? AevoHandler.getTimestamp() : null;
        String signature = useSignatures ? AevoHandler.generateAuthSignature(
            Long.parseLong(timestamp),
            apiKey,
            apiSecret,
            "GET",
            "/trade-history",
            ""
        ) : null;

        return execute(
                getApi().getTradeHistory(
                        timestamp,
                        signature,
                        apiKey,
                        useSignatures ? null : apiSecret,
                        startTime,
                        asset,
                        endTime,
                        tradeTypes,
                        instrumentType,
                        optionType,
                        limit,
                        offset
                ),
                isAutoRetryAfterRatelimit()
        );
    }

    /**
     * Returns the account's trade history
     * @param startTime Entries created prior (less than) to the start time are excluded in UNIX timestamp in nanosecond (default 0)
     * @return {@link TradeHistory}
     * @see <a href="https://api-docs.aevo.xyz/reference/gettradehistory">Aevo - GET Trade History</a>
     */
    public TradeHistory getTradeHistory(
            @NonNull Long startTime
    ) throws NoSuchAlgorithmException, InvalidKeyException, AevoRestException {
        return getTradeHistory(
                startTime,
                null,
                null,
                null,
                null,
                null,
                null,
                null
        );
    }

    /**
     * Returns the account's deposit and withdraw history
     * @param startTime Entries created prior (less than) to the start time are excluded in UNIX timestamp in nanosecond (default 0)
     * @param endTime Entries created after (greater than) the end time are excluded in UNIX timestamp in nanosecond (default current time)
     * @param txType Transaction type to get history for
     * @param txStatus Transaction status to get history for
     * @param limit Limits the number of relevant entries in the response. Defaults to 50. Maximum is 1000.
     * @param offset Offset
     * @return {@link TransactionHistory}
     * @see <a href="https://api-docs.aevo.xyz/reference/gettransactionhistory">Aevo - GET Transaction History</a>
     */
    public TransactionHistory getTransactionHistory(
            @Nullable Long startTime,
            @Nullable Long endTime,
            @Nullable String txType,
            @Nullable String txStatus,
            @Nullable Integer limit,
            @Nullable Integer offset
    ) throws NoSuchAlgorithmException, InvalidKeyException, AevoRestException {
        String timestamp = useSignatures ? AevoHandler.getTimestamp() : null;
        String signature = useSignatures ? AevoHandler.generateAuthSignature(
            Long.parseLong(timestamp),
            apiKey,
            apiSecret,
            "GET",
            "/transaction-history",
            ""
        ) : null;

        return execute(
                getApi().getTransactionHistory(
                        timestamp,
                        signature,
                        apiKey,
                        useSignatures ? null : apiSecret,
                        startTime,
                        endTime,
                        txType,
                        txStatus,
                        limit,
                        offset
                ),
                isAutoRetryAfterRatelimit()
        );
    }

    /**
     * Returns the account's deposit and withdraw history
     * @return {@link TransactionHistory}
     * @see <a href="https://api-docs.aevo.xyz/reference/gettransactionhistory">Aevo - GET Transaction History</a>
     */
    public TransactionHistory getTransactionHistory()
            throws NoSuchAlgorithmException, InvalidKeyException, AevoRestException {
        return getTransactionHistory(
                null,
                null,
                null,
                null,
                null,
                null
        );
    }

    /**
     * Returns the account's referral rewards history
     * @param limit Limits the number of relevant entries in the response. Defaults to 50. Maximum is 1000.
     * @param offset Offset
     * @return {@link ReferralRewardsHistory}
     * @see <a href="https://api-docs.aevo.xyz/reference/getreferralrewardshistory">Aevo - GET Referral Rewards History</a>
     */
    public ReferralRewardsHistory getReferralRewardsHistory(
            @Nullable Integer limit,
            @Nullable Integer offset
    ) throws NoSuchAlgorithmException, InvalidKeyException, AevoRestException {
        String timestamp = useSignatures ? AevoHandler.getTimestamp() : null;
        String signature = useSignatures ? AevoHandler.generateAuthSignature(
            Long.parseLong(timestamp),
            apiKey,
            apiSecret,
            "GET",
            "/referral-rewards-history",
            ""
        ) : null;

        return execute(
                getApi().getReferralRewardsHistory(
                        timestamp,
                        signature,
                        apiKey,
                        useSignatures ? null : apiSecret,
                        limit,
                        offset
                ),
                isAutoRetryAfterRatelimit()
        );
    }
    
    /**
     * Returns the account's referral rewards history
     * @return {@link ReferralRewardsHistory}
     * @see <a href="https://api-docs.aevo.xyz/reference/getreferralrewardshistory">Aevo - GET Referral Rewards History</a>
     */
    public ReferralRewardsHistory getReferralRewardsHistory()
            throws NoSuchAlgorithmException, InvalidKeyException, AevoRestException {
        return getReferralRewardsHistory(
                null,
                null
        );
    }

    /**
     * Returns the account's referral history
     * @param limit Limits the number of relevant entries in the response. Defaults to 50. Maximum is 1000.
     * @param offset Offset
     * @return {@link ReferralHistory}
     * @see <a href="https://api-docs.aevo.xyz/reference/getreferralhistory">Aevo - GET Referral History</a>
     */
    public ReferralHistory getReferralHistory(
            @Nullable Integer limit,
            @Nullable Integer offset
    ) throws NoSuchAlgorithmException, InvalidKeyException, AevoRestException {
        String timestamp = useSignatures ? AevoHandler.getTimestamp() : null;
        String signature = useSignatures ? AevoHandler.generateAuthSignature(
            Long.parseLong(timestamp),
            apiKey,
            apiSecret,
            "GET",
            "/referral-history",
            ""
        ) : null;

        return execute(
                getApi().getReferralHistory(
                        timestamp,
                        signature,
                        apiKey,
                        useSignatures ? null : apiSecret,
                        limit,
                        offset
                ),
                isAutoRetryAfterRatelimit()
        );
    }

    /**
     * Returns the account's referral history
     * @return {@link ReferralHistory}
     * @see <a href="https://api-docs.aevo.xyz/reference/getreferralhistory">Aevo - GET Referral History</a>
     */
    public ReferralHistory getReferralHistory()
            throws NoSuchAlgorithmException, InvalidKeyException, AevoRestException {
        return getReferralHistory(
                null,
                null
        );
    }

    /**
     * Returns the account's referral statistics
     * @return {@link ReferralStatistics}
     * @see <a href="https://api-docs.aevo.xyz/reference/getreferralstatistics">Aevo - GET Referral Statistics</a>
     */
    public ReferralStatistics getReferralStatistics()
            throws NoSuchAlgorithmException, InvalidKeyException, AevoRestException {
        String timestamp = useSignatures ? AevoHandler.getTimestamp() : null;
        String signature = useSignatures ? AevoHandler.generateAuthSignature(
                Long.parseLong(timestamp),
                apiKey,
                apiSecret,
                "GET",
                "/referral-statistics",
                ""
        ) : null;

        return execute(
                getApi().getReferralStatistics(
                        timestamp,
                        signature,
                        apiKey,
                        useSignatures ? null : apiSecret
                ),
                isAutoRetryAfterRatelimit()
        );
    }

    /**
     * Claim referral rewards on this account
     * @return {@link Success}
     * @see <a href="https://api-docs.aevo.xyz/reference/postclaimreferralrewards">Aevo - POST Claim Referral Rewards</a>
     */
    public Success postClaimReferralRewards()
            throws NoSuchAlgorithmException, InvalidKeyException, AevoRestException {
        String timestamp = useSignatures ? AevoHandler.getTimestamp() : null;
        String signature = useSignatures ? AevoHandler.generateAuthSignature(
                Long.parseLong(timestamp),
                apiKey,
                apiSecret,
                "POST",
                "/claim-referral-rewards",
                ""
        ) : null;

        return execute(
                getApi().postClaimReferralRewards(
                        timestamp,
                        signature,
                        apiKey,
                        useSignatures ? null : apiSecret
                ),
                isAutoRetryAfterRatelimit()
        );
    }

    /**
     * Get market maker protection (MMP) setting
     * @param asset Symbol of the underlying asset
     * @return {@link Mmp}
     * @see <a href="https://api-docs.aevo.xyz/reference/getmmp-1">Aevo - GET MMP</a>
     */
    public Mmp getMmp(
            @NonNull String asset
    ) throws NoSuchAlgorithmException, InvalidKeyException, AevoRestException {
        String timestamp = useSignatures ? AevoHandler.getTimestamp() : null;
        String signature = useSignatures ? AevoHandler.generateAuthSignature(
                Long.parseLong(timestamp),
                apiKey,
                apiSecret,
                "GET",
                "/mmp",
                ""
        ) : null;

        return execute(
                getApi().getMmp(
                        timestamp,
                        signature,
                        apiKey,
                        useSignatures ? null : apiSecret,
                        asset
                ),
                isAutoRetryAfterRatelimit()
        );
    }

    /**
     * Sets the market maker protection (MMP) setting
     * @param interval Interval in seconds. If set to 0, MMP is disabled
     * @param frozen Duration in seconds during which the account will be frozen. If set to 0, a manual reset is required
     * @param amountLimit Amount limit setting for MMP. In 6 decimals fixed number
     * @param deltaLimit Delta limit setting for MMP. In unsigned float.
     * @param asset Symbol of the underlying asset
     * @return {@link Success}
     * @see <a href="https://api-docs.aevo.xyz/reference/postmmp-1">Aevo - POST MMP</a>
     */
    public Success postMmp(
            @NonNull Integer interval,
            @NonNull Integer frozen,
            @NonNull String amountLimit,
            @Nullable Float deltaLimit,
            @NonNull String asset
    ) throws NoSuchAlgorithmException, InvalidKeyException, AevoRestException {
        MmpBody body = new MmpBody(
                interval,
                frozen,
                amountLimit,
                deltaLimit,
                asset
        );
        String timestamp = useSignatures ? AevoHandler.getTimestamp() : null;
        String signature = useSignatures ? AevoHandler.generateAuthSignature(
                Long.parseLong(timestamp),
                apiKey,
                apiSecret,
                "POST",
                "/mmp",
                gson.toJson(body)
        ) : null;

        return execute(
                getApi().postMmp(
                        timestamp,
                        signature,
                        apiKey,
                        useSignatures ? null : apiSecret,
                        body
                ),
                isAutoRetryAfterRatelimit()
        );
    }

    /**
     * Sets the market maker protection (MMP) setting
     * @param interval Interval in seconds. If set to 0, MMP is disabled
     * @param frozen Duration in seconds during which the account will be frozen. If set to 0, a manual reset is required
     * @param amountLimit Amount limit setting for MMP. In 6 decimals fixed number
     * @param asset Symbol of the underlying asset
     * @return {@link Success}
     * @see <a href="https://api-docs.aevo.xyz/reference/postmmp-1">Aevo - POST MMP</a>
     */
    public Success postMmp(
            @NonNull Integer interval,
            @NonNull Integer frozen,
            @NonNull String amountLimit,
            @NonNull String asset
    ) throws NoSuchAlgorithmException, InvalidKeyException, AevoRestException {
        return postMmp(
                interval,
                frozen,
                amountLimit,
                null,
                asset
        );
    }

    /**
     * Resets the market maker protection (MMP) setting
     * @param asset Symbol of the underlying asset
     * @return {@link Success}
     * @see <a href="https://api-docs.aevo.xyz/reference/postresetmmp">Aevo - POST Reset MMP</a>
     */
    public Success postResetMmp(
            @NonNull String asset
    ) throws NoSuchAlgorithmException, InvalidKeyException, AevoRestException {
        ResetMmpBody body = new ResetMmpBody(
                asset
        );
        String timestamp = useSignatures ? AevoHandler.getTimestamp() : null;
        String signature = useSignatures ? AevoHandler.generateAuthSignature(
                Long.parseLong(timestamp),
                apiKey,
                apiSecret,
                "POST",
                "/reset-mmp",
                gson.toJson(body)
        ) : null;

        return execute(
                getApi().postResetMmp(
                        timestamp,
                        signature,
                        apiKey,
                        useSignatures ? null : apiSecret,
                        body
                ),
                isAutoRetryAfterRatelimit()
        );
    }

    /**
     * Cancels all the RFQ blocks
     * @return {@link Cancelled}
     * @see <a href="https://api-docs.aevo.xyz/reference/deleterfqs">Aevo - DELETE RFQs</a>
     */
    public Cancelled deleteRfqs()
            throws NoSuchAlgorithmException, InvalidKeyException, AevoRestException {
        String timestamp = useSignatures ? AevoHandler.getTimestamp() : null;
        String signature = useSignatures ? AevoHandler.generateAuthSignature(
                Long.parseLong(timestamp),
                apiKey,
                apiSecret,
                "DELETE",
                "/rfqs",
                ""
        ) : null;

        return execute(
                getApi().deleteRfqs(
                        timestamp,
                        signature,
                        apiKey,
                        useSignatures ? null : apiSecret
                ),
                isAutoRetryAfterRatelimit()
        );
    }

    /**
     * Get RFQ blocks open for trading
     * @param role Role of the account
     * @return {@link RFQBlocks}
     * @see <a href="https://api-docs.aevo.xyz/reference/getrfqs">Aevo - GET RFQs</a>
     */
    public RFQBlocks getRfqs(
            @Nullable String role
    ) throws NoSuchAlgorithmException, InvalidKeyException, AevoRestException {
        String timestamp = useSignatures ? AevoHandler.getTimestamp() : null;
        String signature = useSignatures ? AevoHandler.generateAuthSignature(
                Long.parseLong(timestamp),
                apiKey,
                apiSecret,
                "GET",
                "/rfqs",
                ""
        ) : null;

        return execute(
                getApi().getRfqs(
                        timestamp,
                        signature,
                        apiKey,
                        useSignatures ? null : apiSecret,
                        role
                ),
                isAutoRetryAfterRatelimit()
        );
    }

    /**
     * Get RFQ blocks open for trading
     * @return {@link RFQBlocks}
     * @see <a href="https://api-docs.aevo.xyz/reference/getrfqs">Aevo - GET RFQs</a>
     */
    public RFQBlocks getRfqs() throws NoSuchAlgorithmException, InvalidKeyException, AevoRestException {
        return getRfqs(null);
    }

    /**
     * Creates a new RFQ block
     * @param legs {@link RFQsBody.RFQLeg} to create the RFQ block with
     * @param fullSize Full size if true
     * @param isBuy True if long, false if short
     * @param amount Number of contracts, in 6 decimals fixed number
     * @param duration Duration of the RFQ block in seconds
     * @param counterparties Counterparties allowed to quote for the RFQ block
     * @return {@link RFQBlocks}
     * @see <a href="https://api-docs.aevo.xyz/reference/postrfqs">Aevo - POST RFQs</a>
     */
    public RFQBlocks postRfqs(
            @Nullable RFQsBody.RFQLeg[] legs,
            @Nullable Boolean fullSize,
            @Nullable Boolean isBuy,
            @Nullable String amount,
            @Nullable Long duration,
            @Nullable String[] counterparties
    ) throws NoSuchAlgorithmException, InvalidKeyException, AevoRestException {
        RFQsBody body = new RFQsBody(
                legs,
                fullSize,
                isBuy,
                amount,
                duration,
                counterparties
        );
        String timestamp = useSignatures ? AevoHandler.getTimestamp() : null;
        String signature2 = useSignatures ? AevoHandler.generateAuthSignature(
                Long.parseLong(timestamp),
                apiKey,
                apiSecret,
                "POST",
                "/rfqs",
                gson.toJson(body)
        ) : null;

        return execute(
                getApi().postRfqs(
                        timestamp,
                        signature2,
                        apiKey,
                        useSignatures ? null : apiSecret,
                        body
                ),
                isAutoRetryAfterRatelimit()
        );
    }

    /**
     * Creates a new RFQ block
     * @param body {@link RFQsBody} to create the RFQ block with
     * @return {@link RFQBlocks}
     * @see <a href="https://api-docs.aevo.xyz/reference/postrfqs">Aevo - POST RFQs</a>
     */
    public RFQBlocks postRfqs(
            @NonNull RFQsBody body
    ) throws NoSuchAlgorithmException, InvalidKeyException, AevoRestException {
        String timestamp = useSignatures ? AevoHandler.getTimestamp() : null;
        String signature2 = useSignatures ? AevoHandler.generateAuthSignature(
                Long.parseLong(timestamp),
                apiKey,
                apiSecret,
                "POST",
                "/rfqs",
                gson.toJson(body)
        ) : null;

        return execute(
                getApi().postRfqs(
                        timestamp,
                        signature2,
                        apiKey,
                        useSignatures ? null : apiSecret,
                        body
                ),
                isAutoRetryAfterRatelimit()
        );
    }

    /**
     * Close an RFQ block
     * @param blockId Block ID to close
     * @return {@link Success}
     * @see <a href="https://api-docs.aevo.xyz/reference/deleterfqsblockid">Aevo - DELETE RFQs/{Block ID}</a>
     */
    public Success deleteBlockRfq(
            @NonNull String blockId
    ) throws NoSuchAlgorithmException, InvalidKeyException, AevoRestException {
        String timestamp = useSignatures ? AevoHandler.getTimestamp() : null;
        String signature = useSignatures ? AevoHandler.generateAuthSignature(
                Long.parseLong(timestamp),
                apiKey,
                apiSecret,
                "DELETE",
                "/rfqs/" + blockId,
                ""
        ) : null;

        return execute(
                getApi().deleteBlockRfq(
                        timestamp,
                        signature,
                        apiKey,
                        useSignatures ? null : apiSecret,
                        blockId
                ),
                isAutoRetryAfterRatelimit()
        );
    }

    /**
     * Get the quotes for a given RFQ block
     * @param blockId Block ID to get quotes for
     * @return {@link QuoteOfRfq}
     * @see <a href="https://api-docs.aevo.xyz/reference/getrfqsblockidquotes">Aevo - GET RFQs/{Block ID}/Quotes</a>
     */
    public QuoteOfRfq getBlockRfqQuotes(
            @NonNull String blockId
    ) throws NoSuchAlgorithmException, InvalidKeyException {
        String timestamp = useSignatures ? AevoHandler.getTimestamp() : null;
        String signature2 = useSignatures ? AevoHandler.generateAuthSignature(
                Long.parseLong(timestamp),
                apiKey,
                apiSecret,
                "GET",
                "/rfqs/" + blockId + "/quotes",
                ""
        ) : null;

        return execute(
                getApi().getBlockRfqQuotes(
                        timestamp,
                        signature2,
                        apiKey,
                        useSignatures ? null : apiSecret,
                        blockId
                ),
                isAutoRetryAfterRatelimit()
        );
    }

    /**
     * Cancel multiple quotes
     * @param quoteIds Quote IDs to cancel
     * @param blockId Block ID to cancel quotes for
     * @return {@link Cancelled}
     * @see <a href="https://api-docs.aevo.xyz/reference/deletequotes">Aevo - DELETE Quotes</a>
     */
    public Cancelled deleteQuotes(
            @Nullable String[] quoteIds,
            @Nullable String blockId
    ) throws NoSuchAlgorithmException, InvalidKeyException, AevoRestException {
        String timestamp = useSignatures ? AevoHandler.getTimestamp() : null;
        String signature = useSignatures ? AevoHandler.generateAuthSignature(
            Long.parseLong(timestamp),
            apiKey,
            apiSecret,
            "DELETE",
            "/quotes",
            ""
        ) : null;

        return execute(
                getApi().deleteQuotes(
                        timestamp,
                        signature,
                        apiKey,
                        useSignatures ? null : apiSecret,
                        quoteIds,
                        blockId
                ),
                isAutoRetryAfterRatelimit()
        );
    }

    /**
     * Returns all the account's quotes
     * @return {@link List<Quote>} of {@link Quote}
     * @see <a href="https://api-docs.aevo.xyz/reference/getquotes">Aevo - GET Quotes</a>
     */
    public List<Quote> getQuotes() throws NoSuchAlgorithmException, InvalidKeyException, AevoRestException {
        String timestamp = useSignatures ? AevoHandler.getTimestamp() : null;
        String signature = useSignatures ? AevoHandler.generateAuthSignature(
            Long.parseLong(timestamp),
            apiKey,
            apiSecret,
            "GET",
            "/quotes",
            ""
        ) : null;

        return execute(
                getApi().getQuotes(
                        timestamp,
                        signature,
                        apiKey,
                        useSignatures ? null : apiSecret
                ),
                isAutoRetryAfterRatelimit()
        );
    }

    /**
     * Creates a new quote
     * @param body {@link QuotesBody} to create the quote with
     * @return {@link Quote}
     * @see <a href="https://api-docs.aevo.xyz/reference/postquotes">Aevo - POST Quotes</a>
     */
    public Quote postQuotes(
            @NonNull QuotesBody body
    ) throws NoSuchAlgorithmException, InvalidKeyException, AevoRestException {
        String timestamp = useSignatures ? AevoHandler.getTimestamp() : null;
        String signature = useSignatures ? AevoHandler.generateAuthSignature(
                Long.parseLong(timestamp),
                apiKey,
                apiSecret,
                "POST",
                "/quotes",
                gson.toJson(body)
        ) : null;

        return execute(
                getApi().postQuotes(
                        timestamp,
                        signature,
                        apiKey,
                        useSignatures ? null : apiSecret,
                        body
                ),
                isAutoRetryAfterRatelimit()
        );
    }

    /**
     * Creates a new quote
     * @param blockId Block ID to create the quote for
     * @param account Account's ethereum address
     * @param amount Number of contracts, in 6 decimals fixed number
     * @param isBuy True if long, false if short
     * @param salt Salt for the signature
     * @param timestamp Timestamp for the signature
     * @param signature Hash of the order payload signature signed by the account
     * @param legs Array of {@link QuotesBody.QuoteLeg} to create the quote with
     * @param limitPrice Limit price for the quote
     * @return {@link Quote}
     * @see <a href="https://api-docs.aevo.xyz/reference/postquotes">Aevo - POST Quotes</a>
     */
    public Quote postQuotes(
            @NonNull String blockId,
            @NonNull String account,
            @NonNull String amount,
            boolean isBuy,
            @NonNull String salt,
            @NonNull String timestamp,
            @NonNull String signature,
            @Nullable QuotesBody.QuoteLeg[] legs,
            @Nullable String limitPrice
    ) throws NoSuchAlgorithmException, InvalidKeyException, AevoRestException {
        QuotesBody body = new QuotesBody(
                blockId,
                account,
                amount,
                isBuy,
                salt,
                timestamp,
                signature,
                legs,
                limitPrice
        );
        String timestamp2 = useSignatures ? AevoHandler.getTimestamp() : null;
        String signature2 = useSignatures ? AevoHandler.generateAuthSignature(
                Long.parseLong(timestamp),
                apiKey,
                apiSecret,
                "POST",
                "/quotes",
                gson.toJson(body)
        ) : null;

        return execute(
                getApi().postQuotes(
                        timestamp2,
                        signature2,
                        apiKey,
                        useSignatures ? null : apiSecret,
                        body
                ),
                isAutoRetryAfterRatelimit()
        );
    }

    /**
     * Creates a new quote
     * @param blockId Block ID to create the quote for
     * @param account Account's ethereum address
     * @param amount Number of contracts, in 6 decimals fixed number
     * @param isBuy True if long, false if short
     * @param salt Salt for the signature
     * @param timestamp Timestamp for the signature
     * @param signature Hash of the order payload signature signed by the account
     * @return {@link Quote}
     * @see <a href="https://api-docs.aevo.xyz/reference/postquotes">Aevo - POST Quotes</a>
     */
    public Quote postQuotes(
            @NonNull String blockId,
            @NonNull String account,
            @NonNull String amount,
            boolean isBuy,
            @NonNull String salt,
            @NonNull String timestamp,
            @NonNull String signature
    ) throws NoSuchAlgorithmException, InvalidKeyException, AevoRestException {
        QuotesBody body = new QuotesBody(
                blockId,
                account,
                amount,
                isBuy,
                salt,
                timestamp,
                signature
        );
        String timestamp2 = useSignatures ? AevoHandler.getTimestamp() : null;
        String signature2 = useSignatures ? AevoHandler.generateAuthSignature(
                Long.parseLong(timestamp),
                apiKey,
                apiSecret,
                "POST",
                "/quotes",
                gson.toJson(body)
        ) : null;

        return execute(
                getApi().postQuotes(
                        timestamp2,
                        signature2,
                        apiKey,
                        useSignatures ? null : apiSecret,
                        body
                ),
                isAutoRetryAfterRatelimit()
        );
    }

    /**
     * Simulates a new quote
     * @param body {@link QuotesBody} to simulate the quote with
     * @return {@link Quote}
     * @see <a href="https://api-docs.aevo.xyz/reference/postquotespreview">Aevo - POST Quotes Preview</a>
     */
    public Quote postQuotesPreview(
            @NonNull QuotesBody body
    ) throws NoSuchAlgorithmException, InvalidKeyException, AevoRestException {
        String timestamp = useSignatures ? AevoHandler.getTimestamp() : null;
        String signature = useSignatures ? AevoHandler.generateAuthSignature(
                Long.parseLong(timestamp),
                apiKey,
                apiSecret,
                "POST",
                "/quotes/preview",
                gson.toJson(body)
        ) : null;

        return execute(
                getApi().postQuotesPreview(
                        timestamp,
                        signature,
                        apiKey,
                        useSignatures ? null : apiSecret,
                        body
                ),
                isAutoRetryAfterRatelimit()
        );
    }

    /**
     * Creates a new quote
     * @param blockId Block ID to create the quote for
     * @param account Account's ethereum address
     * @param amount Number of contracts, in 6 decimals fixed number
     * @param isBuy True if long, false if short
     * @param salt Salt for the signature
     * @param timestamp Timestamp for the signature
     * @param signature Hash of the order payload signature signed by the account
     * @param legs Array of {@link QuotesBody.QuoteLeg} to create the quote with
     * @param limitPrice Limit price for the quote
     * @return {@link Quote}
     * @see <a href="https://api-docs.aevo.xyz/reference/postquotespreview">Aevo - POST Quotes Preview</a>
     */
    public Quote postQuotesPreview(
            @NonNull String blockId,
            @NonNull String account,
            @NonNull String amount,
            boolean isBuy,
            @NonNull String salt,
            @NonNull String timestamp,
            @NonNull String signature,
            @Nullable QuotesBody.QuoteLeg[] legs,
            @Nullable String limitPrice
    ) throws NoSuchAlgorithmException, InvalidKeyException, AevoRestException {
        QuotesBody body = new QuotesBody(
                blockId,
                account,
                amount,
                isBuy,
                salt,
                timestamp,
                signature,
                legs,
                limitPrice
        );
        String timestamp2 = useSignatures ? AevoHandler.getTimestamp() : null;
        String signature2 = useSignatures ? AevoHandler.generateAuthSignature(
                Long.parseLong(timestamp),
                apiKey,
                apiSecret,
                "POST",
                "/quotes/preview",
                gson.toJson(body)
        ) : null;

        return execute(
                getApi().postQuotesPreview(
                        timestamp2,
                        signature2,
                        apiKey,
                        useSignatures ? null : apiSecret,
                        body
                ),
                isAutoRetryAfterRatelimit()
        );
    }

    /**
     * Simulates a new quote
     * @param blockId Block ID to create the quote for
     * @param account Account's ethereum address
     * @param amount Number of contracts, in 6 decimals fixed number
     * @param isBuy True if long, false if short
     * @param salt Salt for the signature
     * @param timestamp Timestamp for the signature
     * @param signature Hash of the order payload signature signed by the account
     * @return {@link Quote}
     * @see <a href="https://api-docs.aevo.xyz/reference/postquotespreview">Aevo - POST Quotes Preview</a>
     */
    public Quote postQuotesPreview(
            @NonNull String blockId,
            @NonNull String account,
            @NonNull String amount,
            boolean isBuy,
            @NonNull String salt,
            @NonNull String timestamp,
            @NonNull String signature
    ) throws NoSuchAlgorithmException, InvalidKeyException, AevoRestException {
        QuotesBody body = new QuotesBody(
                blockId,
                account,
                amount,
                isBuy,
                salt,
                timestamp,
                signature
        );
        String timestamp2 = useSignatures ? AevoHandler.getTimestamp() : null;
        String signature2 = useSignatures ? AevoHandler.generateAuthSignature(
                Long.parseLong(timestamp),
                apiKey,
                apiSecret,
                "POST",
                "/quotes/preview",
                gson.toJson(body)
        ) : null;

        return execute(
                getApi().postQuotesPreview(
                        timestamp2,
                        signature2,
                        apiKey,
                        useSignatures ? null : apiSecret,
                        body
                ),
                isAutoRetryAfterRatelimit()
        );
    }

    /**
     * Cancels a quote
     * @param quoteId Quote ID to cancel
     * @return {@link Success}
     * @see <a href="https://api-docs.aevo.xyz/reference/deletequotesquoteid">Aevo - DELETE Quotes/{Quote ID}</a>
     */
    public Success deleteQuotesById(
            @NonNull String quoteId
    ) throws NoSuchAlgorithmException, InvalidKeyException, AevoRestException {
        String timestamp = useSignatures ? AevoHandler.getTimestamp() : null;
        String signature2 = useSignatures ? AevoHandler.generateAuthSignature(
                Long.parseLong(timestamp),
                apiKey,
                apiSecret,
                "DELETE",
                "/quotes/" + quoteId,
                ""
        ) : null;

        return execute(
                getApi().deleteQuotesById(
                        timestamp,
                        signature2,
                        apiKey,
                        useSignatures ? null : apiSecret,
                        quoteId
                ),
                isAutoRetryAfterRatelimit()
        );
    }

    /**
     * Edits an existing quote
     * @param quoteId Quote ID to edit
     * @param body {@link QuotesBody} to edit the quote with
     * @return {@link Quote}
     * @see <a href="https://api-docs.aevo.xyz/reference/putquotesquoteid">Aevo - PUT Quotes/{Quote ID}</a>
     */
    public Quote putQuotesById(
            @NonNull String quoteId,
            @NonNull QuotesBody body
    ) throws NoSuchAlgorithmException, InvalidKeyException, AevoRestException {
        String timestamp = useSignatures ? AevoHandler.getTimestamp() : null;
        String signature2 = useSignatures ? AevoHandler.generateAuthSignature(
                Long.parseLong(timestamp),
                apiKey,
                apiSecret,
                "PUT",
                "/quotes/" + quoteId,
                gson.toJson(body)
        ) : null;

        return execute(
                getApi().putQuotesById(
                        timestamp,
                        signature2,
                        apiKey,
                        useSignatures ? null : apiSecret,
                        quoteId,
                        body
                ),
                isAutoRetryAfterRatelimit()
        );
    }

    /**
     * Edits an existing quote
     * @param quoteId Quote ID to edit
     * @param blockId Block ID to edit the quote for
     * @param account Account's ethereum address
     * @param amount Number of contracts, in 6 decimals fixed number
     * @param isBuy True if long, false if short
     * @param salt Salt for the signature
     * @param timestamp Timestamp for the signature
     * @param signature Hash of the order payload signature signed by the account
     * @param legs Array of {@link QuotesBody.QuoteLeg} to edit the quote with
     * @param limitPrice Limit price for the quote
     * @return {@link Quote}
     * @see <a href="https://api-docs.aevo.xyz/reference/putquotesquoteid">Aevo - PUT Quotes/{Quote ID}</a>
     */
    public Quote putQuotesById(
            @NonNull String quoteId,
            @NonNull String blockId,
            @NonNull String account,
            @NonNull String amount,
            boolean isBuy,
            @NonNull String salt,
            @NonNull String timestamp,
            @NonNull String signature,
            @Nullable QuotesBody.QuoteLeg[] legs,
            @Nullable String limitPrice
    ) throws NoSuchAlgorithmException, InvalidKeyException, AevoRestException {
        QuotesBody body = new QuotesBody(
                blockId,
                account,
                amount,
                isBuy,
                salt,
                timestamp,
                signature,
                legs,
                limitPrice
        );
        String timestamp2 = useSignatures ? AevoHandler.getTimestamp() : null;
        String signature2 = useSignatures ? AevoHandler.generateAuthSignature(
            Long.parseLong(timestamp),
            apiKey,
            apiSecret,
            "PUT",
            "/quotes/" + quoteId,
            gson.toJson(body)
        ) : null;

        return execute(
                getApi().putQuotesById(
                        timestamp2,
                        signature2,
                        apiKey,
                        useSignatures ? null : apiSecret,
                        quoteId,
                        body
                ),
                isAutoRetryAfterRatelimit()
        );
    }

    /**
     * Edits an existing quote
     * @param quoteId Quote ID to edit
     * @param blockId Block ID to edit the quote for
     * @param account Account's ethereum address
     * @param amount Number of contracts, in 6 decimals fixed number
     * @param isBuy True if long, false if short
     * @param salt Salt for the signature
     * @param timestamp Timestamp for the signature
     * @param signature Hash of the order payload signature signed by the account
     * @return {@link Quote}
     * @see <a href="https://api-docs.aevo.xyz/reference/putquotesquoteid">Aevo - PUT Quotes/{Quote ID}</a>
     */
    public Quote putQuotesById(
            @NonNull String quoteId,
            @NonNull String blockId,
            @NonNull String account,
            @NonNull String amount,
            boolean isBuy,
            @NonNull String salt,
            @NonNull String timestamp,
            @NonNull String signature
    ) throws NoSuchAlgorithmException, InvalidKeyException, AevoRestException {
        QuotesBody body = new QuotesBody(
                blockId,
                account,
                amount,
                isBuy,
                salt,
                timestamp,
                signature
        );
        String timestamp2 = useSignatures ? AevoHandler.getTimestamp() : null;
        String signature2 = useSignatures ? AevoHandler.generateAuthSignature(
                Long.parseLong(timestamp),
                apiKey,
                apiSecret,
                "PUT",
                "/quotes/" + quoteId,
                gson.toJson(body)
        ) : null;

        return execute(
                getApi().putQuotesById(
                        timestamp2,
                        signature2,
                        apiKey,
                        useSignatures ? null : apiSecret,
                        quoteId,
                        body
                ),
                isAutoRetryAfterRatelimit()
        );
    }

    /**
     * Submits a swap
     * @param collateralAsset Name of the collateral asset
     * @param isBuy True for long, false for short
     * @param baseAmount The collateral amount. In 6 decimals fixed number for USDT, 18 decimals for WETH, and 8 decimals for WBTC
     * @param quoteAmount Amount of USDC in 6 decimals fixed number
     * @return {@link Swap}
     * @see <a href="https://api-docs.aevo.xyz/reference/postswap">Aevo - POST Swap</a>
     */
    public Swap postSwap(
            @NonNull String collateralAsset,
            @Nullable Boolean isBuy,
            @Nullable String baseAmount,
            @Nullable Long quoteAmount
    ) throws NoSuchAlgorithmException, InvalidKeyException, AevoRestException {
        SwapBody body = new SwapBody(
                collateralAsset,
                isBuy,
                baseAmount,
                quoteAmount
        );

        return postSwap(body);
    }

    /**
     * Submits a swap
     * @param body {@link SwapBody} to submit the swap with
     * @return {@link Swap}
     * @see <a href="https://api-docs.aevo.xyz/reference/postswap">Aevo - POST Swap</a>
     */
    public Swap postSwap(
            @NonNull SwapBody body
    ) throws NoSuchAlgorithmException, InvalidKeyException, AevoRestException {
        String timestamp = useSignatures ? AevoHandler.getTimestamp() : null;
        String signature = useSignatures ? AevoHandler.generateAuthSignature(
                Long.parseLong(timestamp),
                apiKey,
                apiSecret,
                "POST",
                "/swap",
                gson.toJson(body)
        ) : null;

        return execute(
                getApi().postSwap(
                        timestamp,
                        signature,
                        apiKey,
                        useSignatures ? null : apiSecret,
                        body
                ),
                isAutoRetryAfterRatelimit()
        );
    }

    /**
     * Simulates a new swap
     * @param body {@link SwapBody} to simulate the swap with
     * @return {@link SwapPreview}
     * @see <a href="https://api-docs.aevo.xyz/reference/postswappreview">Aevo - POST Swap Preview</a>
     */
    public SwapPreview postSwapPreview(
            @NonNull SwapBody body
    ) throws NoSuchAlgorithmException, InvalidKeyException, AevoRestException {
        String timestamp = useSignatures ? AevoHandler.getTimestamp() : null;
        String signature = useSignatures ? AevoHandler.generateAuthSignature(
                Long.parseLong(timestamp),
                apiKey,
                apiSecret,
                "POST",
                "/swap/preview",
                gson.toJson(body)
        ) : null;

        return execute(
                getApi().postSwapPreview(
                        timestamp,
                        signature,
                        apiKey,
                        useSignatures ? null : apiSecret,
                        body
                ),
                isAutoRetryAfterRatelimit()
        );
    }

    /**
     * Simulates a new swap
     * @param collateralAsset Name of the collateral asset
     * @param isBuy True for long, false for short
     * @param baseAmount The collateral amount. In 6 decimals fixed number for USDT, 18 decimals for WETH, and 8 decimals for WBTC
     * @param quoteAmount Amount of USDC in 6 decimals fixed number
     * @return {@link SwapPreview}
     * @see <a href="https://api-docs.aevo.xyz/reference/postswappreview">Aevo - POST Swap Preview</a>
     */
    public SwapPreview postSwapPreview(
            @NonNull String collateralAsset,
            @Nullable Boolean isBuy,
            @Nullable String baseAmount,
            @Nullable Long quoteAmount
    ) throws NoSuchAlgorithmException, InvalidKeyException, AevoRestException {
        SwapBody body = new SwapBody(
                collateralAsset,
                isBuy,
                baseAmount,
                quoteAmount
        );

        return postSwapPreview(body);
    }
}
