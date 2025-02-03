//Joshua Baney
//CMSC330 Advanced Programming Languages 
//Project 1
// 2/2/25
// Lexer.java
// This file defines the lexical analyzer for the project.

import java.io.*;

public class Lexer {

    private StreamTokenizer tokenizer;
    private String punctuation = ",;.()";
    private Token[] punctuationTokens = {Token.COMMA, Token.SEMICOLON, Token.PERIOD, Token.LEFT_PAREN, Token.RIGHT_PAREN };

    public Lexer(File file) throws FileNotFoundException {
        tokenizer = new StreamTokenizer(new FileReader(file));
        // Treat the period as an ordinary character so we can distinguish it from words.
        tokenizer.ordinaryChar('.');
        // Set the quote character so that strings are recognized.
        tokenizer.quoteChar('"');
    }

    public Token getNextToken() throws LexicalError, IOException {
        int tokenType = tokenizer.nextToken();
        switch (tokenType) {
            case StreamTokenizer.TT_NUMBER:
                return Token.NUMBER;
            case StreamTokenizer.TT_WORD:
                // Compare the word (ignoring underscores) to known token names.
                for (Token aToken : Token.values()) {
                    if (aToken.name().replace("_", "").equalsIgnoreCase(tokenizer.sval))
                        return aToken;
                }
                return Token.IDENTIFIER;
            case '"': // Quoted string detected
                return Token.STRING;
            case StreamTokenizer.TT_EOF:
                return Token.EOF;
            default:
                for (int i = 0; i < punctuation.length(); i++) {
                    if (tokenType == punctuation.charAt(i))
                        return punctuationTokens[i];
                }
        }
        return Token.EOF;
    }

    public String getLexeme() {
        return tokenizer.sval;
    }

    public int getNumber() {
        return (int) tokenizer.nval;
    }

    public int getLineNo() {
        return tokenizer.lineno();
    }
}
