class Main {
    public static void main(String[] args) {
        int[][] key = {
                {0, 0, 0},
                {1, 0, 0},
                {0, 1, 1}
        };
        int[][] lock = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };
        Solution sol = new Solution();
        boolean answer = sol.solution(key, lock);
        System.out.println(answer);
    }
}

class Solution {
    public static int M;
    public static int N;
    public static int B;
    public static int[][] board;

    public boolean solution(int[][] key, int[][] lock) {
        M = key.length;
        N = lock.length;
        B = 2 * (M - 1) + N;
        board = new int[B][B];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i + M - 1][j + M - 1] = lock[i][j];
            }
        }

        for (int i = 0; i < N + M - 1; i++) {
            for (int j = 0; j < N + M - 1; j++) {
                for (int k = 0; k < 4; k++) {
                    boolean found = insert(i, j, key);

                    if (found)
                        return true;

                    rotate(key);
                }
            }
        }

        return false;
    }

    public boolean insert(int baseI, int baseJ, int[][] key) {
        int[][] tmp = new int[B][B];

        for (int i = 0; i < B; i++) {
            for (int j = 0; j < B; j++) {
                tmp[i][j] = board[i][j];
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                if (tmp[i + baseI][j + baseJ] == 1 && key[i][j] == 1)
                    return false;

                if (tmp[i + baseI][j + baseJ] == 0 && key[i][j] == 1)
                    tmp[i + baseI][j + baseJ] = key[i][j];
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (tmp[i + M - 1][j + M - 1] != 1)
                    return false;
            }
        }

        return true;
    }

    public void rotate(int[][] matrix) {
        int n = matrix.length - 1;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n - i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - j][i];
                matrix[n - j][i] = matrix[n - i][n - j];
                matrix[n - i][n - j] = matrix[j][n - i];
                matrix[j][n - i] = tmp;
            }
        }
    }
}