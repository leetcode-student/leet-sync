class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> orderMap = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            orderMap.put(order.charAt(i), i);
        }

        String lastWord = words[0];
        for (int i = 1; i < words.length; i++) {
            String currWord = words[i];

            for (int c = 0; c < Math.max(lastWord.length(), currWord.length()); c++) {
                if (c == currWord.length()) {
                    return false;
                } else if (c == lastWord.length()) {
                    break;
                } else if (orderMap.get(lastWord.charAt(c)) < orderMap.get(currWord.charAt(c))) {
                    break;
                } else if (orderMap.get(lastWord.charAt(c)) > orderMap.get(currWord.charAt(c))) {
                    return false;
                }
            }
            
            lastWord = currWord;
        }

        return true;
    }
}