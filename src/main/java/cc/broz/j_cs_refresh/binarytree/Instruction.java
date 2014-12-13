package cc.broz.j_cs_refresh.binarytree;

import java.util.Collection;
import java.util.Deque;

import cc.broz.j_cs_refresh.IBinaryTree;

public interface Instruction<T> {
    abstract public void process(Collection<T> coll,
                                 Deque<Instruction<T>> work);
}
