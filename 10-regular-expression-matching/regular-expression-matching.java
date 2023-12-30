class Solution {
    public boolean isMatch(String s, String p) {
        Map<String, Boolean> cache = new HashMap<>();
        return isMatch(s, 0, p, 0, cache);
    }

    private boolean isMatch(String s, int sIdx, String p, int pIdx, Map<String, Boolean> cache) {
        //System.out.println("sIdx=" + sIdx + ", pIdx=" + pIdx);
        if (sIdx == s.length()) {
            if (pIdx == p.length()) {
                return true;
            } else if (pIdx + 1 == p.length() || p.charAt(pIdx + 1) != '*') {
                return false;
            }
        }
        
        if (pIdx == p.length()) {
            return sIdx == s.length();
        }

        String key = sIdx + "_" + pIdx;

        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        boolean isMatch = false;

        if (pIdx + 1 < p.length() && p.charAt(pIdx + 1) == '*') {
            if (isMatch(s, sIdx, p, pIdx + 2, cache)) {
                isMatch = true;
            }

            int i = sIdx;
            while (i < s.length() && (p.charAt(pIdx) == '.' || s.charAt(i) == p.charAt(pIdx))) {
                if (isMatch(s, i + 1, p, pIdx + 2, cache)) {
                    isMatch = true;
                    break;
                }
                i++;
            }
        } else if (p.charAt(pIdx) == '.') {
            isMatch = isMatch(s, sIdx + 1, p, pIdx + 1, cache);
        } else {
            isMatch = s.charAt(sIdx) == p.charAt(pIdx)
                && isMatch(s, sIdx + 1, p, pIdx + 1, cache);
        }

        cache.put(key, isMatch);

        return isMatch;
    }
}