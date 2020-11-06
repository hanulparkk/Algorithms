import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
    int index;
    int weight;

    public Node(int index, int weight) {
        this.index = index;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }
}

public class Main {

    public static final int INF = (int) 1e9;
    public static int[] dist;
    public static ArrayList<ArrayList<Node>> graph;

    public static void main(String[] args) throws IOException {
        //input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        dist = new int[V + 1];
        Arrays.fill(dist, INF);

        graph = new ArrayList<>();
        for (int i = 0; i < V + 1; i++)
            graph.add(new ArrayList<>());

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Node(v, w));
        }

        //logic
        dijkstra(new Node(K, 0));

        //output
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < dist.length; i++) {
            if (dist[i] == INF)
                sb.append("INF").append("\n");
            else
                sb.append(dist[i]).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }

    public static void dijkstra(Node u) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(u);
        dist[u.index] = 0;

        while (!pq.isEmpty()) {
            u = pq.poll();

            if(dist[u.index] < u.weight)
                continue;

            for (Node v : graph.get(u.index)) {
                int newDist = dist[u.index] + v.weight;

                if (newDist < dist[v.index]) {
                    dist[v.index] = newDist;
                    pq.offer(new Node(v.index, newDist));
                }
            }
        }
    }
}