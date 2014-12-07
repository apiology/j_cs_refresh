package cc.broz.j_cs_refresh;

import java.util.Collection;
import java.util.Queue;
import java.util.Stack;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.ArrayList;

public class BinaryTree<T> implements IBinaryTree<T> {
    public T item;
    public BinaryTree<T> left;
    public BinaryTree<T> right;

    public BinaryTree(BinaryTree<T> left,
                      T item,
                      BinaryTree<T> right) {
        this.left = left;
        this.item = item;
        this.right = right;
    }

    /**
     * Appends the items of this tree in a pre-order traversal.
     */
    @Override
    public void dfsPreOrder(Collection<T> coll) {
        coll.add(item);
        if (left != null) {
            left.dfsPreOrder(coll);
        }
        if (right != null) {
            right.dfsPreOrder(coll);
        }
    }

    @Override
    public void dfsPreOrderIterative(Collection<T> coll) {
        Deque<BinaryTree<T>> stack = new ArrayDeque<BinaryTree<T>>();
        stack.push(this);
        while (stack.peek() != null) {
            BinaryTree<T> tree = stack.pop();
            coll.add(tree.item);
            if (tree.right != null) {
                stack.push(tree.right);
            }
            if (tree.left != null) {
                stack.push(tree.left);
            }
        }
    }

    @Override
    public void dfsInOrder(Collection<T> coll) {
        if (left != null) {
            left.dfsInOrder(coll);
        }
        coll.add(item);
        if (right != null) {
            right.dfsInOrder(coll);
        }
    }

    private static class BinaryTreeTraversalState<S> {
        public S tree;
        public boolean visitedLeft;
        public boolean addedItem;
        public boolean visitedRight;
        public BinaryTreeTraversalState(S tree) {
            this.tree = tree;
            this.visitedLeft = false;
            this.visitedRight = false;
            this.addedItem = false;
        }
    }

    @Override
    public void dfsInOrderIterative(Collection<T> coll) {
        Deque<BinaryTreeTraversalState<BinaryTree<T>>> stack =
            new ArrayDeque<BinaryTreeTraversalState<BinaryTree<T>>>();
        stack.push(new BinaryTreeTraversalState<BinaryTree<T>>(this));
        while (stack.peek() != null) {
            BinaryTreeTraversalState<BinaryTree<T>> btts = stack.pop();
            if (btts.visitedLeft && btts.addedItem) {
                if (btts.tree.right != null) {
                    stack.push(new
                               BinaryTreeTraversalState<BinaryTree<T>>(btts.tree.right));
                }
            } else if (btts.visitedLeft) {
                btts.addedItem = true;
                stack.push(btts);
                coll.add(btts.tree.item);
            } else {
                btts.visitedLeft = true;
                stack.push(btts);
                if (btts.tree.left != null) {
                    stack.push(new
                       BinaryTreeTraversalState<BinaryTree<T>>(btts.tree.left));
                }
            }
        }
    }

    @Override
    public void dfsPostOrder(Collection<T> coll) {
        if (left != null) {
            left.dfsPostOrder(coll);
        }
        if (right != null) {
            right.dfsPostOrder(coll);
        }
        coll.add(item);
    }

    @Override
    public void dfsPostOrderIterative(Collection<T> coll) {
        Deque<BinaryTreeTraversalState<BinaryTree<T>>> stack =
            new ArrayDeque<BinaryTreeTraversalState<BinaryTree<T>>>();
        stack.push(new BinaryTreeTraversalState<BinaryTree<T>>(this));
        while (stack.peek() != null) {
            BinaryTreeTraversalState<BinaryTree<T>> btts = stack.pop();
            if (btts.visitedLeft && btts.visitedRight) {
                coll.add(btts.tree.item);
            } else if (btts.visitedLeft) {
                btts.visitedRight = true;
                stack.push(btts);
                if (btts.tree.right != null) {
                    stack.push(new
                               BinaryTreeTraversalState<BinaryTree<T>>(btts.tree.right));
                }
            } else {
                btts.visitedLeft = true;
                stack.push(btts);
                if (btts.tree.left != null) {
                    stack.push(new
                       BinaryTreeTraversalState<BinaryTree<T>>(btts.tree.left));
                }
            }
        }
    }

    @Override
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
