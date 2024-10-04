package streams;

import data.Student;
import data.StudentDataBase;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamReduceExample {

    public static void main(String[] args) {
        System.out.println(performMultiplication(Arrays.asList(1, 3, 5, 7)));
        Optional<Integer> res = performMultiplicationWithoutIdentity(Arrays.asList(1, 3, 5, 7));
        res.ifPresent(System.out::println);
        System.out.println(getStudentWithHighestGrade());
    }

    private static int performMultiplication(List<Integer> list) {
        return list.stream().reduce(1, (a,b) -> a*b);
    }

    private static Optional<Integer> performMultiplicationWithoutIdentity(List<Integer> list) {
        return list.stream().reduce((a,b) -> a*b);
    }

    private static Optional<Student> getStudentWithHighestGrade() {
        return StudentDataBase.getAllStudents()
                .stream()
                .reduce((s1,s2) -> s1.getGpa() > s2.getGpa() ? s1 : s2);
    }
}
