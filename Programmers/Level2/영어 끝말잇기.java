import java.util.*;

class Main {
    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        Solution solution = new Solution();

        int n = 3;
        String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};

        int[] answer = solution.solution(n, words);

        System.out.println(Arrays.toString(answer));

        long elapsedTime = System.currentTimeMillis() - startTime;

        System.out.println("Total execution time in millis : " + elapsedTime);

    }
}

//First Solution
class Solution {
    public int[] solution(int n, String[] words) {
        int loser = 0;
        int turn = 0;
        String preWord = words[0];

        Set<String> set = new HashSet<>();
        
        set.add(preWord);

        for (int i = 1; i < words.length; i++) {
            String curWord = words[i];

            if (preWord.charAt(preWord.length() - 1) != curWord.charAt(0) || !set.add(curWord)) {
                loser = (i % n) + 1;
                turn = (i / n) + 1;
                break;
            }

            preWord = curWord;
        }

        return new int[]{loser, turn};
    }
}