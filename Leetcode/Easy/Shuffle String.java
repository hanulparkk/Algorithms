class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "codeleet";
        int[] indices = {4, 5, 6, 7, 0, 2, 1, 3};
        solution.restoreString(s, indices);
    }
}

class Solution {
    public String restoreString(String s, int[] indices) {
        char[] chars = new char[s.length()];

        for (int i = 0; i < s.length(); i++) {
            chars[indices[i]] = s.charAt(i);
        }

        String shuffledString = new String(chars);
        return shuffledString;
    }
}