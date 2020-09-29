class Main {
    public static void main(String[] args) {

        Solution solution = new Solution();

        int n = 5;
        int[][] results = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};

        long answer = solution.solution(n, results);

    }
}

//First Solution
class Solution {
    public int solution(int n, int[][] results) {
        int[][] map = new int[n + 1][n + 1];

        for (int[] r : results) {
            map[r[0]][r[1]] = 1;
            map[r[1]][r[0]] = -1;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (map[i][j] == 1) {
                    for (int k = 1; k < n + 1; k++)
                        if (map[i][k] == -1)
                            map[j][k] = -1;
                } else if (map[i][j] == -1) {
                    for (int k = 1; k < n + 1; k++)
                        if (map[i][k] == 1)
                            map[j][k] = 1;
                }
            }
        }

        int answer = 0;

        for (int i = 1; i < n + 1; i++) {
            int count = 0;

            for (int j = 1; j < n + 1; j++)
                if (map[i][j] == 0)
                    count++;

            if (count == 1)
                answer++;
        }

        return answer;
    }
}