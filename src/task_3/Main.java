package task_3;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student(1, "John");
        Student student2 = new Student(2, "Jack");
        Student student3 = new Student(3, "Bob");

        student1.addBook("Java Basic");
        student1.addBook("Java Pro");
        student1.addBook("Spring");
        student1.addBook("Python");

        student2.addBook("HTML");
        student2.addBook("CSS");
        student2.addBook("JavaScript");
        student2.addBook("Spring");

        student3.addBook("Python");
        student3.addBook("C++");
        student3.addBook("C#");

        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);

        // Вывести список всех книг, прочитанных студентами,
        // и не содержащих подстроку "Java".

        Set<String> books = students.stream()
                .flatMap(x -> x.getBooks().stream())
                .filter(x -> !x.contains("Java"))
                .collect(Collectors.toSet());
        System.out.println("Список всех книг, не содержащих 'Java': ");
        System.out.println(books);
        System.out.println("1 строка\n2 строка");
        books.forEach(System.out::println);
        books.forEach(x -> System.out.println(x));
    }
}
