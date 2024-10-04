package streams;

import data.Student;
import data.StudentDataBase;

import java.util.Optional;

public class StreamMapReduceExample {

    public static void main(String[] args) {
        getNotebooksCount().ifPresent(System.out::println);
        getNotebooksCountForFemaleStudentsWithGradeAboveTwo().ifPresent(System.out::println);
    }

    private static Optional<Integer> getNotebooksCount() {
        return StudentDataBase.getAllStudents()
                .stream()
                .map(Student::getNoteBooks)
                .reduce(Integer::sum);
    }

    private static Optional<Integer> getNotebooksCountForFemaleStudentsWithGradeAboveTwo() {
        return StudentDataBase.getAllStudents()
                .stream()
                .filter(s -> s.getGender().equals("female"))
                .filter(s -> s.getGradeLevel() >= 3)
                .map(Student::getNoteBooks)
                .reduce(Integer::sum);
    }
}
