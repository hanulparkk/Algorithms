class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String address = "1.1.1.1";
        solution.defangIPaddr(address);
    }
}

class Solution {
    public String defangIPaddr(String address) {
        StringBuilder sb = new StringBuilder();
        for (char ch : address.toCharArray()) {
            if (ch == '.') {
                sb.append("[.]");
                continue;
            }
            sb.append(ch);
        }
        return sb.toString();
    }
}