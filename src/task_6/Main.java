package task_6;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[][][] array = {{{1, 2, 3}, {4, 5, 6, 7}},

                {{4, 2, 2}, {7, 6}, {1, 9, 5}, {1, 6, 4}},

                {{1, 1}, {8, 6, 4, 2}, {5, 9}}};

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                for (int k = 0; k < array[i][j].length; k++) {
                    System.out.print(array[i][j][k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
