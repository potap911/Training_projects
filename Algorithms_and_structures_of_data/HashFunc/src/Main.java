import java.util.List;

public class Main {
    public static KeyValuePair[] entries = new KeyValuePair[8];
    public static int size = 8;
    public static int numberOfElements = 0;

    public static void main(String[] args) {
        List<KeyValuePair> list = List.of(
                new KeyValuePair("Word", "Key"),
                new KeyValuePair("Word", "Key"),
                new KeyValuePair("Word", "Key"),
                new KeyValuePair("Word", "Key"),
                new KeyValuePair("Word", "Key")
        );

        for (KeyValuePair keyValuePair : list) {
            int hash = keyValuePair.hashCode();
            int index = hash % 8;
            System.out.println(index);
        }

        System.out.println("Word".hashCode() % 8);
        System.out.println("Key".hashCode() % 8);


    }

    public static int hashFunc(String key) {
        return 0;
    }

    public static void add(String key, String value) {
        int index = findGoodIndex(key);
        entries[index] = new KeyValuePair(key, value);
        numberOfElements++;
        if (numberOfElements == size) {
            resize(size * 2);
        }
    }

    public static void resize(int newSize) {
        KeyValuePair[] newEntries = new KeyValuePair[newSize];
        for (int i = 0; i < size; i++) {
            KeyValuePair entry = entries[i];
            int index = findGoodIndex(entry.key);
            newEntries[index] = entry;
        }
        entries = newEntries;
        size = newSize;
    }

    public static String get(String key) {
        int index = findGoodIndex(key);
        if (index == -1) return null;
        KeyValuePair entry = entries[index];
        if (entry == null) {
            return null;
        }
        return entry.value;
    }

    public static int findGoodIndex(String key) {
        int hash = hashFunc(key);
        int index = hash % size;

        for (int i = 0; i < size; i++) {
            int probingIndex = (index + i) % size;
            KeyValuePair entry = entries[probingIndex];
            if (entry == null || entry.key.equals(key)) {
                return probingIndex;
            }
        }
        return -1;

    }

}