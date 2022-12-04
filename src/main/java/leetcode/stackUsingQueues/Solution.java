package leetcode.stackUsingQueues;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {


}

//LAST IN FIRST OUT
class MyStack {

    Deque<Integer> queue = new ArrayDeque<>();

    public MyStack() {}

    public void push(int x) {
        this.queue.addFirst(x);
    }

    public int pop() {
        return queue.pop();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
