import java.util.*;

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] candies = {2, 3, 5, 1, 3};
        int extraCandies = 3;
        solution.kidsWithCandies(candies, extraCandies);
    }
}

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        ArrayList<Boolean> resultList = new ArrayList<Boolean>();
        int max = 0;

        for (int candy : candies) {
            max = Math.max(candy, max);
        }

        for (int candy : candies) {
            boolean result = false;
            if (candy + extraCandies >= max) {
                result = true;
            }
            resultList.add(result);
        }

        return resultList;
    }
}