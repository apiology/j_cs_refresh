package cc.broz.j_cs_refresh;

import junit.framework.TestCase;

public class LinkedListTest extends TestCase {
    public void testLinkedList() {
        LLNode<String> list =
            node("a",
                 node("b",
                      node("c",
                           node("d",
                                null))));
        assertEquals("abcd", append(list));
    }

    public String append(LLNode<String> list) {
        String s = "";
        while (list != null) {
            s = s + list.getContent();
            list = list.getNext();
        }
        return s;
    }

    public LLNode<String> node(String s,
                               LLNode<String> next) {
        return new LLNode<String>(s, next);
    }
}
