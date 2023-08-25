import dev.alphaserpentis.web3.aevo4j.handler.AevoHandler;
import dev.alphaserpentis.web3.aevo4j.services.PrivateService;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class PrivateRestAPITests {

    public static void main(String[] args)
            throws NoSuchAlgorithmException, InvalidKeyException, IOException {
        if(args.length != 4) {
            throw new IllegalArgumentException("Please provide the API Key, API Secret, true/false to use signatures, and Aevo signing key as arguments");
        }

        PrivateService service = AevoHandler.getPrivateService(
                AevoHandler.defaultRetrofit(true),
                args[0],
                args[1],
                Boolean.parseBoolean(args[2])
        );
    }
}
