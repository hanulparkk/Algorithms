class Main {
    public static void main(String[] args) {

        Solution solution = new Solution();

        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;

        int answer = solution.solution(numbers, target);

        System.out.println(answer);

    }
}

//First Solution: DFS
class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }

    public static int dfs(int[] numbers, int target, int sum, int depth) {
        if (depth == numbers.length) {
            if (sum == target)
                return 1;

            return 0;
        }
        
        return dfs(numbers, target, sum + numbers[depth], depth + 1) + dfs(numbers, target, sum - numbers[depth], depth + 1);
    }
}