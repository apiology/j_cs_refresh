package cc.broz.j_cs_refresh;

import junit.framework.Test;
import junit.framework.TestSuite;

public class VinceHeapSort2Test
    extends SortTester
{

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public VinceHeapSort2Test(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(VinceHeapSort2Test.class);
    }

    public Sorter getSorter() {
        return new HeapSort(new VinceMinHeap2Factory());
    }
}
