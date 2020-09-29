import java.util.*;

class Main {
    public static void main(String[] args) {

        Solution solution = new Solution();

        int n = 6;
        int[][] vertex = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};

        long answer = solution.solution(n, vertex);

    }
}

//First Solution: BFS
class Solution {
    public int solution(int n, int[][] edge) {
        int[] dist = new int[n + 1];
        boolean[][] map = new boolean[n + 1][n + 1];

        for (int[] e : edge) {
            map[e[0]][e[1]] = true;
            map[e[1]][e[0]] = true;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);

        int maxDist = 0;

        while (!queue.isEmpty()) {
            int i = queue.poll();

            for (int j = 2; j < n + 1; j++) {
                if (dist[j] == 0 && map[i][j]) {
                    dist[j] = dist[i] + 1;
                    queue.offer(j);
                    maxDist = Math.max(maxDist, dist[j]);
                }
            }
        }

        int count = 0;

        for (int d : dist)
            if (d == maxDist)
                count++;

        return count;
    }
}