package benchmark;

import java.util.List;
import java.util.stream.Collectors;

public class ParallelStreamOperations {

    public static long sum(List<Integer> data) {
        return data.parallelStream().mapToLong(Integer::intValue).sum();
    }

    public static double average(List<Integer> data) {
        return data.parallelStream().mapToInt(Integer::intValue).average().orElse(0.0);
    }

    public static double standardDeviation(List<Integer> data) {
        double mean = average(data);
        return Math.sqrt(data.parallelStream()
                .mapToDouble(i -> Math.pow(i - mean, 2))
                .average()
                .orElse(0.0));
    }

    public static List<Integer> multiplyByTwo(List<Integer> data) {
        return data.parallelStream()
                .map(i -> i * 2)
                .collect(Collectors.toList());
    }

    public static List<Integer> filterEvenDivisibleByThree(List<Integer> data) {
        return data.parallelStream()
                .filter(i -> i % 2 == 0 && i % 3 == 0)
                .collect(Collectors.toList());
    }
}
