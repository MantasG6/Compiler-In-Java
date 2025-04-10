package org.compiler.Exceptions;

public class LexerException extends RuntimeException {

    public LexerException() {
        super("Exception While Lexical Tokenizing");
    }

    public LexerException(String message) {
        super(message);
    }

    public LexerException(String message, Throwable cause) {
        super(message, cause);
    }
}
