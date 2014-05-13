package cc.broz.j_cs_refresh;

import cc.broz.j_cs_refresh.BinaryTree;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.function.Consumer;

import static cc.broz.j_cs_refresh.TestUtils.intsToArrayList;

public class BinaryTreeTest
    extends TestCase
{
    BinaryTree sampleTree;

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public BinaryTreeTest(String testName)
    {
        super(testName);
        this.sampleTree =
            new BinaryTree<Integer>(new BinaryTree<Integer>(null,
                                                            1,
                                                            null),
                                    5,
                                    new BinaryTree<Integer>(null,
                                                            2,
                                                            new BinaryTree<Integer>(null,
                                                                                    1,
                                                                                    null)));
    }

    public void traverse(Consumer<ArrayList<Integer>> consumer,
                         ArrayList<Integer> expected) {
        ArrayList<Integer> al = new ArrayList<Integer>(4);
        consumer.accept(al);
        assertEquals(expected,
                     al);
    }

    public void testDFSPreorder() {
        traverse(sampleTree::dfsPreOrder,
                 intsToArrayList(5, 1, 2, 1));
    }

    public void testDFSPInorder() {
        traverse(sampleTree::dfsInOrder,
                 intsToArrayList(1, 5, 2, 1));
    }

    public void testDFSPostorder() {
        traverse(sampleTree::dfsPostOrder,
                 intsToArrayList(1, 1, 2, 5));
    }

    public void testBFS() {
        traverse(sampleTree::bfs,
                 intsToArrayList(5, 1, 2, 1));
    }
}
