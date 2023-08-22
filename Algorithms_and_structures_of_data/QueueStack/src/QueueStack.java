import java.util.Stack;

public class QueueStack {
    Stack<Integer> a;
    Stack<Integer> b;

    public QueueStack() {
        this.a = new Stack<>();
        this.b = new Stack<>();
    }

    public void pushBack(int x) {
        a.push(x);
    }

    public int popFront() {
        while (!a.empty()) {
            b.push(a.pop());
        }
        return b.pop();
    }

}
