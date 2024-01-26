/*

if word a comes before word b, either

a and b are equal
a prefixes b
a and b mismatch at some index i... then a[i] < b[i]

wrt, wrf, er, ett, rftt

t->f
r->t
w->e
e->r

find all dependencies
see if there is a cycle

*/
class Solution {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> charDependedBy = new HashMap<>();
        Map<Character, Set<Character>> charDependents = new HashMap<>();

        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);

                if (!charDependedBy.containsKey(c)) {
                    charDependedBy.put(c, new HashSet<>());
                }

                if (!charDependents.containsKey(c)) {
                    charDependents.put(c, new HashSet<>());
                }
            }
        }

        for (int i = 0; i + 1 < words.length; i++) {
            WordOrder wordOrder = compare(words[i], words[i + 1]);

            //System.out.println("word1=" + words[i] + ", word2=" + words[i + 1] + ", wordOrder.before=" + wordOrder.before + ", wordOrder.after=" + wordOrder.after);
            
            if (!wordOrder.valid) {
                return "";
            } else if (wordOrder.before == wordOrder.after) {
                continue;
            }

            charDependedBy.get(wordOrder.before).add(wordOrder.after);
            charDependents.get(wordOrder.after).add(wordOrder.before);
        }

        StringBuilder dict = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();
        Set<Character> visited = new HashSet<>();

        for (char c : charDependents.keySet()) {
            if (charDependents.get(c).isEmpty()) {
                queue.add(c);
                visited.add(c);
                dict.append(c);
            }
        }

        System.out.println("charDependedBy=" + charDependedBy);
        System.out.println("charDependents=" + charDependents);
        System.out.println("dict=" + dict);

        while (!queue.isEmpty()) {
            char c = queue.poll();
            for (char dependedBy : charDependedBy.get(c)) {
                charDependents.get(dependedBy).remove(c);

                if (!visited.contains(dependedBy) && charDependents.get(dependedBy).isEmpty()) {
                    queue.add(dependedBy);
                    visited.add(dependedBy);
                    dict.append(dependedBy);
                    //System.out.println("append c=" + c);
                }
            }
        }

        if (visited.size() != charDependedBy.size()) {
            return "";
        }

        return dict.toString();
    }

    public WordOrder compare(String wordA, String wordB) {
        WordOrder wordOrder = new WordOrder();

        int minLength = Math.min(wordA.length(), wordB.length());

        for (int i = 0; i < minLength; i++) {
            char charA = wordA.charAt(i);
            char charB = wordB.charAt(i);

            if (charA != charB) {
                wordOrder.valid = true;
                wordOrder.before = charA;
                wordOrder.after = charB;
                return wordOrder;
            }
        }

        if (wordA.length() > wordB.length()) {
            return wordOrder;
        }

        wordOrder.valid = true;
        return wordOrder;
    }

    private static class WordOrder {
        boolean valid;
        char before;
        char after;
    }
}