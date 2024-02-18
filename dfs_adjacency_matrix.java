import java.util.Stack;

public class dfs_adjacency_matrix {
    int vertices;
    int[][] adjacencyMatrix;

    dfs_adjacency_matrix(int vertices) {
        this.vertices = vertices;
        adjacencyMatrix = new int[vertices][vertices];
    }

    void addEdge(int source, int destination) {
        adjacencyMatrix[source][destination] = 1;
    }

    void DFS(int startVertex) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[vertices];

        stack.push(startVertex);
        visited[startVertex] = true;

        while (!stack.isEmpty()) {
            int currentVertex = stack.pop();
            System.out.print(currentVertex + " ");

            for (int i = 0; i < vertices; i++) {
                if (adjacencyMatrix[currentVertex][i] == 1 && !visited[i]) {
                    stack.push(i);
                    visited[i] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        dfs_adjacency_matrix graph = new dfs_adjacency_matrix(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        // graph.addEdge(3, 3);

        System.out.println("DFS starting from vertex 2:");
        graph.DFS(0);

    }

}
