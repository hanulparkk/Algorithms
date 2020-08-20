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

        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) == 'A') {
                check[i] = true;
            }
        }

        Recursion(name, check, 0, 0);
        // RecursionTracking(name, check, 0, 0, "");

        return answer;
    }

    public static void Recursion(String name, boolean[] check, int pos, int move) {
        char ch = name.charAt(pos);
        int up = ch - 'A';
        int down = 'Z' - ch + 1;
        move += Math.min(up, down);
        check[pos] = true;

        boolean end = true;
        for (boolean bool : check) {
            end = end && bool;
        }

        if (end) {
            answer = Math.min(answer, move);
            return;
        }

        int posL = pos;
        int left = 0;
        while (check[posL]) {
            if (posL == 0) posL = name.length() - 1;
            else posL--;
            left++;
        }

        int posR = pos;
        int right = 0;
        while (check[posR]) {
            posR = (posR + 1) % name.length();
            right++;
        }

        Recursion(name, check.clone(), posR, move + right);
        Recursion(name, check.clone(), posL, move + left);

    }
    
    //Recursion Tracking
    /*
    public static void RecursionTracking(String name, boolean[] check, int pos, int move, String track) {
        char ch = name.charAt(pos);
        int up = ch - 'A';
        int down = 'Z' - ch + 1;
        move += Math.min(up, down);
        check[pos] = true;

        track += up < down ? "U" + up : "D" + down;

        boolean end = true;
        for (boolean bool : check) {
            end = end && bool;
        }

        if (end) {
            answer = Math.min(answer, move);
            System.out.println(track + " : " + move);
            return;
        }

        int posL = pos;
        int left = 0;
        while (check[posL]) {
            if (posL == 0) posL = name.length() - 1;
            else posL--;
            left++;
        }

        int posR = pos;
        int right = 0;
        while (check[posR]) {
            posR = (posR + 1) % name.length();
            right++;
        }

        RecursionTracking(name, check.clone(), posR, move + right, track + "R" + right);
        RecursionTracking(name, check.clone(), posL, move + left, track + "L" + left);

    }
    */
}