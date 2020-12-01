class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {4, 2, 3};
        solution.checkPossibility(nums);
    }
}

class Solution {
    public boolean checkPossibility(int[] nums) {
        int changed = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] <= nums[i + 1]) {
                continue;
            }

            if (i != 0 && nums[i - 1] > nums[i + 1]) {
                nums[i + 1] = nums[i];
            } else {
                nums[i] = nums[i + 1];
            }

            changed++;

            if (changed > 1) {
                return false;
            }
        }

        return true;
    }
}