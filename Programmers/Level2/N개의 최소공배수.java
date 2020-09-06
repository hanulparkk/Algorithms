class Main {
    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        Solution solution = new Solution();

        int[] arr = {2, 6, 8, 14};

        int answer = solution.solution(arr);

        System.out.println(answer);

        long elapsedTime = System.currentTimeMillis() - startTime;

        System.out.println("Total execution time in millis : " + elapsedTime);

    }
}

//First Solution
class Solution {
    public int solution(int[] arr) {
        int max = 0;

        for (int i : arr)
            max = Math.max(max, i);

        int lcm;
        boolean found;
        int n = 1;

        do {
            lcm = n * max;
            found = true;

            for (int i : arr) {
                if (lcm % i != 0) {
                    found = false;
                    break;
                }
            }

            n++;

        } while (!found);

        return lcm;
    }
}