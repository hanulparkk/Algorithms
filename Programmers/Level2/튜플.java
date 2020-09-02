import java.util.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.util.stream.Stream;

class Main {
    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        Solution solution = new Solution();

        String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";

        int[] answer = solution.solution(s);

        System.out.println(Arrays.toString(answer));

        long elapsedTime = System.currentTimeMillis() - startTime;

        System.out.println("Total execution time in millis : " + elapsedTime);

    }
}

//First Solution
class Solution {
    public int[] solution(String s) {
        Map<Integer, String> map = new HashMap<>();

        for (int i = 1; i < s.length() - 1; i++) {
            char ch = s.charAt(i);

            if (ch == '{') {
                int count = 0;

                i++;
                ch = s.charAt(i);

                String str = "";

                while (ch != '}') {
                    str += ch;

                    if (ch == ',')
                        count++;

                    i++;
                    ch = s.charAt(i);
                }

                map.put(count + 1, str);
            }
        }

        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= map.size(); i++) {
            String[] strArr = map.get(i).split(",");

            for (int j = 0; j < strArr.length; j++) {
                int item = Integer.parseInt(strArr[j]);

                if (!list.contains(item))
                    list.add(item);
            }
        }

        int[] answer = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}

//Second Solution
class Solution {
    public int[] solution(String s) {
        String[] arr = s.replaceAll("[{]", " ").replaceAll("[}]", " ").trim().split(" , ");

        Arrays.sort(arr, (a, b) -> {
            return a.length() - b.length();
        });

        int[] answer = new int[arr.length];

        Set<String> set = new HashSet<>();

        int idx = 0;
        for (String s1 : arr) {
            for (String s2 : s1.split(",")) {
                if (set.add(s2)) answer[idx++] = Integer.parseInt(s2);
            }
        }

        return answer;
    }
}

//Third Solution
class Solution {
    public int[] solution(String s) {
        Map<String, Integer> map = new HashMap<>();

        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher matcher = pattern.matcher(s);

        while (matcher.find()) {
            String n = matcher.group();
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        int size = map.size();

        int[] answer = new int[size];

        for (String key : map.keySet()) {
            answer[size - map.get(key)] = Integer.parseInt(key);
        }

        return answer;
    }
}

//Fourth Solution
class Solution {
    public int[] solution(String s) {
        String[] strArr = s.replaceAll("[}{]", "").split(",");

        Map<String, Integer> map = new HashMap<>();

        for (String str : strArr)
            map.put(str, map.getOrDefault(str, 0) + 1);

        int[] answer = new int[map.size()];

        for (String key : map.keySet())
            answer[map.size() - map.get(key)] = Integer.parseInt(key);

        return answer;
    }
}

//Fifth Solution
class Solution {
    final Map<Integer, Integer> counts = new LinkedHashMap<>();

    public int[] solution(String s) {
        Stream.of(s.replaceAll("[}{]", "").split(",")).mapToInt(Integer::parseInt)
                .forEach(i -> counts.merge(i, 1, Integer::sum));

        return counts.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .map(Map.Entry::getKey).mapToInt(x -> x).toArray();
    }
}