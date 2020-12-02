class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String A = "aaaaaaabc";
        String B = "aaaaaaacb";
        solution.buddyStrings(A, B);
    }
}

//First Solution
class Solution {
    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) {
            return false;
        }

        int[] countA = countComponentsOf(A);
        int[] countB = countComponentsOf(B);

        if (A.equals(B)) {
            return hasDuplicateComponents(countA);
        }

        if (!hasSameComposition(countA, countB)) {
            return false;
        }

        return checkDiffBetween(A, B);
    }

    public static int[] countComponentsOf(String s) {
        int[] count = new int[26];

        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }

        return count;
    }

    public static boolean hasDuplicateComponents(int[] count) {
        for (int c : count) {
            if (c > 1) {
                return true;
            }
        }

        return false;
    }

    public static boolean hasSameComposition(int[] countA, int[] countB) {
        for (int i = 0; i < 26; ++i) {
            if (countA[i] != countB[i]) {
                return false;
            }
        }

        return true;
    }

    public static boolean checkDiffBetween(String A, String B) {
        int diff = 0;

        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) != B.charAt(i)) {
                diff++;
            }

            if (diff > 2) {
                return false;
            }
        }

        return true;
    }
}


//Second Solution
class Solution {
    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) {
            return false;
        }

        if (A.equals(B)) {
            int[] count = new int[26];

            for (char ch : A.toCharArray()) {
                int index = ch - 'a';
                count[index]++;

                if (count[index] > 1) {
                    return true;
                }
            }

            return false;
        }


        char[] a = A.toCharArray();
        char[] b = B.toCharArray();

        int i = 0;
        while (a[i] == b[i]) {
            i++;
        }

        char toBeSwaped = b[i];

        for (int j = i + 1; j < a.length; j++) {
            if (a[j] == toBeSwaped) {
                a[j] = a[i];
                a[i] = toBeSwaped;
                break;
            }
        }

        while (i < a.length && a[i] == b[i]) {
            i++;
        }

        if (i == a.length) {
            return true;
        }

        return false;
    }
}

//Third Solution
class Solution {
    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) {
            return false;
        }

        if (A.equals(B)) {
            int[] count = new int[26];

            for (int i = 0; i < A.length(); ++i) {
                count[A.charAt(i) - 'a']++;
            }

            for (int c : count) {
                if (c > 1) return true;
            }

            return false;
        }

        int first = -1;
        int second = -1;

        for (int i = 0; i < A.length(); ++i) {
            if (A.charAt(i) != B.charAt(i)) {
                if (first == -1) {
                    first = i;
                } else if (second == -1) {
                    second = i;
                } else {
                    return false;
                }
            }
        }

        return (second != -1 && A.charAt(first) == B.charAt(second) &&
                A.charAt(second) == B.charAt(first));
    }
}