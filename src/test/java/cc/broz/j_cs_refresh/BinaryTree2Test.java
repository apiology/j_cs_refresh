package cc.broz.j_cs_refresh;

import cc.broz.j_cs_refresh.BinaryTree;

import java.util.function.Consumer;
import java.util.ArrayList;

public class BinaryTree2Test extends BaseBinaryTreeTest
{
    BinaryTree<Integer> sampleTree;

    public BinaryTree2Test(String testName) {
        super(testName,
              new BinaryTree2<Integer>(new BinaryTree2<Integer>(null,
                                                                1,
                                                                null),
                                       5,
                                       new BinaryTree2<Integer>(null,
                                                                2,
                                                                new BinaryTree2<Integer>(null,
                                                                                         1,
                                                                                         null))));
    }
}
