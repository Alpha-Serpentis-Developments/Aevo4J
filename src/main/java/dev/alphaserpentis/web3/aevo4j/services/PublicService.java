package dev.alphaserpentis.web3.aevo4j.services;

import dev.alphaserpentis.web3.aevo4j.api.endpoints.rest.PublicEndpoints;
import dev.alphaserpentis.web3.aevo4j.data.request.rest.AccountBody;
import dev.alphaserpentis.web3.aevo4j.data.response.common.Index;
import dev.alphaserpentis.web3.aevo4j.data.response.common.Orderbook;
import dev.alphaserpentis.web3.aevo4j.data.response.common.Trade;
import dev.alphaserpentis.web3.aevo4j.data.response.rest.CheckReferral;
import dev.alphaserpentis.web3.aevo4j.data.response.rest.CoinGeckoStats;
import dev.alphaserpentis.web3.aevo4j.data.response.rest.Funding;
import dev.alphaserpentis.web3.aevo4j.data.response.rest.FundingHistory;
import dev.alphaserpentis.web3.aevo4j.data.response.rest.IndexHistory;
import dev.alphaserpentis.web3.aevo4j.data.response.rest.InstrumentInfo;
import dev.alphaserpentis.web3.aevo4j.data.response.rest.MarkHistory;
import dev.alphaserpentis.web3.aevo4j.data.response.rest.Markets;
import dev.alphaserpentis.web3.aevo4j.data.response.common.Option;
import dev.alphaserpentis.web3.aevo4j.data.response.rest.SettlementHistory;
import dev.alphaserpentis.web3.aevo4j.data.response.rest.Statistics;
import dev.alphaserpentis.web3.aevo4j.data.response.rest.Success;
import dev.alphaserpentis.web3.aevo4j.data.response.rest.Time;
import dev.alphaserpentis.web3.aevo4j.exception.AevoRestException;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;

import java.util.List;

public class PublicService extends AbstractService<PublicEndpoints> {
    public PublicService(@NonNull PublicEndpoints api) {
        super(api);
    }

    /**
     * Get a list of active underlying assets
     * @return A list of active underlying assets
     * @see <a href="https://api-docs.aevo.xyz/reference/getassets">Aevo - GET Assets</a>
     */
    public List<String> getAssets() throws AevoRestException {
        return execute(
                getApi().getAssets()
        );
    }

    /**
     * Get a list of active expiries for an underlying asset
     * @param asset The underlying asset
     * @return A list of active expiries for an underlying asset
     * @see <a href="https://api-docs.aevo.xyz/reference/getexpiries">Aevo - GET Expiries</a>
     */
    public List<String> getExpiries(
            @NonNull String asset
    ) throws AevoRestException {
        return execute(
                getApi().getExpiries(
                        asset
                )
        );
    }

    /**
     * Get the current index price for the given asset
     * @param asset Name of the underlying asset
     * @return The current index price for an underlying asset
     * @see <a href="https://api-docs.aevo.xyz/reference/getindex">Aevo - GET Index</a>
     */
    public Index getIndex(
            @NonNull String asset
    ) throws AevoRestException {
        return execute(
                getApi().getIndex(
                        asset
                )
        );
    }

    /**
     * Get the historical index prices for the given asset. Defaults to 30 second resolution, start time of 0 nanoseconds, and end time of current time
     * @param asset Name of the underlying asset
     * @return The historical index prices for the given asset
     * @see <a href="https://api-docs.aevo.xyz/reference/getindexhistory">Aevo - GET Index History</a>
     */
    public IndexHistory getIndexHistory(
            @NonNull String asset
    ) throws AevoRestException {
        return getIndexHistory(
                asset,
                null,
                null,
                null
        );
    }

    /**
     * Get the historical index prices for the given asset
     * @param asset Name of the underlying asset
     * @param resolution Interval between entries in seconds. Must be a multiple of 30. Defaults to 30
     * @param startTime Entries created prior to start time are excluded from the result in nanoseconds. Defaults to 0
     * @param endTime Entries created after end time are excluded from the result in nanoseconds. Defaults to current time
     * @return The historical index prices for the given asset
     * @see <a href="https://api-docs.aevo.xyz/reference/getindexhistory">Aevo - GET Index History</a>
     */
    public IndexHistory getIndexHistory(
            @NonNull String asset,
            @Nullable Integer resolution,
            @Nullable Integer startTime,
            @Nullable Integer endTime
    ) throws AevoRestException {
        return execute(
                getApi().getIndexHistory(
                        asset,
                        resolution,
                        startTime,
                        endTime
                )
        );
    }

