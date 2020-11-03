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
    public static int[][] map;
    public static int[] dx;
    public static int[] dy;
    public static Queue<Pair> queue;
    public static int greenTomato;

    public static void main(String[] args) throws IOException {
        //input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        dx = new int[]{-1, 1, 0, 0};
        dy = new int[]{0, 0, -1, 1};
        queue = new LinkedList<>();
        greenTomato = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 0)
                    greenTomato++;
                else if (map[i][j] == 1)
                    queue.offer(new Pair(i, j));
            }
        }

        int day = 0;

        //logic
        if (greenTomato != 0) {
            day = bfs();

            if (greenTomato != 0)
                day = -1;
        }

        //output
        bw.write(String.valueOf(day));
        br.close();
        bw.flush();
        bw.close();
    }

    public static int bfs() {
        int day = 0;

        while (!queue.isEmpty()) {
            int queueSize = queue.size();

            for (int i = 0; i < queueSize; i++) {
                Pair pair = queue.poll();

                for (int j = 0; j < 4; j++) {
                    int nx = pair.x + dx[j];
                    int ny = pair.y + dy[j];

                    if (nx < 0 || nx >= N)
                        continue;

                    if (ny < 0 || ny >= M)
                        continue;

                    if (map[nx][ny] != 0)
                        continue;

                    queue.offer(new Pair(nx, ny));
                    map[nx][ny] = 1;
                    greenTomato--;
                }
            }
            day++;
        }
        return day - 1;
    }
}