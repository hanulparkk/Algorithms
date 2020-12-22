class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 5;
        int start = 0;
        solution.xorOperation(n, start);
    }
}

class Solution {
    public int xorOperation(int n, int start) {
        int answer = start;
        for (int i = 1; i < n; i++) {
            answer ^= (start + 2 * i);
        }
        return answer;
    }
}