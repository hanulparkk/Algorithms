class Main {
    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        Solution solution = new Solution();

        int n = 3;
        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};

        int answer = solution.solution(n, computers);

        System.out.println(answer);

        long elapsedTime = System.currentTimeMillis() - startTime;

        System.out.println("Total execution time in millis : " + elapsedTime);

    }
}

//First Solution: DFS
class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visit = new boolean[n];

        for (int i = 0; i < n; i++)
            if (!visit[i]) {
                dfs(n, computers, i, visit);
                answer++;
            }

        return answer;
    }

    public void dfs(int n, int[][] computers, int i, boolean[] visit) {
        visit[i] = true;

        for (int j = 0; j < n; j++) {
            if (computers[i][j] == 1 && !visit[j])
                dfs(n, computers, j, visit);
        }
    }
}