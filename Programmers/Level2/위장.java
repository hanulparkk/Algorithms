import java.util.*;

class Main {
    public static void main(String[] args) {

        Solution solution = new Solution();

        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};

        int answer = solution.solution(clothes);

        System.out.println(answer);

    }
}

//First Solution
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;

        Map<String, Integer> map = new HashMap<>();

        for (String[] cloth : clothes) {
            map.put(cloth[1], map.getOrDefault(cloth[1], 0) + 1);
        }

        for (int count : map.values()) {
             answer *= (count + 1);
        }

        answer -= 1;
        
        return answer;
    }
}