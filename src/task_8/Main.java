package task_8;

import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) {
        try {
            InputStream in = new FileInputStream("C:\\Users\\Di\\Lessons\\Lesson_54_2_massiv\\src\\task_8\\test.txt");
        //    System.out.println((char) in.read());
            int date = in.read();
            while (date != -1) {
                System.out.print((char) date);
                date = in.read();
            }

        } catch (Exception e) {
            throw new RuntimeException("File not found: test.txt", e);
        }

    }
}
