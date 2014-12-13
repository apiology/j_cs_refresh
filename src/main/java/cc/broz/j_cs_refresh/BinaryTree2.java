package cc.broz.j_cs_refresh;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;
import cc.broz.j_cs_refresh.binarytree.inorder.InOrderTraverseInstruction;
import cc.broz.j_cs_refresh.binarytree.postorder.PostOrderTraverseInstruction;
import cc.broz.j_cs_refresh.binarytree.Instruction;

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
    public T getPayload() {
        return this.value;
    }

    @Override
    public IBinaryTree<T> getRight() {
        return this.right;
    }

    @Override
    public IBinaryTree<T> getLeft() {
        return this.left;
    }


    @Override
    public void dfsPreOrder(Collection<T> coll) {
        coll.add(this.value);
        if (left != null) left.dfsPreOrder(coll);
        if (right != null) right.dfsPreOrder(coll);
    }

    @Override
    public void dfsPreOrderIterative(Collection<T> coll) {
        Deque<IBinaryTree<T>> work = new ArrayDeque<>();
        work.push(this);
        while (!work.isEmpty()) {
            IBinaryTree<T> item = work.pop();
            coll.add(item.getPayload());
            if (item.getRight() != null) {
                work.push(item.getRight());
            }
            if (item.getLeft() != null) {
                work.push(item.getLeft());
            }
        }
    }

    @Override
    public void dfsInOrder(Collection<T> coll) {
        if (left != null) left.dfsInOrder(coll);
        coll.add(this.value);
        if (right != null) right.dfsInOrder(coll);
    }

    @Override
    public void dfsInOrderIterative(Collection<T> coll) {
        new DfsInOrderIterative<T>(this).populate(coll);
    }

    @Override
    public void dfsInOrderIterative2(Collection<T> coll) {
        Deque<Instruction<T>> work = new ArrayDeque<>();
        work.add(new InOrderTraverseInstruction<T>(this));
        while (!work.isEmpty()) {
            Instruction<T> instruction = work.pop();
            instruction.process(coll, work);
        }
    }

    @Override
    public void dfsPostOrder(Collection<T> coll) {
        if (left != null) left.dfsPostOrder(coll);
        if (right != null) right.dfsPostOrder(coll);
        coll.add(this.value);
    }

    @Override
    public void dfsPostOrderIterative(Collection<T> coll) {
        Deque<Instruction<T>> work = new ArrayDeque<>();
        work.push(new PostOrderTraverseInstruction<T>(this));
        while (!work.isEmpty()) {
            work.pop().process(coll, work);
        }
    }

    @Override
    public void bfs(Collection<T> coll) {
        throw new IllegalStateException("Not implemented");
    }

}
