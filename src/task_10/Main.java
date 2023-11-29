package task_10;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            // 1. Создать файл (при помощи кода, не вручную).
            File file = new File("Hello, World!.txt");
            file.createNewFile();
            //проверка существония файла
            System.out.println("Существует ли файл? - " + file.exists());

            // 2. Записать в файл строку - "Hello, World! I *** study ***** Java!"./
            FileWriter writer = new FileWriter(file);
            writer.append("Hello, World! I *** study ***** Java!");
            writer.flush();
            // 3. Читать из файла информацию и выводить в консоль
            InputStream in = new FileInputStream("C:\\Users\\Di\\Lessons\\Lesson_54_2_massiv\\Hello, World!.txt");
            int date = in.read();
            while (date != -1) {
                System.out.print((char) date);
                date = in.read();

            }
            System.out.println();
            //4. После слова Hello пропустить нужное число байт, чтобы подстрока ", World" не была выведена.
            FileInputStream in1 = new FileInputStream("C:\\Users\\Di\\Lessons\\Lesson_54_2_massiv\\Hello, World!.txt");

            int date1;
            StringBuilder buffer = new StringBuilder();
            int charactersToSkip = 4;

            while ((date1 = in1.read()) != -1) {
                if (charactersToSkip > 0) {
                    charactersToSkip--;
                    buffer.append((char) date1); // Пропустить первые 4 знака
                    continue;
                }

                // Обнаружение подстроки ", World"
                if (date1 == ',' && buffer.toString().endsWith("Hello")) {
                    int skipWorld = ", World".getBytes().length;  // Пропустить нужное количество байт
                    while (skipWorld > 0) {
                        in1.read();
                        skipWorld--;
                    }
                } else {
                    buffer.append((char) date1);
                }

            }

            System.out.println();

            //5. Продолжить вывод так, чтобы выводилось в консоль всё, кроме звёздочек (не при помощи skip).
            in1.close(); // закрыть второй поток

            in1 = new FileInputStream("C:\\Users\\Di\\Lessons\\Lesson_54_2_massiv\\Hello, World!.txt"); // открыть третий поток
            date1 = in1.read();
            while (date1 != -1) {
                if (date1 != '*') {
                    System.out.print((char) date1);
                }
                date1 = in1.read();
            }

            in1.close();

            // 6. Итоговый вывод в консоль должен быть - "Hello! I study Java!".*/
            int helloIndex = buffer.indexOf("Hello"); // Поиск позиции "Hello"

            if (helloIndex != -1) {
                buffer.insert(helloIndex + "Hello".length(), "!"); // Вставка восклицательного знака после "Hello"
            }
            System.out.println();
            System.out.println(buffer.toString().replaceAll("\\*+", "").trim());

            in1.close();

        } catch (
                IOException e) {
            throw new RuntimeException(e);
        }
    }
}
/*
        1. Создать файл (при помощи кода, не вручную).
        2. Записать в файл строку - "Hello, World! I *** study ***** Java!".
        3. Читать из файла информацию и выводить в консоль.
        4. После слова Hello пропустить нужное число байт, чтобы подстрока ", World" не была выведена.
        5. Продолжить вывод так, чтобы выводилось в консоль всё, кроме звёздочек (не при помощи skip).
        6. Итоговый вывод в консоль должен быть - "Hello! I study Java!".*/
