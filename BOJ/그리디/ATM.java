import java.util.*;

public class Main {
    public static void main(String[] args) {
        //input
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] p = new int[n];
        int[] d = new int[n];

        for (int i = 0; i < n; i++)
        	p[i] = sc.nextInt();
        
        //logic
        Arrays.sort(p);

        d[0] = p[0];
        int sum = p[0];

        for (int i = 1; i < n; i++) {
            d[i] = p[i] + d[i - 1];
            sum += d[i];
        }

        //output
        System.out.println(sum);
    }
}