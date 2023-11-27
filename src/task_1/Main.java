package task_1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //преобразровать двумерный массив в одномерный

        int[][] array = {{5, 9, 2},
                {1, 3, 2, 9},
                {6, 2}};
        int[] result = Arrays.stream(array) //стрим одномерных массивов int[]
                .flatMapToInt(x -> Arrays.stream(x)) //stream чисел 5,9,2,1,3,2,9,6,2
                .toArray();

        System.out.println("Исходный массив - " + Arrays.toString(array));
        System.out.println("Результат - " + Arrays.toString(result));

        System.out.println("Вывод через стрим элементов двумерного массива - ");
        Arrays.stream(array).forEach(x -> System.out.println(Arrays.toString(x)));

    }
}
