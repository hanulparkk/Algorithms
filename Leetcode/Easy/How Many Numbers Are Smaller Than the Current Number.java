class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {8, 1, 2, 2, 3};
        solution.smallerNumbersThanCurrent(nums);
    }
}

class Solution {
    public static final int MAX_VALUE = 101;

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] freq = new int[MAX_VALUE];
        int[] count = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            freq[nums[i]]++;
        }

        for (int i = 1; i < MAX_VALUE; i++) {
            freq[i] += freq[i - 1];
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            }
            count[i] = freq[nums[i] - 1];
        }

        return count;
    }
}