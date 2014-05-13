package cc.broz.j_cs_refresh;

import java.util.Collection;
import java.util.Queue;
import java.util.ArrayDeque;

public class BinaryTree<T> {
    public T item;
    public BinaryTree left;
    public BinaryTree right;

    public BinaryTree(BinaryTree left,
                      T item,
                      BinaryTree right) {
        this.left = left;
        this.item = item;
        this.right = right;
    }

    /**
     * Appends the items of this tree in a pre-order traversal.
     */
    public void dfsPreOrder(Collection<T> coll) {
        coll.add(item);
        if (left != null) {
            left.dfsPreOrder(coll);
        }
        if (right != null) {
            right.dfsPreOrder(coll);
        }
    }

    public void dfsInOrder(Collection<T> coll) {
        if (left != null) {
            left.dfsInOrder(coll);
        }
        coll.add(item);
        if (right != null) {
            right.dfsInOrder(coll);
        }
    }

    public void dfsPostOrder(Collection<T> coll) {
        if (left != null) {
            left.dfsPostOrder(coll);
        }
        if (right != null) {
            right.dfsPostOrder(coll);
        }
        coll.add(item);
    }

    public void bfs(Collection<T> coll) {
        Queue<BinaryTree<T>> q = new ArrayDeque<BinaryTree<T>>();
        q.add(this);
        while (!q.isEmpty()) {
            BinaryTree<T> tree = q.remove();
            coll.add(tree.item);
            if (tree.left != null) {
                q.add(tree.left);
            }
            if (tree.right != null) {
                q.add(tree.right);
            }
        }
    }
}
