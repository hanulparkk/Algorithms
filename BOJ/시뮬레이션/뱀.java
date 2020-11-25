import java.io.*;
import java.util.*;

class Node {
    public int x;
    public int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int N;
    static int K;
    static int L;
    static int[][] board;   //0: empty, 1: apple, 2: snake
    static int[] dx = {-1, 0, 1, 0};    //0:up, 1:right, 2:down, 3:left
    static int[] dy = {0, 1, 0, -1};
    static int numberOfDirections = 4;
    static int d = 1;   //current dirction
    static int x = 0;   //current location
    static int y = 0;
    static int sec = 0; //current second
    static Queue<Node> snake = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        board = new int[N][N];

        StringTokenizer st;
        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine(), " ");
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            board[i - 1][j - 1] = 1;
        }

        board[x][y] = 2;
        snake.offer(new Node(x, y));
        //printMap();

        boolean flag = true;
        
        L = Integer.parseInt(br.readLine());
        for (int l = 0; l < L; l++) {
            st = new StringTokenizer(br.readLine(), " ");
            int X = Integer.parseInt(st.nextToken());
            String C = st.nextToken();

            flag = moveN(X, C);

            if (!flag) {
                break;
            }
        }

        while (flag) {
            flag = moveOne(0);
        }

        bw.write(String.valueOf(sec));
        bw.flush();
        bw.close();
        br.close();
    }

    public static int nextDirection(int currentDirection, int rotation) {
        return (currentDirection + rotation) % numberOfDirections;
    }

    public static boolean isValidRange(int x, int y) {
        return (x >= 0 && x < N) && (y >= 0 && y < N);
    }

    public static boolean moveOne(int rotation) {
        d = nextDirection(d, rotation);
        x += dx[d];
        y += dy[d];
        sec++;

        if (!isValidRange(x, y)) {
            return false;
        }

        if (board[x][y] == 2) {
            return false;
        }

        if (board[x][y] == 0) {
            Node tail = snake.poll();
            board[tail.x][tail.y] = 0;
        }

        board[x][y] = 2;
        snake.offer(new Node(x, y));
        //printMap();
        return true;
    }

    public static boolean moveN(int X, String C) {
        for (int i = sec; i < X; i++) {
            if (!moveOne(0)) {
                return false;
            }
        }

        if (C.equals("L")) {
            return moveOne(3);
        }

        //if (C.equals("D"))
        return moveOne(1);
    }

//    public static void printMap() {
//        System.out.println(sec);
//        for (int i = 0; i < N; i++) {
//            System.out.println(Arrays.toString(map[i]));
//        }
//        System.out.println("---------------------");
//    }
}