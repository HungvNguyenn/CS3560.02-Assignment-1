package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidParenthesesTest {

    //test case from Lecture 5 hands on
    @Test
    public void testIsValid() {
        ValidParentheses vp = new ValidParentheses();
        assertTrue(vp.isValid("()"));
        assertTrue(vp.isValid("()[]{}"));
        assertFalse(vp.isValid("(]"));
        assertFalse(vp.isValid("([)]"));
    }

    //test case for an empty string
    @Test
    public void emptyString(){
        ValidParentheses vp = new ValidParentheses();
        assertTrue(vp.isValid(""));
    }

    //test case that test single brackets open and close brackets only
    @Test
    public void singleBracket(){
        ValidParentheses vp = new ValidParentheses();
        assertFalse(vp.isValid("("));
        assertFalse(vp.isValid("["));
        assertFalse(vp.isValid("{"));
        assertFalse(vp.isValid(")"));
        assertFalse(vp.isValid("]"));
        assertFalse(vp.isValid("}"));
    }

    //test case that test long strings
    @Test
    public void longStrings(){
        ValidParentheses vp = new ValidParentheses();
        assertTrue(vp.isValid("(((((((((())))))))))"));
        assertTrue(vp.isValid("[{({})({})({}[])}]"));
        assertFalse(vp.isValid("(((((((())))))))("));
        assertFalse(vp.isValid("[{({})({})({}[)]}]"));
    }

}