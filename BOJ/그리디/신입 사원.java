//First Solution
import java.util.*;

public class Main {
    public static void main(String[] args) {
        //input
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        while (tc-- > 0) {
            int n = sc.nextInt();
            int[] rank = new int[n + 1];

            for (int i = 0; i < n; i++)
                rank[sc.nextInt()] = sc.nextInt();

            //logic
            int cnt = 0;
            int cutLine = n + 1;

            for (int i = 1; i <= n; i++) {
                if (rank[i] < cutLine) {
                    cnt++;
                    cutLine = rank[i];
                }
            }

            //output
            System.out.println(cnt);
        }
    }
}

//Second Solution
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        //input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[] rank = new int[N + 1];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                rank[x] = y;
            }

            //logic
            int cnt = 1;
            int cutLine = rank[1];

            for (int i = 2; i <= N; i++) {
                if (rank[i] < cutLine) {
                    cnt++;
                    cutLine = rank[i];
                }
            }

            //output
            System.out.println(cnt);
        }
    }
}