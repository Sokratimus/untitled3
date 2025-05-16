package benchmark;

import org.openjdk.jmh.annotations.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Thread)
public class StreamBenchmark {

    private List<Integer> data;

    @Setup(Level.Invocation)
    public void setup() {
        data = DataGenerator.generateData(10_000_000);
    }

    @Benchmark
    public long streamSum() {
        return StreamOperations.sum(data);
    }

    @Benchmark
    public long parallelStreamSum() {
        return ParallelStreamOperations.sum(data);
    }

    @Benchmark
    public double streamAverage() {
        return StreamOperations.average(data);
    }

    @Benchmark
    public double parallelStreamAverage() {
        return ParallelStreamOperations.average(data);
    }

    @Benchmark
    public double streamStdDev() {
        return StreamOperations.standardDeviation(data);
    }

    @Benchmark
    public double parallelStreamStdDev() {
        return ParallelStreamOperations.standardDeviation(data);
    }

    @Benchmark
    public List<Integer> streamMultiplyByTwo() {
        return StreamOperations.multiplyByTwo(data);
    }

    @Benchmark
    public List<Integer> parallelStreamMultiplyByTwo() {
        return ParallelStreamOperations.multiplyByTwo(data);
    }

    @Benchmark
    public List<Integer> streamFilter() {
        return StreamOperations.filterEvenDivisibleByThree(data);
    }

    @Benchmark
    public List<Integer> parallelStreamFilter() {
        return ParallelStreamOperations.filterEvenDivisibleByThree(data);
    }
}
