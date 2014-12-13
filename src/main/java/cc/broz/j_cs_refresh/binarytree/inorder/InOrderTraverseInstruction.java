package cc.broz.j_cs_refresh.binarytree.inorder;

import java.util.Deque;
import java.util.Collection;

import cc.broz.j_cs_refresh.binarytree.Instruction;
import cc.broz.j_cs_refresh.binarytree.AddInstruction;
import cc.broz.j_cs_refresh.IBinaryTree;


public class InOrderTraverseInstruction<T> implements Instruction<T> {
    IBinaryTree<T> tree;

    public InOrderTraverseInstruction(IBinaryTree<T> tree) {
        this.tree = tree;
    }

    @Override
    public void process(Collection<T> coll,
                        Deque<Instruction<T>> work) {
        if (tree.getRight() != null) {
            work.push(new InOrderTraverseInstruction<T>(tree.getRight()));
        }
        work.push(new AddInstruction<T>(tree.getPayload()));
        if (tree.getLeft() != null) {
            work.push(new InOrderTraverseInstruction<T>(tree.getLeft()));
        }
    }
}
