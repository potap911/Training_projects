import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
        System.out.println(Arrays.toString(array));
        System.out.println("Искомый элемент: " + binarySearch(array, 75)); // поиск элемента бинарным поиском

        List<Player> players = new ArrayList<>();
        players.add(new Player(1100, "Player 1"));
        players.add(new Player(1200, "Player 2"));
        players.add(new Player(1600, "Player 3"));
        players.add(new Player(1600, "Player 4"));
        players.add(new Player(3000, "Player 5"));
        players.add(new Player(3000, "Player 6"));
        players.add(new Player(4000, "Player 7"));
        players.add(new Player(4500, "Player 8"));

        Player newPlayer = new Player(1111, "newPlayer");
        Player newPlayer1 = new Player(3001, "newPlayer1");

        insertPlayer(players, newPlayer);
        insertPlayer(players, newPlayer1);
        players.forEach(System.out::println);

    }

    public static void insertPlayer(List<Player> players, Player newPlayer) {
        int left = 0;
        int right = players.size() - 1;
        int index = players.size();

        while (left < right) {
            int middle = (left + right) / 2;
            int rating = players.get(middle).getRating();
            if (rating < newPlayer.getRating()) {
                index = middle;
                left = middle + 1;
            } else if (rating > newPlayer.getRating()) {
                index = middle;
                right = middle - 1;
            } else {
                index = middle;
            }
        }
        players.add(index, newPlayer);
    }

    public static int binarySearch(int[] array, int search) {
        int left = 0;
        int right = array.length - 1;
        int countIterations = 0;
        while (left <= right) {
            countIterations++;
            int middle = (left + right) / 2;
            if (array[middle] < search) {
                left = middle + 1;
            } else if (array[middle] > search) {
                right = middle - 1;
            } else {
                System.out.println("Колличество итераций: " + countIterations);
                return middle;
            }
        }
        System.out.println("Колличество итераций: " + countIterations);
        return -1;
    }


}