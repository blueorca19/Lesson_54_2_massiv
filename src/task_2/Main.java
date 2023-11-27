package task_2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        //вывести все элементы массива в одну строку кроме b
        String[][] array = {{"a","b"},
                {"c","d","e","f"},
                {"g","h","i"}};

        List<String> result = Arrays.stream(array)
                .flatMap(x -> Arrays.stream(x))
                .filter(x -> !x.equals("b"))
                .collect(Collectors.toList());

        System.out.println("Результат - " + result);
    }
}
