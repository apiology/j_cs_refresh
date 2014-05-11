package cc.broz.j_cs_refresh;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class InsertionSortTest
    extends SortTester
{

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public InsertionSortTest(String testName)
    {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite(InsertionSortTest.class);
    }

    public Sorter getSorter() {
        return new InsertionSort();
    }
}
