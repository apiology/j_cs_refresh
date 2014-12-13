package cc.broz.j_cs_refresh;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Consumer;
import junit.framework.TestCase;
import static cc.broz.j_cs_refresh.TestUtils.intsToArrayList;

public abstract class BaseBinaryTreeTest extends TestCase {
    IBinaryTree<Integer> sampleTree;
    
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public BaseBinaryTreeTest(String testName, IBinaryTree<Integer> sampleTree)
    {
        super(testName);
        this.sampleTree = sampleTree;
    }

    public void testDFSPreorder() {
        traverse(sampleTree::dfsPreOrder,
                 5, 1, 2, 1);
        traverse(sampleTree::dfsPreOrderIterative,
                 5, 1, 2, 1);
    }

    public void testDFSPInorder() {
        traverse(sampleTree::dfsInOrder,
                 1, 5, 2, 1);
        traverse(sampleTree::dfsInOrderIterative,
                 1, 5, 2, 1);
        traverse(sampleTree::dfsInOrderIterative2,
                 1, 5, 2, 1);
    }

    public void testDFSPostorder() {
        traverse(sampleTree::dfsPostOrder,
                 1, 1, 2, 5);
        traverse(sampleTree::dfsPostOrderIterative,
                 1, 1, 2, 5);
    }

    public void testBFS() {
        traverse(sampleTree::bfs,
                 5, 1, 2, 1);
    }

    private void traverse(Consumer<Collection<Integer>> consumer,
                          Integer ...expected) {
        ArrayList<Integer> al = new ArrayList<Integer>(4);
        consumer.accept(al);
        assertEquals(intsToArrayList(expected),
                     al);
    }
}
