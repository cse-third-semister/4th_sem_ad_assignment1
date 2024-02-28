import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import javax.management.Query;

public class bfs {
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
        graph[0].add(new edge(0, 1, 1));

        graph[1].add(new edge(1, 2, 1));
        graph[1].add(new edge(1, 4, 1));

        graph[2].add(new edge(2, 1, 1));
        graph[2].add(new edge(2, 4, 1));
        graph[2].add(new edge(2, 3, 1));
        

        graph[3].add(new edge(3, 2, 1));

        graph[4].add(new edge(4, 1, 1));
        graph[4].add(new edge(4, 2, 1));
        graph[4].add(new edge(4, 5, 1));

        graph[5].add(new edge(5, 4, 1));

        

       

    }

    public static void bfs(ArrayList<edge> obj[], int s) {
        boolean b[] = new boolean[obj.length];
        Queue<Integer> obj5 = new LinkedList<>();

        for (int i = 0; i < obj.length; i++) {
            b[i] = false;
        }
        obj5.add(s);

        while (!obj5.isEmpty()) {
            int cur = obj5.remove();
           

            if (!b[cur]) {
                System.out.print(cur + "->");
                b[cur] = true;
                for (int i = 0; i < obj[cur].size(); i++) {
                    edge e = obj[cur].get(i);
                    obj5.add(e.d);

                }
            }

        }
        System.out.println("\n");

    }

    public static void main(String[] args) {
        ArrayList<edge> obj[] = new ArrayList[6];
        bfs oj = new bfs();
        creategraph(obj);
        System.out.println("Jyotiranjan Mahapatra\nreg. no- 2241013013\nsec  - 2241023\n");
        System.out.println("BFS traversal is \n");

        bfs(obj, 0);

    }

}
