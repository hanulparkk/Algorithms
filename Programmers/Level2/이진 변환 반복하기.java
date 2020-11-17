public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();

        String s = "110010101001";

        sol.solution(s);
    }
}

class Solution {
    public int[] solution(String s) {
        int cntConv = 0;
        int cntZero = 0;

        while (!s.equals("1")) {
            int len = s.length();
            s = s.replaceAll("0", "");
            cntZero += len - s.length();

            s = Integer.toBinaryString(s.length());
            cntConv++;
        }

        return new int[]{cntConv, cntZero};
    }
}