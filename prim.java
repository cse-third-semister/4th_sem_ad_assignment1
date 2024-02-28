import java.util.ArrayList;
import java.util.PriorityQueue;

public class prim {
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
        graph[0].add(new edge(0, 1, 10));
        graph[0].add(new edge(0, 2, 15));
        graph[0].add(new edge(0, 3, 30));

        graph[1].add(new edge(1, 3, 40));
        graph[1].add(new edge(1, 0, 10));

        graph[2].add(new edge(2, 0, 15));
        graph[2].add(new edge(2, 3, 50));

        graph[3].add(new edge(3, 0, 30));
        graph[3].add(new edge(3, 1, 40));
        graph[3].add(new edge(3, 2, 50));

        
    }

    static class pair implements Comparable<pair> {
        int v;
        int cost;

        public pair(int v, int cost) {
            this.cost = cost;
            this.v = v;

        }

        @Override
        public int compareTo(pair p2) {
            return this.cost - p2.cost;

        }
    }

    public static void mst(ArrayList<edge> obj[]) {
        boolean b[] = new boolean[obj.length];
        PriorityQueue<pair> pq = new PriorityQueue<>();
        pq.add(new pair(0, 0));
        int costt = 0;
        while (!pq.isEmpty()) {
            pair cur = pq.remove();
            if (!b[cur.v]) {
                b[cur.v] = true;
                costt = costt + cur.cost;
                for (int i = 0; i < obj[cur.v].size(); i++) {
                    edge e = obj[cur.v].get(i);
                    pq.add(new pair(e.d, e.w));

                }

            }
        }
        System.out.print( costt);

    }

    public static void main(String[] args) {
        ArrayList<edge> obj[] = new ArrayList[4];

        creategraph(obj);
        System.out.println("Jyotiranjan Mahapatra\nreg. no- 2241013013\nsec  - 2241023\n");
        System.out.print("The cost of Minimum spanning tree  is ");
        mst(obj);

    }

}