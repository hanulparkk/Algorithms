//First Solution
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Stack<String> stack = new Stack<>();

        //logic
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch >= '0' && ch <= '9')
                stack.push(String.valueOf(ch));

            if (ch == '(')
                stack.push(String.valueOf(ch));

            if (ch == ')') {
                int Q = 0;
                while (!stack.peek().equals("(")) {
                    String token = stack.pop();
                    if (token.startsWith("n"))
                        Q += Integer.parseInt(token.substring(1));
                    else
                        Q++;
                }
                stack.pop();

                int K = Integer.parseInt(stack.pop());
                stack.push("n" + (K * Q));
            }
        }

        int total = 0;
        while (!stack.isEmpty()) {
            String token = stack.pop();
            if (token.startsWith("n"))
                total += Integer.parseInt(token.substring(1));
            else
                total++;
        }

        //output
        System.out.println(total);
    }
}