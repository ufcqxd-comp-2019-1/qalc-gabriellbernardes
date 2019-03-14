package br.ufc.comp.qalc.frontend.token;

public class LparenToken  extends Token {
    public LparenToken(long line, long start) {
        super(line, start, "(");
    }

    public String getFunctionIdentifier() {
        interpretAttributes();

        return stringValue;
    }


    @Override
    public String getTokenIdentifier() {
        return "LPAREN";
    }
}