    /**
     * Get the historical mark prices for the given instrument. Defaults to 30 second resolution, start time of 0 nanoseconds, and end time of current time
     * @param instrumentName Name of the instrument
     * @return The historical mark prices for the given instrument
     * @see <a href="https://api-docs.aevo.xyz/reference/getmarkhistory">Aevo - GET Mark History</a>
     */
    public MarkHistory getMarkHistory(
            @NonNull String instrumentName
    ) throws AevoRestException {
        return getMarkHistory(
                instrumentName,
                null,
                null,
                null,
                null
        );
    }

    /**
     * Get the historical mark prices for the given instrument
     * @param instrumentName Name of the instrument
     * @param resolution Interval between entries in seconds. Must be a multiple of 30. Defaults to 30
     * @param limit Maximum number of entries to return. Defaults to 50. Maximum is 1000
     * @param startTime Entries created prior to start time are excluded from the result in nanoseconds. Defaults to 0
     * @param endTime Entries created after end time are excluded from the result in nanoseconds. Defaults to current time
     * @return The historical mark prices for the given instrument
     * @see <a href="https://api-docs.aevo.xyz/reference/getmarkhistory">Aevo - GET Mark History</a>
     */
    public MarkHistory getMarkHistory(
            @NonNull String instrumentName,
            @Nullable Integer resolution,
            @Nullable Integer limit,
            @Nullable Integer startTime,
            @Nullable Integer endTime
    ) throws AevoRestException {
        return execute(
                getApi().getMarkHistory(
                        instrumentName,
                        resolution,
                        limit,
                        startTime,
                        endTime
                )
        );
    }

    /**
     * Get the historical settlement prices for the given asset. Defaults to start time of 0 nanoseconds, end time of current time, and limit of 50 entries
     * @return The historical settlement prices for the given asset
     * @see <a href="https://api-docs.aevo.xyz/reference/getsettlementhistory">Aevo - GET Settlement History</a>
     */
    public List<SettlementHistory> getSettlementHistory() throws AevoRestException {
        return getSettlementHistory(
                null,
                null,
                null,
                null
        );
    }

    /**
     * Get the historical settlement prices for the given asset
     * @param asset Name of the underlying asset
     * @param startTime Entries created prior to start time are excluded from the result in nanoseconds. Defaults to 0
     * @param endTime Entries created after end time are excluded from the result in nanoseconds. Defaults to current time
     * @param limit Maximum number of entries to return. Defaults to 50. Maximum is 1000
     * @return The historical settlement prices for the given asset
     * @see <a href="https://api-docs.aevo.xyz/reference/getsettlementhistory">Aevo - GET Settlement History</a>
     */
    public List<SettlementHistory> getSettlementHistory(
            @Nullable String asset,
            @Nullable Integer startTime,
            @Nullable Integer endTime,
            @Nullable Integer limit
    ) throws AevoRestException {
        return execute(
                getApi().getSettlementHistory(
                        asset,
                        startTime,
                        endTime,
                        limit
                )
        );
    }

    /**
     * Returns a list of instruments. Defaults to all listed instruments
     * @return A list of instruments
     * @see <a href="https://api-docs.aevo.xyz/reference/getmarkets">Aevo - GET Markets</a>
     */
    public List<Markets> getMarkets() throws AevoRestException {
        return getMarkets(
                null,
                null
        );
    }

    /**
     * Returns a list of instruments
     * @param asset Name of the underlying asset
     * @param instrumentType Type of instrument. Defaults to all listed instruments
     * @return A list of instruments
     * @see <a href="https://api-docs.aevo.xyz/reference/getmarkets">Aevo - GET Markets</a>
     */
    public List<Markets> getMarkets(
            @Nullable String asset,
            @Nullable String instrumentType
    ) throws AevoRestException {
        return execute(
                getApi().getMarkets(
                        asset,
                        instrumentType
                )
        );
    }

    /**
     * Returns the market statistics for the entirety of Aevo
     * @return The market statistics for the entirety of Aevo
     * @see <a href="https://api-docs.aevo.xyz/reference/getstatistics">Aevo - GET Statistics</a>
     */
    public Statistics getStatistics() throws AevoRestException {
        return getStatistics(
                null,
                null,
                null
        );
    }

