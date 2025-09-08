package function;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerPractice {

    public static void main(String[] args) {
        Consumer<String> printer = s -> System.out.println("Consumer: " + s.toUpperCase());
        printer.accept("hello");

        List<String> words = Arrays.asList("java", "kotlin", "c", "go", "python");

        forEachDo(words, printer);
    }

    public static <T> void forEachDo(List<T> list, Consumer<T> consumer) {
        for (T item : list) {
            consumer.accept(item);
        }
    }
}
