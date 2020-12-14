package main;

import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3, 4};
        solution.decompressRLElist(nums);
    }
}

class Solution {
    public int[] decompressRLElist(int[] nums) {
        int newSize = 0;
        for (int i = 0; i < nums.length; i += 2) {
            newSize += nums[i];
        }

        int[] result = new int[newSize];
        int fromIndex = 0;
        for (int i = 0; i < nums.length; i += 2) {
            int toIndex = fromIndex + nums[i];
            int value = nums[i + 1];
            Arrays.fill(result, fromIndex, toIndex, value);
            fromIndex = toIndex;
        }
        
        return result;
    }
}