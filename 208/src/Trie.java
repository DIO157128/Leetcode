class Node {
    Node[] children;
    boolean isEnd;

    public Node() {
        children = new Node[26];
        isEnd = false;
    }
}

class Trie {
    private Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node ptr = root;
        int n = word.length();
        for (int i = 0; i < n; i++) {
            int id = word.charAt(i) - 'a';
            if (ptr.children[id] == null) {
                ptr.children[id] = new Node();
            }
            ptr = ptr.children[id];
        }
        ptr.isEnd = true;
    }

    private Node searchPrefix(String word) {
        Node ptr = root;
        int n = word.length();
        for (int i = 0; i < n; i++) {
            int id = word.charAt(i) - 'a';
            ptr = ptr.children[id];
            if (ptr == null) {
                return null;
            }
        }
        return ptr;
    }

    public boolean search(String word) {
        Node res = searchPrefix(word);
        if (res == null) {
            return false;
        } else {
            return res.isEnd;
        }
    }

    public boolean startsWith(String prefix) {

        return searchPrefix(prefix) != null;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.search("apple");
        trie.search("app");
        trie.startsWith("app");
        trie.insert("app");
        trie.search("app");
    }
}