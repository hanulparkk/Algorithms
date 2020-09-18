import java.util.*;

class Main {
    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        Solution solution = new Solution();

        String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};

        int[] answer = solution.solution(operations);

        System.out.println(Arrays.toString(answer));

        long elapsedTime = System.currentTimeMillis() - startTime;

        System.out.println("Total execution time in millis : " + elapsedTime);

    }
}

//First Solution: List
class Solution {
    public int[] solution(String[] operations) {
        int max = 0;
        int min = 0;
        List<Integer> list = new LinkedList<>();

        for (String operation : operations) {
            if (operation.startsWith("I"))
                list.add(Integer.parseInt(operation.split(" ")[1]));
            else if (operation.equals("D 1") && !list.isEmpty())
                list.remove(list.size() - 1);
            else if (operation.equals("D -1") && !list.isEmpty())
                list.remove(0);

            Collections.sort(list);
        }

        if (!list.isEmpty()) {
            max = list.get(list.size() - 1);
            min = list.get(0);
        }

        return new int[]{max, min};
    }
}

//Second Solution: TreeSet
class Solution {
    public int[] solution(String[] operations) {
        int max = 0;
        int min = 0;
        TreeSet<Integer> treeSet = new TreeSet<>();

        for (String operation : operations) {
            if (operation.startsWith("I"))
                treeSet.add(Integer.parseInt(operation.split(" ")[1]));
            else if (operation.equals("D 1") && !treeSet.isEmpty())
                treeSet.pollLast();
            else if (operation.equals("D -1") && !treeSet.isEmpty())
                treeSet.pollFirst();
        }
        
        if (!treeSet.isEmpty()) {
            max = treeSet.last();
            min = treeSet.first();
        }

        return new int[]{max, min};
    }
}