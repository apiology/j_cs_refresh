package cc.broz.j_cs_refresh;

import junit.framework.TestCase;
import java.util.ArrayList;
import java.util.List;

class ArrayBinaryTree<T> {
    List<T> arr;

    private static int left(int idx) {
        return 2*idx + 1;
    }

    private static int right(int idx) {
        return 2*idx + 2;
    }

    private void set(int idx, T item) {
        if (idx < this.arr.size()) {
            this.arr.set(idx, item);
        } else {
            for (int i = arr.size(); i < idx; i++) {
                this.arr.add(i, null);
            }
            this.arr.add(idx, item);
        }
    }

    private static int ROOT_INDEX = 0;

    public class Cursor {
        private int idx;
        
        Cursor(int idx) {
            this.idx = idx;
        }

        public T getValue() {
            return arr.get(idx);
        }

        public Cursor replaceLeft(T value) {
            set(left(idx), value);
            return getLeft();
        }

        public Cursor replaceRight(T value) {
            set(right(idx), value);
            return getRight();
        }

        public Cursor getLeft() {
            return new Cursor(left(idx));
        }

        public Cursor getRight() {
            return new Cursor(right(idx));
        }
    }
    
    public ArrayBinaryTree(T root) {
        arr = new ArrayList<T>();
        set(ROOT_INDEX, root);
    }

    public Cursor getRoot() {
        return new Cursor(ROOT_INDEX);
    }
}

public class ArrayBinaryTreeTest extends TestCase {
    public void testBinaryTreeRootRightRightValueSet() {
        ArrayBinaryTree<String> abt = new ArrayBinaryTree<>("root");
        abt.getRoot().replaceLeft("left");
        abt.getRoot().replaceRight("right").replaceRight("rightright");
        
        assertEquals(abt.getRoot().getValue(), "root");
        assertEquals("root", abt.getRoot().getValue());
        assertEquals("left", abt.getRoot().getLeft().getValue());
        assertEquals("right", abt.getRoot().getRight().getValue());
        assertEquals("rightright", abt.getRoot().getRight().getRight().getValue());
    }
}
