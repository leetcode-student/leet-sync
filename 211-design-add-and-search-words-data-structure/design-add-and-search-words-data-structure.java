class WordDictionary {
    private Tree root;

    public WordDictionary() {
        root = new Tree();
        root.children = new HashMap<>();
    }
    
    public void addWord(String word) {
        addWordToTree(root, word, 0);
    }
    
    public boolean search(String word) {
        //System.out.println("search word=" + word);
        return searchTreeForWord(root, word, 0);
    }

    public boolean searchTreeForWord(Tree tree, String word, int i) {
        if (tree == null) {
            return false;
        }

        //System.out.println("    tree.character=" + tree.character + ", tree.children=" + tree.children + ", i=" + i);

        if (i == word.length()) {
            return tree.isTerminal;
        }

        if (word.charAt(i) == '.') {
            //System.out.println("    handling .");
            for (char subChar : tree.children.keySet()) {
                if (searchTreeForWord(tree.children.get(subChar), word, i + 1)) {
                    return true;
                }
            }
            return false;
        }
        
        if (!tree.children.containsKey(word.charAt(i))) {
            //System.out.println("    not found");
            return false;
        }
        return searchTreeForWord(tree.children.get(word.charAt(i)), word, i + 1);
    }

    public void addWordToTree(Tree tree, String word, int i) {
        if (i == word.length()) {
            tree.isTerminal = true;
            return;
        }

        if (!tree.children.containsKey(word.charAt(i))) {
            Tree subTree = new Tree();
            subTree.character = word.charAt(i);
            subTree.children = new HashMap<>();

            tree.children.put(word.charAt(i), subTree);
        }
        
        addWordToTree(tree.children.get(word.charAt(i)), word, i + 1);
    }

    private static class Tree {
        private char character;
        private boolean isTerminal;
        private Map<Character, Tree> children;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */