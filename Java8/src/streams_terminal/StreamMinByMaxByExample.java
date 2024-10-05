package streams_terminal;

import data.Student;
import data.StudentDataBase;

import java.util.Comparator;
import java.util.Optional;

import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.minBy;

public class StreamMinByMaxByExample {

    public static void main(String[] args) {
        System.out.println(getStudentWithLowestGpa());
        System.out.println(getStudentWithHighestGpa());
    }

    private static Optional<Student> getStudentWithLowestGpa() {
        return StudentDataBase.getAllStudents()
                .stream()
                .collect(minBy(Comparator.comparing(Student::getGpa)));
    }

    private static Optional<Student> getStudentWithHighestGpa() {
        return StudentDataBase.getAllStudents()
                .stream()
                .collect(maxBy(Comparator.comparing(Student::getGpa)));
    }
}
