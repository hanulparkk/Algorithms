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
    public static int[][] map;
    public static int[] dx;
    public static int[] dy;

    public static void main(String[] args) throws IOException {
        //input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++)
                map[i][j] = line.charAt(j) - '0';
        }
        dx = new int[]{-1, 1, 0, 0};
        dy = new int[]{0, 0, -1, 1};

        List<Integer> list = new ArrayList<>();

        //logic
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1)
                    list.add(bfs(new Pair(i, j)));
            }
        }
        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        sb.append(list.size()).append("\n");
        for (int l : list)
            sb.append(l).append("\n");

        //output
        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }

    public static int bfs(Pair pair) {
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(pair);
        map[pair.x][pair.y] = 0;
        int cnt = 1;

        while (!queue.isEmpty()) {
            pair = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = pair.x + dx[i];
                int ny = pair.y + dy[i];

                if (nx < 0 || nx >= N)
                    continue;

                if (ny < 0 || ny >= N)
                    continue;

                if (map[nx][ny] == 0)
                    continue;

                queue.offer(new Pair(nx, ny));
                map[nx][ny] = 0;
                cnt++;
            }
        }
        return cnt;
    }
}