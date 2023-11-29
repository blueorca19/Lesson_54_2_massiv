package task_5;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee("Aleks", "Developer", 1500));
        employees.add(new Employee("John", "Developer", 1500));
        employees.add(new Employee("Ken", "Developer", 900));
        employees.add(new Employee("Jeck", "Developer", 1500));
        employees.add(new Employee("Thomas", "Manager", 680.50));
        employees.add(new Employee("Thea", "CEO", 2000));
        employees.add(new Employee("Mary", "Manager", 700));


        //        0. Создать класс Employee
//        1. Вывести всех сотрудников без высшего руководителя
//        2. Сгруппировать сотрудников по должности
//        3. Вычислить среднюю зарплату всех сотрудников (двумя способами)
//        4. Получить список сотрудников с зп > 1000
//        5. Получить список сотрудников из отдела маркетинг и увеличить зп на 15%
//        6. Получить сотрудника с самой низкой зп
//        7. Получите сотрудников из всех отделов с максимальной зп
        System.out.println("Сотрудники без высшего руководителя:");
        List<Employee> result1 = employees.stream()
                .filter(x -> !x.getPozition().equals("CEO"))
                .toList();

        result1.forEach(System.out::println);

        System.out.println("Сгруппированные сотрудники по должности:");
        Map<String, List<Employee>> result2 = employees.stream()
                .collect(Collectors.groupingBy(x -> x.getPozition()));

        result2.forEach((x, y) -> {
            System.out.println(x);
            y.forEach(System.out::println);
        });
        System.out.println("Cредняя зарплата всех сотрудников 1 способ:");

        Double result3 = employees.stream()
                .collect(Collectors.averagingDouble(x -> x.getSalary()));
        System.out.println(result3);
        System.out.println("Cредняя зарплата всех сотрудников 2 способ:");

        double result4 = employees.stream()
                .mapToDouble(x -> x.getSalary())
                .average()
                .orElse(0);
        System.out.println(result4);
        System.out.println("Cписок сотрудников с зп > 1000");

        List<Employee> result5 = employees.stream()
                .filter(x -> x.getSalary() > 1000)
                .collect(Collectors.toList());
        result5.forEach(System.out::println);

        System.out.println("Cписок сотрудников из отдела маркетинг и увеличение зп на 15%");
        List<Employee> result6 = employees.stream()
                .filter(x -> x.getPozition().equals("Manager"))
                .peek(x -> x.setSalary((x.getSalary() * 1.15)))
                .collect(Collectors.toList());
        result6.forEach(System.out::println);

        System.out.println("Cотрудник с самой низкой зп");


        Employee result7 = employees.stream()
                .min(Comparator.comparingDouble(x -> x.getSalary()))
                .orElse(null);
        System.out.println(result7);

        System.out.println("Сотрудники из всех отделов с максимальной зп Способ 1");
        employees.stream()
                .collect(Collectors.groupingBy(x -> x.getPozition()))
                .forEach((x, y) -> y.stream()
                        .sorted((a, b) -> Double.compare(b.getSalary(), a.getSalary()))
                        .limit(1)
                        .forEach(System.out::println));

        System.out.println("Сотрудники из всех отделов с максимальной зп Способ 2");
        Map<String, List<Employee>> result8 = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getPozition,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparingDouble(x -> x.getSalary())),//сравниваем по зарплате, выводим макс.
                                optional -> optional.map(x -> Collections.singletonList(x))// для каждой позиции находим сотрудника
                                        // с максзарплатой, оборачивая его в список
                                        .orElse(null)
                        )
                ));
        result8.forEach((pozition, employeesList) -> {
            System.out.println("Отдел: " + pozition);
            employeesList.forEach(employee -> {
                System.out.println("Имя: " + employee.getName() + ", Зарплата: " + employee.getSalary());
            });
        });

        System.out.println("Все сотрудники из всех отделов с максимальной зп");
        Map<String, List<Employee>> employeesByPosition = employees.stream()
                .collect(Collectors.groupingBy(Employee::getPozition));
        for (List<Employee> list : employeesByPosition.values()) {
            if (list != null && !list.isEmpty()) {
                list.sort((x, y) -> Double.compare(y.getSalary(), x.getSalary()));
                double max = list.get(0).getSalary();
//                list.forEach(x -> {
//                    if (x.getSalary() == max) {
//                        System.out.println(x);
//                    }
//                });
                list.stream()
                        .filter(x -> x.getSalary() == max)
                        .forEach(System.out::println);
            }


        }


    }

}
