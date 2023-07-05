package org.example;

import java.io.File;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ForkJoinPool;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        /*String[] argum = {"-d", "/home/nikita/IdeaProjects", "-l", String.valueOf(1000000000)};
        ParametersBag bag = new ParametersBag(argums);*/

        String folderPath = "/home/nikita/IdeaProjects";
        long sizeLimit = 0;
        File file = new File(folderPath);
        Node root = new Node(file);

        FolderSizeCalculator calculator = new FolderSizeCalculator(root);
        calculator.compute();

        System.out.println(root);


    }


}