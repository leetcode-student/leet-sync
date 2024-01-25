/*

 ())
^

() )
  ^

   )))
^^^

Valid parenthesis

1. At any point there aren't any more closed paren than open paren
2. It is also true for the reverse

   )))(
^^^    ^

Greedy

Whenever there is an extra closed paren, add an open paren before it. Then close the remaining open ones.

*/

class Solution {
    public int minAddToMakeValid(String s) {
        int addCount = 0;
        int openCount = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                openCount++;
            } else if (c == ')') {
                if (openCount == 0) {
                    addCount++;
                } else {
                    openCount--;
                }
            }
        }

        return addCount + openCount;
    }
}