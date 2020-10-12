import java.util.*;

class Main {
    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        Solution solution = new Solution();

        int n = 4;
        int[][] costs = {{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}};

        int answer = solution.solution(n, costs);

        System.out.println(answer);

        long elapsedTime = System.currentTimeMillis() - startTime;

        System.out.println("Total execution time in millis : " + elapsedTime);

    }
}

//First Solution: Kruskal's algorithm
class Solution {
    public int solution(int n, int[][] costs) {
        Arrays.sort(costs, Comparator.comparingInt(o1 -> o1[2]));

        int answer = 0;
        int[] parent = new int[n];

        for (int i = 0; i < n; i++)
            parent[i] = i;
                
        for (int[] cost : costs) {
            int island1 = cost[0];
            int island2 = cost[1];

            if (findParent(parent, island1, island2))
                continue;

            unionParent(parent, island1, island2);
            answer += cost[2];
        }

        return answer;
    }

    public int getParent(int[] parent, int island) {
        if (parent[island] == island)
            return island;
        else
            return getParent(parent, parent[island]);
    }

    public void unionParent(int[] parent, int island1, int island2) {
        int parentOfIsland1 = getParent(parent, island1);
        int parentOfIsland2 = getParent(parent, island2);

        if (parentOfIsland1 < parentOfIsland2) {
            parent[island2] = parentOfIsland1;
            parent[parentOfIsland2] = parentOfIsland1;
        } else {
            parent[island1] = parentOfIsland2;
            parent[parentOfIsland1] = parentOfIsland2;
        }
    }

    public boolean findParent(int[] parent, int island1, int island2) {
        int parentOfIsland1 = getParent(parent, island1);
        int parentOfIsland2 = getParent(parent, island2);

        if (parentOfIsland1 == parentOfIsland2)
            return true;
        else
            return false;
    }
}

//Second Solution: Kruskal's algorithm (Improved)
class Solution {

    public static int[] parent;

    public int findParent(int x) {
        if (x == parent[x])
            return x;

        return parent[x] = findParent(parent[x]);
    }

    public void unionParent(int x, int y) {
        x = findParent(x);
        y = findParent(y);

        if (x < y)
            parent[y] = x;
        else
            parent[x] = y;
    }

    public int solution(int n, int[][] costs) {
        int answer = 0;
        parent = new int[n];

        for (int i = 0; i < n; i++)
            parent[i] = i;

        Arrays.sort(costs, Comparator.comparingInt(o1 -> o1[2]));

        for (int[] cost : costs) {
            int x = cost[0];
            int y = cost[1];

            if (findParent(x) != findParent(y)) {
                unionParent(x, y);
                answer += cost[2];
            }
        }

        return answer;
    }
}