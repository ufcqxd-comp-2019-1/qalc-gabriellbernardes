package br.ufc.comp.qalc.frontend.token;

public class MinusToken extends Token {

    public MinusToken(long line, long start) {
        super(line, start, "-");
    }

    public String getFunctionIdentifier() {
        interpretAttributes();

        return stringValue;
    }


    @Override
    public String getTokenIdentifier() {
        return "MINUS";
    }
}
