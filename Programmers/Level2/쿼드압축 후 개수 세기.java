class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] arr = {
                {1, 1, 0, 0},
                {1, 0, 0, 0},
                {1, 0, 0, 1},
                {1, 1, 1, 1}
        };

        int[] answer = solution.solution(arr);
    }
}

//First Solution
class Solution {
    int cntZero;
    int cntOne;
    int[][] bitMap;

    public int[] solution(int[][] arr) {
        bitMap = arr;
        int n = bitMap.length;

        quadComp(0, 0, n);

        int[] answer = {cntZero, cntOne};
        return answer;
    }

    public void quadComp(int r, int c, int n) {
        int std = bitMap[r][c];

        for (int i = r; i < r + n; i++) {
            for (int j = c; j < c + n; j++) {
                if (std != bitMap[i][j]) {
                    n /= 2;
                    quadComp(r, c, n);
                    quadComp(r, c + n, n);
                    quadComp(r + n, c, n);
                    quadComp(r + n, c + n, n);
                    return;
                }
            }
        }

        if (std == 0)
            cntZero++;
        else
            cntOne++;
    }
}