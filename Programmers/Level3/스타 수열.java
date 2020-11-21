public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] a = {0, 3, 3, 0, 7, 2, 0, 2, 2, 0};
        sol.solution(a);
    }
}

class Solution {
    public int solution(int[] a) {
        int longestStarSeq = -1;
        int[] count = new int[a.length];

        for (int i = 0; i < a.length; i++)
            count[a[i]]++;

        for (int element = 0; element < count.length; element++) {
            if (count[element] * 2 <= longestStarSeq)
                continue;

            int starSeq = 0;
            int i = 0;
            while (i < a.length - 1) {
                if (a[i] == a[i + 1]) {
                    i++;
                    continue;
                }

                if (a[i] != element && a[i + 1] != element) {
                    i++;
                    continue;
                }

                starSeq += 2;
                i += 2;
            }

            if (longestStarSeq < starSeq)
                longestStarSeq = starSeq;
        }

        return longestStarSeq;
    }
}