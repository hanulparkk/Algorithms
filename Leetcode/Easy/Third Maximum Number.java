import java.util.*;

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {3, 2, 1};
        solution.thirdMax(nums);
    }
}

//First Solution
class Solution {
    public int thirdMax(int[] nums) {
        Arrays.sort(nums);

        int nth = 0;
        int max = Integer.MAX_VALUE;

        for (int i = nums.length - 1; i >= 0; i--) {
            if (max > nums[i]) {
                max = nums[i];
                nth++;
            }

            if (nth > 2) {
                break;
            }
        }

        if (nth < 3) {
            return nums[nums.length - 1];
        }

        return max;
    }
}

//Second Solution
class Solution {
    public int thirdMax(int[] nums) {
        long firstMax = Long.MIN_VALUE;
        long secondMax = Long.MIN_VALUE;
        long thirdMax = Long.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > firstMax) {
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = nums[i];
            } else if (nums[i] > secondMax && nums[i] < firstMax) {
                thirdMax = secondMax;
                secondMax = nums[i];
            } else if (nums[i] > thirdMax && nums[i] < secondMax) {
                thirdMax = nums[i];
            }
        }

        if (thirdMax == Long.MIN_VALUE) {
            return (int) firstMax;
        }

        return (int) thirdMax;
    }
}