import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] tree = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++)
            tree[i] = Integer.parseInt(st.nextToken());

        //logic
        int left = 0;
        int right = (int) 1e9;
        int result = 0;

        while (left <= right) {
            long total = 0;
            int mid = (left + right) / 2;

            for (int i = 0; i < N; i++) {
                if (tree[i] > mid)
                    total += tree[i] - mid;
            }

            if (total < M)
                right = mid - 1;
            else {
                left = mid + 1;
                result = mid;
            }
        }

        //output
        System.out.println(result);
    }
}