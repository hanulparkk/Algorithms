class Main {
    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        Solution solution = new Solution();

        int n = 3;

        int answer = solution.solution(n);

        System.out.println(answer);

        long elapsedTime = System.currentTimeMillis() - startTime;

        System.out.println("Total execution time in millis : " + elapsedTime);

    }
}

//First Solution: Recursion, time out
class Solution {
    public int solution(int n) {
        return fibo(n);
    }

    public int fibo(int n) {
        if (n < 1)
            return 0;

        if (n == 1)
            return 1;

        return (fibo(n - 1) + fibo(n - 2)) % 12345678;
    }
}

//Second Solution
class Solution {
    public int solution(int n) {
        int answer = 0;

        int n2 = 0;
        int n1 = 1;

        for (int i = 0; i < n - 1; i++) {
            answer = (n1 + n2) % 1234567;
            
            n2 = n1;
            n1 = answer;
        }

        return answer;
    }
}