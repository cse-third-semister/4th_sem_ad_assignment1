import java.util.ArrayList;
import java.util.Stack;

 

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
        
        
        int v = 5;
        ArrayList<edge>[] graph = new ArrayList[v];
        create_graph(graph, v);
        System.out.println("Jyotiranjan Mahapatra\nreg. no- 2241013013\nsec  - 2241023\n");
        System.out.print("DFS traversal is ");
        dfs(0, graph, new boolean[v]);

    }

    public static void dfs(int curr, ArrayList<edge>[] graph, boolean arr[]) {
        
        

        Stack<Integer> stack = new Stack<>();

        stack.push(curr);
        arr[curr] = true;

        while (!stack.isEmpty()) {
            curr = stack.pop();
            arr[curr] = true;
            System.out.print(curr + " ");

            for (int i = 0; i < graph[curr].size(); i++) {
                edge e = graph[curr].get(i);
                if (!arr[e.dist]) {
                    stack.push(e.dist);
                    
                }
            }
        }
    }

}
