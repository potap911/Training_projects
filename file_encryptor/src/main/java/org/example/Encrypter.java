package org.example;

import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.model.enums.AesKeyStrength;
import net.lingala.zip4j.model.enums.EncryptionMethod;

import java.io.File;

public class Encrypter extends Thread {
    private String password;
    private GUIForm form;
    private File file;
    private ZipFile zipFile;

    public Encrypter(GUIForm form) {
        this.form = form;
    }

    public void setFile(File file) {
        this.file = file;
    }

    void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void run() {
        onStart();
        try {
            String archiveName = getArchiveName();
            zipFile = new ZipFile(archiveName, password.toCharArray());
            if (file.isDirectory()) {
                zipFile.addFolder(file);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        onFinish();
    }

    private String getArchiveName() {
        for (int i = 0; ; i++) {
            String number = i > 1 ? Integer.toString(i) : "";
            String archiveName = file.getAbsolutePath() + number + ".enc";
            if (!new File(archiveName).exists()) {
                return archiveName;
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
