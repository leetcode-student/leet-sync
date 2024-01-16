/*

63 minutes
35 minutes

z->x
x->a
a->z
b->x

*/
class Solution {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> firstToSecondMap = new HashMap<>();
        Map<Character, Set<Character>> secondToFirstMap = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                char c = word.charAt(j);
                if (!firstToSecondMap.containsKey(c)) {
                    firstToSecondMap.put(c, new HashSet<>());
                }
                if (!secondToFirstMap.containsKey(c)) {
                    secondToFirstMap.put(c, new HashSet<>());
                }
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String firstWord = words[i];
            String secondWord = words[i + 1];

            boolean comparing = true;
            for (int j = 0; j < Math.max(firstWord.length(), secondWord.length()); j++) {
                char firstChar = j < firstWord.length() ? firstWord.charAt(j) : 0;
                char secondChar = j < secondWord.length() ? secondWord.charAt(j) : 0;

                if (firstChar == secondChar) {
                    continue;
                } else if (comparing && firstChar != 0 && secondChar == 0) {
                    return "";
                } else if (comparing && firstChar != 0) {
                    if (secondToFirstMap.get(firstChar).contains(secondChar)) {
                        return "";
                    } else {
                        firstToSecondMap.get(firstChar).add(secondChar);
                        secondToFirstMap.get(secondChar).add(firstChar);
                        comparing = false;
                    }
                }
            }
        }

        StringBuilder dict = new StringBuilder();
        
        Set<Character> roots = new HashSet<>();
        for (char second : secondToFirstMap.keySet()) {
            if (secondToFirstMap.get(second).isEmpty()) {
                roots.add(second);
            }
        }

        System.out.println("firstToSecondMap=" + firstToSecondMap);
        System.out.println("secondToFirstMap=" + secondToFirstMap);
        System.out.println("roots=" + roots);

        for (char root : roots) {
            Queue<Character> bfsQueue = new LinkedList<>();
            bfsQueue.add(root);
            secondToFirstMap.remove(root);

            while (!bfsQueue.isEmpty()) {
                char curr = bfsQueue.poll();

                dict.append(curr);
                
                for (char second : firstToSecondMap.get(curr)) {
                    secondToFirstMap.get(second).remove(curr);
                    if (secondToFirstMap.get(second).isEmpty()) {
                        bfsQueue.add(second);
                    }
                }
            }
        }

        if (dict.length() == firstToSecondMap.size()) {
            return dict.toString();
        } else {
            return "";
        }
    }
}