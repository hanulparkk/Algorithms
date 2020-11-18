public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] a = {1, 2, 3, 4};
        int[] b = {-3, -1, 0, 2};

        sol.solution(a, b);
    }
}

class Solution {
    public int solution(int[] a, int[] b) {
        int sum = 0;

        for (int i = 0; i < a.length; i++)
            sum += a[i] * b[i];

        return sum;
    }
}