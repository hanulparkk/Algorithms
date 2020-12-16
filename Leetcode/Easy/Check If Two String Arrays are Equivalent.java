import java.util.Arrays;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] word1 = {"ab", "c"};
        String[] word2 = {"a", "bc"};
        solution.arrayStringsAreEqual(word1, word2);
    }
}

// First solution
class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String string1 = Arrays.stream(word1).collect(Collectors.joining());
        String string2 = Arrays.stream(word2).collect(Collectors.joining());
        return string1.equals(string2);
    }
}


// Second solution
class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder string1 = new StringBuilder();
        StringBuilder string2 = new StringBuilder();
        for (int i = 0; i < word1.length; i++) {
            string1.append(word1[i]);
        }
        for (int i = 0; i < word2.length; i++) {
            string2.append(word2[i]);
        }
        return string1.toString().equals(string2.toString());
    }
}