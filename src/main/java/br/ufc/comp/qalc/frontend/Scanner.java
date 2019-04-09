package br.ufc.comp.qalc.frontend;

import br.ufc.comp.qalc.frontend.token.*;
import java.io.IOException;
import java.awt.*;
import java.util.*;

/**
 * Analisador Léxico da linguagem.
 * <p>
 * Funciona como uma fonte de tokens, de onde o Analisador Sintático
 * deverá ler.
 *
 * @see Source
 */
public class Scanner {

    /**
     * Último token reconhecido.
     */
    protected Token currentToken;
    /**
     * Fonte de caracteres de onde extrair os tokens.
     */
    protected Source source;

    /**
     * Constrói um Analisador Léxico a partir de uma fonte de caracteres.
     *
     * @param sourceStream Fonte a ser utilizada.
     */
    public Scanner(Source sourceStream) {
        // FIXME Lidar corretamente com as exceções.
        this.source = sourceStream;
    }

    public boolean isToken(char s){
        if (s == Source.EOF) {return  true;}
        if (Character.isDigit(s)) {return  true;}
        if (s == '@') {return true;}
        if (s == '$') {return  true;}
        if (s == '=') {return  true;}
        if (s == '+') {return  true;}
        if (s == '-') {return  true;}
        if (s == '*') {return  true;}
        if (s == '/') {return  true;}
        if (s == '%') {return  true;}
        if (s == '^') {return  true;}
        if (s == '(') {return  true;}
        if (s == ')') {return  true;}
        if (s == ' ') {return  true;}
        if (s == ';') {return  true;}
        if (s == '#') {return  true;}
        if (s == '\n' || source.getCurrentChar() == '\r') {return  true;}
        if (s == ',') {return  true;}
        return false;
    }
    /**
     * Consome caracteres da fonte até que eles componham um lexema de
     * um dos tokens da linguagem, coinstrói um objeto representando esse
     * token associado ao lexema lido e o retorna.
     *
     * @return Token reconhecido.
     * @throws IOException Caso haja problema na leitura da fonte.
     */
    public Token getNextToken() throws IOException {
        // TODO Reconhecimento de tokens


        if (source.getCurrentChar() == Source.EOF) {
            return new EOFToken(source.getCurrentLine(), source.getCurrentColumn());
        }else if (Character.isDigit(source.getCurrentChar())) {

                StringBuilder lexema = new StringBuilder();

                long currentLine = source.getCurrentLine();
                long lexemeStart = source.getCurrentColumn();

                do {
                    lexema.append(source.getCurrentChar());
                    source.advance();
                } while (Character.isDigit(source.getCurrentChar()));
                if(source.getCurrentChar() == '.'){
                    lexema.append(source.getCurrentChar());
                    source.advance();
                    do {
                        lexema.append(source.getCurrentChar());
                        source.advance();
                    } while (Character.isDigit(source.getCurrentChar()));
                }
                String stringValue = lexema.toString();

                return new NumberToken(currentLine, lexemeStart, stringValue);
        } else if (source.getCurrentChar() == '@') {
            StringBuilder lexema = new StringBuilder();

            long currentLine = source.getCurrentLine();
            long lexemaStart = source.getCurrentColumn();

            do {
                lexema.append(source.getCurrentChar());
                source.advance();
            } while (Character.isLetter(source.getCurrentChar()));

            return new FunctionIdentifierToken(currentLine, lexemaStart, lexema.toString());
        } else if (source.getCurrentChar() == '$') {

            StringBuilder lexema = new StringBuilder();
            long currentLine = source.getCurrentLine();
            long lexemaStart = source.getCurrentColumn();

            lexema.append(source.getCurrentChar());
            source.advance();
            if (Character.isLetter(source.getCurrentChar())) {
                do {
                    lexema.append(source.getCurrentChar());
                    source.advance();
                } while (Character.isLetter(source.getCurrentChar()));
                return new VariableIdentifierToken(currentLine, lexemaStart, lexema.toString());

            }else if (Character.isDigit(source.getCurrentChar()) || source.getCurrentChar() == '?'){ // ResultIdentifierToken 5


                if (source.getCurrentChar() == '?'){
                    lexema.append(source.getCurrentChar());
                    source.advance();
                    return new ResultIdentifierToken(currentLine, lexemaStart, lexema.toString());
                }
                lexema.append(source.getCurrentChar());
                source.advance();
                while (Character.isDigit(source.getCurrentChar())){
                    lexema.append(source.getCurrentChar());
                    source.advance();
                }
                if(Long.parseLong(lexema.substring(1))== 0){
                    return new ErrorToken(currentLine, lexemaStart, lexema.toString());
                }
                return new ResultIdentifierToken(currentLine, lexemaStart, lexema.toString());
            }

        }else if (source.getCurrentChar() == '='){

            StringBuilder lexema = new StringBuilder();
            long currentLine = source.getCurrentLine();
            long lexemaStart = source.getCurrentColumn();

            lexema.append(source.getCurrentChar());
            source.advance();
            return new FunctionIdentifierToken(currentLine, lexemaStart, lexema.toString());

        }else if (source.getCurrentChar() == '+'){

            StringBuilder lexema = new StringBuilder();
            long currentLine = source.getCurrentLine();
            long lexemaStart = source.getCurrentColumn();

            lexema.append(source.getCurrentChar());
            source.advance();
            return  new PlusToken(currentLine, lexemaStart, lexema.toString());
        }else if (source.getCurrentChar() == '-'){

            StringBuilder lexema = new StringBuilder();
            long currentLine = source.getCurrentLine();
            long lexemaStart = source.getCurrentColumn();

            lexema.append(source.getCurrentChar());
            source.advance();
            return  new MinusToken(currentLine, lexemaStart, lexema.toString());
        }else if (source.getCurrentChar() == '*'){

            StringBuilder lexema = new StringBuilder();
            long currentLine = source.getCurrentLine();
            long lexemaStart = source.getCurrentColumn();

            lexema.append(source.getCurrentChar());
            source.advance();
            return  new TimesToken(currentLine, lexemaStart, lexema.toString());
        }else if (source.getCurrentChar() == '/'){

            StringBuilder lexema = new StringBuilder();
            long currentLine = source.getCurrentLine();
            long lexemaStart = source.getCurrentColumn();

            lexema.append(source.getCurrentChar());
            source.advance();
            return  new DivToken(currentLine, lexemaStart, lexema.toString());
        }else if (source.getCurrentChar() == '%'){
            StringBuilder lexema = new StringBuilder();
            long currentLine = source.getCurrentLine();
            long lexemaStart = source.getCurrentColumn();

            lexema.append(source.getCurrentChar());
            source.advance();
            return  new ModToken(currentLine, lexemaStart, lexema.toString());
        }else if (source.getCurrentChar() == '^') {
            StringBuilder lexema = new StringBuilder();
            long currentLine = source.getCurrentLine();
            long lexemaStart = source.getCurrentColumn();

            lexema.append(source.getCurrentChar());
            source.advance();
            return new PowToken(currentLine, lexemaStart, lexema.toString());
        }else if (source.getCurrentChar() == '(') {

            StringBuilder lexema = new StringBuilder();
            long currentLine = source.getCurrentLine();
            long lexemaStart = source.getCurrentColumn();

            lexema.append(source.getCurrentChar());
            source.advance();
            return new LparenToken(currentLine, lexemaStart, lexema.toString());
        }
        else if (source.getCurrentChar() == ')') {

            StringBuilder lexema = new StringBuilder();
            long currentLine = source.getCurrentLine();
            long lexemaStart = source.getCurrentColumn();

            lexema.append(source.getCurrentChar());
            source.advance();
            return new RparenToken(currentLine, lexemaStart, lexema.toString());
        }
        else if (source.getCurrentChar() == ',') {

            StringBuilder lexema = new StringBuilder();
            long currentLine = source.getCurrentLine();
            long lexemaStart = source.getCurrentColumn();

            lexema.append(source.getCurrentChar());
            source.advance();
            return new CommaToken(currentLine, lexemaStart, lexema.toString());
        }
        else if (source.getCurrentChar() == ';') {

            StringBuilder lexema = new StringBuilder();
            long currentLine = source.getCurrentLine();
            long lexemaStart = source.getCurrentColumn();

            lexema.append(source.getCurrentChar());
            source.advance();
            return new SemmiToken(currentLine, lexemaStart, lexema.toString());
        }
        else if (source.getCurrentChar() == ' ') {

            StringBuilder lexema = new StringBuilder();
            long currentLine = source.getCurrentLine();
            long lexemaStart = source.getCurrentColumn();
            lexema.append(source.getCurrentChar());
            do{
                source.advance();
            }while (source.getCurrentChar() == ' ');
            return new WhiteToken(currentLine, lexemaStart, lexema.toString());
        }
        else if (source.getCurrentChar() == '#') {

            StringBuilder lexema = new StringBuilder();
            long currentLine = source.getCurrentLine();
            long lexemaStart = source.getCurrentColumn();
            lexema.append(source.getCurrentChar());
            do{
                source.advance();
            }while (source.getCurrentChar() != '\n' && source.getCurrentChar() != '\r' && source.getCurrentChar() != source.EOF);

            return new ComToken(currentLine, lexemaStart, lexema.toString());
        }
        else if (source.getCurrentChar() == '\n') {

            StringBuilder lexema = new StringBuilder();
            long currentLine = source.getCurrentLine();
            long lexemaStart = source.getCurrentColumn();
            lexema.append(source.getCurrentChar());

            source.advance();
            return new LineBreak(currentLine, lexemaStart, lexema.toString());
        }else{
            StringBuilder lexema = new StringBuilder();
            long currentLine = source.getCurrentLine();
            long lexemaStart = source.getCurrentColumn();

            do{
                lexema.append(source.getCurrentChar());
                source.advance();
            }while (!this.isToken(source.getCurrentChar()));

            return new ErrorToken(currentLine, lexemaStart, lexema.toString());
        }

        // TODO Recuperação de erros.

        return null;
    }

    /**
     * Obtém o último token reconhecido.
     *
     * @return O último token reconhecido.
     */
    public Token getCurrentToken() {
        return currentToken;
    }
}
