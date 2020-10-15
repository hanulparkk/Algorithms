class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int n = 45;

        int answer = solution.solution(n);
    }
}

//First Solution
class Solution {
    public int solution(int n) {
        int a = n;
        int b;
        int temp;
        StringBuilder sb = new StringBuilder();

        while (a != 0) {
            temp = a % 3;
            a = a / 3;
            b = temp;
            sb.append(b);
        }

        int answer = 0;

        for (int i = 0; i < sb.length(); i++) {
            char ch = sb.charAt(i);
            int d = Integer.parseInt(String.valueOf(ch));
            answer += d * Math.pow(3, sb.length() - 1 - i);
        }

        return answer;
    }
}

//Second Solution
class Solution {
    public int solution(int n) {
        String s = Integer.toString(n, 3);
        StringBuilder sb = new StringBuilder(s);
        s = sb.reverse().toString();

        int answer = Integer.parseInt(s, 3);
        return answer;
    }
}