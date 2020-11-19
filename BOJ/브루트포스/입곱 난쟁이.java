import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = 9;
        int[] arr = new int[N];

        int sum = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }

        //logic
        Arrays.sort(arr);

        boolean found = false;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j)
                    continue;

                if (sum - arr[i] - arr[j] == 100) {
                    arr[i] = 0;
                    arr[j] = 0;
                    found = true;
                    break;
                }
            }

            if (found)
                break;
        }
        
        //output
        for (int k = 0; k < N; k++) {
            if (arr[k] == 0)
                continue;

            bw.write(String.valueOf(arr[k]));
            bw.write("\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}