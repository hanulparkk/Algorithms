class Main {
    public static void main(String[] args) {

        Solution solution = new Solution();

        String s = "abcdcba";

        int answer = solution.solution(s);

    }
}

//First Solution
class Solution {
    public int solution(String s) {
        int answer = 1;

        for (int i = 1; i < s.length() - 1; i++) {
            answer = Math.max(answer, findLongestPalindrome(s, i, i));
            answer = Math.max(answer, findLongestPalindrome(s, i, i + 1));
        }

        return answer;
    }

    public int findLongestPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1;
    }
}
