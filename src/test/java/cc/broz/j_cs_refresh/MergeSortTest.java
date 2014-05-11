package cc.broz.j_cs_refresh;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import static cc.broz.j_cs_refresh.TestUtils.intsToArrayList;
import static cc.broz.j_cs_refresh.TestUtils.stringsToArrayList;
import static cc.broz.j_cs_refresh.TestUtils.longsToArrayList;
import cc.broz.j_cs_refresh.Sorter;

/**
 * Unit test for simple App.
 */
public class MergeSortTest
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public MergeSortTest( String testName )
    {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite(MergeSortTest.class);
    }

    public void assertSortsAs(int[] expected,
                              int[] source) {
        assertEquals(intsToArrayList(expected),
                     getSorter().sort(intsToArrayList(source)));
    }

    public void assertSortsAs(long[] expected,
                              long[] source) {
        assertEquals(longsToArrayList(expected),
                     getSorter().sort(longsToArrayList(source)));
    }

    public void assertSortsAs(String[] expected,
                              String[] source) {
        assertEquals(stringsToArrayList(expected),
                     getSorter().sort(stringsToArrayList(source)));
    }

    public Sorter getSorter() {
        return new MergeSort();
    }

    public void testEmptySort()
    {
        assertSortsAs(new int[] {},
                      new int[] {});
    }

    public void testOneElementSort()
    {
        assertSortsAs(new int[] {1},
                      new int[] {1});
    }

    public void testTwoElementSort()
    {
        assertSortsAs(new int[] {1, 2},
                      new int[] {1, 2});
    }

    public void testActualTwoElementSort()
    {
        assertSortsAs(new int[] {1, 2},
                      new int[] {2, 1});
    }

    public void testActualTwoElementSortLongs()
    {
        assertSortsAs(new long[] {1, 2},
                      new long[] {2, 1});
    }

    public void testActualTwoElementSortStrings()
    {
        assertSortsAs(new String[] {"a", "b", "bar", "c", "foo"},
                      new String[] {"foo", "bar", "a", "b", "c"});
    }
}
