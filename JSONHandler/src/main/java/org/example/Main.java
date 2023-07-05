package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        String jsonFile = Files.readString(Paths.get("/home/nikita/IdeaProjects/java_basics/ExceptionsDebuggingAndTesting/homework_2/SPBMetro/src/main/resources/map.json"));

        ObjectMapper mapper = new ObjectMapper(); // создаем объект ObjectMapper
        mapper.registerModule(new JavaTimeModule()); // добавляем моделя для работы со временем

        JsonNode jsonData = mapper.readTree(jsonFile); // создаем объект JsonNode, записываем в него строку
        // JsonNode базовый обстрактный класс, ObjectNode и ArrayNode - наследники

        JsonNode stations = jsonData.get("stations"); // создаем еще один объект, вычленяем станции
        JsonNode lines = jsonData.get("lines"); // еще один объект, вычленяем линии

        for (JsonNode line : lines) {
            ObjectNode lineNode = (ObjectNode) line; // приводим объекс JsonNode к ObjectNode
            lineNode.remove("color"); // удоляем элемент из объекста
            String lineNumber = line.get("number").asText(); // берем строку из поля number
            JsonNode statiionsList = stations.get(lineNumber); // создаем на основе стоки объект JsonNode
            int stationsCount = statiionsList.size(); // берем у объекта размер списка
            lineNode.put("stationsCount", stationsCount); // записываем новое поле со значением в ObjectNode
        }

        File output = new File("export.json");
        mapper.writeValue(output, lines); // запись в файл


        String json = Files.readString(Paths.get("person.json")); //

        Person person = mapper.readValue(json, Person.class);
        System.out.println(person.getJob().getSince());

        String newJson = mapper.writeValueAsString(person);
        FileWriter fileNewPerson = new FileWriter("newPerson.json");
        fileNewPerson.write(newJson);
        fileNewPerson.close();
    }
}