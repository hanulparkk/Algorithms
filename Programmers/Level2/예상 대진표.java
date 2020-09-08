class Main {
    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        Solution solution = new Solution();

        int n = 8;
        int a = 4;
        int b = 7;

        int answer = solution.solution(n, a, b);

        System.out.println(answer);

        long elapsedTime = System.currentTimeMillis() - startTime;

        System.out.println("Total execution time in millis : " + elapsedTime);

    }
}

//First Solution
class Solution {
    public int solution(int n, int a, int b) {
        int round = 0;
        boolean match = false;

        while (!match) {
            round++;

            for (int i = 1; i <= n; i += 2) {
                if ((i == a || (i + 1) == a) && (i == b || (i + 1) == b)) {
                    match = true;
                    break;
                }

                if (i == a || (i + 1) == a)
                    a = (i + 1) / 2;

                if (i == b || (i + 1) == b)
                    b = (i + 1) / 2;
            }

            n /= 2;
        }

        return round;
    }
}

//Second Solution
class Solution {
    public int solution(int n, int a, int b) {
        int round = 0;
        
        while (a != b) {
            a = a / 2 + a % 2;
            b = b / 2 + b % 2;
            
            round++;
        }
        
        return round;
    }
}