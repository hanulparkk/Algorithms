class Main {
    public static void main(String[] args) {

        Solution solution = new Solution();

        String[] data = {"N~F=0", "R~T>2"};
        int n = data.length;

        int answer = solution.solution(n, data);

        System.out.println(answer);

    }
}

//First Solution: DFS
class Solution {
    static String[] friends;
    static int N;
    static boolean[] visit;
    static String[] condition;
    static int answer;

    public int solution(int n, String[] data) {
        friends = new String[]{"A", "C", "F", "J", "M", "N", "R", "T"};
        N = friends.length;
        visit = new boolean[N];
        condition = data;
        answer = 0;

        DFS("");

        return answer;
    }

    public void DFS(String s) {
        if (s.length() == N) {
            if (isValid(s))
                answer++;

            return;
        }

        for (int i = 0; i < N; i++) {
            if (visit[i])
                continue;

            visit[i] = true;
            DFS(s + friends[i]);
            visit[i] = false;
        }
    }

    public boolean isValid(String s) {
        for (String c : condition) {
            int f1 = s.indexOf(c.charAt(0));
            int f2 = s.indexOf(c.charAt(2));
            char c1 = c.charAt(3);
            int c2 = c.charAt(4) - '0';

            if (f1 == -1 || f2 == -1)
                return false;

            int dist = Math.abs(f1 - f2) - 1;

            if (c1 == '=' && dist == c2)
                continue;
            else if (c1 == '>' && dist > c2)
                continue;
            else if (c1 == '<' && dist < c2)
                continue;
            else
                return false;
        }

        return true;
    }
}