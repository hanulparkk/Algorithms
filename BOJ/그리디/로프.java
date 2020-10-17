import java.util.*;

public class Main {
    public static void main(String[] args) {
        //input
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer[] ropes = new Integer[n];
        for (int i = 0; i < n; i++)
            ropes[i] = sc.nextInt();
        int max = 0;

        //logic
        Arrays.sort(ropes, Collections.reverseOrder());

        for (int i = 0; i < n; i++)
            max = Math.max(max, ropes[i] * (i + 1));

        //output
        System.out.println(max);
    }
}