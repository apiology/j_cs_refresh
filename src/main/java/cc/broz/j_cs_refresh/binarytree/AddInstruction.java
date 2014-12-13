package cc.broz.j_cs_refresh.binarytree;

import java.util.Collection;

import java.util.Deque;

import cc.broz.j_cs_refresh.IBinaryTree;

public class AddInstruction<T> implements Instruction<T> {
    T item;

    public AddInstruction(T item) {
        this.item = item;
    }

    @Override
    public void process(Collection<T> coll,
                        Deque<Instruction<T>> work) {
        coll.add(item);
    }
}
