package streams_terminal;

import data.Student;
import data.StudentDataBase;

import static java.util.stream.Collectors.averagingInt;
import static java.util.stream.Collectors.summingInt;

public class StreamSumAvgExample {

    public static void main(String[] args) {
        System.out.println(sum());
        System.out.println(average());
    }

    private static int sum() {
        return StudentDataBase.getAllStudents().stream()
                .collect(summingInt(Student::getNoteBooks));
    }

    private static Double average() {
        return StudentDataBase.getAllStudents().stream()
                .collect(averagingInt(Student::getNoteBooks));
    }
}
