class WordDictionary {

    private class TrieNode{
        TrieNode[] children;
        boolean isEndOfWord;

        public TrieNode(){
            children = new TrieNode[26];
            isEndOfWord = false;
        }
    }
    private TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            int idx = ch - 'a';
            if(curr.children[idx] == null){
                curr.children[idx] = new TrieNode();
            }
            curr = curr.children[idx];
        }
        curr.isEndOfWord = true;
    }

    public boolean search(String word) {
        return searchInNode(word, 0, root);
    }

    private boolean searchInNode(String word, int index, TrieNode curr){
        if(index == word.length()){
            return curr.isEndOfWord;
        }
        char ch = word.charAt(index);

        if(ch == '.'){
            for(int i = 0; i < 26; i++){
                if(curr.children[i] != null){
                    if(searchInNode(word, index+1, curr.children[i])){
                        return true;
                    }
                }
            }
            return false;
        }else{
            int childIndex = ch - 'a';
            if(curr.children[childIndex] == null){
                return false;
            }
            return searchInNode(word, index+1, curr.children[childIndex]);
        }
    }
}
