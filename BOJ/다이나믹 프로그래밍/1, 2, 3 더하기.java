//First Solution
import java.io.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        //input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int n;
        int[] dp = new int[11];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        int preMax = 4;

        //logic
        while (T-- > 0) {
            n = Integer.parseInt(br.readLine());

            for (int i = preMax; i <= n; i++)
                dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];

            if (preMax < n)
                preMax = n + 1;

            //output
            System.out.println(dp[n]);
        }
    }
}

//Second Solution
import java.io.*;

public class Main {

    public static int count;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            count = 0;
            int n = Integer.parseInt(br.readLine());
            Backtracking(n, 0);

            System.out.println(count);
        }
    }

    public static void Backtracking(int target, int now) {
        if (target < now)
            return;

        if (target == now) {
            count++;
            return;
        } else {
            Backtracking(target, now + 1);
            Backtracking(target, now + 2);
            Backtracking(target, now + 3);
        }
    }
}