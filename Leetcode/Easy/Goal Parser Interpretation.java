class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String command = "(G()(al)";
        solution.interpret(command);
    }
}

class Solution {
    public String interpret(String command) {
        StringBuilder interpretation = new StringBuilder();
        int index = 0;
        while (index < command.length()) {
            if (command.charAt(index) == 'G') {
                interpretation.append('G');
                index++;
                continue;
            }
            if (command.charAt(index + 1) == ')') {
                interpretation.append('o');
                index += 2;
                continue;
            }
            interpretation.append("al");
            index += 4;
        }
        return interpretation.toString();
    }
}