import java.util.Stack;

class CQueue {

    private Stack<Integer> stackA, stackB;

    public CQueue() {
        stackA = new Stack<Integer>();
        stackB = new Stack<Integer>();
    }

    public void appendTail(int value) {
        stackA.push(value);
    }

    public int deleteHead() {
        if (stackA.empty()) {
            return -1;
        }
        while (!stackA.empty()) {
            stackB.push(stackA.pop());
        }
        int head = stackB.pop();
        while (!stackB.empty()) {
            stackA.push(stackB.pop());
        }
        return head;
    }
}
