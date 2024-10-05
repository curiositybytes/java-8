package streams_terminal;

import data.Student;
import data.StudentDataBase;

import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.*;

public class StreamsMappingExample {

    public static void main(String[] args) {
        System.out.println(getStudentNamesInList());
        System.out.println(getStudentNamesInSet());
    }

    private static List<String> getStudentNamesInList() {
        return StudentDataBase.getAllStudents().stream()
                .collect(mapping(Student::getName, toList()));
    }

    private static Set<String> getStudentNamesInSet() {
        return StudentDataBase.getAllStudents().stream()
                .collect(mapping(Student::getName, toSet()));
    }
}
