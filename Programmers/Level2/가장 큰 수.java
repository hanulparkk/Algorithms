import java.util.*;

class Main {
    public static void main(String[] args) {

        Solution solution = new Solution();

        int[] numbers = {3, 30, 34, 5, 9};

        String answer = solution.solution(numbers);

        System.out.println(answer);

    }
}

class Solution {
    public String solution(int[] numbers) {

        ArrayList<String> arrayList = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {
            arrayList.add(String.valueOf(numbers[i]));
        }

        Comparator<String> myComparator = new Comparator<>() {
            @Override
            public int compare(String s1, String s2) {
                return (int) (Long.parseLong(s2 + s1) - Long.parseLong(s1 + s2));
            }
        };

        arrayList.sort(myComparator);

        if (arrayList.get(0).equals("0")) {
            return "0";
        }

        return String.join("", arrayList);

    }
}