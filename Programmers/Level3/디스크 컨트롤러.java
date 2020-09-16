import java.util.*;

class Main {
    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        Solution solution = new Solution();

        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};

        int answer = solution.solution(jobs);

        System.out.println(answer);

        long elapsedTime = System.currentTimeMillis() - startTime;

        System.out.println("Total execution time in millis : " + elapsedTime);

    }
}

//First Solution: PriorityQueue
class Solution {
    public int solution(int[][] jobs) {
        PriorityQueue<int[]> jobQueue = new PriorityQueue<>((o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
        PriorityQueue<int[]> readyQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));

        for (int[] job : jobs)
            jobQueue.offer(job);

        int N = jobs.length;
        int terminated = 0;
        int currentTime = 0;
        int totalRespTime = 0;

        while (terminated < N) {
            while (!jobQueue.isEmpty() && jobQueue.peek()[0] <= currentTime)
                readyQueue.offer(jobQueue.poll());

            if (!readyQueue.isEmpty()) {
                int[] job = readyQueue.poll();
                currentTime += job[1];
                totalRespTime += currentTime - job[0];
                terminated++;
            } else
                currentTime++;
        }

        return totalRespTime / N;
    }
}