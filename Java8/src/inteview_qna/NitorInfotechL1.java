package inteview_qna;

import java.util.*;
import java.util.stream.Collectors;

/**
 * You are given a list of students, where each student has a name and a
 * set of marks in various subjects. Implement a Java program using the
 * Stream API to calculate the average marks of each student and return a
 * map containing the student name along with their average marks.
 *
 */
public class NitorInfotechL1 {

    public static void main(String[] args) {
        Student s1 = new Student();
        s1.name = "Ram";
        s1.marks = new HashMap<>();
        s1.marks.put("Maths", 80);
        s1.marks.put("Science", 70);
        s1.marks.put("Computer", 90);

        Student s2 = new Student();
        s2.marks = new HashMap<>();
        s2.name = "Shyam";
        s2.marks.put("Maths", 50);
        s2.marks.put("Science", 90);
        s2.marks.put("Computer", 95);

        List<Student> students = new ArrayList<>();
        students.add(s1);
        students.add(s2);

        Map<String, Double> averageMarks = students.stream()
                .collect(Collectors.toMap(
                        Student::getName, // Key: Student's name
                        student -> student.getMarks().values().stream() // Stream over the student's marks
                                .mapToInt(Integer::intValue) // Convert Integer to int
                                .average() // Calculate the average
                                .orElse(0.0) // Default value if no marks (though not needed here)
                ));

        // Print the average marks of each student
        averageMarks.forEach((name, avgMarks) -> System.out.println(name + ": " + avgMarks));
    }

    static class Student {
        String name;
        Map<String, Integer> marks;

        public String getName() {
            return name;
        }

        public Map<String, Integer> getMarks() {
            return marks;
        }
    }
}
