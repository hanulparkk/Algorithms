class Main {
    public static void main(String[] args) {

        Solution solution = new Solution();

        String name = "JEROEN";

        int answer = solution.solution(name);

        System.out.println(answer);

    }
}

//First Solution: Recursion
class Solution {
    static int answer = Integer.MAX_VALUE;

    public int solution(String name) {
        boolean[] check = new boolean[name.length()];

        for (int i = 0; i < name.length(); i++)
            if (name.charAt(i) == 'A')
                check[i] = true;

        recursion(name, check, 0, 0);

        return answer;
    }

    public static void recursion(String name, boolean[] check, int pos, int move) {
        char ch = name.charAt(pos);
        int up = ch - 'A';
        int down = 'Z' - ch + 1;
        move += Math.min(up, down);
        check[pos] = true;

        boolean exit = true;
        for (boolean bool : check)
            exit = exit && bool;

        if (exit) {
            answer = Math.min(answer, move);
            return;
        }

        int posL = pos;
        int left = 0;
        while (check[posL]) {
            if (posL == 0)
                posL = name.length() - 1;
            else
                posL--;
            left++;
        }

        int posR = pos;
        int right = 0;
        while (check[posR]) {
            posR = (posR + 1) % name.length();
            right++;
        }

        recursion(name, check.clone(), posR, move + right);
        recursion(name, check.clone(), posL, move + left);
    }
}

//Second Solution
class Solution {
    public int solution(String name) {
        int upDown = 0;
        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) != 'A') {
                int up = name.charAt(i) - 'A';
                int down = 'Z' - name.charAt(i) + 1;
                upDown += Math.min(up, down);
            }
        }

        int leftRight = name.length() - 1;
        for (int i = 0; i < name.length(); i++) {
            if (i == 0 || name.charAt(i) != 'A') {
                int next = i + 1;
                while (next < name.length() && name.charAt(next) == 'A')
                    next++;

                int move = 2 * i + name.length() - next;
                leftRight = Math.min(move, leftRight);
            }
        }

        return upDown + leftRight;
    }
}