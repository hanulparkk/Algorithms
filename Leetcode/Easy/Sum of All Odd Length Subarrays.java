class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1, 4, 2, 5, 3};
        solution.sumOddLengthSubarrays(arr);
    }
}

// First solution
class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int totalSumOfOddLength = 0;
        for (int oddLength = 1; oddLength <= arr.length; oddLength += 2) {
            totalSumOfOddLength += sumOfOddLength(arr, oddLength);
        }
        return totalSumOfOddLength;
    }

    private int sumOfOddLength(int[] arr, int oddLength) {
        int sumOfOddLength = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i + oddLength > arr.length) {
                break;
            }
            for (int j = 0; j < oddLength; j++) {
                sumOfOddLength += arr[i + j];
            }
        }
        return sumOfOddLength;
    }
}

// Second solution
class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int totalSumOfOddLength = 0;
        for (int oddLength = 1; oddLength <= arr.length; oddLength += 2) {
            totalSumOfOddLength += sumOfOddLength(arr, oddLength);
        }
        return totalSumOfOddLength;
    }

    private int sumOfOddLength(int[] arr, int oddLength) {
        int sumOfOddLength = 0;
        int tempSumOfOddLength = 0;
        int i = 0;
        while (i < oddLength) {
            tempSumOfOddLength += arr[i];
            i++;
        }
        sumOfOddLength = tempSumOfOddLength;
        i = 0;
        while (oddLength < arr.length) {
            tempSumOfOddLength = tempSumOfOddLength + arr[oddLength] - arr[i];
            oddLength++;
            i++;
            sumOfOddLength += tempSumOfOddLength;
        }
        return sumOfOddLength;
    }
}