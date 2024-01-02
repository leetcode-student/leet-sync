/*
0 1 2 3
length=4
mid= 1,2 or 1, or 2

0 1 2 3 4
length=5
mid= 2 or 1,2 or 2,3

*/

class Solution {
    public boolean validPalindrome(String s) {
        int mid = s.length() / 2;

        if (s.length() % 2 == 0) {
            return (mid - 1 >= 0 && validPalindrome(s, mid - 1, mid - 1, false))
                || (mid - 1 >= 0 && validPalindrome(s, mid - 1, mid, false))
                || validPalindrome(s, mid, mid, false);
        } else {
            return (mid - 1 >= 0 && validPalindrome(s, mid -1, mid, false))
                || validPalindrome(s, mid, mid, false)
                || (mid + 1 < s.length() && validPalindrome(s, mid, mid + 1, false));
        }
    }

    private boolean validPalindrome(String s, int left, int right, boolean deleteUsed) {
        if (left == -1 && right == s.length()) {
            return true;
        } else if (left == -1 && deleteUsed) {
            return false;
        } else if (right == s.length() && deleteUsed) {
            return false;
        }

        if (left >= 0 && right < s.length() && s.charAt(left) == (s.charAt(right))) {
            return validPalindrome(s, left - 1, right + 1, deleteUsed);
        }
        
        if (deleteUsed) {
            return false;
        }

        return validPalindrome(s, left - 1, right, true) || validPalindrome(s, left, right + 1, true);
    }
}