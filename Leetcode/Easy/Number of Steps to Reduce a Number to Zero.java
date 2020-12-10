class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int num = 14;
        solution.numberOfSteps(num);
    }
}

class Solution {
    public int numberOfSteps(int num) {
        int numberOfSteps = 0;
        while (num != 0) {
            numberOfSteps++;
            if (isEvenNumber(num)) {
                num /= 2;
                continue;
            }
            num -= 1;
        }
        return numberOfSteps;
    }

    public boolean isEvenNumber(int num) {
        return num % 2 == 0;
    }
}