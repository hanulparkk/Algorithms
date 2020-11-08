import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean[] exist = new boolean[20000001];
        int base = 10000000;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++)
            exist[Integer.parseInt(st.nextToken()) + base] = true;

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            if (exist[Integer.parseInt(st.nextToken()) + base])
                sb.append(1).append(" ");
            else
                sb.append(0).append(" ");
        }

        //output
        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}