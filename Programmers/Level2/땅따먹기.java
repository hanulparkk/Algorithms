class Main {
    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        Solution solution = new Solution();

        int[][] land = {{1, 2, 3, 5}, {5, 6, 7, 8}, {4, 3, 2, 1}};

        int answer = solution.solution(land);

        System.out.println(answer);

        long elapsedTime = System.currentTimeMillis() - startTime;

        System.out.println("Total execution time in millis : " + elapsedTime);

    }
}

//First Solution: DFS, time out
class Solution {
    static int[][] data;
    static int max;

    int solution(int[][] land) {
        data = land;
        max = 0;

        dfs(0, -1, 0);

        return max;
    }

    void dfs(int row, int preCol, int sum) {
        if (row == data.length) {
            max = Math.max(max, sum);
            return;
        }

        for (int col = 0; col < 4; col++) {
            if (col != preCol)
                dfs(row + 1, col, sum + data[row][col]);
        }
    }
}

//Second Solution
class Solution {
    int solution(int[][] land) {
        for (int i = 1; i < land.length; i++) {
            for (int j = 0; j < 4; j++) {
                int subMax = 0;

                for (int k = 0; k < 4; k++)
                    if (j != k)
                        subMax = Math.max(subMax, land[i - 1][k]);

                land[i][j] += subMax;
            }
        }

        int max = 0;

        for (int j = 0; j < 4; j++)
            max = Math.max(max, land[land.length - 1][j]);

        return max;
    }
}