import java.util.Stack;

public class DequeStack {
    Stack<Integer> a;
    Stack<Integer> b;

    public DequeStack() {
        this.a = new Stack<>();
        this.b = new Stack<>();
    }

    public void pushBack(int x) {
        a.push(x);
    }

    public void pushFront(int x) {
        b.push(x);
    }

    public int popBack(int x) {
        if (a.empty()) {
            rebalance();
        }
        return a.pop();
    }

    public int popFront(int x) {
        if (b.empty()) {
            rebalance();
        }
        return b.pop();
    }

    public void rebalance() {
       Stack<Integer> stack = new Stack<>();
       Stack<Integer> s1 = a;
       Stack<Integer> s2 = b;
       if (a.empty()) {
           s1 = b;
           s2 = a;
       }
       int d = s1.size() / 2;
        for (int i = 0; i < d; i++) {
            stack.push(s1.pop());
        }
        while (!s1.empty()) {
            s2.push(s1.pop());
        }
        while (!stack.empty()) {
            s1.push(stack.pop());
        }
    }
}
