class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramsToStrings = new HashMap<>();

        for (String s : strs) {
            String anagram = toAnagram(s);

            if (!anagramsToStrings.containsKey(anagram)) {
                anagramsToStrings.put(anagram, new ArrayList<>());
            }

            anagramsToStrings.get(anagram).add(s);
        }

        List<List<String>> groupedAnagrams = new ArrayList<>();

        for (String anagramKey : anagramsToStrings.keySet()) {
            groupedAnagrams.add(anagramsToStrings.get(anagramKey));
        }

        return groupedAnagrams;
    }

    private String toAnagram(String s) {
        int[] counts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int count : counts) {
            sb.append(count);
            sb.append(",");
        }

        return sb.toString();
    }
}