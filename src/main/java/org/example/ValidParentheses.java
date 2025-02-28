package org.example;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        //create a stack to store in string
        Stack<Character> stack = new Stack<Character>();
        //add the closing bracket of specific open bracket to the stack
        for (char c: s.toCharArray()) {
            if(c == '('){
                stack.push(')');
            } else if(c == '{'){
                stack.push('}');
            } else if(c == '['){
                stack.push(']');
            } else if (stack.isEmpty() || stack.pop() != c){ //pop the stack to check if the closing is in the right order
                return false;
            }
        }
        return stack.isEmpty();
    }
}
