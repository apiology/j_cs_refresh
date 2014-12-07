package cc.broz.j_cs_refresh;

import cc.broz.j_cs_refresh.BinaryTree;

import java.util.function.Consumer;
import java.util.ArrayList;

public class BinaryTreeTest extends BaseBinaryTreeTest
{
    BinaryTree<Integer> sampleTree;

    public BinaryTreeTest(String testName) {
        super(testName,
              new BinaryTree<Integer>(new BinaryTree<Integer>(null,
                                                              1,
                                                              null),
                                      5,
                                      new BinaryTree<Integer>(null,
                                                              2,
                                                              new BinaryTree<Integer>(null,
                                                                                      1,
                                                                                      null))));

    }
}
