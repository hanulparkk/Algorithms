class Main {
    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        Solution solution = new Solution();

        int n = 4;

        int[] answer = solution.solution(n);

        System.out.println(Arrays.toString(answer));

        long elapsedTime = System.currentTimeMillis() - startTime;

        System.out.println("Total execution time in millis : " + elapsedTime);

    }
}

//First Solution
class Solution {
    public int[] solution(int n) {
        int[][] snail = new int[n][n];
        int x = -1;
        int y = 0;
        int num = 1;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i % 3 == 0)
                    x++;
                else if (i % 3 == 1)
                    y++;
                else { //if (i % 3 == 2)
                    x--;
                    y--;
                }

                snail[x][y] = num++;
            }
        }

        int[] answer = new int[num - 1];
        int idx = 0;

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (snail[i][j] != 0)
                    answer[idx++] = snail[i][j];

        return answer;
    }
}