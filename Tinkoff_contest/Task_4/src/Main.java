import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = scanner.nextInt();
        int countBills = 2;
        int countNom = scanner.nextInt();
        int[] nominals = new int[countNom];
        for (int i = 0; i < nominals.length; i++) {
            nominals[i] = scanner.nextInt();
        }

        int resCount = 0;
        List<Integer> resList = new ArrayList<>();
        int pt = nominals.length-1;

        while (sum > 0 && pt >= 0) {
            if (sum - nominals[pt] >= 0) {
                sum -= nominals[pt];
                resList.add(nominals[pt]);
                resCount++;
                countBills--;
            } else pt--;
            if (countBills == 0) {
                countBills = 2;
                pt--;
            }
        }
        if (sum == 0 && resCount > 0) {
            StringBuilder s =  new StringBuilder();
            resList.forEach(integer -> s.append(integer + " "));
            System.out.println(resCount);
            System.out.println(s.toString().trim());
        } else System.out.println(-1);
    }
}