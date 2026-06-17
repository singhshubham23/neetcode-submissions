class PrefixTree {
    
    
    private class TrieNode {
        private TrieNode[] children;
        private boolean isEndOfWord;

        public TrieNode() {
            this.children = new TrieNode[26]; 
            this.isEndOfWord = false;
        }
    }

    private TrieNode root;

    public PrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a'; 
            
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode node = traverseTo(word);
        return node != null && node.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        return traverseTo(prefix) != null;
    }

    private TrieNode traverseTo(String str) {
        TrieNode current = root;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int index = ch - 'a';
            
            if (current.children[index] == null) {
                return null; 
            }
            current = current.children[index];
        }
        return current;
    }
}