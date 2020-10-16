import java.util.*;

class Main {
    public static void main(String[] args) {
        //input
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] values = new int[N];

        for (int i = 0; i < N; i++)
            values[i] = sc.nextInt();

        //logic
        int answer = 0;

        for (int i = N - 1; i >= 0; i--) {
            answer += K / values[i];
            K = K % values[i];

            if (K == 0)
                break;
        }

        //output
        System.out.println(answer);
    }
}