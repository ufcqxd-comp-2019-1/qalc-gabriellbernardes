package br.ufc.comp.qalc.frontend.token;

public class AtribToken  extends Token {
    public AtribToken(long line, long start) {
        super(line, start, start);
    }

    @Override
    public String toString() {
        // NOTE: Não existe lexema associado, porém é o único token que não possui
        return "";
    }

    @Override
    public String getTokenIdentifier() {
        return "ATRIB";
    }
}
