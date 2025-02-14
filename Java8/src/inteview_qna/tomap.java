package inteview_qna;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * For a given list of Student objects, where each Student has a rollNo and a name, generate two maps:
 *
 * 1. A map where the key is the name of the student and the value is the student object.
 *      If there are duplicate names, return the first occurrence.
 * 2. A map where the key is the rollNo of the student and the value is the student object.
 *      If there are duplicate roll numbers, return the last occurrence.
 *
 */
public class tomap {

    public static void main(String[] args) {
        Student s1 = new Student();
        s1.rollNo = 1;
        s1.name = "Dheeraj";

        Student s2 = new Student();
        s2.rollNo = 2;
        s2.name = "Akash";

        Student s3 = new Student();
        s3.rollNo = 1;
        s3.name = "Dheeraj";

        List<Student> students = new ArrayList<>();
        students.add(s1);
        students.add(s2);
        students.add(s3);

        Map<String, Student> studentMap = students
                .stream()
                .collect(Collectors.toMap(Student::getName, Function.identity(),
                        (a,b) -> a));

        Map<Integer, Student> studentMapRollNo = students
                .stream()
                .collect(Collectors.toMap(Student::getRollNo, Function.identity(),
                        (a,b) -> b));

        System.out.println(studentMap);
        System.out.println(studentMapRollNo);
    }

    static class Student {
        int rollNo;
        String name;

        public int getRollNo() {
            return rollNo;
        }

        public String getName() {
            return name;
        }
    }
}
