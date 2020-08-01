class Main {
    public static void main(String[] args) {

        Solution solution = new Solution();

        int w = 8;
        int h = 12;

        long answer = solution.solution(w, h);

        System.out.println(answer);

    }
}

class Solution {
    public long solution(int w, int h) {
        int gcd = w < h ? w : h;

        while (gcd > 0) {
            if (w % gcd == 0 && h % gcd == 0) {
                break;
            }
            gcd--;
        }
        
        return (long) w * (long) h - (w + h - gcd);
    }
}