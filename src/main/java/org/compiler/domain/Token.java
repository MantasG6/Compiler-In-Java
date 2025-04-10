package org.compiler.domain;

import org.compiler.domain.support.TokenType;

public class Token {

    private final TokenType type;
    private final String value;

    public Token(TokenType type) {
        this.type = type;
        this.value = null;
    }

    public Token(TokenType type, String value) {
        this.type = type;
        this.value = value;
    }

    public TokenType getType() {
        return type;
    }

    public String getValue() {
        return value;
    }
}
