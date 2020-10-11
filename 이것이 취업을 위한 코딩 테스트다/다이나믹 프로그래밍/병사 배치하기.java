import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        int n = 7;
        ArrayList<Integer> v = new ArrayList<>(Arrays.asList(15, 11, 4, 8, 5, 2, 4));
        int[] dp = new int[2000];

        // 순서를 뒤집어 '최장 증가 부분 수열' 문제로 변환
        Collections.reverse(v);

        // 다이나믹 프로그래밍을 위한 1차원 DP 테이블 초기화
        Arrays.fill(dp, 1);

        // 가장 긴 증가하는 부분 수열(LIS: Longest Increasing Subsequence) 알고리즘 수행
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (v.get(j) < v.get(i))
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }

        // 열외해야 하는 병사의 최소 수를 출력
        int maxValue = 0;
        for (int i = 0; i < n; i++)
            maxValue = Math.max(maxValue, dp[i]);
        System.out.println(n - maxValue);
    }
}