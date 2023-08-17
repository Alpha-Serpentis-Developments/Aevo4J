package dev.alphaserpentis.web3.aevo4j.services;

import dev.alphaserpentis.web3.aevo4j.api.endpoints.rest.PrivateEndpoints;
import io.reactivex.rxjava3.annotations.NonNull;

public class PrivateService extends AbstractService<PrivateEndpoints> {
    public PrivateService(@NonNull PrivateEndpoints api) {
        super(api);
    }
}
