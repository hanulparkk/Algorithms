class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String J = "aA";
        String S = "aAAbbbb";
        solution.numJewelsInStones(J, S);
    }
}

class Solution {
    public int numJewelsInStones(String J, String S) {
        int count = 0;
        for (char s : S.toCharArray()) {
            if (J.indexOf(s) != -1) {
                count++;
            }
        }
        return count;
    }
}