package br.ufc.comp.qalc.frontend.token;

public class TimesToken extends Token {

    public TimesToken(long line, long start) {
        super(line, start, "*");
    }

    public String getFunctionIdentifier() {
        interpretAttributes();

        return stringValue;
    }


    @Override
    public String getTokenIdentifier() {
        return "TIMES";
    }
}

