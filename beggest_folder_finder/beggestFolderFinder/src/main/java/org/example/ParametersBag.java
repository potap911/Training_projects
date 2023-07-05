package org.example;

import java.io.File;

public class ParametersBag {
    private long limit;
    private String path;
    public ParametersBag(String[] args) throws IllegalAccessException {
        if (args.length != 4) {
            throw  new IllegalAccessException("Укажите два параметра: -l (лимит по объему) и -d (путь к папке)");
        }
        limit = 0;
        path = "";

        for (int i = 0; i < 4; i = i + 2) {
            if (args[i].equals("-l")) {
                limit = Long.parseLong(args[i + 1]);
            } else if (args[i].equals("-d")) {
                path = args[i + 1];
            }
        }
        if (limit < 0) {
            throw new IllegalAccessException("Лимит не указан или указан не верно");
        }
        File folder = new File(path);
        if (!folder.exists() || !folder.isDirectory()) {
            throw new IllegalAccessException("Путь к папке не указан или не указан не верно");
        }
    }
    public long getLimit() {
        return 0;
    }
    public String getPath() {
        return "";
    }
}
