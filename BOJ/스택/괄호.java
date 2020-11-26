import java.io.*;
import java.util.*;

public class Main {
    static Stack stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        stack = new Stack();

        for (int i = 0; i < T; i++) {
            String PS = br.readLine();

            if (!isVPS(PS)) {
                bw.write("NO");
                bw.newLine();
                continue;
            }

            bw.write("YES");
            bw.newLine();
        }

        bw.flush();
        br.close();
        bw.close();
    }

    public static boolean isVPS(String PS) {
        for (int i = 0; i < PS.length(); i++) {
            char p = PS.charAt(i);

            if (p == '(') {
                stack.push(p);
                continue;
            }

            //if(p == ')')
            if (stack.isEmpty()) {
                return false;
            }

            stack.pop();
        }

        if (!stack.isEmpty()) {
            stack.clear();
            return false;
        }

        return true;
    }
}