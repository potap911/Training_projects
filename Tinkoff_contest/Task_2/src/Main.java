import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        Map<Character, Integer> charMap = new HashMap<>();
        charMap.put('s', 0);
        charMap.put('h', 0);
        charMap.put('e', 0);
        charMap.put('r', 0);
        charMap.put('i', 0);
        charMap.put('f', 0);

        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (charMap.containsKey(c)) {
                charMap.put(c, charMap.get(c)+1);
            }
        }

        charMap.replace('f', charMap.get('f')/2);
        int res = Collections.min(charMap.values());
        System.out.println(res);
    }
}