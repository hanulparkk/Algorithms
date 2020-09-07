import java.util.*;

class Main {
    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        Solution solution = new Solution();

        String s = "baabaa";

        int answer = solution.solution(s);

        System.out.println(answer);

        long elapsedTime = System.currentTimeMillis() - startTime;

        System.out.println("Total execution time in millis : " + elapsedTime);

    }
}

//First Solution: StringBuilder, time out
class Solution {
    public int solution(String s) {
        StringBuilder sb = new StringBuilder(s);
        int preLength = -1;

        while (preLength != sb.length()) {
            preLength = sb.length();

            for (int i = 0; i < sb.length() - 1; i++) {
                if (sb.charAt(i) == sb.charAt(i + 1)) {
                    sb.deleteCharAt(i);
                    sb.deleteCharAt(i);
                    break;
                }
            }
        }

        return sb.length() == 0 ? 1 : 0;
    }
}

//Second Solution: Stack
class Solution {
    public int solution(String s) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (st.isEmpty()) {
                st.add(s.charAt(i));
                continue;
            }

            if (st.peek() == s.charAt(i))
                st.pop();
            else
                st.add(s.charAt(i));
        }

        return st.size() == 0 ? 1 : 0;
    }
}