package cc.broz.j_cs_refresh;

import junit.framework.TestCase;

class ArrayBinaryTree<T> {
    private T root;
    private T leftValue;
    private T rightValue;
    
    public class Cursor {
        T value;

        Cursor(T value) {
            this.value = value;
        }

        public T getValue() {
            return this.value;
        }

        public Cursor replaceLeft(T value) {
            leftValue = value;
            return getLeft();
        }

        public Cursor replaceRight(T value) {
            rightValue = value;
            return getRight();
        }

        public Cursor getLeft() {
            return new Cursor(leftValue);
        }

        public Cursor getRight() {
            return new Cursor(rightValue);
        }
    }
    
    public ArrayBinaryTree(T root) {
        this.root = root;
    }

    public Cursor getRootCursor() {
        return new Cursor(root);
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
