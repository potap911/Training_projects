import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class Main {
    public static void main(String[] args) throws Exception {

        String path = "/home/nikita/Desktop/Folder";
        String in = "/home/nikita/Desktop/Folderarchive.zip";
        String out = path;

        FileOutputStream outputStream = new FileOutputStream(out);
        ZipOutputStream zipOut = new ZipOutputStream(outputStream);
        writeFileToXip(new File(in), zipOut, "");
        zipOut.flush();
        zipOut.close();
        outputStream.close();

        FileInputStream inputStream = new FileInputStream(in);
        ZipInputStream zipInput = new ZipInputStream(inputStream);
        while (true) {
            ZipEntry entry = zipInput.getNextEntry();
            if (entry == null) {
                break;
            }
            File file = new File(out + entry.getName());
            if (entry.isDirectory()) {
                file.mkdirs();
            } else {
                byte[] bytes = zipInput.readAllBytes();
                Files.write(
                        Paths.get(file.getAbsolutePath()),
                        bytes,
                        StandardOpenOption.CREATE
                );

            }
        }
    }

    public static void writeFileToXip(File file, ZipOutputStream zipOutput, String path) throws Exception {
        if (file.isDirectory()) {
            String folder = path + file.getName() + "/";
            ZipEntry entry = new ZipEntry(folder);
            zipOutput.putNextEntry(entry);
            zipOutput.closeEntry();
            File[] files = file.listFiles();
            for (File subfile : files) {
                writeFileToXip(subfile, zipOutput, folder);
            }
            return;
        }
        ZipEntry entry = new ZipEntry(path + file.getName());
        zipOutput.putNextEntry(entry);
        byte[] bytes = Files.readAllBytes(Paths.get(file.getAbsolutePath()));
        zipOutput.write(bytes);
    }
}