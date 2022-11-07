package utils;

import org.apache.commons.lang3.tuple.Pair;

import java.util.Stack;

public class StackGetMax {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println(stack.pop());
        System.out.println(stack);

        MyStack myStack = new MyStack();

        myStack.push(1);
        myStack.push(2);
        myStack.push(5);
        myStack.push(4);

        System.out.println(myStack.pop());
        System.out.println(myStack.getMax());
        System.out.println(myStack);
    }

}

class MyStack {

    Stack<Pair<Integer, Integer>> stack = new Stack<>();

    public void push(Integer value) {
        Integer max = value;
        if (!stack.isEmpty() && value != null) {
            Pair<Integer, Integer> peek = stack.peek();
            if (peek.getRight() > value) max = stack.peek().getRight();
        }
        stack.push(Pair.of(value, max));
    }

    public Integer pop() {
        return stack.pop().getLeft();
    }

    public Integer getMax() {
        return stack.peek().getRight();
    }

}