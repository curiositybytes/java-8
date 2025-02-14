package practice_questions;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Basic {
    public static void main(String[] args) {
        System.out.println(filterEvenNumbers(new int[] {1,2,3,5,6,2,10,34,53,7}));
        System.out.println(convertToUppercase(Arrays.asList("abc", "hello", "WorLD")));
        System.out.println(filterStringWithStarting(Arrays.asList("abc", "hello", "WorLD"), "a"));
        System.out.println(sumOfNumbers(new int[]{1,2,3,4,5}));
        System.out.println(sumOfNumbersReduce(new int[]{1,2,3,4,5}));
        System.out.println(sortNumbers(new int[]{1,7,5,6,2,10,34,53,7}));
        System.out.println(sortNumbersUsingComparator(new int[]{1,7,5,6,2,10,34,53,7}));
        System.out.println(findDuplicateNumbers(new int[]{1,2,3,4,3,2,1}));
        System.out.println(groupStringByLength(Arrays.asList("apple", "bat", "cat", "dog", "elephant")));
        System.out.println(flatNestedLists(Arrays.asList(Arrays.asList(1,2,3,4), Arrays.asList(5,6,7,8))));
        System.out.println(findEmployeeWithMaximumAge(Employee.getEmployeeList()).get());
        System.out.println(findEmployeeWithSecondHighestSalary(Employee.getEmployeeList()).get());
        System.out.println(findTopNElements(new int[]{1,7,5,6,2,10,34,53,7}, 5));
        System.out.println(findLongestWord(Arrays.asList("apple", "bat", "cat", "dog", "elephant")).get());
        System.out.println(joinString(Arrays.asList("apple", "bat", "cat", "dog", "elephant")));
        System.out.println(groupEmployeesByDepartment(Employee.getEmployeeList()));
        System.out.println(calculateAvgSalaryByDepartment(Employee.getEmployeeList()));
    }

    private static List<Integer> filterEvenNumbers(int[] nums) {
        return Arrays.stream(nums).filter(n -> n%2==0).boxed().toList();
    }

    private static List<String> convertToUppercase(List<String> s) {
        return s.stream().map(String::toUpperCase).toList();
    }

    private static List<String> filterStringWithStarting(List<String> strings, String target) {
        return strings.stream().filter(s -> s.startsWith(target)).toList();
    }

    private static Integer sumOfNumbers(int[] nums) {
        return Arrays.stream(nums).sum();
    }

    private static Integer sumOfNumbersReduce(int[] nums) {
        return Arrays.stream(nums).reduce(0, Integer::sum);
    }

    private static List<Integer> sortNumbers(int[] nums) {
        return Arrays.stream(nums).sorted().boxed().toList();
    }

    private static List<Integer> sortNumbersUsingComparator(int[] nums) {
        return Arrays.stream(nums).boxed().sorted(Comparator.comparing(Integer::intValue).reversed()).toList();
    }

    private static Set<Integer> findDuplicateNumbers(int[] nums) {
        Set<Integer> unique = new HashSet<>();
        return Arrays.stream(nums).boxed().filter(n -> !unique.add(n)).collect(Collectors.toSet());
    }

    private static Map<Integer, List<String>> groupStringByLength(List<String> strings) {
        return strings.stream().collect(Collectors.groupingBy(String::length));
    }

    private static List<Integer> flatNestedLists(List<List<Integer>> ints) {
        return ints.stream().flatMap(List::stream).toList();
    }

    private static Optional<Employee> findEmployeeWithMaximumAge(List<Employee> employees) {
        return employees.stream().max(Comparator.comparing(Employee::getAge));
    }

    private static Optional<Employee> findEmployeeWithSecondHighestSalary(List<Employee> employees) {
        return employees.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).skip(1).findFirst();
    }

    private static List<Integer> findTopNElements(int[] nums, int n) {
        return Arrays.stream(nums).boxed().sorted(Comparator.comparing(Function.identity())).limit(n).toList();
    }

    private static Optional<String> findLongestWord(List<String> words) {
        return words.stream()
                .collect(Collectors.toMap(Function.identity(), String::length))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey);
    }

    private static String joinString(List<String> words) {
        return words.stream().collect(Collectors.joining(", "));
    }

    private static Map<String, List<Employee>> groupEmployeesByDepartment(List<Employee> employees) {
        return employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));
    }

    private static Map<String, Double> calculateAvgSalaryByDepartment(List<Employee> employees) {
        System.out.println(groupEmployeesByDepartment(employees));
        return employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingInt(Employee::getSalary)));
    }

    static class Employee {
        String name;
        String department;
        Integer age;
        Integer salary;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public Integer getSalary() {
            return salary;
        }

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public void setSalary(Integer salary) {
            this.salary = salary;
        }

        public Employee(String name, Integer age, Integer salary, String department) {
            this.name = name;
            this.age = age;
            this.salary = salary;
            this.department = department;
        }

        public static Employee getDummyEmployeeObject(int empCode, int age, int salary, String dept) {
            return new Employee("Emp" + empCode, 20+age, 20000 + salary, "Dept: " + dept);
        }

        public static List<Employee> getEmployeeList() {
            List<Employee> employeeList = new ArrayList<>();
            Random random = new Random();
            for (int i=0; i<10; ++i) {
                employeeList.add(getDummyEmployeeObject(i, i, i, ""  + random.nextInt(3)));
            }

            return employeeList;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", salary=" + salary +
                    '}';
        }
    }
}
