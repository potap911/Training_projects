public class Deque {
    int[] data;
    int first;
    int last;

    public Deque(int maxSize) {
        data = new int[maxSize];
        first = 0;
        last = 0;
    }
    public boolean empty() {
        return first == last;
    }

    public void doubleSize() {
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
    }
    public void pushFront(int x) {
        int i = first - 1;
        if (i < 0) {
            i = data.length - 1;
        }
        if (i == last) {
            doubleSize();
            i = data.length - 1;
        }
        data[i] = x;
        first = i;
    }

    public void pushBack(int x) {
        if (last + 1 == first || (last + 1 == data.length && first == 0)) {
            doubleSize();
        }
        data[last] = x; // кладем значение по индексу last
        last++; // двигаем указатель
        if (last >= data.length) last = 0; // если указатель больше/равен размеру -> указатель в начало
    }
    public int popFront() {
        if (empty()) {
            System.out.println("Popping from empty queue");
            return -1;
        }

        int value = data[first]; // записываем значение из очереди
        data[first] = 0;
        first++; // двигаем указатель
        if (first >= data.length) first = 0; // если указатель больше/равен размеру -> указатель в начало
        return value;
    }

    public int popBack() {
        if (empty()) {
            System.out.println("Popping from empty queue");
            return -1;
        }
        int i = last - 1;
        if (i < 0) i = data.length;
        int value = data[i];
        data[i] = 0;
        last = i;
        return value;
    }

    public int[] getData() {
        return data;
    }
}
