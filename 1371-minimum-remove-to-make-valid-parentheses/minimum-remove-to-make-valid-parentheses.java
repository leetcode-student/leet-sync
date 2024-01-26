/*

What is a valid parenthesis?

1. Scanning left to right, the closed count can't be more than the open count
2. It is also true if you reverse the string

input
))((
1st pass
((
2nd pass
""


*/
class Solution {
    public String minRemoveToMakeValid(String s) {
        String withCloseParensFixed = minRemoveToMakeValidHelper(s);
        String withCloseParensFixedReversed = reverse(withCloseParensFixed);
        String withAllParensFixedReversed = minRemoveToMakeValidHelper(withCloseParensFixedReversed);
        String withAllParensFixed = reverse(withAllParensFixedReversed);

        return withAllParensFixed;
    }

    private String reverse(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = s.length() - 1; i >=0; i--) {
            char c = s.charAt(i);

            if (c == '(') {
                sb.append(')');
            } else if (c == ')') {
                sb.append('(');
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    private String minRemoveToMakeValidHelper(String s) {
        StringBuilder sb = new StringBuilder();

        int openCount = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                openCount++;
                sb.append(c);
            } else if (c == ')') {
                if (openCount > 0) {
                    openCount--;
                    sb.append(c);
                }
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}