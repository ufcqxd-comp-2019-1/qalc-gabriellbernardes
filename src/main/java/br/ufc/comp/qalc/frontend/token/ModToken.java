package br.ufc.comp.qalc.frontend.token;

public class ModToken extends Token {

    public ModToken(long line, long start) {
        super(line, start, "%");
    }

    public String getFunctionIdentifier() {
        interpretAttributes();

        return stringValue;
    }


    @Override
    public String getTokenIdentifier() {
        return "MOD";
    }
}