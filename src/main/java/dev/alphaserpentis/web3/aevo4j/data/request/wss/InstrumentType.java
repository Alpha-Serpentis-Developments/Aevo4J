package dev.alphaserpentis.web3.aevo4j.data.request.wss;

import com.google.gson.annotations.SerializedName;

public class InstrumentType {
    @SerializedName("instrument_type")
    public String instrumentType;

    public InstrumentType(String instrumentType) {
        this.instrumentType = instrumentType;
    }
}
