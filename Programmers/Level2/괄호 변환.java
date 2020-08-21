import java.util.Stack;

class Main {
    public static void main(String[] args) {

        Solution solution = new Solution();

        String p = "()))((()";

        String answer = solution.solution(p);

        System.out.println(answer);

    }
}

//First Solution: Recursion
class Solution {
    public String solution(String p) {
        if (p.length() == 0 || isCorrect(p)) {
            return p;
        }

        String[] separated = separateIntoBalanced(p);

        String u = separated[0];
        String v = separated[1];

        if (isCorrect(u)) {
            return u + solution(v);
        } else {
            StringBuilder sb = new StringBuilder();

            sb.append('(');
            sb.append(solution(v));
            sb.append(')');

            u = u.substring(1, u.length() - 1);

            for (char ch : u.toCharArray()) {
                if (ch == '(')
                    sb.append(')');
                else if (ch == ')')
                    sb.append('(');
            }

            v = sb.toString();

            return solution(v);
        }
    }

    public static boolean isCorrect(String p) {
        boolean result = false;

        Stack<Character> stack = new Stack<>();

        for (char ch : p.toCharArray()) {
            if (ch == '(')
                stack.push(ch);
            else if (ch == ')' && !stack.isEmpty()) {
                if (stack.pop() != '(')
                    return result;
            } else
                return result;
        }

        if (stack.isEmpty())
            result = true;

        return result;
    }

    public static String[] separateIntoBalanced(String p) {
        int item1 = 0;
        int item2 = 0;

        char firstItem = p.charAt(0);
        item1++;

        int i = 1;
        for (; i < p.length(); i++) {
            char ch = p.charAt(i);

            if (ch == firstItem)
                item1++;
            else
                item2++;

            if (item1 == item2)
                break;
        }

        String u = p.substring(0, i + 1);
        String v = p.substring(i + 1);

        return new String[]{u, v};
    }
}