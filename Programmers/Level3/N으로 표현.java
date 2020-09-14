import java.util.*;

class Main {
    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        Solution solution = new Solution();

        int N = 5;
        int number = 12;

        int answer = solution.solution(N, number);

        System.out.println(answer);

        long elapsedTime = System.currentTimeMillis() - startTime;

        System.out.println("Total execution time in millis : " + elapsedTime);

    }
}

//First Solution
class Solution {
    public int solution(int N, int number) {
        List<Set<Integer>> instance = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            Set<Integer> set = new HashSet<>();
            int NNN = Integer.parseInt(Integer.toBinaryString((2 << i) - 1)) * N;

            set.add(NNN);
            instance.add(set);
        }

        for (int i = 1; i < 8; i++) {
            for (int j = 0; j < i; j++) {
                for (int value1 : instance.get(j)) {
                    for (int value2 : instance.get(i - j - 1)) {
                        instance.get(i).add(value1 + value2);
                        instance.get(i).add(value1 - value2);
                        instance.get(i).add(value1 * value2);

                        if (value1 != 0)
                            instance.get(i).add(value2 / value1);
                    }
                }
            }
        }

        int answer = -1;

        for (int i = 0; i < 8; i++) {
            if (instance.get(i).contains(number)) {
                answer = i + 1;
                break;
            }
        }

        return answer;
    }
}