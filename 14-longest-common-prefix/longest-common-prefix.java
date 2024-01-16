class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder prefix = new StringBuilder(strs[0]);
        for (int i = 1; i < strs.length; i++) {
            int uncommonIdx = prefix.length();

            if (strs[i].length() < prefix.length()) {
                uncommonIdx = strs[i].length();
            }

            for (int j = 0; j < strs[i].length() && j < prefix.length(); j++) {
                if (strs[i].charAt(j) != prefix.charAt(j)) {
                    uncommonIdx = Math.min(uncommonIdx, j);
                    break;
                }
            }

            while (prefix.length() > uncommonIdx) {
                prefix.deleteCharAt(prefix.length() - 1);
            }
        }
        return prefix.toString();
    }
}