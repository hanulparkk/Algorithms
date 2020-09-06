class Main {
    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        Solution solution = new Solution();

        String s = "3people unFollowed me";

        String answer = solution.solution(s);

        System.out.println(answer);

        long elapsedTime = System.currentTimeMillis() - startTime;

        System.out.println("Total execution time in millis : " + elapsedTime);

    }
}

//First Solution
class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();

        boolean flag = true;

        for (char ch : s.toCharArray()) {
            if (flag) {
                sb.append((ch + "").toUpperCase());
                flag = false;
            } else
                sb.append((ch + "").toLowerCase());

            if (ch == ' ')
                flag = true;
        }

        return sb.toString();
    }
}