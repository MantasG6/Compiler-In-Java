package org.compiler.lexer;

import org.compiler.Exceptions.LexerException;
import org.compiler.domain.support.TokenType;
import org.junit.Test;

import static org.junit.Assert.*;

public class LexerTest {

    @Test
    public void testTokenizer() {

        // 1. Arrange
        String sourceCode = "a = 10\n" + "show a";

        // 2. Act
        Lexer lexer = new Lexer(sourceCode);

        // 3. Assert
        assertTrue(lexer.nextToken());
        assertEquals(TokenType.VARIABLE, lexer.getCurrentToken().getType());
        assertEquals("a", lexer.getCurrentToken().getValue());
        assertNull(lexer.getPreviousToken());

        assertTrue(lexer.nextToken());
        assertEquals(TokenType.EQUALS_OPERATOR, lexer.getCurrentToken().getType());
        assertEquals(TokenType.VARIABLE, lexer.getPreviousToken().getType());
        assertEquals("a", lexer.getPreviousToken().getValue());

        assertTrue(lexer.nextToken());
        assertEquals(TokenType.NUMBER, lexer.getCurrentToken().getType());
        assertEquals("10", lexer.getCurrentToken().getValue());
        assertEquals(TokenType.EQUALS_OPERATOR, lexer.getPreviousToken().getType());

        assertTrue(lexer.nextToken());
        assertEquals(TokenType.SHOW, lexer.getCurrentToken().getType());
        assertEquals(TokenType.NUMBER, lexer.getPreviousToken().getType());
        assertEquals("10", lexer.getPreviousToken().getValue());

        assertTrue(lexer.nextToken());
        assertEquals(TokenType.VARIABLE, lexer.getCurrentToken().getType());
        assertEquals("a", lexer.getCurrentToken().getValue());
        assertEquals(TokenType.SHOW, lexer.getPreviousToken().getType());
    }

    @Test
    public void testTokenNotDefined() {
        String sourceCode = "!a = 4";

        Lexer lexer = new Lexer(sourceCode);

        Exception exception = assertThrows(LexerException.class, lexer::nextToken);

        assertEquals("Token not defined.", exception.getMessage());
    }
}
