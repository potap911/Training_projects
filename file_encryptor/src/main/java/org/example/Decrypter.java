package org.example;

import net.lingala.zip4j.ZipFile;

import javax.swing.*;
import java.io.File;

public class Decrypter extends Thread {
    private String password;
    private GUIForm form;
    private File file;
    private ZipFile zipFile;

    public Decrypter(GUIForm form) {
        this.form = form;
    }
    public void setFile(File file) {
        this.file = file;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void run() {
        onStart();
        try {
            String outPath = getOutPutPath();
            ZipFile zipFile = new ZipFile(file, password.toCharArray());
            zipFile.extractAll(outPath);
        } catch (Exception ex) {
            if (ex.getMessage().contains("Wrong Password")) {
                JOptionPane.showMessageDialog(form.getRootPanel(), "Неверный пароль", "Ошибка", JOptionPane.WARNING_MESSAGE);
            } else ex.printStackTrace();
        }
        onFinish();
    }
    private String getOutPutPath() {
        String path = file.getAbsolutePath()
                .replaceAll("\\.enc$", "");
        for (int i = 1; ; i++) {
            String number = i > 1 ? Integer.toString(i) : "";
            String outPath = path + number;
            if (!new File(path + number).exists()) {
                return outPath;
            }
        }
    }

    private void onStart() {
        form.setButtonsEnable(false);
    }
    private void onFinish() {
        form.setButtonsEnable(true);
        zipFile.setPassword("".toCharArray());
        form.showFinished();

    }
}
