class Main {
    public static void main(String[] args) {

        Solution solution = new Solution();

        String number = "4177252841";
        int k = 4;

        String answer = solution.solution(number, k);

        System.out.println(answer);

    }
}

//First solution
class Solution {
    public String solution(String number, int k) {

        StringBuilder stringBuffer = new StringBuilder();

        int digit = number.length() - k;

        int maxIdx = 0;
        for (int i = 0; i < digit; i++) {
            for (int j = maxIdx; j < (number.length() - digit + i + 1); j++) {
                maxIdx = number.charAt(maxIdx) < number.charAt(j) ? j : maxIdx;
            }
            stringBuffer.append(number.charAt(maxIdx));
            maxIdx++;
        }

        return stringBuffer.toString();
    }
}

//Second solution
class Solution {
    public String solution(String number, int k) {

        StringBuilder sb = new StringBuilder(number.length() - k);

        for (char ch : number.toCharArray()) {

            while (sb.length() > 0 && sb.charAt(sb.length() - 1) < ch && k > 0) {
                sb.deleteCharAt(sb.length() - 1);
                k--;
            }

            if (sb.length() < sb.capacity()) {
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}