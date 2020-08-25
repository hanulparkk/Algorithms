import java.util.*;
class Main {
    public static void main(String[] args) {

        Solution solution = new Solution();

        int[] citations = {5, 5, 5, 5};

        int answer = solution.solution(citations);

        System.out.println(answer);

    }
}

//First Solution
class Solution {
    public int solution(int[] citations) {
        int n = citations.length;
        int h = n;

        while (h >= 0) {
            int ge = 0;

            for (int c : citations) {
                if (h <= c)
                    ge++;
            }

            int le = n - ge;

            if (ge >= h && le <= h)
                return h;

            h--;
        }

        return h;
    }
}

//Second Solution
class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);

        int max = 0;
        for (int i = citations.length - 1; i > -1; i--) {
            int min = Math.min(citations[i], citations.length - i);
            if (max < min) max = min;
        }

        return max;
    }
}