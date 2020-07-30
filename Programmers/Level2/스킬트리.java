import java.util.*;

public class Main {
    public static void main(String[] args) {

        Solution solution = new Solution();

        String skill = "CBD";
        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};

        int answer = solution.solution(skill, skill_trees);

        System.out.println(answer);

    }
}

//First solution
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        List<Character> chars = new ArrayList<>();
        for(char ch : skill.toCharArray()) {
            chars.add(ch);
        }

        for(String skill_tree : skill_trees) {
            int level = 0;
            int success = 1;
            for(char ch : skill_tree.toCharArray()) {
                if(chars.contains(ch)) {
                    if(level < chars.indexOf(ch)) {
                        success = 0;
                        break;
                    } else if(level == chars.indexOf(ch)) {
                        level++;
                    } else {
                    }
                }
            }
            if(success == 1) {
                answer++;
            }
        }

        return answer;
    }
}

//Second solution
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for(String skill_tree : skill_trees) {
            if(!(skill.indexOf(skill_tree.replaceAll("[^" + skill + "]", "")) != 0)) {
                answer++;
            }
        }

        return answer;
    }
}

