import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Long> uniqueNumbers = new ArrayList<>();

        long[] phoneNumbers = new long[]{+79281411325L, +79251311378L, +79281411354L, +79285672328L, +79281411325L};
        long[] sortPhoneNumbers = new long[]{
                +79000000001L,
                +79000000001L,
                +79000000002L,
                +79000000003L,
                +79000000004L,
                +79000000004L,
                +79000000004L,
                +79000000004L,
                +79000000005L,
        };

        uniqueNumbers = findUniqueNumbers(phoneNumbers); // поиск уникальных номеров в несортировонном массиве
        System.out.println(uniqueNumbers);

        uniqueNumbers = findUniqueNumbersIntoSortArray(sortPhoneNumbers); // поиск уникальных номеров в сортированном массиве
        System.out.println(uniqueNumbers);

    }

    public static List<Long> findUniqueNumbers(long[] phoneNumbers) {
        List<Long> uniqueNumbers = new ArrayList<>();
        for (long phoneNumber : phoneNumbers) {
            boolean check = false;
            for (Long uniqueNumber : uniqueNumbers) {
                if (uniqueNumber == phoneNumber) {
                    check = true;
                    break;
                }
            }
            if (!check) uniqueNumbers.add(phoneNumber);
        }
        return uniqueNumbers;
    }
    public static List<Long> findUniqueNumbersIntoSortArray(long[] sortPhoneNumbers) {
        List<Long> uniqueNumbers = new ArrayList<>();
        long prevNumber = sortPhoneNumbers[0];
        for (int i = 1; i < sortPhoneNumbers.length; i++) {
            if (prevNumber != sortPhoneNumbers[i]) {
                uniqueNumbers.add(prevNumber);
                prevNumber = sortPhoneNumbers[i];
            }
        }
        uniqueNumbers.add(prevNumber);
        return uniqueNumbers;
    }
}