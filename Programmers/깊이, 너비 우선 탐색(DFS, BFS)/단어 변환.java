import java.util.*;

class Main {
    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        Solution solution = new Solution();

        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};

        int answer = solution.solution(begin, target, words);

        System.out.println(answer);

        long elapsedTime = System.currentTimeMillis() - startTime;

        System.out.println("Total execution time in millis : " + elapsedTime);

    }
}

//First Solution: DFS
class Solution {
    static int answer;

    public int solution(String begin, String target, String[] words) {
        boolean found = false;

        for (String word : words)
            if (word.equals(target))
                found = true;

        if (!found)
            return 0;

        answer = Integer.MAX_VALUE;
        boolean[] visit = new boolean[words.length];

        dfs(begin, target, words, visit, 0);

        return answer;
    }

    public void dfs(String begin, String target, String[] words, boolean[] visit, int depth) {
        if (begin.equals(target)) {
            answer = Math.min(answer, depth);
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (!visit[i] && isConvertible(begin, words[i])) {
                visit[i] = true;
                dfs(words[i], target, words, visit, depth + 1);
                visit[i] = false;
            }
        }
    }

    public boolean isConvertible(String begin, String target) {
        int count = 0;

        for (int i = 0; i < begin.length(); i++) {
            if (begin.charAt(i) != target.charAt(i))
                count++;

            if (count > 1)
                return false;
        }

        return true;
    }
}

//Second Solution: BFS
class Solution {
    public class Word {
        String value;
        int depth;

        public Word(String value, int depth) {
            this.value = value;
            this.depth = depth;
        }
    }

    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        boolean[] visit = new boolean[words.length];

        Queue<Word> wordQueue = new LinkedList<>();
        wordQueue.offer(new Word(begin, 0));

        while (!wordQueue.isEmpty()) {
            Word curWord = wordQueue.poll();

            if (curWord.value.equals(target))
                return curWord.depth;

            for (int i = 0; i < words.length; i++) {
                if (!visit[i] && isConvertible(curWord.value, words[i])) {
                    visit[i] = true;
                    wordQueue.offer(new Word(words[i], curWord.depth + 1));
                }
            }

        }

        return answer;
    }

    public boolean isConvertible(String begin, String target) {
        int count = 0;

        for (int i = 0; i < begin.length(); i++) {
            if (begin.charAt(i) != target.charAt(i))
                count++;

            if (count > 1)
                return false;
        }

        return true;
    }
}