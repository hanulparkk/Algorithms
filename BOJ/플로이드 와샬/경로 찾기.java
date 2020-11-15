import java.io.*;
import java.util.*;

public class Main {

    public static int N;
    public static int[][] graph;

    public static void main(String[] args) throws IOException {
        //input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < N; j++)
                graph[i][j] = Integer.parseInt(st.nextToken());
        }

        //logic
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (graph[i][j] == 1)
                        continue;

                    graph[i][j] = graph[i][k] * graph[k][j];
                }
            }
        }

        //output
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                bw.write(String.valueOf(graph[i][j]));
                bw.write(" ");
            }

            bw.newLine();
        }

        br.close();
        bw.flush();
        bw.close();
    }
}