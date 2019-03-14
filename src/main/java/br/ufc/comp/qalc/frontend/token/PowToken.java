package br.ufc.comp.qalc.frontend.token;

public class PowToken extends Token {

    public PowToken(long line, long start) {
        super(line, start, "^");
    }

    public String getFunctionIdentifier() {
        interpretAttributes();

        return stringValue;
    }


    @Override
    public String getTokenIdentifier() {
        return "POW";
    }
}