class Main {
    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        Solution solution = new Solution();

        int[] money = {1, 2, 3, 1};

        int answer = solution.solution(money);

        System.out.println(answer);

        long elapsedTime = System.currentTimeMillis() - startTime;

        System.out.println("Total execution time in millis : " + elapsedTime);

    }
}

//First Solution: DP
class Solution {
    public int solution(int[] money) {
        int[] dp1 = new int[money.length - 1];
        dp1[0] = money[0];
        dp1[1] = money[0];

        int[] dp2 = new int[money.length];
        dp2[1] = money[1];

        for (int i = 2; i < dp1.length; i++)
            dp1[i] = Math.max(dp1[i - 2] + money[i], dp1[i - 1]);

        for (int i = 2; i < dp2.length; i++)
            dp2[i] = Math.max(dp2[i - 2] + money[i], dp2[i - 1]);

        return Math.max(dp1[dp1.length - 1], dp2[dp2.length - 1]);
    }
}