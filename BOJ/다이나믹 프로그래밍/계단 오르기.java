import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] step = new int[N + 1];
        for (int i = 1; i <= N; i++)
            step[i] = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 1];
        dp[1] = step[1];
        dp[2] = step[1] + step[2];

        //logic
        for (int i = 3; i <= N; i++)
            dp[i] = Math.max(dp[i - 3] + step[i - 1] + step[i], dp[i - 2] + step[i]);

        //output
        bw.write(String.valueOf(dp[N]));
        br.close();
        bw.flush();
        bw.close();
    }
}