import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Queue queue = new Queue(10);

        queue.pushBack(1);
        queue.pushBack(2);
        queue.pushBack(3);
        System.out.println(Arrays.toString(queue.getData()));
        System.out.println("Peek - " + queue.peek());
        System.out.println("first - " + queue.getFirst());
        System.out.println("last - " + queue.getLast());
        queue.popBack();
        System.out.println(Arrays.toString(queue.getData()));
        System.out.println("Peek - " + queue.peek());
        System.out.println("first - " + queue.getFirst());
        System.out.println("last - " + queue.getLast());
        queue.pushBack(4);
        System.out.println(Arrays.toString(queue.getData()));
        System.out.println("Peek - " + queue.peek());
        System.out.println("first - " + queue.getFirst());
        System.out.println("last - " + queue.getLast());
    }
}