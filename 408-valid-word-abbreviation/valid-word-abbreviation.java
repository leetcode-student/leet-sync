class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int iWord = 0;
        int iAbbr = 0;

        while (iAbbr < abbr.length()) {
            //System.out.println("iWord=" + iWord + ", iAbbr=" + iAbbr);
            if (iWord == word.length()) {
                return false;
            } else if (abbr.charAt(iAbbr) == '0') {
                return false;
            } else if (Character.isDigit(abbr.charAt(iAbbr))) {
                int start = iAbbr;
                while (iAbbr < abbr.length() && Character.isDigit(abbr.charAt(iAbbr))) {
                    iAbbr++;
                }
                int length = Integer.parseInt(abbr.substring(start, iAbbr));
                //System.out.println("    length=" + length);

                iWord += length;
            } else if (word.charAt(iWord) != abbr.charAt(iAbbr)) {
                return false;
            } else {
                iWord++;
                iAbbr++;
            }
        }
        
        return iWord == word.length();
    }
}