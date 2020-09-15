import java.util.*;

class Main {
    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        Solution solution = new Solution();

        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        int[] answer = solution.solution(genres, plays);

        System.out.println(Arrays.toString(answer));

        long elapsedTime = System.currentTimeMillis() - startTime;

        System.out.println("Total execution time in millis : " + elapsedTime);

    }
}

//First Solution
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> cntMap = new HashMap<>();
        Map<String, List<Integer>> idxMap = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            cntMap.put(genres[i], cntMap.getOrDefault(genres[i], 0) + plays[i]);
            idxMap.put(genres[i], idxMap.getOrDefault(genres[i], new LinkedList<>()));
            idxMap.get(genres[i]).add(i);
        }

        List<String> genreList = new ArrayList<>(cntMap.keySet());
        Collections.sort(genreList, (o1, o2) -> cntMap.get(o2).compareTo(cntMap.get(o1)));

        List<Integer> ansList = new LinkedList<>();

        for (String genre : genreList) {
            List<Integer> idxList = idxMap.get(genre);
            Collections.sort(idxList, (o1, o2) -> plays[o2] - plays[o1]);

            int limit = 0;

            for (int idx : idxList) {
                if (limit > 1)
                    break;

                ansList.add(idx);
                limit++;
            }
        }

        int[] ans = ansList.stream().mapToInt(x -> (int) x).toArray();
        return ans;
    }
}