class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2,5,1,3,4,7};
        int n = 3;
        solution.shuffle(nums, n);
    }
}

class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] resultArray = new int[nums.length];;
        for (int i = 0; i < n; i++) {
            resultArray[i * 2] = nums[i];
            resultArray[i * 2 + 1] = nums[i + n];
        }
        return resultArray;
    }
}