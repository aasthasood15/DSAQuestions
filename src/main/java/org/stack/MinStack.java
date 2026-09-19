package org.stack;

import java.util.Stack;
import java.util.function.Function;
import java.util.function.Predicate;

public class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        this.minStack = new Stack<>();
        this.stack = new Stack<>();
    }

    public void push(int value) {
        stack.push(value);
        if (minStack.isEmpty() || minStack.peek() >= value) {
            minStack.push(value);
        }
    }

    public int pop() {
        int val = stack.pop();
        if (val == minStack.peek()) {
            minStack.pop();
        }
        return val;
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }



}
