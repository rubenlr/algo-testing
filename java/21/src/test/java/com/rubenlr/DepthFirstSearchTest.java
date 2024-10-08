package com.rubenlr;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DepthFirstSearchTest {

    private final Map<String, List<String>> tree = Map.of(
            "A", List.of("B", "C"),
            "B", List.of("D", "E"),
            "C", List.of("F"),
            "D", List.of(),
            "E", List.of("F"),
            "F", List.of()
    );
    private DepthFirstSearch dfs;

    @BeforeEach
    public void load() {
        dfs = new DepthFirstSearch();
    }

    @Test
    public void shouldRunIterative() {
        var result = dfs.runIterative(tree, "A");

        assertEquals("A, B, C, D, E, F", String.join(", ", result));
    }

    @Test
    public void shouldRunRecursive() {
        var result = dfs.runRecursive(tree, "A", new HashSet<>());

        assertEquals("A, B, C, D, E, F", String.join(", ", result));
    }
}
