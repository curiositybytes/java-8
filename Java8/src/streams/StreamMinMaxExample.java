package streams;

import data.Student;
import data.StudentDataBase;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamMinMaxExample {

    public static void main(String[] args) {
        findMaxValue(Arrays.asList(1, 3, 9, 5, 7)).ifPresent(System.out::println);
        findMinValue(Arrays.asList(1, 3, 9, -2, 5, 7)).ifPresent(System.out::println);
    }

    private static Optional<Integer> findMaxValue(List<Integer> numbers) {
        return numbers.stream()
                .reduce(Math::max);
    }

    private static Optional<Integer> findMinValue(List<Integer> numbers) {
        return numbers.stream()
                .reduce(Math::min);
    }
}
