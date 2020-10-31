//First Solution
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int[] blocks = new int[W];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < W; i++)
            blocks[i] = Integer.parseInt(st.nextToken());

        //logic
        int sum = 0;
        for (int i = 1; i < W - 1; i++) {
            int left = i - 1;
            int right = i + 1;
            int leftMax = blocks[i];
            int rightMax = blocks[i];

            while (left >= 0) {
                if (blocks[left] > leftMax)
                    leftMax = blocks[left];

                left--;
            }

            while (right < W) {
                if (blocks[right] > rightMax)
                    rightMax = blocks[right];

                right++;
            }

            sum += Math.min(leftMax, rightMax) - blocks[i];
        }

        //output
        bw.write(String.valueOf(sum));
        br.close();
        bw.flush();
        bw.close();
    }
}

//Second Solution
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        //input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int[] blocks = new int[W];
        int[] left = new int[W];
        int[] right = new int[W];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++)
            blocks[i] = Integer.parseInt(st.nextToken());

        //logic
        int height = 0;
        for (int i = 0; i < W; i++) {
            if (height < blocks[i])
                height = blocks[i];

            left[i] = height;
        }

        height = 0;
        for (int i = W - 1; i >= 0; i--) {
            if (height < blocks[i])
                height = blocks[i];

            right[i] = height;
        }

        int sum = 0;
        for (int i = 0; i < W; i++)
            sum += Math.min(left[i], right[i]) - blocks[i];

        //output
        System.out.println(sum);
    }
}