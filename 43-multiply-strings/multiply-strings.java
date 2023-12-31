/**
 
12
 5
__
10
50


 5
12
__
10
50

**/
class Solution {
    public String multiply(String num1, String num2) {
        StringBuilder total = new StringBuilder("0");

        for (int i = num1.length() - 1; i >= 0; i--) {
            int carry = 0;
            StringBuilder subTotalReversed = new StringBuilder();
            for (int j = num1.length() - 1; j > i; j--) {
                subTotalReversed.append("0");
            }
            for (int j = num2.length() - 1; j >= 0; j--) {
                int digit1 = Character.getNumericValue(num1.charAt(i));
                int digit2 = Character.getNumericValue(num2.charAt(j));

                int digitProduct = digit1 * digit2 + carry;

                System.out.println(digit1 + " * " + digit2 + " + " + carry + " = " + digitProduct);

                carry = digitProduct / 10;
                digitProduct = digitProduct % 10;

                subTotalReversed.append(digitProduct);
            }

            if (carry > 0) {
                subTotalReversed.append(carry);
            }

            total = new StringBuilder(add(total.toString(), subTotalReversed.reverse().toString()));
            System.out.println("total=" + total);
        }

        int firstIdx = 0;
        while (firstIdx + 1 < total.length() && total.charAt(firstIdx) == '0') {
            firstIdx++;
        }

        return total.toString().substring(firstIdx);
    } 

    private String add(String num1, String num2) {
        String longer = num1.length() >= num2.length() ? num1 : num2;
        String shorter = num1.length() < num2.length() ? num1 : num2;

        if (longer.equals("0")) {
            return shorter;
        } else if (shorter.equals("0")) {
            return longer;
        }

        int carry = 0;
        StringBuilder addedReversed = new StringBuilder();
        for (int i = longer.length() - 1; i >= 0; i--) {
            int digit1 = Character.getNumericValue(longer.charAt(i));
            int shorterIndex = i + shorter.length() - longer.length();
            int digit2 = shorterIndex >= 0 ? Character.getNumericValue(shorter.charAt(shorterIndex)) : 0;

            int digitSum = digit1 + digit2 + carry;

            carry = digitSum / 10;
            digitSum = digitSum % 10;

            addedReversed.append(Integer.toString(digitSum));
        }

        if (carry > 0) {
            addedReversed.append(Integer.toString(carry));
        }

        StringBuilder added = addedReversed.reverse();

        System.out.println(num1 + " + " + num2 + " = " + added);

        return added.toString();
    }
}