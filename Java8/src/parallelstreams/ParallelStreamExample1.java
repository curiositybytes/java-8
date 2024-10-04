package parallelstreams;

import data.Student;
import data.StudentDataBase;

import java.util.List;
import java.util.stream.Collectors;

public class ParallelStreamExample1 {

    public static void main(String[] args) {
        System.out.println("Sequential duration = " + getDistinctActivitiesSortedListSequentially());
        System.out.println("Parallel duration = " + getDistinctActivitiesSortedListParallely());
    }

    private static long getDistinctActivitiesSortedListSequentially() {
        final long startTime = System.currentTimeMillis();
        StudentDataBase.getAllStudents()
                .stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        final long endTime = System.currentTimeMillis();

        return endTime - startTime;
    }

    private static long getDistinctActivitiesSortedListParallely() {
        final long startTime = System.currentTimeMillis();
        StudentDataBase.getAllStudents()
                .parallelStream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        final long endTime = System.currentTimeMillis();

        return endTime - startTime;
    }
}
