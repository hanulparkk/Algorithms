import java.util.*;

class Main {
    public static void main(String[] args) {

        Solution solution = new Solution();

        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;

        int answer = solution.solution(scoville, K);

        System.out.println(answer);

    }
}

//First Solution: PriorityQueue
class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int val : scoville)
            pq.offer(val);

        int answer = 0;
        
        while (pq.peek() < K) {
            if (pq.size() == 1)
                return -1;

            pq.offer(pq.poll() + (pq.poll() * 2));
            answer++;
        }

        return answer;
    }
}