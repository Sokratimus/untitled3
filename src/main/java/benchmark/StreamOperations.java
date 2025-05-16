package benchmark;

import java.util.List;
import java.util.stream.Collectors;

public class StreamOperations {

    public static long sum(List<Integer> data) {
        return data.stream().mapToLong(Integer::intValue).sum();
    }

    public static double average(List<Integer> data) {
        return data.stream().mapToInt(Integer::intValue).average().orElse(0.0);
    }

    public static double standardDeviation(List<Integer> data) {
        double mean = average(data);
        return Math.sqrt(data.stream()
                .mapToDouble(i -> Math.pow(i - mean, 2))
                .average()
                .orElse(0.0));
    }

    public static List<Integer> multiplyByTwo(List<Integer> data) {
        return data.stream()
                .map(i -> i * 2)
                .collect(Collectors.toList());
    }

    public static List<Integer> filterEvenDivisibleByThree(List<Integer> data) {
        return data.stream()
                .filter(i -> i % 2 == 0 && i % 3 == 0)
                .collect(Collectors.toList());
    }
}
