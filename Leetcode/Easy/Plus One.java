class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] digits = {1, 2, 3};
        solution.plusOne(digits);
    }
}

class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;

        for (int i = digits.length - 1; i >= 0; i--) {
            int num = (digits[i] + carry);
            carry = num / 10;
            digits[i] = num % 10;
        }

        if (carry == 1) {
            int[] answer = new int[digits.length + 1];
            answer[0] = carry;
            System.arraycopy(digits, 0, answer, 1, digits.length);
            return answer;
        }

        return digits;
    }
}