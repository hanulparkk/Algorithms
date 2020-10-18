import java.util.*;

public class Main {
    public static void main(String[] args) {
        //input
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int A = 300;
        int B = 60;
        int C = 10;
        int[] btn = {A, B, C};

        //logic
        if (T % C != 0) {
            System.out.println(-1);
            return;
        }

        StringBuilder sb = new StringBuilder();

        for(int b : btn) {
            sb.append(T / b).append(" ");
            T %= b;
        }

        //output
        System.out.println(sb.toString());
    }
}