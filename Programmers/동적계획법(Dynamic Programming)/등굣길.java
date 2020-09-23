class Main {
    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        Solution solution = new Solution();

        int m = 4;
        int n = 3;
        int[][] puddles = {{2, 2}};

        int answer = solution.solution(m, n, puddles);

        System.out.println(answer);

        long elapsedTime = System.currentTimeMillis() - startTime;

        System.out.println("Total execution time in millis : " + elapsedTime);

    }
}

//First Solution: DP
class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] map = new int[n][m];
        map[0][0] = 1;

        for (int[] puddle : puddles)
            map[puddle[1] - 1][puddle[0] - 1] = -1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == -1)
                    continue;

                if (i > 0 && map[i - 1][j] != -1)
                    map[i][j] += map[i - 1][j] % 1000000007;

                if (j > 0 && map[i][j - 1] != -1)
                    map[i][j] += map[i][j - 1] % 1000000007;
            }
        }

        return map[n - 1][m - 1] % 1000000007;
    }
}