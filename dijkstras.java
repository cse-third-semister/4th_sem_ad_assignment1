import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;



public class dijkstras {
    static class edge {
        int s;
        int d;
        int w;

        edge(int s, int d, int w) {
            this.s = s;
            this.d = d;
            this.w = w;
        }
    }

    public static void creategraph(ArrayList<edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new edge(0, 1, 4));
        graph[0].add(new edge(0, 2, 1));

       

        graph[1].add(new edge(1, 3, 2));
        graph[1].add(new edge(1, 2, 2));
        graph[1].add(new edge(1, 0, 4));

        graph[2].add(new edge(2, 0, 1));
        graph[2].add(new edge(2, 1, 2));
        

        graph[3].add(new edge(3, 1, 2));

        // graph[4].add(new edge(4, 1, 1));
        // graph[4].add(new edge(4, 2, 1));
        // graph[4].add(new edge(4, 5, 1));

        // graph[5].add(new edge(5, 4, 1));

    }

    static class pair implements Comparable<pair> {
        int n;
        int path;

        public pair(int n, int path) {
            this.path = path;
            this.n = n;

        }

        @Override
        public int compareTo(pair p2) {
            return this.path - p2.path;

        }

        public static void dijkstras(ArrayList<edge> arr[], int s) {
            int dist[] = new int[arr.length];
            for (int i = 0; i < arr.length; i++) {
                if (i != s) {
                    dist[i] = Integer.MAX_VALUE;
                }
            }
            boolean vis[] = new boolean[arr.length];
            PriorityQueue<pair> pq = new PriorityQueue<>();
            pq.add(new pair(s, 0));
            while (!pq.isEmpty()) {
                pair cur = pq.remove();
                if (!vis[cur.n]) {
                    vis[cur.n] = true;
                    for (int i = 0; i < arr[cur.n].size(); i++) {
                        edge e = arr[cur.n].get(i);
                        int u = e.s;
                        int v = e.d;
                        int w = e.w;
                        if (dist[u] + w < dist[v]) {
                            dist[v] = dist[u] + w;
                            pq.add(new pair(v, dist[v]));
                        }

                    }

                }

            }
            for (int i = 0; i < dist.length; i++) {
                System.out.print(dist[i] + " ");
            }
            System.out.println();

        }
    }

    public static void main(String[] args) {
        ArrayList<edge> obj[] = new ArrayList[4];
        
        creategraph(obj);
        System.out.println("Jyotiranjan Mahapatra\nreg. no- 2241013013\nsec  - 2241023\n");
        System.out.println("Shortest distance  is \n");
       
        pair.dijkstras(obj, 0);

    }

    

}
