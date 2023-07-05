package org.example;

import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.exception.ZipException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.io.File;


public class GUIForm {
    private JPanel rootPanel;
    private JButton selectButton;
    private JButton actionButton;
    private JTextField filePath;
    private File selectedFile;
    private boolean encryptedFileSelector = true;
    private String decryptAction = "Расшифровать";
    private String encryptAction = "Зашифровать";

    public GUIForm() {
        actionButton.addActionListener(new Action() {
            @Override
            public Object getValue(String key) {
                return null;
            }

            @Override
            public void putValue(String key, Object value) {

            }

            @Override
            public void setEnabled(boolean b) {

            }

            @Override
            public boolean isEnabled() {
                return false;
            }

            @Override
            public void addPropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void removePropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedFile == null) {
                    return;
                }
                setButtonsEnable(false);
                String password = JOptionPane.showInputDialog("Введите пароль");
                if (password == null || password.length() == 0) {
                    JOptionPane.showMessageDialog(rootPanel, "Пароль не указан", "Ошибка", JOptionPane.WARNING_MESSAGE);
                }
                if (encryptedFileSelector) {
                    decryptFile(password);
                } else {
                    encryptFile(password);
                }
                setButtonsEnable(true);
            }
        });
        selectButton.addActionListener(new Action() {
            @Override
            public Object getValue(String key) {
                return null;
            }

            @Override
            public void putValue(String key, Object value) {

            }

            @Override
            public void setEnabled(boolean b) {

            }

            @Override
            public boolean isEnabled() {
                return false;
            }

            @Override
            public void addPropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void removePropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                chooser.showOpenDialog(rootPanel);
                selectedFile = chooser.getSelectedFile();
                onFileSelect();
            }
        });
    }

    private void onFileSelect() {
        if (selectedFile == null) {
            filePath.setText("");
            actionButton.setVisible(false);
            return;
        }
        filePath.setText(selectedFile.getAbsolutePath());
        ZipFile zipFile = new ZipFile(selectedFile);
        encryptedFileSelector = zipFile.isValidZipFile();
        actionButton.setText(encryptedFileSelector ? decryptAction : encryptAction);
        actionButton.setVisible(true);
    }


    private void encryptFile(String password) {
        Encrypter encrypter = new Encrypter(this);
        encrypter.setFile(selectedFile);
        encrypter.setPassword(password);
        encrypter.start();
    }

    private void decryptFile(String password) {
        Decrypter decrypter = new Decrypter(this);
        decrypter.setFile(selectedFile);
        decrypter.setPassword(password);
        decrypter.start();
    }


    public JPanel getRootPanel() {
        return rootPanel;
    }

    public void showFinished() {
        JOptionPane.showMessageDialog(
                rootPanel,
                encryptedFileSelector ? "Расшифровка завершена" : "Шифрование завершено", "Завершено",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public void setButtonsEnable(boolean enable) {
        selectButton.setEnabled(enable);
        actionButton.setEnabled(enable);
    }


}
