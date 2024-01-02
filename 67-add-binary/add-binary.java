class Solution {
    public String addBinary(String a, String b) {
        a = new StringBuilder(a).reverse().toString();
        b = new StringBuilder(b).reverse().toString();

        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int maxLength = Math.max(a.length(), b.length());
        for (int i = 0; i < maxLength; i++) {
            int digitSum = carry;
            if (i < a.length()) {
                digitSum += Character.getNumericValue(a.charAt(i));
            }
            if (i < b.length()) {
                digitSum += Character.getNumericValue(b.charAt(i));
            }

            carry = digitSum / 2;
            digitSum = digitSum % 2;
            sb.append(Integer.toString(digitSum));
        }

        if (carry == 1) {
            sb.append('1');
        }

        return sb.reverse().toString();
    }
}