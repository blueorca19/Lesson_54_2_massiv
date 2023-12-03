package task_12;

import task_11.Cat;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class LibraryLoad {
    public static void main(String[] args) {
        File file = new File("Library.txt");
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            Library book1 = (Library) in.readObject();
            Library book2 = (Library) in.readObject();
            Library book3 = (Library) in.readObject();

            System.out.println("Проверенные книги в каталоге: ");
            System.out.println(book1);
            System.out.println(book2);
            System.out.println(book3);


        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

    }
}
