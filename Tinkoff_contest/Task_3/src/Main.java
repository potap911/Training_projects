import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        
        int[] joeArr = new int[count];
        for (int i = 0; i < count; i++) {
            joeArr[i] = scanner.nextInt();
        }
        int[] winArr = new int[count];
        for (int i = 0; i < count; i++) {
            winArr[i] = scanner.nextInt();
        }

        int left = 1;
        int right = count-1;

        for (int i = 1; i < count; i++) {
            if (joeArr[i] != winArr[i]) {
                left = i;
                break;
            }
        }
        for (int i = count-1; i > 0; i--) {
            if (joeArr[i] != winArr[i]) {
                right = i;
                break;
            }
        }
        sort(joeArr, left, right);

        if (Arrays.equals(joeArr, winArr)) System.out.println("YES");
        else System.out.println("NO");
    }
    public static void sort(int[] arr, int left, int right) {
        Random random = new Random();
        if (arr.length == 0 || left >= right) return;

        int meddle = arr[left + random.nextInt(right - left)];

        int l = left, r = right;
        while (l <= r) {
            while (arr[l] < meddle) l++;
            while (arr[r] > meddle) r--;
            if (l <= r) {
                int swap = arr[l];
                arr[l] = arr[r];
                arr[r] = swap;
                l++;
                r--;
            }
        }
        if (left < r) sort(arr, left, r);
        if (right > l) sort(arr, l, right);
    }
}