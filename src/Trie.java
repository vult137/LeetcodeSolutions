// 208. Implement Trie (Prefix Tree)
public class Trie {

    class TrieNode {
        private TrieNode[] links;
        private static final int R = 26;
        private boolean isEnd;

        public TrieNode() {
            this.links = new TrieNode[R];
            this.isEnd = false;
        }

        public boolean containsKey(char c) {
            return links[c - 'a'] != null;
        }

        public TrieNode get(char c) {
            return links[c - 'a'];
        }

        public void put(TrieNode node, char c) {
            links[c - 'a'] = node;
        }

        public void setEnd() {
            isEnd = true;
        }

        public boolean isEnd() {
            return isEnd;
        }
    }

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!node.containsKey(c))
                node.put(new TrieNode(), c);
            node = node.get(c);
        }
        node.setEnd();
    }

    public TrieNode searchPrefix(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (node.containsKey(c))
                node = node.get(c);
            else
                return null;
        }
        return node;
    }


    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node!= null;
    }
}
