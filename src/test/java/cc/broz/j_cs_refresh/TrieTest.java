package cc.broz.j_cs_refresh;

import java.util.HashMap;

import java.util.Map;

import junit.framework.TestCase;

class Trie<T> {
    Map<Character, Trie<T>> nodes;
    T value;

    Trie() {
        this.nodes = new HashMap<>();
    }
    
    public void add(String s, T value) {
        if (s.length() == 0) {
            this.value = value;
        } else {
            char c = s.charAt(0);
            String substr = s.substring(1);
            if (!nodes.containsKey(c)) {
                nodes.put(c, new Trie<T>());
            }
            nodes.get(c).add(substr, value);
        }
    }

    public Map<String, T> getAllKeysAndValues() {
        Map<String, T> allKeysAndValues = new HashMap<>();
        if (value != null) {
            allKeysAndValues.put("", value);
        }
        for (Map.Entry<Character, Trie<T>> node : nodes.entrySet()) {
            char c = node.getKey();
            Trie<T> t = node.getValue();
            for (Map.Entry<String, T> childKeysAndValue :
                     t.getAllKeysAndValues().entrySet()) {
                String childKey = childKeysAndValue.getKey();
                T childValue = childKeysAndValue.getValue();
                allKeysAndValues.put(c + childKey, childValue);
            }
            
        }
        return allKeysAndValues;
    }
}

public class TrieTest extends TestCase {

    private Trie<Integer> getTestTrie() {
        Trie<Integer> t = new Trie<>();
        Map<String, Integer> testKeysAndValues = getTestKeysAndValues();
        for (Map.Entry<String, Integer> entry : testKeysAndValues.entrySet()) {
            t.add(entry.getKey(), entry.getValue());
        }
        return t;
    }

    public Map<String, Integer> getTestKeysAndValues() {
        Map<String, Integer> m = new HashMap<>();
        m.put("vince", 1);
        m.put("victor", 2);
        m.put("victoria", 3);
        m.put("becca", 4);
        return m;
    }
    
    public void testEntriesByKey() {
        Trie<Integer> t = getTestTrie();

        assertEquals(getTestKeysAndValues(),
                     t.getAllKeysAndValues());
    }
}
