class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "RLRRLLRLRL";
        solution.balancedStringSplit(s);
    }
}

class Solution {
    public int balancedStringSplit(String s) {
        int countOfL = 0;
        int countOfR = 0;
        int countOfBalancedStrings = 0;
        for (char ch : s.toCharArray()) {
            if (ch == 'L') {
                countOfL++;
            }
            if (ch == 'R') {
                countOfR++;
            }
            if (countOfL == countOfR) {
                countOfL = 0;
                countOfR = 0;
                countOfBalancedStrings++;
            }
        }
        return countOfBalancedStrings;
    }
}