import java.util.*;

public class Main {
    public static void main(String[] args) {
        //input
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        n = 1000 - n;
        int[] coins = {500, 100, 50, 10, 5, 1};
        int i = 0;
        int count = 0;

        //logic
        while (n != 0) {
            count += n / coins[i];
            n %= coins[i];
            i++;
        }

        //output
        System.out.println(count);
    }
}