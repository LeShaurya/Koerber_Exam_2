package com.customer_app.Q1;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;


public class Q1Sol {
    public static void main(String[] args) {
        Map<String, Integer> map=new HashMap<String, Integer>();
        map.put("raj", 95);
        map.put("ekta", 75);
        map.put("rajiv", 85);
        map.put("sunita", 66);
        map.put("gunika", 99);

        System.out.println("1------printing map------");
        map.entrySet().forEach(System.out::println);

        System.out.println("2------contain raj------");
        map.entrySet().stream().filter(entry -> entry.getKey().contains("raj"))
                .forEach(System.out::println);

        System.out.println("3------sorted(key)------");
        map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(System.out::println);

        System.out.println("4------sorted(key)------");
        map.entrySet().stream()
                .sorted((Map.Entry.comparingByValue()))
                .forEach(System.out::println);

        System.out.println("5------reverse sorted(key)------");
        map.entrySet().stream()
                .sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey()))
                .forEach(System.out::println);

        Map<Student, Integer> map1=new HashMap<>();
        map1.put(new Student(109, "raj", 95), 95);
        map1.put(new Student(61, "keta", 78), 78);
        map1.put(new Student(11, "gunika", 98), 98);
        map1.put(new Student(19, "keshav", 97), 97);

        System.out.println("6------printing map------");
        map1.entrySet().forEach(System.out::println);

        System.out.println("7------sorted(name)------");
        map1.entrySet().stream()
                .sorted(Comparator.comparing(e -> e.getKey().getName()))
                .forEach(System.out::println);

        System.out.println("8------sorted(id)------");
        map1.entrySet().stream()
                .sorted(Comparator.comparing(e -> e.getKey().getId()))
                .forEach(System.out::println);

    }
}
