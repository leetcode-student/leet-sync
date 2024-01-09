class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>();
        for (String word : wordDict) {
            wordDictSet.add(word);
        }
        return wordBreak(s, 0, wordDictSet, new HashMap<>());
    }

    private boolean wordBreak(String s, int start, Set<String> wordDictSet, Map<Integer, Boolean> cache) {
        if (start == s.length()) {
            return true;
        }

        if (cache.containsKey(start)) {
            return cache.get(start);
        }

        boolean isWordBreak = false;
        for (int i = 0; i < s.length() - start; i++) {
            String substring = s.substring(start, start + i + 1);
            if (wordDictSet.contains(substring) && wordBreak(s, start + i + 1, wordDictSet, cache)) {
                isWordBreak = true;
            }
        }

        cache.put(start, isWordBreak);

        return isWordBreak;
    }
}