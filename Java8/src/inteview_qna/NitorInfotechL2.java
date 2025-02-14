package inteview_qna;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiFunction;

import static java.util.stream.Collectors.*;

/**
 * Asked in the interview for Nitor Infotech.
 * Student class contains two integer fields ID and Marks.
 * Given two list of students containing the student id and marks in any two subjects.
 * WAP to find the student ID, of the student who scored maximum, in all the subjects combined.
 * A student does not pass if he has not given tests for all the subjects. Only consider the students
 * who appeared in all the exams.
 *
 */

public class NitorInfotechL2 {

    public static void main(String[] args) {
        BiFunction<Integer, Integer, Student> createStudent = Student::new;
        List<Student> english = new ArrayList<>();
        english.add(createStudent.apply(1, 20));
        english.add(createStudent.apply(2, 30));
        english.add(createStudent.apply(3, 40));
        english.add(createStudent.apply(4, 50));

        List<Student> maths = new ArrayList<>();
        maths.add(createStudent.apply(1, 40));
        maths.add(createStudent.apply(2, 50));
        maths.add(createStudent.apply(3, 70));
        maths.add(createStudent.apply(5, 150));

        List<Student> combined = new ArrayList<>();
        combined.addAll(english);
        combined.addAll(maths);

        combined = combined.stream().collect(groupingBy(Student::getId))
                .values()
                .stream()
                .filter(sList -> sList.size() > 1)
                .flatMap(List::stream)
                .collect(toList());

        Map<Integer, Integer> grouped = combined
                .stream()
                .collect(groupingBy(Student::getId, summingInt(Student::getMarks)));

        Optional<Integer> max = grouped.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey);


        max.ifPresent(System.out::println);


    }
}

class Student {
    private int id;
    private int marks;

    public Student() {
        this.id = 0;
        this.marks = 0;
    }

    public Student(int id, int marks) {
        this.id = id;
        this.marks = marks;
    }

    public int getId() {
        return id;
    }

    public int getMarks() {
        return marks;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }
}
