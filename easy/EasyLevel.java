import java.util.*;

class Employee {
    private String name;
    private int age;
    private double salary;

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public double getSalary() { return salary; }

    @Override
    public String toString() {
        return "Employee{name='" + name + "', age=" + age + ", salary=" + salary + "}";
    }
}

public class EasyLevel {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("Alice", 30, 50000),
            new Employee("Bob", 45, 60000),
            new Employee("Charlie", 25, 45000),
            new Employee("David", 35, 55000)
        );

        // Sort employees by name
        employees.sort((e1, e2) -> e1.getName().compareTo(e2.getName()));
        System.out.println("Employees sorted by name: " + employees);

        // Sort employees by age
        employees.sort((e1, e2) -> Integer.compare(e1.getAge(), e2.getAge()));
        System.out.println("Employees sorted by age: " + employees);

        // Sort employees by salary
        employees.sort((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        System.out.println("Employees sorted by salary: " + employees);
    }
}
