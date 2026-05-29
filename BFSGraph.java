import java.util.*;

public class BFSGraph {

    static Map<String, List<String>> graph = new HashMap<>();

    // BFS Function
    static void bfs(String start) {

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        queue.add(start);

        while (!queue.isEmpty()) {

            String node = queue.poll();

            if (!visited.contains(node)) {

                System.out.println(node);
                visited.add(node);

                queue.addAll(graph.get(node));
            }
        }
    }

    // Main Method
    public static void main(String[] args) {

        graph.put("Python", Arrays.asList("AI", "Data Science"));
        graph.put("AI", Arrays.asList("Machine Learning"));
        graph.put("Data Science", Arrays.asList("Statistics"));
        graph.put("Machine Learning", new ArrayList<>());
        graph.put("Statistics", new ArrayList<>());

        bfs("Python");
    }
}