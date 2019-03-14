package br.ufc.comp.qalc.frontend.token;

public class PlusToken extends Token {
    public PlusToken(long line, long start) {
        super(line, start, "+");
    }

    public String getFunctionIdentifier() {
        interpretAttributes();

        return stringValue;

    }

    public String getTokenIdentifier() {
        return "PLUS";
    }
}

