import java.util.*;

class Main {
    public static void main(String[] args) {

        Solution solution = new Solution();

        int distance = 25;
        int[] rocks = {2, 14, 11, 21, 17};
        int n = 2;

        int answer = solution.solution(distance, rocks, n);

    }
}

//First Solution: Binary search
class Solution {
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);

        int answer = 0;
        int left = 0;
        int right = distance;

        while (left <= right) {
            int mid = (left + right) / 2;
            int pre = 0;
            int removed = 0;

            for (int rock : rocks) {
                if (rock - pre < mid)
                    removed++;
                else
                    pre = rock;
            }

            if (distance - pre < mid)
                removed++;

            if (removed <= n) {
                left = mid + 1;

                if (mid > answer)
                    answer = mid;
            } else
                right = mid - 1;
        }

        return answer;
    }
}