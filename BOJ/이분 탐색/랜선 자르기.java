import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] arr = new int[K];
        int max = 0;

        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());

            if (max < arr[i])
                max = arr[i];
        }

        long left = 1;
        long right = max;
        long result = 0;

        while (left <= right) {
            long total = 0;
            long mid = (left + right) / 2;

            for (int i = 0; i < K; i++)
                total += arr[i] / mid;

            if (total < N)
                right = mid - 1;
            else {
                left = mid + 1;
                result = mid;
            }
        }

        //output
        bw.write(String.valueOf(result));
        br.close();
        bw.flush();
        bw.close();
    }
}