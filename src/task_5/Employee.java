package task_5;

import java.util.Objects;

public class Employee {

    private String name;
    private String pozition;
    private double salary;

    public Employee(String name, String pozition, double salary) {
        this.name = name;
        this.pozition = pozition;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPozition() {
        return pozition;
    }

    public void setPozition(String pozition) {
        this.pozition = pozition;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Double.compare(salary, employee.salary) == 0 && Objects.equals(name, employee.name) && Objects.equals(pozition, employee.pozition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, pozition, salary);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", pozition='" + pozition + '\'' +
                ", salary=" + salary +
                '}';
    }
}
