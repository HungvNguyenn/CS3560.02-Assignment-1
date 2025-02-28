package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidParenthesesTest {

    @Test
    public void testIsValid() {
        ValidParentheses vp = new ValidParentheses();
        assertTrue(vp.isValid("()"));
        assertTrue(vp.isValid("()[]{}"));
        assertFalse(vp.isValid("(]"));
        assertFalse(vp.isValid("([)]"));
    }

    @Test
    public void emptyString(){
        ValidParentheses vp = new ValidParentheses();
        assertTrue(vp.isValid(""));
    }

    @Test
    public void singleBracket(){
        ValidParentheses vp = new ValidParentheses();
        assertFalse(vp.isValid("["));
        assertFalse(vp.isValid("("));
        assertFalse(vp.isValid("{"));
    }

    @Test
    public void longStrings(){
        ValidParentheses vp = new ValidParentheses();
        assertTrue(vp.isValid("(((((((((())))))))))"));
        assertTrue(vp.isValid("[{({})({})({}[])}]"));
        assertFalse(vp.isValid("(((((((())))))))("));
        assertFalse(vp.isValid("[{({})({})({}[)]}]"));
    }

}