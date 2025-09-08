package function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class SupplierPracice {

    public static void main(String[] args) {

        Supplier<Double> randomSupplier = Math::random;
        System.out.println("Supplier: " + randomSupplier.get()); // 0~1 사이 난수
        System.out.println("Supplier: " + randomSupplier.get()); // 호출할 때마다 다른 값

        List<Double> randoms = generateList(5, randomSupplier);
        System.out.println("Supplier result: " + randoms);

    }

    public static <T> List<T> generateList(int count, Supplier<T> supplier) {
        List<T> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            result.add(supplier.get());
        }
        return result;
    }
}
