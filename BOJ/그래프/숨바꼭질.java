import java.io.*;
import java.util.*;

public class Main {

    public static int[] dp;

    public static void main(String[] args) throws IOException {
        //input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        dp = new int[100001];

        //logic
        bfs(N, K);

        //output
        bw.write(String.valueOf(dp[K]));
        br.close();
        bw.flush();
        bw.close();
    }

    public static void bfs(int N, int K) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);

        while (!queue.isEmpty()) {
            N = queue.poll();

            if (N == K)
                return;

            if (N + 1 < 100001 && dp[N + 1] == 0) {
                dp[N + 1] = dp[N] + 1;
                queue.offer(N + 1);
            }

            if (N - 1 >= 0 && dp[N - 1] == 0) {
                dp[N - 1] = dp[N] + 1;
                queue.offer(N - 1);
            }

            if (N * 2 < 100001 && dp[N * 2] == 0) {
                dp[N * 2] = dp[N] + 1;
                queue.offer(N * 2);
            }
        }
    }
}