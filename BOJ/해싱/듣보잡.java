import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        //logic
        Set<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            set.add(name);
        }

        List<String> list = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            String name = br.readLine();

            if (set.contains(name))
                list.add(name);
        }

        Collections.sort(list);

        //output
        bw.write(String.valueOf(list.size()));
        bw.write("\n");

        for (String name : list) {
            bw.write(String.valueOf(name));
            bw.write("\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}