    /**
     * Returns the market statistics for the given asset
     * @param asset Name of the underlying asset
     * @param instrumentType Type of instrument
     * @param endTime Entries created after end time are excluded from the result in nanoseconds
     * @return The market statistics for the given asset
     * @see <a href="https://api-docs.aevo.xyz/reference/getstatistics">Aevo - GET Statistics</a>
     */
    public Statistics getStatistics(
            @Nullable String asset,
            @Nullable String instrumentType,
            @Nullable Integer endTime
    ) throws AevoRestException {
        return execute(
                getApi().getStatistics(
                        asset,
                        instrumentType,
                        endTime
                )
        );
    }

    /**
     * Returns the statistics of all the assets, specifically for CoinGecko
     * @return {@link List<CoinGeckoStats>}
     * @see <a href="https://api-docs.aevo.xyz/reference/getcoingeckostatistics">Aevo - GET CoinGecko Statistics</a>
     */
    public List<CoinGeckoStats> getCoinGeckoStatistics() throws AevoRestException {
        return execute(
            getApi().getCoinGeckoStatistics()
        );
    }

    /**
     * Returns the orderbook for the given instrument
     * @param instrumentName Name of the instrument
     * @return The orderbook for the given instrument
     * @see <a href="https://api-docs.aevo.xyz/reference/getorderbook">Aevo - GET Orderbook</a>
     */
    public Orderbook getOrderbook(
            @NonNull String instrumentName
    ) throws AevoRestException {
        return execute(
                getApi().getOrderbook(
                        instrumentName
                )
        );
    }

    /**
     * Returns the current funding rate for the given instrument
     * @param instrumentName Name of the instrument
     * @return The current funding rate for the given instrument
     * @see <a href="https://api-docs.aevo.xyz/reference/getfunding">Aevo - GET Funding</a>
     */
    public Funding getFunding(
            @NonNull String instrumentName
    ) throws AevoRestException {
        return execute(
                getApi().getFunding(
                        instrumentName
                )
        );
    }

    /**
     * Returns the funding history for the given instrument. Defaults to start time of 0 nanoseconds and end time of current time
     * @return The funding history for the given instrument
     * @see <a href="https://api-docs.aevo.xyz/reference/getfundinghistory">Aevo - GET Funding History</a>
     */
    public FundingHistory getFundingHistory() throws AevoRestException {
        return getFundingHistory(
                null,
                null,
                null
        );
    }

    /**
     * Returns the funding history for the given instrument
     * @param instrumentName Name of the instrument
     * @param startTime Entries created prior to start time are excluded from the result in nanoseconds. Defaults to 0
     * @param endTime Entries created after end time are excluded from the result in nanoseconds. Defaults to current time
     * @return The funding history for the given instrument
     * @see <a href="https://api-docs.aevo.xyz/reference/getfundinghistory">Aevo - GET Funding History</a>
     */
    public FundingHistory getFundingHistory(
            @Nullable String instrumentName,
            @Nullable Integer startTime,
            @Nullable Integer endTime
    ) throws AevoRestException {
        return execute(
                getApi().getFundingHistory(
                        instrumentName,
                        startTime,
                        endTime
                )
        );
    }

    /**
     * Returns the instrument information for the given instrument
     * @param instrumentName Name of the instrument
     * @return The instrument information for the given instrument
     * @see <a href="https://api-docs.aevo.xyz/reference/getinstrumentinstrumentname">Aevo - GET Instrument/{instrument_name}</a>
     */
    public InstrumentInfo getInstrumentInformation(
            @NonNull String instrumentName
    ) throws AevoRestException {
        return execute(
                getApi().getInstrumentInformation(
                        instrumentName
                )
        );
    }

    /**
     * Returns the trade history for the given instrument. Defaults to start time of 0 nanoseconds and end time of current time
     * @param instrumentName Name of the instrument
     * @return The trade history for the given instrument
     * @see <a href="https://api-docs.aevo.xyz/reference/getinstrumentinstrumentnametradehistory">Aevo - GET Instrument/{instrument_name}/Trade-History</a>
     */
    public List<Trade> getInstrumentTradeHistory(
            @NonNull String instrumentName
    ) throws AevoRestException {
        return getInstrumentTradeHistory(
                instrumentName,
                null,
                null
        );
    }

