import java.util.*;

class Main {
    public static void main(String[] args) {

        Solution solution = new Solution();

        int[] people = {70, 50, 80, 50};
        int limit = 100;

        int answer = solution.solution(people, limit);

        System.out.println(answer);

    }
}

//First Solution
class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);

        int boat = 0;
        int left = 0;
        int right = people.length - 1;

        while (left < right) {
            int weight = people[left] + people[right];

            if (weight <= limit) {
                left++;
                right--;
            } else
                right--;

            boat++;
        }

        if (left == right)
            boat++;

        return boat;
    }
}