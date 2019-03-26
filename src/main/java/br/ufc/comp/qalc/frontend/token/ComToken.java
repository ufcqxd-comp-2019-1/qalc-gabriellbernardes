package br.ufc.comp.qalc.frontend.token;

public class ComToken extends  Token {


    public ComToken(long line, long start) {
        super(line, start, "#");
    }

    public String getFunctionIdentifier() {
        interpretAttributes();

        return stringValue;
    }


    @Override
    public String getTokenIdentifier() {
        return "COMMENT";
    }
}


