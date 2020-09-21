import java.util.*;

class Main {
    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        Solution solution = new Solution();

        int[] numbers = {2, 1, 3, 4, 1};

        int[] answer = solution.solution(numbers);

        System.out.println(Arrays.toString(answer));

        long elapsedTime = System.currentTimeMillis() - startTime;

        System.out.println("Total execution time in millis : " + elapsedTime);

    }
}

//First Solution
class Solution {
    public int[] solution(int[] numbers) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < numbers.length; i++)
            for (int j = i + 1; j < numbers.length; j++)
                set.add(numbers[i] + numbers[j]);

        return set.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}