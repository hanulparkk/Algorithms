import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack();
        stack.push(0); // this prevents EmptyStackException at stack.peek()
        int n = 1;

        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());

            if (stack.peek() > input) {
                sb.setLength(0);
                sb.append("NO");
                break;
            }

            while (stack.peek() < input) {
                stack.push(n);
                sb.append("+\n");
                n++;
            }

            stack.pop();
            sb.append("-\n");
        }

        System.out.println(sb);
        br.close();
    }
}