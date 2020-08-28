class Main {
    public static void main(String[] args) {

        Solution solution = new Solution();

        int[][] board = {{0, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {0, 0, 1, 0}};
//        int[][] board = {{0, 0, 1, 1}, {1, 1, 1, 1}};

        int answer = solution.solution(board);

        System.out.println(answer);

    }
}

//First Solution
class Solution {
    public int solution(int[][] board) {
        int answer = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 1) {
                    int n = findLargestSquare(board, i, j);
                    answer = Math.max(n * n, answer);
                }
            }
        }

        return answer;
    }

    public static int findLargestSquare(int[][] board, int x, int y) {
        int n = 1;

        for (; n < Math.max(board.length, board[0].length); n++) {
            if (x + n >= board.length || y + n >= board[0].length || board[x + n][y + n] == 0)
                return n;

            for (int i = x; i < x + n; i++) {
                if (i >= board.length || board[i][y + n] == 0)
                    return n;
            }

            for (int j = y; j < y + n; j++) {
                if (j >= board[0].length || board[x + n][j] == 0)
                    return n;
            }
        }

        return n;
    }
}

//Second Solution
class Solution {
    public int solution(int[][] board) {
        int max = 0;

        //Search the first column
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 1) {
                max = 1;
                break;
            }
        }

        //Search the first row
        if (max == 0) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[0][j] == 1) {
                    max = 1;
                    break;
                }
            }
        }

        //Core algorithm
        for (int i = 1; i < board.length; i++) {
            for (int j = 1; j < board[i].length; j++) {
                if (board[i][j] == 1)
                    board[i][j] = Math.min(Math.min(board[i - 1][j], board[i][j - 1]), board[i - 1][j - 1]) + 1;

                max = Math.max(max, board[i][j]);
            }
        }

        return max * max;
    }
}