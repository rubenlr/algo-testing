package com.rubenlr;

import org.openjdk.jmh.annotations.*;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime) // Measures average execution time
@OutputTimeUnit(TimeUnit.NANOSECONDS) // Outputs in nanoseconds
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS) // Warm-up phase
@Measurement(iterations = 10, time = 1, timeUnit = TimeUnit.SECONDS) // Measurement phase
@Fork(1) // Number of JVM forks
@State(Scope.Thread) // Benchmark state is thread-local
public class DepthFirstSearchBenchmark {

    private final DepthFirstSearch dfs= new DepthFirstSearch();
    private final Map<String, List<String>> tree = Map.of(
            "A", List.of("B", "C"),
            "B", List.of("D", "E"),
            "C", List.of("F"),
            "D", List.of(),
            "E", List.of("F"),
            "F", List.of()
    );

    @Benchmark
    public void benchmarkRunIterative() {
        dfs.runIterative(tree, "A");
    }

    @Benchmark
    public void benchmarkRunRecursive() {
        dfs.runRecursive(tree, "A", new HashSet<>());
    }
}
