class Main {
    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        Solution solution = new Solution();

        String s = "1 2 3 4";

        String answer = solution.solution(s);

        System.out.println(answer);

        long elapsedTime = System.currentTimeMillis() - startTime;

        System.out.println("Total execution time in millis : " + elapsedTime);

    }
}

class Solution {
    public String solution(String s) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (String str : s.split(" ")) {
            int n = Integer.parseInt(str);

            if (n > max)
                max = n;

            if (n < min)
                min = n;
        }

        return min + " " + max;
    }
}