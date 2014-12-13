package cc.broz.j_cs_refresh;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;


public class DfsInOrderIterative<T> {
    Deque<IBinaryTree<T>> toVisit;
    Deque<IBinaryTree<T>> toAddCurrAndVisitRight;
    
    public DfsInOrderIterative(IBinaryTree<T> top) {
        this.toVisit = new ArrayDeque<>();
        this.toAddCurrAndVisitRight = new ArrayDeque<>();
        this.toVisit.push(top);
    }

    public void populate(Collection<T> added) {
        while (!this.toVisit.isEmpty() ||
               !this.toAddCurrAndVisitRight.isEmpty()) {
            visitAllLeftNodes();
            addOneAndVisitRight(added);
        }
    }

    private void visitAllLeftNodes() {
        while (!this.toVisit.isEmpty()) {
            IBinaryTree<T> node = this.toVisit.pop();
            if (node.getLeft() != null) {
                this.toVisit.push(node.getLeft());
            }
            this.toAddCurrAndVisitRight.push(node);
        }
    }

    private void addOneAndVisitRight(Collection<T> added) {
        if (!this.toAddCurrAndVisitRight.isEmpty()) {
            IBinaryTree<T> item = this.toAddCurrAndVisitRight.pop();
            added.add(item.getPayload());
            if (item.getRight() != null) {
                this.toVisit.push(item.getRight());
            }
        }
    }
}
