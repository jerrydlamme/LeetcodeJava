import java.util.*;
class TrieNode {
    // Initialize your data structure here.
    Map<Character, TrieNode> map;
    boolean hasWord;
    public TrieNode() {
        this.map = new HashMap<Character, TrieNode>();
        hasWord = false;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.map.containsKey(c)) {
                node = node.map.get(c);
            } else {
                TrieNode next = new TrieNode();
                node.map.put(c, next);
                node = next;
            }
        }
        node.hasWord = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.map.containsKey(c)) {
                node = node.map.get(c);
            } else {
                return false;
            }
        }
        
        return node.hasWord;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
                TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (node.map.containsKey(c)) {
                node = node.map.get(c);
            } else {
                return false;
            }
        }
        
        return true;
    }
}
