import java.util.*;

class Main {
    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        Solution solution = new Solution();

        int n = 5;
        int[] lost = {2, 4};
        int[] reserve = {1, 3, 5};

        int answer = solution.solution(n, lost, reserve);

        System.out.println(answer);

        long elapsedTime = System.currentTimeMillis() - startTime;

        System.out.println("Total execution time in millis : " + elapsedTime);

    }
}

//First Solution
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        List<Integer> lostList = new LinkedList<>();

        for (int i : lost)
            lostList.add(i);

        for (int i = 0; i < reserve.length; i++) {
            if (lostList.contains(reserve[i])) {
                lostList.remove(lostList.indexOf(reserve[i]));
                reserve[i] = 0;
            }
        }

        for (int i : reserve) {
            if (i == 0)
                continue;

            if (lostList.contains(i - 1))
                lostList.remove(lostList.indexOf(i - 1));
            else if (lostList.contains(i + 1))
                lostList.remove(lostList.indexOf(i + 1));
        }

        return n - lostList.size();
    }
}

//Second Solution
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] students = new int[n + 2];

        for (int i = 0; i < lost.length; i++)
            students[lost[i]]--;

        for (int i = 0; i < reserve.length; i++)
            students[reserve[i]]++;

        for (int i = 0; i < students.length; i++) {
            if (students[i] != -1)
                continue;

            if (students[i - 1] == 1) {
                students[i - 1]--;
                students[i]++;
            } else if (students[i + 1] == 1) {
                students[i + 1]--;
                students[i]++;
            } else
                n--;
        }

        return n;
    }
}