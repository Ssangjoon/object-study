package function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionPractice {
    public static void main(String[] args) {

        Function<Integer, String> intToString = i -> "숫자: " + i;
        System.out.println("Function: " + intToString.apply(42)); // "숫자: 42"

        List<String> words = Arrays.asList("java", "kotlin", "c", "go", "python");

        List<Integer> lengths = mapList(words, String::length);
        System.out.println("Function result: " + lengths);
    }

    public static <T, R> List<R> mapList(List<T> list, Function<T, R> mapper) {
        List<R> result = new ArrayList<>();
        for (T item : list) {
            result.add(mapper.apply(item));
        }
        return result;
    }


}
