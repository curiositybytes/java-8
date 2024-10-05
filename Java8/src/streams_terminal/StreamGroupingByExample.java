package streams_terminal;

import data.Student;
import data.StudentDataBase;

import java.util.*;

import static java.util.stream.Collectors.*;

public class StreamGroupingByExample {

    public static void main(String[] args) {
        System.out.println(groupStudentsByGender());
        System.out.println(groupStudentsByGpaCustomized());
        System.out.println(twoLevelGrouping_1());
        System.out.println(twoLevelGrouping_2());
        System.out.println(threeArgumentGroupingBy());
        System.out.println(studentWithLeastGpa());
        System.out.println(studentWithLeastGpaWithoutOptional());
        System.out.println(studentWithTopGpa());
        System.out.println(studentWithTopGpaWithoutOptional());
    }

    private static Map<String, List<Student>> groupStudentsByGender() {
        return StudentDataBase.getAllStudents().stream()
                .collect(groupingBy(Student::getGender));
    }

    private static Map<String, List<Student>> groupStudentsByGpaCustomized() {
        return StudentDataBase.getAllStudents().stream()
                .collect(groupingBy(student -> student.getGpa() >= 3.8 ? "OUTSTANDING" : "AVERAGE"));
    }

    private static Map<Integer, Map<String, List<Student>>> twoLevelGrouping_1() {
        return StudentDataBase.getAllStudents().stream()
                .collect(groupingBy(Student::getGradeLevel,
                        groupingBy(student -> student.getGpa() >= 3.8 ? "OUTSTANDING" : "AVERAGE")));
    }

    private static Map<Integer, Integer> twoLevelGrouping_2() {
        return StudentDataBase.getAllStudents().stream()
                .collect(groupingBy(Student::getGradeLevel,
                        summingInt(Student::getNoteBooks)));
    }

    private static LinkedHashMap<String, Set<Student>> threeArgumentGroupingBy() {
        return StudentDataBase.getAllStudents().stream()
                .collect(groupingBy(Student::getName,
                        LinkedHashMap::new, toSet()));
    }

    private static Map<Integer, Student> studentWithLeastGpa() {
        return StudentDataBase.getAllStudents().stream()
                .collect(groupingBy(Student::getGradeLevel,
                        collectingAndThen(minBy(Comparator.comparing(Student::getGpa)), Optional::get)));
    }

    private static Map<Integer, Student> studentWithLeastGpaWithoutOptional() {
        return StudentDataBase.getAllStudents().stream()
                .collect(groupingBy(Student::getGradeLevel,
                        collectingAndThen(minBy(Comparator.comparing(Student::getGpa)), Optional::get)));
    }

    private static Map<Integer, Optional<Student>> studentWithTopGpa() {
        return StudentDataBase.getAllStudents().stream()
                .collect(groupingBy(Student::getGradeLevel, maxBy(Comparator.comparing(Student::getGpa))));
    }

    private static Map<Integer, Student> studentWithTopGpaWithoutOptional() {
        return StudentDataBase.getAllStudents().stream()
                .collect(groupingBy(Student::getGradeLevel,
                        collectingAndThen(maxBy(Comparator.comparing(Student::getGpa)), Optional::get)));
    }
}
