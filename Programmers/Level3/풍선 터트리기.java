import java.util.*;

class Main {
    public static void main(String[] args) {

        Solution solution = new Solution();

        int[] a = {-16, 27, 65, -2, 58, -92, -71, -68, -61, -33};

        long answer = solution.solution(a);

    }
}

//First Solution
class Solution {
    public int solution(int[] a) {
        Set<Integer> set = new HashSet<>();
        int left = a[0];
        int right = a[a.length - 1];
        set.add(left);
        set.add(right);

        for (int i = 1; i < a.length - 1; i++) {
            if (a[i] < left) {
                left = a[i];
                set.add(left);
            }

            if (a[a.length - 1 - i] < right) {
                right = a[a.length - 1 - i];
                set.add(right);
            }
        }

        return set.size();
    }
}