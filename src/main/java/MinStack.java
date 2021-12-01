import java.util.Stack;

public class MinStack {

    private Stack<Integer> values, minValues;

    /** initialize your data structure here. */
    public MinStack() {
        values = new Stack<Integer>();
        minValues = new Stack<Integer>();
    }

    public void push(int x) {
        values.push(x);
        if (minValues.empty() || x <= minValues.peek()) {
            minValues.push(x);
        }
    }

    public void pop() {
        int value = values.pop();
        if (value == minValues.peek()) {
            minValues.pop();
        }
    }

    public int top() {
        return values.peek();
    }

    public int min() {
        return minValues.peek();
    }
}
