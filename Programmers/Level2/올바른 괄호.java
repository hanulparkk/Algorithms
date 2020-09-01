import java.util.*;

class Main {
    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        Solution solution = new Solution();

        String s = "(())()";

        boolean answer = solution.solution(s);

        System.out.println(answer);

        long elapsedTime = System.currentTimeMillis() - startTime;

        System.out.println("Total execution time in millis : " + elapsedTime);

    }
}

/*
    First Solution: Stack
    Test 1: Pass (18.32ms, 43.7MB)
    Test 2: Pass (18.34ms, 43.8MB)
 */
class Solution {
    boolean solution(String s) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                st.push(ch);

            } else if (ch == ')') {
                if (st.isEmpty())
                    return false;

                st.pop();
            }
        }

        if (!st.isEmpty())
            return false;

        return true;
    }
}

/*
    Second Solution: StringBuilder
    Test 1: Pass (16.49ms, 43.7MB)
    Test 2: Pass (13.13ms, 43.6MB)
 */
class Solution {
    boolean solution(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                sb.append(ch);

            } else if (ch == ')') {
                if (sb.length() == 0)
                    return false;

                sb.setLength(sb.length() - 1);
                //sb.deleteCharAt(sb.length() - 1);
            }
        }

        if (sb.length() != 0)
            return false;

        return true;
    }
}