import java.util.HashMap;
import java.util.Map;

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3, 1, 1, 3};
        solution.numIdenticalPairs(nums);
    }
}

// First solution
class Solution {
    public int numIdenticalPairs(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
        }
        return count;
    }
}

// Second solution
class Solution {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        int count = 0;
        for (Map.Entry entry : map.entrySet()) {
            int val = (int) entry.getValue();
            count += + (val * (val - 1)) / 2;
        }
        return count;
    }
}