import java.util.*;

class Main {
    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        Solution solution = new Solution();

        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";

        String answer = solution.solution(numbers, hand);

        System.out.println(answer);

        long elapsedTime = System.currentTimeMillis() - startTime;

        System.out.println("Total execution time in millis : " + elapsedTime);

    }
}

//First Solution
class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();

        Map<Integer, Integer[]> keypad = new HashMap<>();

        int key = 1;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                if (key == 11) {
                    keypad.put(0, new Integer[]{i, j});
                    key++;
                    continue;
                }

                keypad.put(key++, new Integer[]{i, j});
            }
        }

        int leftPos = 10; //"*"
        int rightPos = 12; //"#"

        for (int i = 0; i < numbers.length; i++) {
            key = numbers[i];

            Integer[] loc = keypad.get(key);
            int nextX = loc[0];
            int nextY = loc[1];

            if (nextY == 0) {
                sb.append("L");
                leftPos = key;
            } else if (nextY == 2) {
                sb.append("R");
                rightPos = key;
            } else { //if (nextY == 1)
                loc = keypad.get(leftPos);
                int leftX = loc[0];
                int leftY = loc[1];

                loc = keypad.get(rightPos);
                int rightX = loc[0];
                int rightY = loc[1];

                int leftDist = Math.abs(nextX - leftX) + Math.abs(nextY - leftY);
                int rightDist = Math.abs(nextX - rightX) + Math.abs(nextY - rightY);

                if (leftDist < rightDist || (leftDist == rightDist && hand.equals("left"))) {
                    sb.append("L");
                    leftPos = key;
                } else { //if (leftDist > rightDist || (leftDist == rightDist && hand.equals("right")))
                    sb.append("R");
                    rightPos = key;
                }
            }
        }

        return sb.toString();
    }
}