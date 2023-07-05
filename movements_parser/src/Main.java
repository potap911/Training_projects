import javax.imageio.IIOException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        String path = "movementList.csv";
        List<String> lines = new ArrayList<>();
        String regex = "[^a-zA-Z0-9]([a-zA-Z0-9\s]+)[0-9]{2}\\.[0-9]{2}\\.[0-9]{2}\s[0-9]{2}\\.[0-9]{2}\\.[0-9]{2}";
        Pattern pattern = Pattern.compile(regex);
        try {
            lines = Files.readAllLines(Paths.get(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        HashMap<String, Double> map = new HashMap<>();
        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i);

            Matcher matcher = pattern.matcher(line);
            String result = matcher.find() ? matcher.group(1).trim() : null;

            String[] tokens = line.split(",");
            double expense = Double.parseDouble(tokens[7]);
            if(expense == 0) {
                continue;
            }
            map.put(result, expense);
        }

        for (String name: map.keySet()) {
            String key = name.toString();
            String value = map.get(name).toString();
            System.out.println(key + " " + value);
        }




    }
}