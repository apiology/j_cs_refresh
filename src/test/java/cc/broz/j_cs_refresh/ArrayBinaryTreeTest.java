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

    public Cursor getRootCursor() {
        return new Cursor(ROOT_INDEX);
    }
}

public class ArrayBinaryTreeTest extends TestCase {
    public void testBinaryTreeInitializes() {
        ArrayBinaryTree<String> abt = new ArrayBinaryTree<>("root");
    }
    
    public void testBinaryTreeRootValueSet() {
        ArrayBinaryTree<String> abt = new ArrayBinaryTree<>("root");
        ArrayBinaryTree<String>.Cursor cursor = abt.getRootCursor();
        assertEquals(cursor.getValue(), "root");
    }

    public void testBinaryTreeRootLeftValueSet() {
        ArrayBinaryTree<String> abt = new ArrayBinaryTree<>("root");
        ArrayBinaryTree<String>.Cursor root = abt.getRootCursor();
        assertEquals(root.getValue(), "root");
        ArrayBinaryTree<String>.Cursor rootLeft = root.replaceLeft("left");
        assertEquals("root", abt.getRootCursor().getValue());
        assertEquals("left", abt.getRootCursor().getLeft().getValue());
    }

    public void testBinaryTreeRootRightValueSet() {
        ArrayBinaryTree<String> abt = new ArrayBinaryTree<>("root");
        ArrayBinaryTree<String>.Cursor root = abt.getRootCursor();
        assertEquals(root.getValue(), "root");
        ArrayBinaryTree<String>.Cursor rootLeft = root.replaceLeft("left");
        ArrayBinaryTree<String>.Cursor rootRight = root.replaceRight("right");
        assertEquals("root", abt.getRootCursor().getValue());
        assertEquals("left", abt.getRootCursor().getLeft().getValue());
        assertEquals("right", abt.getRootCursor().getRight().getValue());
    }


    public void testBinaryTreeRootRightRightValueSet() {
        ArrayBinaryTree<String> abt = new ArrayBinaryTree<>("root");
        ArrayBinaryTree<String>.Cursor root = abt.getRootCursor();
        assertEquals(root.getValue(), "root");
        ArrayBinaryTree<String>.Cursor rootLeft = root.replaceLeft("left");
        ArrayBinaryTree<String>.Cursor rootRight = root.replaceRight("right");
        ArrayBinaryTree<String>.Cursor rootRightRight = rootRight.replaceRight("rightright");
        assertEquals("root", abt.getRootCursor().getValue());
        assertEquals("left", abt.getRootCursor().getLeft().getValue());
        assertEquals("right", abt.getRootCursor().getRight().getValue());
        assertEquals("rightright", abt.getRootCursor().getRight().getRight().getValue());
    }

    
     // void testBinaryTreeAsArray() {
     //     ArrayBinaryTree<String> abt = new ArrayBinaryTree<>("root");
     //     Cursor<String> cursor = abt.getRootCursor();
     //     cursor.addLeft("left");
     //     cursor.addRight("right");
         
     // }
}
