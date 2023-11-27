package task_3;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Student {

    private int id;
    private String name;
    private Set<String> books = new HashSet<>();

    public Student(int id, String name) {
        this.id = id;
        this.name = name;

    }
    public void addBook (String book){
        books.add(book);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<String> getBooks() {
        return books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && Objects.equals(name, student.name) && Objects.equals(books, student.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, books);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", books=" + books +
                '}';
    }
}
