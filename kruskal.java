import java.util.ArrayList;
import java.util.Collections;

public class kruskal {
    static class edge implements Comparable<edge> {
        int s;
        int d;
        int w;

        public edge(int s, int d, int w) {
            this.s = s;
            this.d = d;
            this.w = w;
        }

        @Override
        public int compareTo(edge p2) {
            return this.w - p2.w;

        }

    }

    public static void creategraph(ArrayList<edge> graph) {

        graph.add(new edge(0, 1, 10));
        graph.add(new edge(0, 2, 15));
        graph.add(new edge(0, 3, 30));

        graph.add(new edge(1, 3, 40));
        graph.add(new edge(2, 3, 50));

    }

    static int n = 4;
    static int par[] = new int[n];
    static int rank[] = new int[n];

    public static void init() {
        for (int i = 0; i < n; i++) {
            par[i] = i;
        }
    }

    public static int find(int x) {
        if (par[x] == x) {
            return x;

        } else {
            return par[x] = find(par[x]);
        }
    }

    public static void union(int a, int b) {
        int para = find(a);
        int parb = find(b);

        if (para == parb) {
            par[parb] = para;
            rank[para]++;

        } else if (rank[para] < rank[parb]) {
            par[para] = parb;

        } else {
            par[parb] = para;

        }
    }

    public static void kruskal(ArrayList<edge> graph, int v) {
        init();
        Collections.sort(graph);

        int mstc = 0;
        int sum = 0;
        for (int i = 0; sum < v - 1; i++) {
            edge e = graph.get(i);

            int para = find(e.s);
            int parb = find(e.d);

            if (para != parb) {
                union(e.s, e.d);
                mstc = mstc + e.w;
                sum++;
            }

        }
        System.out.println(mstc);

    }
    public static void main(String[] args) {
        ArrayList<edge> obj = new ArrayList<>();
        int vertex = 4;

        creategraph(obj);
        System.out.println("Jyotiranjan Mahapatra\nreg. no- 2241013013\nsec  - 2241023\n");
        System.out.print("The cost of Minimum spanning tree  is ");
        kruskal(obj, vertex);
        
    }

}
