class Main {
    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        Solution solution = new Solution();

        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};

        int answer = solution.solution(triangle);


        System.out.println(answer);

        long elapsedTime = System.currentTimeMillis() - startTime;

        System.out.println("Total execution time in millis : " + elapsedTime);

    }
}

//First Solution: DFS, Time out
class Solution {
    static int max;
    static int[][] data;

    public int solution(int[][] triangle) {
        max = 0;
        data = triangle;

        dfs(0, 0, 0);

        return max;
    }

    public void dfs(int depth, int idx, int sum) {
        if (depth == data.length) {
            max = Math.max(max, sum);
            return;
        }

        int value = data[depth][idx];

        dfs(depth + 1, idx, sum + value);
        dfs(depth + 1, idx + 1, sum + value);
    }
}

//Second Solution: DP
class Solution {
    public int solution(int[][] triangle) {
        int max = 0;

        for (int i = 1; i < triangle.length; i++) {
            triangle[i][0] += triangle[i - 1][0];
            triangle[i][i] += triangle[i - 1][i - 1];

            for (int j = 1; j < i; j++)
                triangle[i][j] = Math.max(triangle[i][j] + triangle[i - 1][j - 1], triangle[i][j] + triangle[i - 1][j]);
        }

//        max = Arrays.stream(triangle[triangle.length - 1]).max().getAsInt();
        for (int i = 0; i < triangle.length; i++)
            max = Math.max(max, triangle[triangle.length - 1][i]);

        return max;
    }
}