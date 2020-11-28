//First Solution: Knapsack
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        int[] W = new int[N + 1];
        int[] V = new int[N + 1];
        int[][] dp = new int[N + 1][K + 1];

        for (int i = 1; i <= N; i++) {
            input = br.readLine().split(" ");
            W[i] = Integer.parseInt(input[0]);
            V[i] = Integer.parseInt(input[1]);
        }

        for (int n = 1; n <= N; n++) {
            for (int w = 1; w <= K; w++) {
                if (W[n] > w) {
                    dp[n][w] = dp[n - 1][w];
                } else {
                    dp[n][w] = Math.max(dp[n - 1][w], dp[n - 1][w - W[n]] + V[n]);
                }
            }
        }

        System.out.println(dp[N][K]);
    }
}

//Second Solution: Fill Knapsack
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int K;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);
        dp = new int[K + 1];

        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            int wi = Integer.parseInt(input[0]);
            int vi = Integer.parseInt(input[1]);
            fillKnapsack(wi, vi);
        }

        System.out.println(dp[K]);
    }

    public static void fillKnapsack(int wi, int vi) {
        for (int i = K; i >= wi; i--) {
            if (dp[i] < dp[i - wi] + vi) {
                dp[i] = dp[i - wi] + vi;
            }
        }
    }
}