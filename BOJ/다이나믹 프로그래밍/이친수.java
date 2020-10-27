import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        long[][] dp = new long[N + 1][2];
        dp[1][0] = 0;
        dp[1][1] = 1;
        
        //logic
        for (int i = 2; i <= N; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 1][1];
            dp[i][1] = dp[i - 1][0];
        }

        //output
        bw.write(String.valueOf(dp[N][0] + dp[N][1]));
        br.close();
        bw.flush();
        bw.close();
    }
}