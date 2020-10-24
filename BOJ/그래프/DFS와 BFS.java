//First Solution: ArrayList<ArrayList<Integer>> graph
import java.io.*;
import java.util.*;

public class Main {

    public static StringBuilder sb;
    public static boolean[] visited;
    public static ArrayList<ArrayList<Integer>> graph;

    public static void main(String[] args) throws IOException {
        //input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        sb = new StringBuilder();
        visited = new boolean[N + 1];
        graph = new ArrayList<>();

        for (int i = 0; i < N + 1; i++)
            graph.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int src = Integer.parseInt(st.nextToken());
            int dst = Integer.parseInt(st.nextToken());
            graph.get(src).add(dst);
            graph.get(dst).add(src);
        }

        for (int i = 1; i < N + 1; i++)
            Collections.sort(graph.get(i));

        //logic
        dfs(V);
        sb.append("\n");
        visited = new boolean[N + 1];
        bfs(V);

        //output
        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }

    public static void dfs(int src) {
        visited[src] = true;
        sb.append(src + " ");

        for (int i = 0; i < graph.get(src).size(); i++) {
            int dst = graph.get(src).get(i);

            if (!visited[dst])
                dfs(dst);
        }
    }

    public static void bfs(int V) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(V);
        visited[V] = true;

        while (!queue.isEmpty()) {
            int src = queue.poll();
            sb.append(src + " ");

            for (int i = 0; i < graph.get(src).size(); i++) {
                int dst = graph.get(src).get(i);

                if (!visited[dst]) {
                    queue.offer(dst);
                    visited[dst] = true;
                }
            }
        }
    }
}

//Second Solution: boolean[][] graph
import java.io.*;
import java.util.*;

public class Main {

    public static StringBuilder sb;
    public static boolean[] visited;
    public static boolean[][] graph;

    public static void main(String[] args) throws IOException {
        //input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        sb = new StringBuilder();
        visited = new boolean[N + 1];
        graph = new boolean[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int src = Integer.parseInt(st.nextToken());
            int dst = Integer.parseInt(st.nextToken());
            graph[src][dst] = true;
            graph[dst][src] = true;
        }

        //logic
        dfs(V);
        sb.append("\n");
        visited = new boolean[N + 1];
        bfs(V);

        //output
        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }

    public static void dfs(int src) {
        visited[src] = true;
        sb.append(src + " ");

        for (int i = 1; i < graph[src].length; i++) {
            if (graph[src][i] && !visited[i])
                dfs(i);
        }
    }

    public static void bfs(int V) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(V);
        visited[V] = true;

        while (!queue.isEmpty()) {
            int src = queue.poll();
            sb.append(src + " ");

            for (int i = 1; i < graph[src].length; i++) {
                if (graph[src][i] && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}