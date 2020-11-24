import java.io.*;
import java.util.*;

class Dice {
    //index -> 0: 위, 1: 아래, 2: 왼, 3: 오, 4: 앞, 5: 뒤
    private final int[] faces;

    public Dice() {
        int numberOfFaces = 6;
        this.faces = new int[numberOfFaces];
    }

    //move -> 1:동, 2:서, 3:북, 4:남
    public void rolling(int move) {
        switch (move) {
            case 1:
                rollRight();
                break;
            case 2:
                rollLeft();
                break;
            case 3:
                rollUp();
                break;
            case 4:
                rollDown();
                break;
        }
    }

    private void rollUp() {
        int temp = faces[1];
        faces[1] = faces[4];
        faces[4] = faces[0];
        faces[0] = faces[5];
        faces[5] = temp;
    }

    private void rollDown() {
        int temp = faces[1];
        faces[1] = faces[5];
        faces[5] = faces[0];
        faces[0] = faces[4];
        faces[4] = temp;
    }

    private void rollLeft() {
        int temp = faces[1];
        faces[1] = faces[2];
        faces[2] = faces[0];
        faces[0] = faces[3];
        faces[3] = temp;
    }

    private void rollRight() {
        int temp = faces[1];
        faces[1] = faces[3];
        faces[3] = faces[0];
        faces[0] = faces[2];
        faces[2] = temp;
    }

    public int topFace() {
        return faces[0];
    }

    public int bottomFace() {
        return faces[1];
    }

    public void setBottomFace(int bottomFace) {
        faces[1] = bottomFace;
    }
}

public class Main {
    static int N;
    static int M;
    static int x;
    static int y;
    static int K;
    static int[][] map;
    static int[] moves;
    //0: 제자리, 1:동, 2:서, 3:북, 4:남
    static int[] dx = {0, 0, 0, -1, 1};
    static int[] dy = {0, 1, -1, 0, 0};
    static Dice dice;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        inputData();

        dice = new Dice();
        boolean moveSuccess;

        for (int i = 0; i < K; i++) {
            moveSuccess = moveNext(moves[i]);

            if (moveSuccess) {
                bw.write(String.valueOf(dice.topFace()));
                bw.newLine();
            }
        }

        bw.flush();
        bw.close();
    }

    public static boolean isValidRange(int x, int y) {
        return (x >= 0 && x < N) && (y >= 0 && y < M);
    }

    public static boolean moveNext(int move) {
        int nx = x + dx[move];
        int ny = y + dy[move];

        if (!isValidRange(nx, ny)) {
            return false;
        }

        x = nx;
        y = ny;
        dice.rolling(move);

        if (map[x][y] == 0) {
            map[x][y] = dice.bottomFace();
            return true;
        }

        dice.setBottomFace(map[x][y]);
        map[x][y] = 0;
        return true;
    }

    public static void inputData() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        moves = new int[K];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < K; i++) {
            moves[i] = Integer.parseInt(st.nextToken());
        }

        br.close();
    }
}