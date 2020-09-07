class Main {
    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        Solution solution = new Solution();

        int[] nums = {1, 2, 3, 4};

        int answer = solution.solution(nums);

        System.out.println(answer);

        long elapsedTime = System.currentTimeMillis() - startTime;

        System.out.println("Total execution time in millis : " + elapsedTime);

    }
}

//First Solution: DFS
class Solution {
    static int[] numArr;
    static boolean[] visit;
    static int count;

    public int solution(int[] nums) {
        numArr = nums;
        visit = new boolean[numArr.length];
        count = 0;

        dfs(0, 0, 0);

        return count;
    }

    public void dfs(int idx, int sum, int depth) {
        if (depth == 3) {
            if (isPrime(sum))
                count++;

            return;
        }

        for (int i = idx; i < numArr.length; i++) {
            if (visit[i])
                continue;

            visit[i] = true;
            dfs(i + 1, sum + numArr[i], depth + 1);
            visit[i] = false;
        }
    }

    public boolean isPrime(int n) {
        if (n < 2)
            return false;

        for (int i = 2; i <= Math.sqrt(n); i++)
            if (n % i == 0)
                return false;

        return true;
    }
}

//Second Solution: Triple nested for loops
class Solution {
    public int solution(int[] nums) {
        int answer = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];

                    if (isPrime(sum))
                        answer++;
                }
            }
        }

        return answer;
    }

    public boolean isPrime(int n) {
        if (n < 2)
            return false;

        for (int i = 2; i <= Math.sqrt(n); i++)
            if (n % i == 0)
                return false;

        return true;
    }
}