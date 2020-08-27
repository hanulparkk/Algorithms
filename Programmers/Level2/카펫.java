import java.util.*;

class Main {
    public static void main(String[] args) {

        Solution solution = new Solution();

        int brown = 24;
        int yellow = 24;

        int[] answer = solution.solution(brown, yellow);

        System.out.println(Arrays.toString(answer));

    }
}

//First Solution
class Solution {
    public int[] solution(int brown, int yellow) {
        int width = 0;
        int height = 0;

        for (int i = 1; i <= yellow; i++) {
            if (yellow % i == 0) {
                int quotient = yellow / i;
                int border = (i + 1) * 2 + (quotient + 1) * 2;

                if (border == brown) {
                    width = quotient + 2;
                    height = i + 2;
                    break;
                }
            }
        }

        return new int[]{width, height};
    }
}