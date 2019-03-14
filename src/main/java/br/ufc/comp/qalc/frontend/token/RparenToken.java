package br.ufc.comp.qalc.frontend.token;

public class RparenToken  extends Token {
    public RparenToken(long line, long start) {
        super(line, start, ")");
    }

    public String getFunctionIdentifier() {
        interpretAttributes();

        return stringValue;
    }


    @Override
    public String getTokenIdentifier() {
        return "RPAREN";
    }
}

