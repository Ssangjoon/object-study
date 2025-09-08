package function;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicatePractice {

    public static void main(String[] args) {
        Predicate<String> isLongerThan3 = s -> s.length() > 3;
        System.out.println("Predicate: 'java' 길이 > 3 ? " + isLongerThan3.test("java"));
        System.out.println("Predicate: 'jav' 길이 > 3 ? " + isLongerThan3.test("jav"));

        List<String> words = Arrays.asList("java", "kotlin", "c", "go", "python");

        List<String> longWords = filterList(words, s -> s.length() >= 3);
        System.out.println("Predicate result: " + longWords);
    }

    public static <T> List<T> filterList(List<T> list, Predicate<T> predicate) {
        List<T> result = new java.util.ArrayList<>();
        for (T item : list) {
            if (predicate.test(item)) {
                result.add(item);
            }
        }
        return result;
    }
}
