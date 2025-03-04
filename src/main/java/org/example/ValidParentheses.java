package org.example;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        //create a stack to store in the string
        Stack<Character> stack = new Stack<Character>();

        //Loop through the String and add in the closing bracket if it read an open bracket
        for (char c: s.toCharArray()) {
            if(c == '('){
                stack.push(')');
            } else if(c == '{'){
                stack.push('}');
            } else if(c == '['){
                stack.push(']');
            } else if (stack.isEmpty() || stack.pop() != c){
                //stack become false if it empties when there still a string or
                // the current char does not equal to the symbol in the pop stack
                return false;
            }
        }

        return stack.isEmpty();
    }
}
