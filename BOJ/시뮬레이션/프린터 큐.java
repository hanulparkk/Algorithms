import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
    int index;
    int priority;

    public Node(int index, int priority) {
        this.index = index;
        this.priority = priority;
    }

    @Override
    public int compareTo(Node other) {
        return other.priority - this.priority;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        //input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());

        //logic
        while (TC-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            Queue<Node> q = new LinkedList<>();
            PriorityQueue<Node> pq = new PriorityQueue<>();

            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; i++) {
                int priority = Integer.parseInt(st.nextToken());
                q.offer(new Node(i, priority));
                pq.offer(new Node(i, priority));
            }

            int nth = 0;
            while (!q.isEmpty()) {
                if (q.peek().priority == pq.peek().priority) {
                    nth++;
                    pq.poll();

                    if (M == q.poll().index)
                        sb.append(nth).append("\n");
                } else
                    q.offer(q.poll());
            }
        }

        //output
        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}