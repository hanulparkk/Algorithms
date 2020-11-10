import java.io.*;
import java.util.*;

public class Main {

    public static int N;
    public static int M;
    public static int[] indegree;
    public static ArrayList<ArrayList<Integer>> graph;
    public static List<Integer> result;


    public static void main(String[] args) throws IOException {
        //input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        indegree = new int[N + 1];
        graph = new ArrayList<>();

        for (int i = 0; i < N + 1; i++)
            graph.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            indegree[v] += 1;
        }

        result = new ArrayList<>();

        //logic
        topologySort();

        //output
        for (Integer i : result) {
            bw.write(String.valueOf(i));
            bw.write(" ");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    public static void topologySort() {
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0)
                q.offer(i);
        }

        System.out.println();

        while (!q.isEmpty()) {
            int u = q.poll();
            result.add(u);

            for (int i = 0; i < graph.get(u).size(); i++) {
                int v = graph.get(u).get(i);

                indegree[v] -= 1;

                if (indegree[v] == 0)
                    q.offer(v);
            }
        }
    }
}