import java.util.*;
import java.util.stream.Collectors;

class Student {
    private String name;
    private double marks;

    public Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() { return name; }
    public double getMarks() { return marks; }

    @Override
    public String toString() {
        return "Student{name='" + name + "', marks=" + marks + "}";
    }
}

public class MediumLevel {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Alice", 85),
            new Student("Bob", 70),
            new Student("Charlie", 90),
            new Student("David", 60),
            new Student("Eve", 78)
        );

        // Filter students scoring above 75% and sort by marks
        List<Student> filteredAndSorted = students.stream()
            .filter(s -> s.getMarks() > 75)
            .sorted((s1, s2) -> Double.compare(s2.getMarks(), s1.getMarks())) // Sort in descending order
            .collect(Collectors.toList());

        System.out.println("Filtered and sorted students: ");
        filteredAndSorted.forEach(s -> System.out.println(s.getName()));
    }
}
