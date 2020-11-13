import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int cnt = 0;

        //logic
        if (N < 100)
            cnt = N;
        else {
            cnt = 99;

            if (N == 1000)
                N = 999;

            //100 ~ 999
            for (int num = 100; num <= N; num++) {
                int digit_100 = num / 100;
                int digit_10 = (num / 10) % 10;
                int digit_1 = num % 10;

                if ((digit_100 - digit_10) == (digit_10 - digit_1))
                    cnt++;
            }
        }

        //output
        bw.write(String.valueOf(cnt));
        br.close();
        bw.flush();
        bw.close();
    }
}