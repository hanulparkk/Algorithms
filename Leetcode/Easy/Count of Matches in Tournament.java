class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 7;
        solution.numberOfMatches(n);
    }
}

// First solution
class Solution {
    public int numberOfMatches(int n) {
        int matches = 0;
        while (n != 1) {
            int quotient = n / 2;
            int remainder = n % 2;
            matches += quotient;
            n = quotient + remainder;
        }
        return matches;
    }
}

// Second solution
class Solution {
    public int numberOfMatches(int n) {
        if (n == 1) {
            return 0;
        }

        int matches = 0;
        int teams = 0;

        if (n % 2 == 0) {
            matches = n / 2;
            teams = n / 2;
            return matches + numberOfMatches(teams);
        }

        matches = (n - 1) / 2;
        teams = (n - 1) / 2 + 1;
        return matches + numberOfMatches(teams);
    }
}

// Third solution
class Solution {
    public int numberOfMatches(int n) {
        if (n == 1) {
            return 0;
        }

        int matches = (n % 2 == 0) ? n / 2 : (n - 1) / 2;
        int teams = (n % 2 == 0) ? n / 2 : (n - 1) / 2 + 1;
        return matches + numberOfMatches(teams);
    }
}