package streams_terminal;

import data.Student;
import data.StudentDataBase;

import static java.util.stream.Collectors.joining;

public class StreamsJoiningExample {

    public static void main(String[] args) {
        System.out.println(joiningVariation1());
        System.out.println(joiningVariation2());
        System.out.println(joiningVariation3());
    }

    private static String joiningVariation3() {
        return StudentDataBase.getAllStudents().stream()
                .map(Student::getName)
                .collect(joining("-", "(", ")"));
    }

    private static String joiningVariation2() {
        return StudentDataBase.getAllStudents().stream()
                .map(Student::getName)
                .collect(joining("-"));
    }

    private static String joiningVariation1() {
        return StudentDataBase.getAllStudents().stream()
                .map(Student::getName)
                .collect(joining());
    }
}
