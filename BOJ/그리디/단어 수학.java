import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        //input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] alphabet = new int[26];
        StringBuffer sb = new StringBuffer();

        //logic
        while (N-- > 0) {
            sb.append(br.readLine());
            
            int len = sb.length();
            for (int i = 0; i < len; i++)
                alphabet[sb.charAt(i) - 'A'] += Math.pow(10, len - 1 - i);

            sb.setLength(0);
        }

        Arrays.sort(alphabet);

        int maxSum = 0;
        int num = 9;
        for (int i = alphabet.length - 1; i >= 0; i--) {
            if (alphabet[i] == 0)
                break;

            maxSum += alphabet[i] * num--;
        }

        //output
        System.out.println(maxSum);
    }
}