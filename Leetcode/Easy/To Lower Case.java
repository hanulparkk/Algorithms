class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String str = "Hello";
        solution.toLowerCase(str);
    }
}

// First solution
class Solution {
    public String toLowerCase(String str) {
        return str.toLowerCase();
    }
}

// Second solution
class Solution {
    public String toLowerCase(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (isUpperCase(ch)) {
                char lowerCase = (char) ('a' + (ch - 'A'));
                sb.append(lowerCase);
                continue;
            }
            sb.append(ch);
        }
        return sb.toString();
    }

    private boolean isUpperCase(char ch) {
        return ch >= 'A' && ch <= 'Z';
//        return Character.isUpperCase(ch);
    }
}