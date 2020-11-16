import java.io.*;
import java.util.*;

class Edge {
    int u;
    int v;
    int w;

    public Edge(int u, int v, int w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }
}

public class Main {
    public static final int INF = (int) 1e9;

    public static void main(String[] args) throws IOException {
        //input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int TC = Integer.parseInt(br.readLine());
        while (TC-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            List<Edge> graph = new ArrayList<>();
            for (int i = 0; i < M + W; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());

                if (i < M) {
                    graph.add(new Edge(S, E, T));
                    graph.add(new Edge(E, S, T));
                } else
                    graph.add(new Edge(S, E, -T));
            }

            //logic
            int[] dist = new int[N + 1];
            Arrays.fill(dist, INF);
            dist[1] = 0;
            boolean updated = false;

            for (int i = 0; i < N; i++) {
                for (Edge edge : graph) {
                    if (dist[edge.v] > edge.w + dist[edge.u]) {
                        dist[edge.v] = edge.w + dist[edge.u];

                        if (i == N - 1) {
                            updated = true;
                            break;
                        }
                    }
                }
            }

            //output
            if (updated)
                bw.write("YES\n");
            else
                bw.write("NO\n");
        }
        bw.flush();
    }
}