class Main {
    public static void main(String[] args) {
        int[][] matrix = {
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };
        
        Solution sol = new Solution();
        sol.rotate(matrix);
    }
}


class Solution {
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