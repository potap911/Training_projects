package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;


import java.util.ArrayList;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws Exception {
        ArrayList<String> list = new ArrayList<>();

        String url = "https://javarush.com/";
        Document doc = Jsoup.connect(url).get();
        Elements images = doc.select("img");


        for (Element image : images) {
            list.add(image.attr("abs:src"));
        }

        for (int i = 0; i < list.size(); i++) {
            String extension = list.get(i)
                    .replaceAll("^.+\\.", "")
                    .replace("?.+$", "");
        }

        list.forEach(System.out::println);








    }
}