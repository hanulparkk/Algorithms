import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = 10;
        int totalPrice = Integer.parseInt(br.readLine());
        int sum = 0;

        for (int i = 1; i < N; i++) {
            sum += Integer.parseInt(br.readLine());
        }

        bw.write(String.valueOf(totalPrice - sum));

        bw.flush();
        br.close();
        bw.close();
    }
}