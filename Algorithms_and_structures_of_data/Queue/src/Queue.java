public class Queue {
    int[] data;
    int first;
    int last;

    public Queue(int maxSize) {
        data = new int[maxSize];
        first = 0;
        last = 0;
    }
    public boolean empty() {
        return first == last;
    }

    public void pushBack(int x) {
        if (last + 1 == first || (last + 1 == data.length && first == 0)) {
            int[] dataUp = new int[data.length * 2];
            int index = 0;
            if (first <= last) {
                for (int i = first; i < last; i++) {
                    dataUp[index] = data[i];
                    index++;
                }
            } else {
                for (int i = first; i < data.length; i++) {
                    dataUp[index] = data[i];
                    index++;
                }
                for (int i = 0; i < last; i++) {
                    dataUp[index] = data[i];
                    index++;
                }
            }
            data = dataUp;
            first = 0;
            last = index;
            System.out.println("No more size");
            return;
        }
        data[last] = x; // кладем значение по индексу last
        last++; // двигаем указатель
        if (last >= data.length) last = 0; // если указатель больше/равен размеру -> указатель в начало
    }

    public int popBack() {
        if (empty()) {
            System.out.println("Popping from empty queue");
        }
        int value = data[first]; // записываем значение из очереди
        data[first] = 0;
        first++; // двигаем указатель
        if (first >= data.length) first = 0; // если указатель больше/равен размеру -> указатель в начало
        return value;
    }

    public int peek() {
        return first;
    }

    public int[] getData() {
        return data;
    }

    public int getFirst() {
        return first;
    }

    public int getLast() {
        return last;
    }
}
