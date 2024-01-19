/*

What is a valid parenthesis?

At any given point left to right, open_count >= close_count
At any given point right to left, close_count >= open_count (basically reverse it)

If we try greedy approach and scan left to right, is it possible to remove too many closed parens?
No, because that can only be made valid by adding an open paren before it.
So it's to remove them

Now it's possible for there to be too may open parens.
For the same reason, we must remove them.

->
())
  ^ remove
<-
(()
^ remove

))((
((



*/
class Solution {
    public String minRemoveToMakeValid(String s) {
        String withCloseParensFixed = withInvalidCloseParensRemoved(s);

        String withOpenParensFixedReversed = withInvalidCloseParensRemoved(reversed(withCloseParensFixed));
        String withOpenParensFixed = reversed(withOpenParensFixedReversed);

        return withOpenParensFixed;
    }

    private String reversed(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
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

    private String withInvalidCloseParensRemoved(String s) {
        StringBuilder sb = new StringBuilder();

        int openCount = 0;
        int closeCount = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                openCount++;
                sb.append(c);
            } else if (c == ')') {
                if (closeCount < openCount) {
                    sb.append(c);
                    closeCount++;
                }
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}