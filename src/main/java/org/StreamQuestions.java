package org;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamQuestions {
    class Employee {
        String name;
        String department;
        int salary;
        int age;

        public String getName() {
            return name;
        }

        public String getDepartment() {
            return department;
        }

        public int getSalary() {
            return salary;
        }
        public int getAge() {
            return age;
        }
    }
    // 1. Frequency Mapping — Count occurrence of each word

    String sentence = "java spring java kafka spring java";
    Map<String, Long> frequency = Arrays.stream(sentence.split(" "))
            .collect(Collectors.groupingBy(
                    Function.identity(),
                    Collectors.counting()
            ));
    // 2. Find employees whose salary is greater than 50,000 and group them by department.

    List<Employee> employees = new ArrayList<>();
    Map<String, List<Employee>> result = employees.stream()
            .filter(e -> e.getSalary() > 50000)
            .collect(Collectors.groupingBy(
                    Employee::getDepartment
            ));

    // 3. Longest Word in a Sentence
    String sentence1 = "Java Spring Boot Microservices";

    String response = String.valueOf(Arrays.stream(sentence1.split(" "))
            .max(Comparator.comparingInt(String::length)));


    // 4. Find even numbers
    List<Integer> numbers =
            Arrays.asList(10, 20, 10, 30, 40, 20, 5);

    List<Integer> ans =
            numbers.stream().filter(s->s%2==0).collect(Collectors.toList());

    // 5. Find duplicate numbers
    List<Integer> dupNumbers =
            Arrays.asList(10, 20, 10, 5, 40, 20, 5);
    HashSet<Integer> hs = new HashSet<>();
    List<Integer> dupAns = dupNumbers.stream()
            .filter(s->!hs.add(s)).collect(Collectors.toList());

    // 6. Remove duplicates

    List<Integer> test6 =
            Arrays.asList(10, 20, 10, 5, 40, 20, 5);
    List<Integer> ans6 = test6.stream()
            .distinct().collect(Collectors.toList());

    // 7. Find the second-highest number

    List<Integer> test7 =
            Arrays.asList(10, 5, 40, 20, 7);
    Optional<Integer> ans7 = test7.stream()
            .distinct().sorted(Comparator.reverseOrder()) .skip(1).findFirst();

    // 8. Find maximum and minimum

    List<Integer> test8 =
            Arrays.asList(10, 5, 40, 20, 7);
    Optional<Integer> ans8 = test8.stream()
            .max(Integer::compareTo);
    Optional<Integer> ans88 = test8.stream()
            .min(Integer::compareTo);


     // 9. Find sum and average
     List<Integer> test9 =
             Arrays.asList(10, 5, 40, 20, 7);
    int sum = test9.stream()
            .mapToInt(Integer::intValue)
            .sum();

    OptionalDouble average = test9.stream()
            .mapToInt(Integer::intValue)
            .average();


     // 10. Find first non-repeated character
     String test10 = "swiss";

    Character ans10 = test10.chars()
            .mapToObj(c -> (char) c)
            .filter(c -> test10.indexOf(c) == test10.lastIndexOf(c))
            .findFirst()
            .orElse(null);
    // 11. Find highest-paid employee in each department (not done)

    Map<String, Employee> ans11 =
            employees.stream()
                    .collect(Collectors.groupingBy(
                            Employee::getDepartment,
                            Collectors.collectingAndThen(
                                    Collectors.maxBy(
                                            Comparator.comparingDouble(
                                                    Employee::getSalary
                                            )
                                    ),
                                    Optional::get
                            )
                    ));

    // 12. sort list of employees first by age then by salary //sapient

    List<Employee> ans12 = employees.stream()
            .sorted(
                    Comparator.comparingInt(Employee::getAge)
                            .thenComparingDouble(Employee::getSalary)
            )
            .collect(Collectors.toList());

    List<Employee> anss12 = employees.stream()
            .sorted(
                    Comparator.comparingInt(Employee::getAge)
                            .thenComparing(
                                    Comparator.comparingDouble(Employee::getSalary)
                                            .reversed()
                            )
            )
            .collect(Collectors.toList());

    // 13. reverse list using stream (not done)
    List<Integer> list13 = Arrays.asList(1, 2, 3, 4, 5);

    List<Integer> reversed = IntStream.range(0, list13.size())
            .mapToObj(i -> list13.get(list13.size() - 1 - i))
            .collect(Collectors.toList());

    // 14. Top 3 salaries Find the top 3 highest distinct salaries.

    List<Integer> top3Salaries = employees.stream()
            .map(Employee::getSalary)
            .distinct()
            .sorted(Comparator.reverseOrder())
            .limit(3)
            .collect(Collectors.toList());

    //15. Find duplicate characters

    String input = "publicis sapient";

    Set<Character> seen = new HashSet<>();

    Set<Character> duplicates = input.chars()
            .mapToObj(c -> (char) c)
            .filter(c -> !Character.isWhitespace(c))
            .filter(c -> !seen.add(c)) // Returns true when 'c' is ALREADY in the set
            .collect(Collectors.toSet());

    //16. Find numbers starting with 1

    List<Integer> result1 = numbers.stream()
            .filter(n -> String.valueOf(n).startsWith("1"))
            .collect(Collectors.toList());

    // 17. Find frequency of each element
    Map<Integer, Long> frequencyEach= numbers.stream()
            .collect(Collectors.groupingBy(
                    Function.identity(),
                    Collectors.counting()
            ));
    // 18. Find frequency of characters in a String

    String str = "banana";

    Map<Character, Long> frequencyStr = str.chars()
            .mapToObj(c -> (char) c)
            .collect(Collectors.groupingBy(
                    Function.identity(),
                    Collectors.counting()
            ));

    // 19. Find average salary of employees
    double averageSalary = employees.stream()
            .mapToDouble(Employee::getSalary)
            .average()
            .orElse(0);

    // 20. Flatten nested lists and find frequency of elements

    List<List<String>> words = List.of(
            List.of("Java", "Spring"),
            List.of("Java", "Kafka"),
            List.of("Spring", "Redis")
    );

    Map<String, Long> frequencyAns = words.stream()
            .flatMap(List::stream)
            .collect(Collectors.groupingBy(
                    Function.identity(),
                    Collectors.counting()
            ));

    // 21. Flatten a list of sentences into individual words

    List<String> sentences = List.of(
        "Java is powerful",
        "Spring Boot is popular",
        "Kafka is distributed"
   );
    List<String> wordsAns = sentences.stream()
            .flatMap(sentence -> Arrays.stream(sentence.split(" ")))
            .collect(Collectors.toList());

    //22. 4th biggest string from both lists combined.

    List<String> list1 = Arrays.asList("apple", "banana", "mango");
    List<String> list2 = Arrays.asList("orange", "kiwi", "grapes", "watermelon");

    String fourthBiggest = Stream.of(list1, list2)
            .flatMap(List::stream)
            .sorted(Comparator.comparingInt(String::length).reversed())
            .skip(3)
            .findFirst()
            .orElse(null);

    // For employees employees.stream.flatMap(s->s.getNumbers.stream())

    //Find duplicate words across multiple sentences

    // Group employees by department
    // Convert List<Employee> to Map

    // Sort employees by salary descending

    //find square elements>25



}
