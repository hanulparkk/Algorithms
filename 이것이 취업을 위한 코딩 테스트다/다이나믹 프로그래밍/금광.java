public class Main {

    public static void main(String[] args) {
        // 금광 정보 입력
        int n = 3;
        int m = 4;
        int[][] arr = {{1, 3, 3, 2}, {2, 1, 4, 1}, {0, 6, 4, 7}};
        // 다이나믹 프로그래밍을 위한 2차원 DP 테이블 초기화
        int[][] dp = arr.clone();

        // 다이나믹 프로그래밍 진행
        for (int j = 1; j < m; j++) {
            for (int i = 0; i < n; i++) {
                int leftUp;
                int leftDown;
                int left;
                // 왼쪽 위에서 오는 경우
                if (i == 0)
                    leftUp = 0;
                else
                    leftUp = dp[i - 1][j - 1];
                // 왼쪽 아래에서 오는 경우
                if (i == n - 1)
                    leftDown = 0;
                else
                    leftDown = dp[i + 1][j - 1];
                // 왼쪽에서 오는 경우
                left = dp[i][j - 1];
                dp[i][j] = dp[i][j] + Math.max(leftUp, Math.max(leftDown, left));
            }
        }

        int result = 0;
        for (int i = 0; i < n; i++)
            result = Math.max(result, dp[i][m - 1]);
        System.out.println(result);
    }
}