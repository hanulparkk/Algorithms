import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        long[] dp = new long[N + 1];
        dp[0] = 0;
        dp[1] = 1;

        //logic
        for (int i = 2; i <= N; i++)
            dp[i] = dp[i - 1] + dp[i - 2];

        //output
        bw.write(String.valueOf(dp[N]));
        br.close();
        bw.flush();
        bw.close();
    }
}