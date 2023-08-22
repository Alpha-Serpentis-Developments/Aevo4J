import dev.alphaserpentis.web3.aevo4j.data.response.rest.Account;
import dev.alphaserpentis.web3.aevo4j.exception.AevoRestException;
import dev.alphaserpentis.web3.aevo4j.handler.AevoHandler;
import dev.alphaserpentis.web3.aevo4j.services.PrivateService;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class PrivateRestAPITests {

    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException, AevoRestException {
        // Check if the first two args are filled out
        if(args.length != 3) {
            throw new IllegalArgumentException("Please provide the API Key, API Secret, and true/false to use signatures as arguments");
        }

        PrivateService service = AevoHandler.getPrivateService(
                AevoHandler.defaultRetrofit(false),
                args[0],
                args[1],
                !Boolean.parseBoolean(args[2])
        );
        Account account = service.getAccount();

        System.out.printf(
                """
                Account: %s
                Username: %s
                Equity: $%s
                Available Balance: $%s
                Balance: $%s
                Account Signing Keys: %s
                Collaterals: %s
                API Keys: %s
                Positions: %s
                """,
                account.getAccount(),
                account.getUsername(),
                account.getEquity(),
                account.getAvailableBalance(),
                account.getBalance(),
                Arrays.toString(account.getSigningKeys()),
                Arrays.toString(account.getCollaterals()),
                Arrays.toString(account.getApiKeys()),
                Arrays.toString(account.getPositions())
        );
    }
}
