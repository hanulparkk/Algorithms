import java.util.*;

class Main {
    public static void main(String[] args) {

        Solution solution = new Solution();

        int n = 6;
        int[] times = {7, 10};

        long answer = solution.solution(n, times);

    }
}

//First Solution: Binary search
class Solution {
    public long solution(int n, int[] times) {
        long answer = (long) Arrays.stream(times).max().getAsInt() * n;
        long left = 0;
        long right = answer;

        while (left <= right) {
            long mid = (left + right) / 2;
            long done = 0;

            for (int time : times)
                done += mid / time;

            if (done < n)
                left = mid + 1;
            else {
                right = mid - 1;

                if (mid < answer)
                    answer = mid;
            }
        }

        return answer;
    }
}