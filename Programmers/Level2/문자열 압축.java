class Main {
    public static void main(String[] args) {

        Solution solution = new Solution();

        String s = "ababcdcdababcdcd";
        
        int answer = solution.solution(s);
        
        System.out.println(answer);

    }
}

class Solution {
    public int solution(String s) {
        int answer = s.length();

        for (int unit = 1; unit < s.length(); unit++) {
            StringBuffer stringBuffer = new StringBuffer();

            int count = 1;
            String preStr = "";
            String str = "";

            int i = 0;
            for (; (i + unit) <= s.length(); i += unit) {
                str = s.substring(i, i + unit);
                if (preStr.equals(str)) {
                    count++;
                } else if (!preStr.equals("")) {
                    if (count > 1) {
                        stringBuffer.append(count);
                    }
                    stringBuffer.append(preStr);
                    count = 1;
                }
                preStr = str;
            }

            if (count > 1) {
                stringBuffer.append(count);
            }
            stringBuffer.append(preStr);

            if (i < s.length()) {
                stringBuffer.append(s.substring(i, s.length()));
            }

            answer = answer > stringBuffer.length() ? stringBuffer.length() : answer;
        }

        return answer;
    }
}