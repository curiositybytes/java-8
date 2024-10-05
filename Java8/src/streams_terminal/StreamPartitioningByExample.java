package streams_terminal;

import data.Student;
import data.StudentDataBase;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.stream.Collectors.partitioningBy;
import static java.util.stream.Collectors.toSet;

public class StreamPartitioningByExample {

    public static void main(String[] args) {
        System.out.println(partitioningBy_1());
        System.out.println(partitioningBy_2());
    }

    private static Map<Boolean, List<Student>> partitioningBy_1() {
        return StudentDataBase.getAllStudents().stream()
                .collect(partitioningBy(student -> student.getGpa() >= 3.8));
    }

    private static Map<Boolean, Set<Student>> partitioningBy_2() {
        return StudentDataBase.getAllStudents().stream()
                .collect(partitioningBy(student -> student.getGpa() >= 3.8, toSet()));
    }
}
