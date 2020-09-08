class Main {
    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        Solution solution = new Solution();

        int n = 5;

        int answer = solution.solution(n);

        System.out.println(answer);

        long elapsedTime = System.currentTimeMillis() - startTime;

        System.out.println("Total execution time in millis : " + elapsedTime);

    }
}

//First Solution
class Solution {
    public int solution(int n) {
        int battery = 0;

        while (n > 0) {
            if (n % 2 == 0) {
                n = n / 2;
            } else { // if (n % 2 == 1)
                n = n - 1;
                battery++;
            }
        }

        return battery;
    }
}

//Second Solution
class Solution {
    public int solution(int n) {
        int battery = 0;

        while (n > 0) {
            if (n % 2 == 1) {
                n = n - 1;
                battery++;
            }
            
            n = n / 2;
        }

        return battery;
    }
}