import java.io.*;
import java.util.*;

public class Main {
    //0:up, 1:right, 2:down, 3:left
    static int numberOfDirections = 4;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N;
    static int M;
    static int[][] map;
    static int numberOfCleanSquares = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //지도의 가로, 세로 크기 입력
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        //로봇 청소기의 현재 위치와 방향 입력
        st = new StringTokenizer(br.readLine(), " ");
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        //지도 상태 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int nx;
        int ny;
        int nd;
        //로봇 청소기 시작 위치는 항상 청소하지 않은 칸
        boolean foundSquare = true;

        while (foundSquare) {
            //현재 위치 청소
            cleanAt(x, y);
            foundSquare = false;

            //왼쪽 방향으로 회전하면서 청소할 칸 찾기
            for (int i = 0; i < numberOfDirections; i++) {
                //왼쪽 방향으로 회전을 위한 위치와 방향 설정
                nd = calculateDirection(d, numberOfDirections - 1 - i);
                nx = x + dx[nd];
                ny = y + dy[nd];

                //청소할 칸이 아니면, 다시 회전 수행
                if (map[nx][ny] != 0) {
                    continue;
                }

                //청소하지 않은 칸이 존재하면, 그 방향으로 한 칸 이동
                foundSquare = true;
                x = nx;
                y = ny;
                d = nd;
                break;
            }

            //네 방향 모두 청소가 되어있거나 벽이면, 후진
            if (!foundSquare) {
                //후진할 위치와 방향 설정
                nd = calculateDirection(d, numberOfDirections / 2);
                nx = x + dx[nd];
                ny = y + dy[nd];

                //후진할 칸이 벽이 라면 작동을 멈춤
                if (map[nx][ny] == 1) {
                    break;
                }

                //후진할 수 있으면, 바라보는 방향을 유지한 채로 한 칸 후진
                foundSquare = true;
                x = nx;
                y = ny;
            }
        }

        bw.write(String.valueOf(numberOfCleanSquares));
        bw.flush();
        br.close();
        bw.close();
    }

    public static void cleanAt(int x, int y) {
        //이미 청소되어 있는 칸이라면, 또 청소하지 않음
        if (map[x][y] == 2) {
            return;
        }

        //청소 상태 갱신
        map[x][y] = 2;
        numberOfCleanSquares++;
    }

    public static int calculateDirection(int currentDirecction, int rotation) {
        int calculatedDirection = (currentDirecction + rotation) % numberOfDirections;
        return calculatedDirection;
    }
}