import java.util.*;

class Main {
    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        Solution solution = new Solution();

        String[][] relation = {{"100", "ryan", "music", "2"}, {"200", "apeach", "math", "2"}, {"300", "tube", "computer", "3"}, {"400", "con", "computer", "4"}, {"500", "muzi", "music", "3"}, {"600", "apeach", "music", "2"}};

        int answer = solution.solution(relation);

        System.out.println(answer);

        long elapsedTime = System.currentTimeMillis() - startTime;

        System.out.println("Total execution time in millis : " + elapsedTime);

    }
}

//First Solution: DFS
class Solution {
    static String[][] table;
    static int rowLen;
    static int colLen;
    static boolean[] visit;
    static Set<String> candidateKey;

    public int solution(String[][] relation) {
        table = relation;
        rowLen = table.length;
        colLen = table[0].length;
        visit = new boolean[table[0].length];
        candidateKey = new HashSet<>();

        for (int i = 1; i <= colLen; i++)
            dfs(0, 0, i, "");

        return candidateKey.size();
    }

    public void dfs(int init, int depth, int limit, String select) {
        if (depth == limit) {
            if (isMinimal(select) && isUnique(select))
                candidateKey.add(select);

            return;
        }

        for (int col = init; col < colLen; col++) {
            if (visit[col])
                continue;

            visit[col] = true;
            dfs(col + 1, depth + 1, limit, select + col);
            visit[col] = false;
        }
    }

    public boolean isMinimal(String select) {
        List<String> comb = Arrays.asList(select.split(""));

        for (String candiKey : candidateKey) {
            List<String> key = Arrays.asList(candiKey.split(""));

            if (comb.containsAll(key))
                return false;
        }

        return true;
    }

    public boolean isUnique(String select) {
        Set<String> set = new HashSet<>();

        for (String[] row : table) {
            StringBuilder comb = new StringBuilder();

            for (int i = 0; i < select.length(); i++) {
                int col = select.charAt(i) - '0';

                comb.append(row[col]);
            }

            if (!set.add(comb.toString()))
                return false;
        }

        return true;
    }
}

//Second Solution: Bit Masking
class Solution {
    public int solution(String[][] relation) {
        int rowLen = relation.length;
        int colLen = relation[0].length;

        List<Integer> candidateKey = new ArrayList<>();

        for (int instance = 1; instance < (1 << colLen); instance++) {
            if (isMinimal(instance, candidateKey) && isUnique(instance, rowLen, colLen, relation))
                candidateKey.add(instance);
        }

        return candidateKey.size();
    }

    public boolean isMinimal(int instance, List<Integer> candidateKey) {
        for (int key : candidateKey) {
            if ((key & instance) == key)
                return false;
        }

        return true;
    }

    public boolean isUnique(int instance, int rowLen, int colLen, String[][] relation) {
        Set<String> set = new HashSet<>();

        for (int row = 0; row < rowLen; row++) {
            StringBuilder sb = new StringBuilder();

            for (int col = 0; col < colLen; col++) {
                if ((instance & (1 << col)) != 0)
                    sb.append(relation[row][col]);
            }

            if (!set.add(sb.toString()))
                return false;
        }

        return true;
    }
}