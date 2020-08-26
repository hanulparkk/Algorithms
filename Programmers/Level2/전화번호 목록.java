class Main {
    public static void main(String[] args) {

        Solution solution = new Solution();

        String[] phone_book = {"119", "97674223", "1195524421"};

        boolean answer = solution.solution(phone_book);

        System.out.println(answer);

    }
}

//First Solution
class Solution {
    public boolean solution(String[] phone_book) {
        for (int i = 0; i < phone_book.length; i++) {
            for (int j = 0; j < phone_book.length; j++) {
                if (i == j)
                    continue;
                if (phone_book[j].startsWith(phone_book[i]))
                    return false;
            }
        }
        return true;
    }
}