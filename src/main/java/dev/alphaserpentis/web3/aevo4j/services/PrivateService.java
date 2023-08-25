package dev.alphaserpentis.web3.aevo4j.services;

import com.google.gson.Gson;
import dev.alphaserpentis.web3.aevo4j.api.endpoints.rest.PrivateEndpoints;
import dev.alphaserpentis.web3.aevo4j.data.request.rest.DeleteApiKeyBody;
import dev.alphaserpentis.web3.aevo4j.data.request.rest.EmailAddressBody;
import dev.alphaserpentis.web3.aevo4j.data.request.rest.EmailPreferenceBody;
import dev.alphaserpentis.web3.aevo4j.data.request.rest.EnabledBody;
import dev.alphaserpentis.web3.aevo4j.data.request.rest.MmpBody;
import dev.alphaserpentis.web3.aevo4j.data.request.rest.OrdersAllBody;
import dev.alphaserpentis.web3.aevo4j.data.request.rest.OrdersBody;
import dev.alphaserpentis.web3.aevo4j.data.request.rest.PostApiKeyBody;
import dev.alphaserpentis.web3.aevo4j.data.request.rest.RegisterBody;
import dev.alphaserpentis.web3.aevo4j.data.request.rest.ResetMmpBody;
import dev.alphaserpentis.web3.aevo4j.data.request.rest.SigningKeyBody;
import dev.alphaserpentis.web3.aevo4j.data.request.rest.TransferBody;
import dev.alphaserpentis.web3.aevo4j.data.request.rest.WithdrawBody;
import dev.alphaserpentis.web3.aevo4j.data.response.rest.Account;
import dev.alphaserpentis.web3.aevo4j.data.response.rest.ApiKeyData;
import dev.alphaserpentis.web3.aevo4j.data.response.rest.CancelledOrders;
import dev.alphaserpentis.web3.aevo4j.data.response.rest.EmailAddress;
import dev.alphaserpentis.web3.aevo4j.data.response.rest.EmailPreferences;
import dev.alphaserpentis.web3.aevo4j.data.response.rest.EmailVerified;
import dev.alphaserpentis.web3.aevo4j.data.response.rest.Enabled;
import dev.alphaserpentis.web3.aevo4j.data.response.rest.Mmp;
import dev.alphaserpentis.web3.aevo4j.data.response.rest.Order;
import dev.alphaserpentis.web3.aevo4j.data.response.rest.OrderHistory;
import dev.alphaserpentis.web3.aevo4j.data.response.rest.OrderId;
import dev.alphaserpentis.web3.aevo4j.data.response.rest.Portfolio;
import dev.alphaserpentis.web3.aevo4j.data.response.rest.PostRegister;
import dev.alphaserpentis.web3.aevo4j.data.response.rest.ReferralHistory;
import dev.alphaserpentis.web3.aevo4j.data.response.rest.ReferralRewardsHistory;
import dev.alphaserpentis.web3.aevo4j.data.response.rest.ReferralStatistics;
import dev.alphaserpentis.web3.aevo4j.data.response.rest.Success;
import dev.alphaserpentis.web3.aevo4j.data.response.rest.TradeHistory;
import dev.alphaserpentis.web3.aevo4j.data.response.rest.TransactionHistory;
import dev.alphaserpentis.web3.aevo4j.exception.AevoRestException;
import dev.alphaserpentis.web3.aevo4j.handler.AevoHandler;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class PrivateService extends AbstractService<PrivateEndpoints> {
    protected Gson gson = new Gson();
    private String apiKey = null;
    private String apiSecret = null;
    private boolean useSignatures = false;

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
                )
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
                )
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
                )
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
                )
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
                )
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
                )
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
                )
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
                )
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
                )
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
                )
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
                )
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
                )
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
                )
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
                )
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
                )
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
                )
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
                )
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
    ) throws NoSuchAlgorithmException, InvalidKeyException, AevoRestException {
        TransferBody body = new TransferBody(
                account,
                collateral,
                to,
                amount,
                salt,
                signature
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
                )
        );
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
                )
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
     * @return {@link Order}
     * @see <a href="https://api-docs.aevo.xyz/reference/postorders">Aevo - POST Orders</a>
     */
    public Order postOrders(
            @NonNull Integer instrument,
            @NonNull String maker,
            boolean isBuy,
            @NonNull String amount,
            @NonNull String limitPrice,
            @NonNull String salt,
            @NonNull String signature,
            @NonNull String timestamp,
            @Nullable Boolean postOnly,
            @Nullable Boolean reduceOnly,
            @Nullable String timeInForce,
            @Nullable Boolean mmp,
            @Nullable String stop,
            @Nullable String trigger
    ) throws NoSuchAlgorithmException, InvalidKeyException, AevoRestException {
        OrdersBody body = new OrdersBody(
                instrument,
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
                trigger
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
                )
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
            @NonNull String amount,
            @NonNull String limitPrice,
            @NonNull String salt,
            @NonNull String signature,
            @NonNull String timestamp
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
                null
        );
    }

    /**
     * Creates a new order
     * @param body {@link OrdersBody} to create the order with
     * @return {@link Order}
     * @see <a href="https://api-docs.aevo.xyz/reference/postorders">Aevo - POST Orders</a>
     */
    public Order postOrders(
            @NonNull OrdersBody body
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
                )
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
                )
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
     * @return {@link Order}
     * @see <a href="https://api-docs.aevo.xyz/reference/postordersorderid">Aevo - POST Orders/{Order ID}</a>
     */
    public Order postEditOrder(
            @NonNull String orderId,
            @NonNull Integer instrument,
            @NonNull String maker,
            boolean isBuy,
            @NonNull String amount,
            @NonNull String limitPrice,
            @NonNull String salt,
            @NonNull String signature,
            @NonNull String timestamp,
            @Nullable Boolean postOnly,
            @Nullable Boolean reduceOnly,
            @Nullable String timeInForce,
            @Nullable Boolean mmp,
            @Nullable String stop,
            @Nullable String trigger
    ) throws NoSuchAlgorithmException, InvalidKeyException, AevoRestException {
        OrdersBody body = new OrdersBody(
                instrument,
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
                trigger
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
                )
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
            @NonNull String amount,
            @NonNull String limitPrice,
            @NonNull String salt,
            @NonNull String signature,
            @NonNull String timestamp
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
                null
        );
    }

    /**
     * Edits an existing order
     * @param orderId Order ID to edit
     * @param body {@link OrdersBody} to edit the order with
     * @return {@link Order}
     * @see <a href="https://api-docs.aevo.xyz/reference/postordersorderid">Aevo - POST Orders/{Order ID}</a>
     */
    public Order postEditOrder(
            @NonNull String orderId,
            @NonNull OrdersBody body
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
                )
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
            ""
        ) : null;

        return execute(
                getApi().deleteOrdersAll(
                        timestamp,
                        signature,
                        apiKey,
                        useSignatures ? null : apiSecret,
                        body
                )
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
     * @param startTime Entries created prior (<) to the start time are excluded in UNIX timestamp in nanosecond (default 0)
     * @param endTime Entries created after (>) the end time are excluded in UNIX timestamp in nanosecond (default current time)
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
                )
        );
    }

    /**
     * Returns the order history of the account
     * @param startTime Entries created prior (<) to the start time are excluded in UNIX timestamp in nanosecond (default 0)
     * @param endTime Entries created after (>) the end time are excluded in UNIX timestamp in nanosecond (default current time)
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
     * @param startTime Entries created prior (<) to the start time are excluded in UNIX timestamp in nanosecond (default 0)
     * @param asset Asset to get trade history for
     * @param endTime Entries created after (>) the end time are excluded in UNIX timestamp in nanosecond (default current time)
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
                )
        );
    }

    /**
     * Returns the account's trade history
     * @param startTime Entries created prior (<) to the start time are excluded in UNIX timestamp in nanosecond (default 0)
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
     * @param startTime Entries created prior (<) to the start time are excluded in UNIX timestamp in nanosecond (default 0)
     * @param endTime Entries created after (>) the end time are excluded in UNIX timestamp in nanosecond (default current time)
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
                )
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
                )
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
                )
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
                )
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
                )
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
                )
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
                )
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
                )
        );
    }
}
