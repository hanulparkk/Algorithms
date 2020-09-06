import java.util.*;

class Main {
    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        Solution solution = new Solution();

        String expression = "100-200*300-500+20";

        long answer = solution.solution(expression);

        System.out.println(answer);

        long elapsedTime = System.currentTimeMillis() - startTime;

        System.out.println("Total execution time in millis : " + elapsedTime);

    }
}

//First Solution: Convert infix to postfix, postfix evaluation
class Solution {
    static String orderOfOperations;

    public long solution(String expression) {
        long max = 0;
        String postfix = "";

        String[] operationsArr = {"*+-", "*-+", "+*-", "+-*", "-*+", "-+*"};

        for (String operations : operationsArr) {
            orderOfOperations = operations;
            postfix = convertInfixToPostfix(expression);
            max = Math.max(max, Math.abs(evaluatePostfix(postfix)));
        }

        return max;
    }

    public String convertInfixToPostfix(String expression) {
        StringBuilder postFix = new StringBuilder();
        Stack<Character> operator = new Stack<>();

        for (char ch : expression.toCharArray()) {
            if (ch == '*' || ch == '+' || ch == '-') {
                postFix.append(",");

                while (!operator.isEmpty()) {
                    if (orderOfOperations.indexOf(ch + "") < orderOfOperations.indexOf(operator.peek()))
                        break;

                    postFix.append(operator.pop() + ",");
                }

                operator.add(ch);

            } else
                postFix.append(ch);
        }

        postFix.append(",");

        while (!operator.isEmpty())
            postFix.append(operator.pop() + ",");

        return postFix.toString();
    }

    public long evaluatePostfix(String expression) {
        String[] strArr = expression.split(",");
        Stack<Long> evaluator = new Stack<>();

        for (String str : strArr) {
            if (str.equals("*")) {
                long operand1 = evaluator.pop();
                long operand2 = evaluator.pop();

                evaluator.add(operand2 * operand1);

            } else if (str.equals("+")) {
                long operand1 = evaluator.pop();
                long operand2 = evaluator.pop();

                evaluator.add(operand2 + operand1);

            } else if (str.equals("-")) {
                long operand1 = evaluator.pop();
                long operand2 = evaluator.pop();

                evaluator.add(operand2 - operand1);

            } else
                evaluator.add(Long.valueOf(str));
        }

        return evaluator.get(0);
    }
}