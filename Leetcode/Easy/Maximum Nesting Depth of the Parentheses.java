import java.util.Stack;

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "(1+(2*3)+((8)/4))+1";
        solution.maxDepth(s);
    }
}

// First solution
class Solution {
    public int maxDepth(String s) {
        Stack<Character> stack = new Stack<>();
        int maxDepth = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
                continue;
            }
            if (ch == ')') {
                maxDepth = Math.max(maxDepth, stack.size());
                stack.pop();
            }
        }
        return maxDepth;
    }
}

// Second solution
class Solution {
    public int maxDepth(String s) {
        int count = 0;
        int maxDepth = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                count++;
                continue;
            }
            if (ch == ')') {
                maxDepth = Math.max(maxDepth, count);
                count--;
            }
        }
        return maxDepth;
    }
}