package cc.broz.j_cs_refresh;

import junit.framework.Test;
import junit.framework.TestSuite;

public class QuickSort2Test
    extends SortTester
{

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public QuickSort2Test(String testName)
    {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite(QuickSort2Test.class);
    }

    public Sorter getSorter() {
        return new QuickSort2();
    }
}
