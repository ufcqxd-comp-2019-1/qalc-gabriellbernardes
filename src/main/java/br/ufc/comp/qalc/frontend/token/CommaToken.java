package br.ufc.comp.qalc.frontend.token;

public class CommaToken extends Token {
    public CommaToken(long line, long start) {
        super(line, start, ",");
    }

    public String getFunctionIdentifier() {
        interpretAttributes();

        return stringValue;
    }


    @Override
    public String getTokenIdentifier() {
        return "COMMA";
    }
}
