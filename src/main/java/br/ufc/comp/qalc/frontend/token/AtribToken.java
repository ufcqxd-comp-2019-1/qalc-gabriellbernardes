package br.ufc.comp.qalc.frontend.token;

public class AtribToken  extends Token {
    public AtribToken(long line, long start) {
        super(line, start, "=");
    }

    public String getFunctionIdentifier() {
        interpretAttributes();

        return stringValue;
    }


    @Override
    public String getTokenIdentifier() {
        return "ATRIB";
    }
}
