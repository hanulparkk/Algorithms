class Main {
    public static void main(String[] args) {

        Solution solution = new Solution();

        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;

        int answer = solution.solution(numbers, target);

        System.out.println(answer);

    }
}

//First Solution: Recursion
class Solution {
    public int solution(int[] numbers, int target) {
        return Recursion(numbers, target, 0, 0);
    }

    public static int Recursion(int[] numbers, int target, int sum, int index) {
        if (index == numbers.length) {
            if (sum == target) {
                return 1;
            }
            return 0;
        }
        return Recursion(numbers, target, sum + numbers[index], index + 1) + Recursion(numbers, target, sum - numbers[index], index + 1);
    }
}