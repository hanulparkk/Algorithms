class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String allowed = "ab";
        String[] words = {"ad", "bd", "aaab", "baa", "badab"};
        solution.countConsistentStrings(allowed, words);
    }
}

// First solution
class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int numberOfConsistentStrings = 0;
        for (String word : words) {
            if (isAllowedString(allowed, word)) {
                numberOfConsistentStrings++;
            }
        }
        return numberOfConsistentStrings;
    }

    public boolean isAllowedString(String allowed, String word) {
        String regex = "^[" + allowed + "]+$";
        if (word.matches(regex)) {
            return true;
        }
        return false;
    }
}

// Second solution
class Solution {
    private final boolean[] checkLetters = new boolean[26];

    public int countConsistentStrings(String allowed, String[] words) {
        for (int i = 0; i < allowed.length(); i++) {
            checkLetters[allowed.charAt(i) - 'a'] = true;
        }

        int numberOfConsistentStrings = 0;
        for (String word : words) {
            if (isAllowedString(word)) {
                numberOfConsistentStrings++;
            }
        }
        return numberOfConsistentStrings;
    }

    public boolean isAllowedString(String word) {
        for (char letter : word.toCharArray()) {
            if (!checkLetters[letter - 'a']) {
                return false;
            }
        }
        return true;
    }
}