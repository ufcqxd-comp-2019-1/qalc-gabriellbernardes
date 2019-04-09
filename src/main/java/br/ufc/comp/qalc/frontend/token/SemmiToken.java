package br.ufc.comp.qalc.frontend.token;

public class SemmiToken extends Token {
    public SemmiToken(long line, long start, String value) throws IllegalArgumentException {

        super(line, start, value);
    }




    @Override
    public String getTokenIdentifier() {
        return "SEMMI";
    }
}
