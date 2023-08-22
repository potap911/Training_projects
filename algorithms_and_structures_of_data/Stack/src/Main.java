import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        System.out.println(powWithStack(5, 2));
        System.out.println(checkBracketSequence("({[]}("));
    }
    public static int pow(int a, int b) {
        if (b == 0) return 1;
        if (b % 2 == 0) {
            int result = pow(a, b / 2);
            return result * result;
        } else return pow(a, b -1) * a;
    }
    public static int powWithStack(int a, int b) {
        Stack<State> st = new Stack<>(); // объявляем Стэк
        st.push(new State(a, b, 0)); // кладем состояние в Стэк, начальная позиция 0
        int result = 0;
        while (!st.empty()) {
            a = st.peek().a; // запись состояния
            b = st.peek().b; // переменных
            int position = st.peek().st; // запись состояния позиции
            st.pop(); // удаление верхнего состояния из Стэка
            if (position == 0) { // прописываем поведение для нулевого/дефолтного состояния
                if (b == 0) {
                    result = 1;
                    continue;
                }
                if (b % 2 == 0) { // если множитель кратен 2 добавляем новые состояния в Стэк
                    st.push(new State(a, b, 1)); // новое состояние с позицией 1
                    st.push(new State(a, b / 2, 0)); // новое дефолтное состояние с позицией 0
                } else {
                    st.push(new State(a, b, 2)); // новое состояние с позицией 2
                    st.push(new State(a, b - 1, 0)); // новое дефолтное состояние с позицией 0
                }
            } else if (position == 1) { // прописываем поведение для позиции 1
                result = result * result;
            } else {
                result = result * a;
            }
        }
        return result;
    }

    public static boolean checkBracketSequence(String s) {
        Stack<Character> st = new Stack<>(); // объявляем Стэк
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                st.push(c); // берем подходящий символ из массива и кладем в Стэк
            } else {
                if (st.empty()) return false;
                if (c == ')' && st.peek().equals('(')) {
                    st.pop(); // если взятый символ противоположен символу из вершины Стэка удаляем его состояние(символ) из стэка
                    continue;
                }
                if (c == ']' && st.peek().equals('[')) {
                    st.pop();
                    continue;
                }
                if (c == '}' && st.peek().equals('{')) {
                    st.pop();
                    continue;
                }
                return false;
            }
        }
        return st.empty();
    }
}