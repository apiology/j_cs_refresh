package cc.broz.j_cs_refresh;

import java.util.Collection;

public class BinaryTree2<T> implements IBinaryTree<T> {
    private BinaryTree2<T> left;
    private T value;
    private BinaryTree2<T> right;

    public BinaryTree2(BinaryTree2<T> left,
                       T value,
                       BinaryTree2<T> right) {
        this.left = left;
        this.value = value;
        this.right = right;
    }

    @Override
    public void dfsPreOrder(Collection<T> coll) {
        coll.add(this.value);
        if (left != null) left.dfsPreOrder(coll);
        if (right != null) right.dfsPreOrder(coll);
    }

    @Override
    public void dfsPreOrderIterative(Collection<T> coll) {
        throw new IllegalStateException("Not implemented");
    }

    @Override
    public void dfsInOrder(Collection<T> coll) {
        if (left != null) left.dfsInOrder(coll);
        coll.add(this.value);
        if (right != null) right.dfsInOrder(coll);
    }

    @Override
    public void dfsInOrderIterative(Collection<T> coll) {
        throw new IllegalStateException("Not implemented");
    }


    @Override
    public void dfsPostOrder(Collection<T> coll) {
        if (left != null) left.dfsPostOrder(coll);
        if (right != null) right.dfsPostOrder(coll);
        coll.add(this.value);
    }


    @Override
    public void dfsPostOrderIterative(Collection<T> coll) {
        throw new IllegalStateException("Not implemented");
    }

    @Override
    public void bfs(Collection<T> coll) {
        throw new IllegalStateException("Not implemented");
    }

}
