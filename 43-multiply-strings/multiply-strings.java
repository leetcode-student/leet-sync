/**

multiply

123
456

123 * 6
123 * 5 * 10
123 * 4 * 100

123
  6

3 * 6 -> 8, carry 1
2 * 6 + 1 -> 3, carry 1
1 * 6 + 1 -> 7

add

123
456

3 + 6
2 + 5
1 + 4

**/
class Solution {
    public String multiply(String num1, String num2) {
        String result = "0";

        for (int i = num2.length() - 1; i >= 0; i--) {
            String product = multiply(num1, Character.getNumericValue(num2.charAt(i)));
            product = multiplyTens(product, num2.length() - 1 - i);

            result = add(result, product);
        }

        return clearLeadingZeroes(result);
    }

    private String clearLeadingZeroes(String num) {
        int firstNonZero = num.length() - 1;
        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i) != '0') {
                firstNonZero = i;
                break;
            }
        }

        return num.substring(firstNonZero);
    }

    private String multiplyTens(String num, int count) {
        StringBuilder result = new StringBuilder(num);
        for (int i = 0; i < count; i++) {
            result.append("0");
        }
        System.out.println(num + " -> " + result);
        return result.toString();
    }

    public String multiply(String num1, int digit2) {
        StringBuilder result = new StringBuilder();
        int carry = 0;
        for (int i = num1.length() - 1; i >= 0; i--) {
            int digit1 = Character.getNumericValue(num1.charAt(i));
            int product = digit1 * digit2 + carry;

            carry = product / 10;
            product = product % 10;

            //System.out.println("digit1=" + digit1 + ", digit2=" + digit2 + ", product=" + product);

            result.append(product);
        }

        if (carry > 0) {
            result.append(carry);
        }

        result.reverse();
        
        if (result.isEmpty()) {
            return "0";
        }

        System.out.println(num1 + " * " + digit2 + " = " + result);
        
        return result.toString();
    }

    public String add(String num1, String num2) {
        if (num1.length() < num2.length()) {
            return add(num2, num1);
        }

        int lengthDiff = num1.length() - num2.length();

        StringBuilder result = new StringBuilder();
        int carry = 0;
        for (int i = num1.length() - 1; i >= 0; i--) {
            int digit1 = Character.getNumericValue(num1.charAt(i));
            int digit2 = i - lengthDiff >= 0 ? Character.getNumericValue(num2.charAt(i - lengthDiff)) : 0;
            int sum = digit1 + digit2 + carry;

            carry = sum / 10;
            sum = sum % 10;

            result.append(sum);
        }

        if (carry > 0) {
            result.append(carry);
        }

        result.reverse();
        
        if (result.isEmpty()) {
            result.append("0");
        }

        System.out.println(num1 + " + " + num2 + " = " + result);
        
        return result.toString();
    }
}