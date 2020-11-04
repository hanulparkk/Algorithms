//First Solution
import java.io.*;
import java.util.*;

public class Main {

    public static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int N;
    public static int M;
    public static int[] dx;
    public static int[] dy;
    public static int[][] map;
    public static int[][] dp;

    public static void main(String[] args) throws IOException {
        //input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dx = new int[]{-1, 1, 0, 0};
        dy = new int[]{0, 0, -1, 1};
        map = new int[N][M];
        dp = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String token = st.nextToken();
            for (int j = 0; j < M; j++)
                map[i][j] = token.charAt(j) - '0';
        }

        //logic
        bfs(new Pair(0, 0));

        //output
        bw.write(String.valueOf(dp[N - 1][M - 1]));
        br.close();
        bw.flush();
        bw.close();
    }

    public static void bfs(Pair pair) {
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(pair);
        dp[pair.x][pair.y] = 1;

        while (!queue.isEmpty()) {
            pair = queue.poll();
            int x = pair.x;
            int y = pair.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= N)
                    continue;

                if (ny < 0 || ny >= M)
                    continue;

                if (map[nx][ny] == 0)
                    continue;

                if (dp[nx][ny] != 0)
                    continue;

                queue.offer(new Pair(nx, ny));
                dp[nx][ny] = dp[x][y] + 1;
            }
        }
    }
}

//Second Solution
import java.io.*;
import java.util.*;

public class Main {

    public static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int N;
    public static int M;
    public static int[] dx;
    public static int[] dy;
    public static int[][] map;

    public static void main(String[] args) throws IOException {
        //input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dx = new int[]{-1, 1, 0, 0};
        dy = new int[]{0, 0, -1, 1};
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String token = st.nextToken();
            for (int j = 0; j < M; j++)
                map[i][j] = token.charAt(j) - '0';
        }

        //logic
        bfs(new Pair(0, 0));

        //output
        bw.write(String.valueOf(map[N - 1][M - 1] - 1));
        br.close();
        bw.flush();
        bw.close();
    }

    public static void bfs(Pair pair) {
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(pair);
        map[pair.x][pair.y] += 1;

        while (!queue.isEmpty()) {
            pair = queue.poll();
            int x = pair.x;
            int y = pair.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= N)
                    continue;

                if (ny < 0 || ny >= M)
                    continue;

                if (map[nx][ny] != 1)
                    continue;

                queue.offer(new Pair(nx, ny));
                map[nx][ny] = map[x][y] + 1;
            }
        }
    }
}