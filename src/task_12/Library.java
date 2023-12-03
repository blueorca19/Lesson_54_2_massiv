package task_12;

import java.io.Serializable;
import java.util.Objects;

public class Library implements Serializable {
//    Написать любой класс на собственное усмотрение. В классе должно быть минимум 5 полей.
//    Создать ещё один класс и написать программу, которая создаёт три объекта этого класса и сохраняет их в файл.
//    Создать ещё класс и написать программу, которая считывает три объекта из файла, выводит их в консоль.

    int year;
    int ISBN;
    int numberOfPages;
    String name;
    String author;

    public Library(int year, int ISBN, int numberOfPages, String name, String author) {
        this.year = year;
        this.ISBN = ISBN;
        this.numberOfPages = numberOfPages;
        this.name = name;
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public int getISBN() {
        return ISBN;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Library library = (Library) o;
        return year == library.year && ISBN == library.ISBN && numberOfPages == library.numberOfPages && Objects.equals(name, library.name) && Objects.equals(author, library.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, ISBN, numberOfPages, name, author);
    }

    @Override
    public String toString() {
        return "Library{" +
                "Год издания = " + year +
                ", ISBN = " + ISBN +
                ", Число страниц = " + numberOfPages +
                ", Наименование = '" + name + '\'' +
                ", Автор = '" + author + '\'' +
                '}';
    }
}
