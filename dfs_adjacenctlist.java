import java.util.ArrayList;
import java.util.Stack;
//-------------------------------------------------------------
//Another way of DFS traversal.........
/*import java.util.Stack;

class Graph {
    int vertices;
    LinkedList<Integer>[] adjacencyList;

    // Constructor to create a graph with given number of vertices
    Graph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    // Add an edge to the graph
    void addEdge(int source, int destination) {
        adjacencyList[source].add(destination);
    }

    // DFS traversal using stack
    void DFS(int startVertex) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[vertices];

        stack.push(startVertex);
        visited[startVertex] = true;

        while (!stack.isEmpty()) {
            int currentVertex = stack.pop();
            System.out.print(currentVertex + " ");

            for (int neighbor : adjacencyList[currentVertex]) {
                if (!visited[neighbor]) {
                    stack.push(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
    }
} */
//---------------------------------------------------------

public class dfs_adjacenctlist {

    static class edge {
        int source;
        int dist;
        int weight;

        edge(int s, int d, int w) {
            this.source = s;
            this.dist = d;
            this.weight = w;
        }

    }

    public static void create_graph(ArrayList<edge>[] graph, int v) {

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new edge(0, 1, 5));
        graph[0].add(new edge(0, 3, 7));

        graph[1].add(new edge(1, 0, 5));
        graph[1].add(new edge(1, 2, 2));

        graph[2].add(new edge(2, 1, 7));
        graph[2].add(new edge(2, 3, 1));
        graph[2].add(new edge(2, 4, 1));

        graph[3].add(new edge(3, 0, 2));
        graph[3].add(new edge(3, 2, 1));

        graph[4].add(new edge(4, 2, 3));

    }

    public static void main(String[] args) {
        /* Graph graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        System.out.println("DFS starting from vertex 2:");
        graph.DFS(2);*/
        
        int v = 5;
        ArrayList<edge>[] graph = new ArrayList[v];
        create_graph(graph, v);
        dfs(0, graph, new boolean[v]);

    }

    public static void dfs(int curr, ArrayList<edge>[] graph, boolean arr[]) {
        // System.out.println(curr);
        // arr[curr] = true;

        // for (int i = 0; i < graph[curr].size(); i++) {
        // edge e = graph[curr].get(i);
        // if(!arr[e.dist]){
        // dfs(e.dist,graph,arr);
        // }
        // }

        Stack<Integer> stack = new Stack<>();

        stack.push(curr);
        arr[curr] = true;

        while (!stack.isEmpty()) {
            curr = stack.pop();
            System.out.print(curr + " ");

            for (int i = 0; i < graph[curr].size(); i++) {
                edge e = graph[curr].get(i);
                if (!arr[e.dist]) {
                    stack.push(e.dist);
                    arr[e.dist] = true;
                }
            }
        }
    }

}
