class Main {
    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        Solution solution = new Solution();

        int n = 4;

        int answer = solution.solution(n);

        System.out.println(answer);

        long elapsedTime = System.currentTimeMillis() - startTime;

        System.out.println("Total execution time in millis : " + elapsedTime);

    }
}

class Solution {
    public int solution(int n) {
        int answer = 0;
        int n2 = 1;
        int n1 = 2;

        for (int i = 2; i < n; i++) {
            answer = (n2 + n1) % 1000000007;
            n2 = n1;
            n1 = answer;
        }

        return answer;
    }
}