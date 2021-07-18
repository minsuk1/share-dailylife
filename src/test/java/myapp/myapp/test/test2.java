package myapp.myapp.test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class test2 {
    public static void main(String[] args) {
        List<Book> totalList = Arrays.asList(
                new Book("Apple", 1800),
                new Book("Apple", 900),
                new Book("Grape", 3100),
                new Book("Grape", 3100),
                new Book("Mango", 3100),
                new Book("Mango", 3100));

        List<Book> apple = totalList.stream().filter(s -> s.getName() == "Apple").collect(Collectors.toList());
        System.out.println(apple);
        apple.stream().forEach(s -> System.out.println(s.getClass()));
        apple.stream().forEach(s -> System.out.println(s.getName()));

        System.out.println("-----------------------------");

        Set<Book> femaleSet = totalList.stream() .filter(s -> s.getIsbn() == 3100) .collect(Collectors.toSet());
        System.out.println(femaleSet);

        femaleSet.stream() .forEach(s-> System.out.println(s.getName()));

        System.out.println("-----------------------------");

        Set<String> set = new HashSet<String>();

        set.add("apple");
        set.add("banana");
        set.add("apple");
        set.add("kiwi");

        System.out.println(set);



    }
}
