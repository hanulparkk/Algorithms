import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < i + 1; j++)
                dp[i][j] = Integer.parseInt(st.nextToken());
        }

        //logic
        for (int i = 1; i < N; i++) {
            dp[i][0] += dp[i - 1][0];
            dp[i][i] += dp[i - 1][i - 1];

            for (int j = 1; j < i; j++)
                dp[i][j] += Math.max(dp[i - 1][j - 1], dp[i - 1][j]);
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            if (max < dp[N - 1][i])
                max = dp[N - 1][i];
        }

        //output
        bw.write(String.valueOf(max));
        br.close();
        bw.flush();
        bw.close();
    }
}