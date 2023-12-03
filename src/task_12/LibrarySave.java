package task_12;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class LibrarySave {
    public static void main(String[] args) {
        File file = new File("Library.txt");
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
            Library book1 = new Library(2014, 978 - 5 - 389 - 07471 - 2, 100, "Fugitive (collection)", "Alice Munro");
            Library book2 = new Library(2013, 978 - 5 - 389 - 0572 - 6, 203, "Phantom of the Opera", "Gaston Leroux");
            Library book3 = new Library(2013, 978 - 5 - 386 - 01 - 1, 300, "City of bones", "Cassandra Clare");
            System.out.println("Добавленные книги в каталог: ");
            System.out.println(book1);
            System.out.println(book2);
            System.out.println(book3);
            file.createNewFile();
            out.writeObject(book1);
            out.writeObject(book2);
            out.writeObject(book3);



        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
