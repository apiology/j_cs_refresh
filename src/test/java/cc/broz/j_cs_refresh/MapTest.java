package cc.broz.j_cs_refresh;

import java.util.Map;

import junit.framework.TestCase;
import java.util.Set;
import java.util.Collection;

public class MapTest extends TestCase {
    Map<Integer, String> intToStringMap;
    
    public MapTest() { }

    @Override
    public void setUp() {
        this.intToStringMap = new VinceHashMap<Integer, String>();
        this.intToStringMap.put(1, "one");
        this.intToStringMap.put(2, "two");
        this.intToStringMap.put(3, "three");
    }

    public void testConstructor() {
        assertNotNull(this.intToStringMap);
    }

    public void testBasicGet() {
        assertEquals("one", this.intToStringMap.get(1));
        assertEquals("two", this.intToStringMap.get(2));
        assertEquals("three", this.intToStringMap.get(3));
    }

    public void testEntrySet() {
        Set<Map.Entry<Integer, String>> entrySet = this.intToStringMap.entrySet();
        assertNotNull(entrySet);
        assertEquals(3, entrySet.size());
    }

    public void testKeySet() {
        Set<Integer> keySet = this.intToStringMap.keySet();
        assertEquals(keySet.size(), 3);
        assertTrue(keySet.contains(1));
        assertTrue(keySet.contains(2));
        assertTrue(keySet.contains(3));
    }

    public void testValueSet() {
        Collection<String> valueSet = this.intToStringMap.values();
        assertEquals(valueSet.size(), 3);
        assertTrue(valueSet.contains("one"));
        assertTrue(valueSet.contains("two"));
        assertTrue(valueSet.contains("three"));
    }

    public void testRemove() {
        assertEquals(3, this.intToStringMap.size());
        this.intToStringMap.remove(4);
        assertEquals(3, this.intToStringMap.size());
        this.intToStringMap.remove(3);
        assertEquals(2, this.intToStringMap.size());
    }
}
