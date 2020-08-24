import java.util.*;

class Main {
    public static void main(String[] args) {

        Solution solution = new Solution();

        String numbers = "17";

        int answer = solution.solution(numbers);

        System.out.println(answer);

    }
}

//First Solution: Recursion
class Solution {
    public int solution(String numbers) {
        boolean[] flags = new boolean[numbers.length()];

        Set<Integer> set = new HashSet<>();

        recursion(numbers.toCharArray(), flags, "", set);

        return set.size();
    }

    public static void recursion(char[] numbers, boolean[] flags, String s, Set set) {
        if (s.length() == numbers.length)
            return;

        for (int i = 0; i < numbers.length; i++) {
            if (flags[i] == true)
                continue;

            StringBuilder sb = new StringBuilder();
            sb.append(s);
            sb.append(numbers[i]);

            boolean[] flagCopies = flags.clone();
            flagCopies[i] = true;

            int N = Integer.parseInt(sb.toString());

            if (isPrimeNum(N))
                set.add(N);

            recursion(numbers, flagCopies, sb.toString(), set);
        }

    }

    public static boolean isPrimeNum(int N) {
        if (N < 2)
            return false;

        for (int i = 2; i <= Math.sqrt(N); i++) {
            if ((N % i) == 0)
                return false;
        }

        return true;
    }
}