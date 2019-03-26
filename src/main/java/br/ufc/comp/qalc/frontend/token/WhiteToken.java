package br.ufc.comp.qalc.frontend.token;

public class WhiteToken extends  Token {


    public WhiteToken(long line, long start) {
        super(line, start, " ");
    }

    public String getFunctionIdentifier() {
        interpretAttributes();

        return stringValue;
    }


    @Override
    public String getTokenIdentifier() {
        return "WHITE";
    }
}
