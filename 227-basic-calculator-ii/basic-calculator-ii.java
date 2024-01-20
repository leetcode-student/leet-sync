class Solution {
    public int calculate(String s) {
        int current = 0;

        int lastOperand = 0;
        char lastOperator = '+';

        for (int i = 0; i < s.length();) {
            if (isOperator(s.charAt(i))) {
                lastOperator = s.charAt(i);
                i++;
            } else if (s.charAt(i) == ' ') {
                i++;
            } else {
                int number = Character.getNumericValue(s.charAt(i));
                int numEnd = i;

                while (numEnd + 1 < s.length() && Character.isDigit(s.charAt(numEnd + 1))) {
                    number = number * 10 + Character.getNumericValue(s.charAt(numEnd + 1));
                    numEnd++;
                }

                System.out.println("number=" + number + ", current=" + current + ", lastOperand=" + lastOperand);

                if (lastOperator == '+') {
                    current += number;
                    lastOperand = number;
                } else if (lastOperator == '-') {
                    current -= number;
                    lastOperand = -number;
                } else if (lastOperator == '*') {
                    current = current - lastOperand + lastOperand * number;
                    lastOperand = lastOperand * number;
                } else {
                    current = current - lastOperand + lastOperand / number;
                    lastOperand = lastOperand / number;
                }

                i = numEnd + 1;
            } 
        }

        return current;
    }

    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }
}