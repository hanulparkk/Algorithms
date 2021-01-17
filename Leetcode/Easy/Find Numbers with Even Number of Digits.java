public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {12, 345, 2, 6, 7896};
        solution.findNumbers(nums);
    }
}

class Solution {
    public int findNumbers(int[] nums) {
        int evenNumberOfDigits = 0;
        for (int num : nums) {
            int numberOfDigits = numberOfDigits(num);
            if (isEvenNumber(numberOfDigits)) {
                evenNumberOfDigits++;
            }
        }
        return evenNumberOfDigits;
    }

    public int numberOfDigits(int number) {
        int numberOfDigits = 0;
        while (number != 0) {
            number /= 10;
            numberOfDigits++;
        }
        return numberOfDigits;
    }

    public boolean isEvenNumber(int numberOfDigits) {
        return numberOfDigits % 2 == 0;
    }
}
