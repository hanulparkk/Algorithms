import java.util.*;

class Main {
    public static void main(String[] args) {

        Solution solution = new Solution();

        int m = 6;
        int n = 4;
        int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};

        int[] answer = solution.solution(m, n, picture);

        System.out.println(Arrays.toString(answer));

    }
}

/*class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}*/

class Solution {
    static int[][] map;
    static boolean[][] visit;
//    static Queue<Pair> queue;
//    static Stack<Pair> stack;

    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};

    public int[] solution(int m, int n, int[][] picture) {
        map = picture.clone();
        visit = new boolean[m][n];
//        queue = new LinkedList<>();
//        stack = new Stack<>();

        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                if (map[x][y] != 0 && !visit[x][y]) {
                    numberOfArea++;
//                    int sizeOfOneArea = BFS(x, y);
//                    int sizeOfOneArea = DFS(x, y);
                    int sizeOfOneArea = Recursion(x, y);
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, sizeOfOneArea);
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    //First Solution: BFS, Queue
/*    public int BFS(int x, int y) {
        int sizeOfOneArea = 0;
        int color = map[x][y];

        queue.offer(new Pair(x, y));
        visit[x][y] = true;
        sizeOfOneArea++;

        while (!queue.isEmpty()) {
            Pair loc = queue.poll();

            for (int i = 0; i < 4; i++) {
                int searchX = loc.getX() + dx[i];
                int srchY = loc.getY() + dy[i];

                if (searchX > -1 && srchY > -1 && searchX < map.length && srchY < map[searchX].length && !visit[searchX][srchY]) {
                    if (map[searchX][srchY] == color) {
                        queue.offer(new Pair(searchX, srchY));
                        visit[searchX][srchY] = true;
                        sizeOfOneArea++;
                    }
                }
            }
        }

        return sizeOfOneArea;
    }*/

    //Second Solution: DFS, Stack
/*    public int DFS(int x, int y) {
        int sizeOfOneArea = 0;
        int color = map[x][y];

        stack.push(new Pair(x, y));
        visit[x][y] = true;
        sizeOfOneArea++;

        while (!stack.isEmpty()) {
            Pair loc = stack.pop();

            for (int i = 0; i < 4; i++) {
                int searchX = loc.getX() + dx[i];
                int srchY = loc.getY() + dy[i];

                if (searchX > -1 && srchY > -1 && searchX < map.length && srchY < map[searchX].length && !visit[searchX][srchY]) {
                    if (map[searchX][srchY] == color) {
                        stack.push(new Pair(searchX, srchY));
                        visit[searchX][srchY] = true;
                        sizeOfOneArea++;
                    }
                }
            }
        }

        return sizeOfOneArea;
    }*/

    //Third Solution: Recursion
    public int Recursion(int x, int y) {
        int sizeOfOneArea = 0;
        int color = map[x][y];

        visit[x][y] = true;
        sizeOfOneArea++;

        for (int i = 0; i < 4; i++) {
            int searchX = x + dx[i];
            int searchY = y + dy[i];

            if (searchX > -1 && searchY > -1 && searchX < map.length && searchY < map[searchX].length && !visit[searchX][searchY]) {
                if (map[searchX][searchY] == color) {
                    sizeOfOneArea += Recursion(searchX, searchY);
                }
            }
        }

        return sizeOfOneArea;
    }
}