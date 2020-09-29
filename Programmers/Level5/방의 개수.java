import java.util.*;

class Main {
    public static void main(String[] args) {

        Solution solution = new Solution();

        int[] arrows = {6, 5, 2, 7, 1, 4, 2, 4, 6};

        long answer = solution.solution(arrows);

    }
}

//First Solution
class Solution {
    public int solution(int[] arrows) {
        int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
        int x = 0;
        int y = 0;

        Set<String> nodeSet = new HashSet<>();
        Set<String> edgeSet = new HashSet<>();

        String preNode = x + "," + y;
        nodeSet.add(preNode);

        int count = 0;

        for (int arrow : arrows) {
            for (int i = 0; i < 2; i++) {
                x += dx[arrow];
                y += dy[arrow];

                String curNode = x + "," + y;
                boolean visitedNode = nodeSet.add(curNode);
                boolean visitedEdge1 = edgeSet.add(preNode + "->" + curNode);
                boolean visitedEdge2 = edgeSet.add(curNode + "->" + preNode);

                if (!visitedNode && visitedEdge1 && visitedEdge2)
                    count++;

                preNode = curNode;
            }
        }

        return count;
    }
}