package cc.broz.j_cs_refresh;

import java.util.Collection;

public interface IBinaryTree<T> {
    public IBinaryTree<T> getLeft();
    public IBinaryTree<T> getRight();
    public T getPayload();
    
    public void dfsPreOrder(Collection<T> coll);
    public void dfsPreOrderIterative(Collection<T> coll);
    public void dfsInOrder(Collection<T> coll);
    public void dfsInOrderIterative(Collection<T> coll);
    public void dfsInOrderIterative2(Collection<T> coll);
    public void dfsPostOrder(Collection<T> coll);
    public void dfsPostOrderIterative(Collection<T> coll);
    public void bfs(Collection<T> coll);
}
