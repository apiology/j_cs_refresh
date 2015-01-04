package cc.broz.j_cs_refresh;

import java.util.AbstractMap;

import java.util.Set;

import java.util.Map;
import java.util.ArrayList;
import java.util.Collections;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.HashSet;

public class VinceHashMap<K,V> extends AbstractMap<K,V> {
    private int size;
    private ArrayList<ArrayList<Map.Entry<K,V>>> chains;

    public VinceHashMap() {
        this.size = 127;
        this.chains =
            new ArrayList<ArrayList<Map.Entry<K,V>>>(Collections.nCopies(this.size, null));
    }

    // private V singleValue;
    // separate chaining

    public int getHash(K k) {
        int hash = k.hashCode() % this.size;
        assert(hash < this.size);
        return hash;
    }

    private ArrayList<Map.Entry<K,V>> getChain(int hash) {
        ArrayList<Map.Entry<K,V>> chain = chains.get(hash);
        if (chain == null) {
            chain = new ArrayList<Map.Entry<K,V>>(1);
            chains.set(hash, chain);
        } else {
            debug("Found chain under hash ", hash, " of ", chain);
        }
        return chain;
    }

    private Map.Entry<K,V> findEntryInChain(K k, ArrayList<Map.Entry<K,V>> chain) {
        for (Map.Entry<K,V> entry : chain) {
            if (entry.getKey().equals(k)) {
                return entry;
            }
        }
        return null;
    }

    @Override
    public V put(K k, V v) {
        int hash = getHash(k);
        debug("hash of ", k, " is ", hash);
        ArrayList<Map.Entry<K,V>> chain = getChain(hash);
        debug("chain to insert into is ", chain);
        Map.Entry<K,V> entry = findEntryInChain(k, chain);
        debug("existing entry found is ", entry);
        if (entry != null) {
            entry.setValue(v);
        } else {
            entry = new AbstractMap.SimpleEntry<K,V>(k, v);
            chain.add(entry);
            debug("chain after adding entry is ", chain);
        }
        return v;
    }

    @Override
    public Set<Map.Entry<K,V>> entrySet() {
        // this is cheating, but the real implementation of this would
        // be gigantic--see the JDK HashMap.java iterator alone for an
        // example.

        // a slightly less cheaty version of this would create a hash
        // table class that doesn't implement this interface, and the
        // implemention would maintain both the entry-to-entry hash
        // table and the key-to-value hash table
        HashSet<Map.Entry<K,V>> s = new HashSet<>();
        for (ArrayList<Map.Entry<K,V>> chain : chains) {
            if (chain != null) {
                for (Map.Entry<K,V> entry : chain) {
                    s.add(entry);
                }
            }
        }
        return s;
    }
    
    public void debug(Object... args) {
        if (false) {
            for (Object o : args) {
                System.out.print(String.valueOf(o));
            }
            System.out.println();
        }
    }

    @Override
    public V get(Object keyObject) {
        debug("calling get - chains is ", this.chains);
        K k = (K) keyObject;
        int hash = getHash(k);
        debug("hash of ", keyObject, " is ", hash);
        ArrayList<Map.Entry<K,V>> chain = getChain(hash);
        debug("chain is ", chain);
        Map.Entry<K,V> entry = findEntryInChain(k, chain);
        debug("entry is ", entry);
        if (entry == null) {
            return null;
        } else {
            return entry.getValue();
        }
    }

    @Override
    public V remove(Object keyObject) {
        K k = (K) keyObject;
        int hash = getHash(k);
        ArrayList<Map.Entry<K,V>> chain = getChain(hash);
        Map.Entry<K,V> entry = findEntryInChain(k, chain);
        if (entry == null) {
            return null;
        } else {
            chain.remove(entry);
            return entry.getValue();
        }
    }
}
