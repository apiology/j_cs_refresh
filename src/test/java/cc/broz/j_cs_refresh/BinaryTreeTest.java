package cc.broz.j_cs_refresh;

import cc.broz.j_cs_refresh.BinaryTree;
import junit.framework.TestCase;
import java.util.ArrayList;
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

    public void testDFSPreorder() {
        ArrayList<Integer> al = new ArrayList(4);
        sampleTree.dfsPreOrder(al);
        assertEquals(intsToArrayList(5, 1, 2, 1),
                     al);
    }

    public void testDFSPInorder() {
        ArrayList<Integer> al = new ArrayList(4);
        sampleTree.dfsInOrder(al);
        assertEquals(intsToArrayList(1, 5, 2, 1),
                     al);
    }

    public void testDFSPostorder() {
        ArrayList<Integer> al = new ArrayList(4);
        sampleTree.dfsPostOrder(al);
        assertEquals(intsToArrayList(1, 1, 2, 5),
                     al);
    }

    public void testBFS() {
        ArrayList<Integer> al = new ArrayList(4);
        sampleTree.bfs(al);
        assertEquals(intsToArrayList(5, 1, 2, 1),
                     al);
    }
}
