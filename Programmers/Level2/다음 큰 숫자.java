class Main {
    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        Solution solution = new Solution();

        int n = 78;

        int answer = solution.solution(n);

        System.out.println(answer);

        long elapsedTime = System.currentTimeMillis() - startTime;

        System.out.println("Total execution time in millis : " + elapsedTime);

    }
}

//First Solution: Integer.toBinaryString(int i)
class Solution {
    public int solution(int n) {
        String binary = Integer.toBinaryString(n);
        int numOfOne = 0;

        for (char ch : binary.toCharArray()) {
            if (ch == '1')
                numOfOne++;
        }

        int answer = n + 1;
        boolean found = false;

        while (!found) {
            binary = Integer.toBinaryString(answer);
            int count = 0;

            for (char ch : binary.toCharArray()) {
                if (ch == '1')
                    count++;
            }

            if (numOfOne != count) {
                answer++;
                continue;
            }

            found = true;
        }

        return answer;
    }
}

//Second Solution
class Solution {
    public int solution(int n) {
        int count = findNumOfOne(n);
        int answer = n + 1;

        while (count != findNumOfOne(answer))
            answer++;

        return answer;
    }

    public int findNumOfOne(int n) {
        int count = 0;

        if (n == 1)
            return 1;

        while (n > 0) {
            if (n % 2 == 1)
                count++;

            n = n / 2;
        }

        return count;
    }
}

//Third Solution: Integer.bitCount(int i)
class Solution {
    public int solution(int n) {
        int bitCount = Integer.bitCount(n);
        int nextBigNum = n + 1;

        while (bitCount != Integer.bitCount(nextBigNum))
            nextBigNum++;

        return nextBigNum;
    }
}