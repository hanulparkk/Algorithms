class Main {
    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        Solution solution = new Solution();

        int n = 15;

        int answer = solution.solution(n);

        System.out.println(answer);

        long elapsedTime = System.currentTimeMillis() - startTime;

        System.out.println("Total execution time in millis : " + elapsedTime);

    }
}

//First Solution
class Solution {
    public int solution(int n) {
        int count = 0;

        for (int i = 1; i <= n / 2; i++) {
            int sum = 0;

            for (int j = i; sum < n; j++) {
                sum += j;

                if (sum == n)
                    count++;
            }
        }

        return count + 1;
    }
}

//Second Solution
class Solution {
    public int solution(int n) {
        int count = 0;

        for (int i = 1; i <= n; i += 2) {
            if (n % i == 0)
                count++;
        }

        return count;
    }
}