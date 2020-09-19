import java.util.*;

class Main {
    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        Solution solution = new Solution();

        int[][] routes = {{-20, 15}, {-14, -5}, {-18, -13}, {-5, -3}};

        int answer = solution.solution(routes);

        System.out.println(answer);

        long elapsedTime = System.currentTimeMillis() - startTime;

        System.out.println("Total execution time in millis : " + elapsedTime);

    }
}

//First Solution
class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, Comparator.comparingInt(o1 -> o1[0]));

        int answer = 1;
        int exitPoint = routes[0][1];

        for (int[] route : routes) {
            int entrance = route[0];
            int exit = route[1];

            if (entrance <= exitPoint)
                exitPoint = Math.min(exitPoint, exit);
            else {
                exitPoint = exit;
                answer++;
            }
        }

        return answer;
    }
}