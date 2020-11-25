import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int K;
    static int[][] wheels;
    static int[] directions;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = 4;
        M = 8;
        wheels = new int[N][M];
        directions = new int[N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                if (line.charAt(j) == '1') {
                    wheels[i][j] = 1;
                }
            }
        }

        K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int wheelNumber = Integer.parseInt(st.nextToken()) - 1;
            int rotation = Integer.parseInt(st.nextToken()) * -1;

            int leftHead = leftHead(wheelNumber);
            int rightHead = rightHead(wheelNumber);
            rotateHead(wheelNumber, rotation);

            int leftRotation = rotation;
            int leftWheelNumber = wheelNumber - 1;
            while (leftWheelNumber >= 0) {
                if (rightHead(leftWheelNumber) == leftHead) {
                    break;
                }

                leftHead = leftHead(leftWheelNumber);
                leftRotation = leftRotation * -1;
                rotateHead(leftWheelNumber, leftRotation);
                leftWheelNumber--;
            }

            int rightRotation = rotation;
            int rightWheelNumber = wheelNumber + 1;
            while (rightWheelNumber < N) {
                if (leftHead(rightWheelNumber) == rightHead) {
                    break;
                }

                rightHead = rightHead(rightWheelNumber);
                rightRotation = rightRotation * -1;
                rotateHead(rightWheelNumber, rightRotation);
                rightWheelNumber++;
            }
        }

        int sum = 0;
        for (int wheelNumber = 0; wheelNumber < N; wheelNumber++) {
            sum += topHead(wheelNumber) * Math.pow(2, wheelNumber);
        }

        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
        br.close();
    }

    public static int rotate(int currentDirection, int rotation) {
        return (currentDirection + M + rotation) % M;
    }

    public static void rotateHead(int wheelNumber, int rotation) {
        int rotatedDirection = rotate(directions[wheelNumber], rotation);
        directions[wheelNumber] = rotatedDirection;
    }

    public static int topHead(int wheelNumber) {
        int topDirection = rotate(directions[wheelNumber], 0);
        int topHead = wheels[wheelNumber][topDirection];
        return topHead;
    }

    public static int leftHead(int wheelNumber) {
        int leftDirection = rotate(directions[wheelNumber], -2);
        int leftHead = wheels[wheelNumber][leftDirection];
        return leftHead;
    }

    public static int rightHead(int wheelNumber) {
        int rightDirection = rotate(directions[wheelNumber], 2);
        int rightHead = wheels[wheelNumber][rightDirection];
        return rightHead;
    }
}