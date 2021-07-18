package myapp.myapp.test;


import java.util.*;
import java.util.stream.Collectors;
import java.util.HashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class test {
    public static void main(String[] args) {
        Map<String,Integer> map=new HashMap();	//<키 자료형, 값 자료형>
        map.put("A", 100);
        map.put("B", 101);
        map.put("C", 102);
        map.put("C", 103); //중복된 key가 들어갈때는 이전 키,값을 지금의 것으로 업데이트
        System.out.println(map);


        List<String> names = Arrays.asList("son", "ryu", "kang");
        Stream<String> stream = names.stream()
                .map(String::toUpperCase);
        System.out.println(stream);

        List<String> lang = Arrays.asList("Java", "Scala", "Groovy", "Python", "Go", "Swift");
        lang.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());


        List<Book> items = Arrays.asList(
                new Book("Apple", 1800),
                new Book("Banana", 900),
                new Book("Grape", 3100),
                new Book("Mango", 11));

        Map<String, Integer> itemMap = items.stream()
                .collect(Collectors.toMap(Book::getName, Book::getIsbn));

        System.out.println(itemMap);
    }
}