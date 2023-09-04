import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int revolvers = scan.nextInt();
        int money = scan.nextInt();
        int[] prises = new int[revolvers];
        for (int i = 0; i < prises.length; i++) {
            prises[i] = scan.nextInt();
        }

        int ressult = 0;
        for (int i = 0, j = prises.length-1; i < prises.length && j > 0; i++, j--) {
            if (prises[i] <= money && prises[i] > ressult) {
                ressult = prises[i];
            }
            if (prises[j] <= money && prises[j] > ressult) {
                ressult = prises[j];
            }
            if (i == j) break;
        }
        System.out.println(ressult);
    }
}