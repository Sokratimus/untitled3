package benchmark;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DataGenerator {
    public static List<Integer> generateData(int size) {
        Random random = new Random();
        return IntStream.range(0, size)
                .map(i -> random.nextInt(100) + 1)
                .boxed()
                .collect(Collectors.toList());
    }
}
