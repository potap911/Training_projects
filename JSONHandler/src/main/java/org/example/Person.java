package org.example;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;


@Data
@NoArgsConstructor
public class Person {
    private String name;
    private int age;
    private boolean isMarried;
    private List<String> hobbies;
    private List<String> children;
    private Car car;
    private Job job;

    @Data
    public class Job {
        private LocalDate since;
        private String city;
        private BigDecimal salary;

    }

    @Data
    public class Car {
        private String licensePlate;
    }

    public Person(String name, int age, boolean isMarried, List<String> hobbies, List<String> children) {
        this.name = name;
        this.age = age;
        this.isMarried = isMarried;
        this.hobbies = hobbies;
        this.children = children;
    }

    public Person(String name, int age, boolean isMarried, List<String> hobbies, List<String> children, Car car, Job job) {
        this.name = name;
        this.age = age;
        this.isMarried = isMarried;
        this.hobbies = hobbies;
        this.children = children;
        this.car = car;
        this.job = job;
    }
}
