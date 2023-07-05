import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        while (true) {
            System.out.println("Введите путь к папке или к файлу");
            String path = new Scanner(System.in).nextLine();
            File file = new File(path); // создаем файл на основе полученной ссылки
            System.out.println(getHumanReadableSize(getFolderSize(file)));
        }
    }

    public static long getFolderSize(File file) {
        if (file.isFile()) { // проверка файла на наличие вложенного файла
            return file.length();
        }
        if (file.isDirectory()) { //проверка файла на вложенные директориии
            long fileSize = 0; // сохраняем колличество размеров файлов
            List<File> listFiles = List.of(file.listFiles()); // создаем лист из списка вложенных файлов/дерикторий
            for (int i = 0; i < listFiles.size(); i++) { //
                fileSize += getFolderSize(listFiles.get(i)); // рекурсия
            }
            return fileSize; // возвращаем объем файла
        }
        return 0;
    }

    public static String getHumanReadableSize(long fileSize) {
        return fileSize + "b" + "\n"
                + fileSize / 1024 + "kb" + "\n"
                + fileSize / 1024 / 1024 + "mb" + "\n"
                + fileSize / 1024 / 1024 / 1024 + "Gb" + "\n";
    }
}