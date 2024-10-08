package com.rubenlr;

import java.util.*;

public class DepthFirstSearch {

    public Set<String> runRecursive(Map<String, List<String>> graph, String startPoint, Set<String> visited) {
        if (graph.containsKey(startPoint)) {
            visited.add(startPoint);

            for (var child: graph.get(startPoint)) {
                if (!visited.contains(child)) {
                    runRecursive(graph, child, visited);
                }
            }
        }

        return visited;
    }

    public Set<String> runIterative(Map<String, List<String>> graph, String startPoint) {
        Set<String> visited = new HashSet<>();
        Deque<String> stack = new ArrayDeque<>();

        // Start by pushing the initial node to the stack
        stack.push(startPoint);

        // Iteratively explore the graph
        while (!stack.isEmpty()) {
            String currentNode = stack.pop();

            // If the node hasn't been visited yet
            if (!visited.contains(currentNode)) {
                visited.add(currentNode);

                // Push all unvisited children onto the stack
                for (String child : graph.get(currentNode)) {
                    if (!visited.contains(child)) {
                        stack.push(child);
                    }
                }
            }
        }

        return visited;
    }

}
