class Solution {
    public String minWindow(String s, String t) {
        if (t.equals("")) {
            return "";
        }

        Map<Character, Integer> expectedHistogram = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            expectedHistogram.put(t.charAt(i), expectedHistogram.getOrDefault(t.charAt(i), 0) + 1);
        }

        Map<Character, Integer> currHistogram = new HashMap<>();
        int minWindowStart = -1;
        int minWindowEnd = -1;
        int currWindowStart = 0;
        for (int i = 0; i < s.length(); i++) {
            currHistogram.put(s.charAt(i), currHistogram.getOrDefault(s.charAt(i), 0) + 1);

            while (currWindowStart < i
                    && isWindow(currHistogram, expectedHistogram)
                    && (!expectedHistogram.containsKey(s.charAt(currWindowStart))
                        || currHistogram.get(s.charAt(currWindowStart)) > expectedHistogram.get(s.charAt(currWindowStart)))) {
                currHistogram.put(s.charAt(currWindowStart), currHistogram.get(s.charAt(currWindowStart)) - 1);
                currWindowStart++;
            }

            if (isWindow(currHistogram, expectedHistogram)) {
                if (minWindowStart == -1 || (i - currWindowStart) < (minWindowEnd - minWindowStart)) {
                    minWindowStart = currWindowStart;
                    minWindowEnd = i;
                }
            }
            
        }

        if (minWindowStart == -1) {
            return "";
        }

        return s.substring(minWindowStart, minWindowEnd + 1);
    }

    private boolean isWindow(Map<Character, Integer> current, Map<Character, Integer> expected) {
        //System.out.println("current=" + current);
        //System.out.println("expected=" + expected);

        if (current.size() < expected.size()) {
            return false;
        }

        for (char key : expected.keySet()) {
            if (!current.containsKey(key)) {
                return false;
            }
            if (current.get(key) < expected.get(key)) {
                return false;
            }
        }

        return true;
    }
}