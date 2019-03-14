package br.ufc.comp.qalc.frontend.token;

public class DivToken extends Token {

    public DivToken(long line, long start) {
        super(line, start, "/");
    }

    public String getFunctionIdentifier() {
        interpretAttributes();

        return stringValue;
    }


    @Override
    public String getTokenIdentifier() {
        return "DIV";
    }
}