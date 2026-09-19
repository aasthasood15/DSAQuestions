package org.stack;

import java.util.Stack;

public class ValidParantheses {

    public void validParantheses() {
        {
            //String s ="[{}()]";
            //String s="([{]})";
            String s = "{]";
            Stack<Character> st = new Stack<>();

            for (char c : s.toCharArray()) {
                if (c == '{' || c == '(' || c == '[') {
                    st.push(c);
                } else if (!st.isEmpty() &&
                        (
                                (st.peek() == '{' && c == '}') ||
                                (st.peek() == '(' && c == ')') ||
                                (st.peek() == '[' && c == ']')

                        )) {
                    st.pop();
                }
            }

            System.out.println(st.isEmpty());


        }
    }
}

