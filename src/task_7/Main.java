package task_7;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите возраст:");
        int age = scanner.nextInt();

        if (age < 0) {
            System.out.println("Возраст не может быть отрицательным!");
            System.err.println("Возраст не может быть отрицательным!");
            return;
        }

        System.out.println("Ваш возраст " + age);
    }
}


