class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] accounts = {{1, 2, 3}, {3, 2, 1}};
        solution.maximumWealth(accounts);
    }
}

class Solution {
    public int maximumWealth(int[][] accounts) {
        int maxSum = 0;

        for (int[] account : accounts) {
            int sum = 0;

            for (int money : account) {
                sum += money;
            }

            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }
}