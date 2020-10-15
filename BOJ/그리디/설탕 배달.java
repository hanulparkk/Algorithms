import java.util.*;

public class Main {
    public static void main(String[] args) {
        //input
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        //logic
        int answer = -1;
        int[] arr = new int[n + 1];
        Arrays.fill(arr, 5000);
        arr[0] = 0;
        arr[3] = 1;

        for (int i = 5; i <= n; i++) {
            arr[i] = Math.min(arr[i], arr[i - 3] + 1);
            arr[i] = Math.min(arr[i], arr[i - 5] + 1);
        }
        
        if (arr[n] != 5000)
            answer = arr[n];

        //output
        System.out.println(answer);
    }
}