package cc.broz.j_cs_refresh.binarytree.postorder;

import cc.broz.j_cs_refresh.binarytree.Instruction;
import cc.broz.j_cs_refresh.IBinaryTree;
import java.util.Collection;
import java.util.Deque;
import cc.broz.j_cs_refresh.binarytree.AddInstruction;

public class PostOrderTraverseInstruction<T> implements Instruction<T> {
    IBinaryTree<T> tree;
    
    public PostOrderTraverseInstruction(IBinaryTree<T> tree) {
        this.tree = tree;
    }

    @Override
    public void process(Collection<T> coll,
                        Deque<Instruction<T>> work) {
        work.push(new AddInstruction<T>(tree.getPayload()));
        if (tree.getRight() != null) {
            work.push(new PostOrderTraverseInstruction<T>(tree.getRight()));
        }
        if (tree.getLeft() != null) {
            work.push(new PostOrderTraverseInstruction<T>(tree.getLeft()));
        }        
    }
}
