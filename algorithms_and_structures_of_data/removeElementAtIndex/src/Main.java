import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[]{15, 23, 20, 5, 15, 20, 15, 20};
        removeRepeats(array); // удаление повторов
        System.out.println(Arrays.toString(array));
    }

    public static void removeRepeats(int[] array) {
        int i = 0;
        while (i < array.length) {
            boolean flag = false;
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    flag = true;
                    break;
                }
            }
            if (flag) removeElement(array, i);
            i++;
        }
    }

    public static void removeElement(int[] array, int element) {
        for (int i = element + 1; i < array.length; i++) {
            array[i - 1] = array[i];
            array[array.length - 1] = 0;
        }
    }
}