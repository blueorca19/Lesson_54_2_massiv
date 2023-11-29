package task_9;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            File file = new File("test_file.txt");
            System.out.println("Существует ли файл? - " + file.exists());
            file.createNewFile();
            System.out.println("Существует ли файл? - " + file.exists());
            InputStream in = new FileInputStream(file);
            OutputStream out = new FileOutputStream(file);
            out.write('W');
            FileWriter writer = new FileWriter(file);
            writer.append("This is test information!");
            writer.flush();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


/*
        1. Создать файл (при помощи кода, не вручную).
        2. Записать в файл строку - "Hello, World! I *** study ***** Java!".
        3. Читать из файла информацию и выводить в консоль.
        4. После слова Hello пропустить нужное число байт, чтобы подстрока ", World" не была выведена.
        5. Продолжить вывод так, чтобы выводилось в консоль всё, кроме звёздочек (не при помощи skip).
        6. Итоговый вывод в консоль должен быть - "Hello! I study Java!".*/
    }
}
