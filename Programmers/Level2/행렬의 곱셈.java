class Main {
    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        Solution solution = new Solution();

        int[][] arr1 = {{1, 4}, {3, 2}, {4, 1}};
        int[][] arr2 = {{3, 3}, {3, 3}};

        int[][] answer = solution.solution(arr1, arr2);

        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer[i].length; j++)
                System.out.print(answer[i][j] + " ");

            System.out.println();
        }

        long elapsedTime = System.currentTimeMillis() - startTime;

        System.out.println("Total execution time in millis : " + elapsedTime);

    }
}

//First Solution
class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] arr1arr2 = new int[arr1.length][arr2[0].length];

        for (int i = 0; i < arr1arr2.length; i++)
            for (int j = 0; j < arr1arr2[0].length; j++)
                for (int k = 0; k < arr1[0].length; k++)
                    arr1arr2[i][j] += arr1[i][k] * arr2[k][j];

        return arr1arr2;
    }
}