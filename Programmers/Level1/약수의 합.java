class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int n = 12;

        int answer = solution.solution(n);
    }
}

//First Solution
class Solution {
    public int solution(int n) {
        int answer = n;

        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0)
                answer += i;
        }

        return answer;
    }
}