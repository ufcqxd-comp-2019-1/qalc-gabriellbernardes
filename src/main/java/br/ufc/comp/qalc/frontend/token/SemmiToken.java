package br.ufc.comp.qalc.frontend.token;

public class SemmiToken extends Token {
    public SemmiToken(long line, long start) {
        super(line, start, ";");
    }

    public String getFunctionIdentifier() {
        interpretAttributes();

        return stringValue;
    }


    @Override
    public String getTokenIdentifier() {
        return "SEMMI";
    }
}