    /**
     * Returns the trade history for the given instrument
     * @param instrumentName Name of the instrument
     * @param startTime Entries created prior to start time are excluded from the result in nanoseconds. Defaults to 0
     * @param endTime Entries created after end time are excluded from the result in nanoseconds. Defaults to current time
     * @return The trade history for the given instrument
     * @see <a href="https://api-docs.aevo.xyz/reference/getinstrumentinstrumentnametradehistory">Aevo - GET Instrument/{instrument_name}/Trade-History</a>
     */
    public List<Trade> getInstrumentTradeHistory(
            @NonNull String instrumentName,
            @Nullable Integer startTime,
            @Nullable Integer endTime
    ) throws AevoRestException {
        return execute(
                getApi().getInstrumentTradeHistory(
                        instrumentName,
                        startTime,
                        endTime
                )
        );
    }

    /**
     * Check if a user can be referred
     * @param account Ethereum address
     * @param referralCode Referral code (username of the referrer) of the new account registration
     * @return {@link CheckReferral} indicating if the user can be referred
     * @see <a href="https://api-docs.aevo.xyz/reference/getcheckreferral">Aevo - GET Check Referral</a>
     */
    public CheckReferral getCheckReferral(
            @NonNull String account,
            @NonNull String referralCode
    ) throws AevoRestException {
        return execute(
                getApi().getCheckReferral(
                        account,
                        referralCode
                )
        );
    }

    /**
     * Unsubscribe an account from all emails
     * @param account Ethereum address
     * @param authTokenEmail Email verification token
     * @return {@link Success}
     * @see <a href="https://api-docs.aevo.xyz/reference/postaccountunsubscribe">Aevo - POST Account Unsubscribe</a>
     */
    public Success postAccountUnsubscribe(
            @NonNull String account,
            @NonNull String authTokenEmail
    ) throws AevoRestException {
        return execute(
                getApi().postAccountUnsubscribe(
                        new AccountBody(
                                account,
                                authTokenEmail
                        )
                )
        );
    }

    /**
     * Returns the server time
     * @return {@link Time}
     * @see <a href="https://api-docs.aevo.xyz/reference/gettime">Aevo - GET Time</a>
     */
    public Time getTime() throws AevoRestException {
        return execute(
            getApi().getTime()
        );
    }

    /**
     * Returns the options history for the group of instruments. Defaults to start time of 0 nanoseconds, end time of current time, and limit of 50 entries
     * @param asset Name of the underlying asset
     * @return The options history for the group of instruments
     * @see <a href="https://api-docs.aevo.xyz/reference/getoptionshistory">Aevo - GET Options History</a>
     */
    public List<Option> getOptionsHistory(
            @NonNull String asset
    ) throws AevoRestException {
        return getOptionsHistory(
                asset,
                null,
                null,
                null,
                null,
                null
        );
    }

    /**
     * Returns the trade history for the group of instruments
     * @param asset Name of the underlying asset
     * @param startTime Entries created prior to start time are excluded from the result in nanoseconds. Defaults to 0
     * @param endTime Entries created after end time are excluded from the result in nanoseconds. Defaults to current time
     * @param optionType Type of option
     * @param offset Offset
     * @param limit Maximum number of entries to return. Defaults to 50. Maximum is 1000
     * @return The trade history for the group of instruments
     * @see <a href="https://api-docs.aevo.xyz/reference/getoptionshistory">Aevo - GET Options History</a>
     */
    public List<Option> getOptionsHistory(
            @NonNull String asset,
            @Nullable Integer startTime,
            @Nullable Integer endTime,
            @Nullable String optionType,
            @Nullable Integer offset,
            @Nullable Integer limit
    ) throws AevoRestException {
        return execute(
                getApi().getOptionsHistory(
                        asset,
                        startTime,
                        endTime,
                        optionType,
                        offset,
                        limit
                )
        );
    }

    /**
     * Verify an account's email
     * @param account Ethereum address
     * @param authTokenEmail Email verification token
     * @return {@link Success}
     */
    public Success postEmailVerified(
        @NonNull String account,
        @NonNull String authTokenEmail
    ) throws AevoRestException {
        return execute(
            getApi().postEmailVerified(
                new AccountBody(
                    account,
                    authTokenEmail
                )
            )
        );
    }
}
