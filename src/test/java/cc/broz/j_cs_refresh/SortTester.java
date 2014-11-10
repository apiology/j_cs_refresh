package cc.broz.j_cs_refresh;

import java.util.ArrayList;
import junit.framework.TestCase;
import static cc.broz.j_cs_refresh.TestUtils.intsToArrayList;
import static cc.broz.j_cs_refresh.TestUtils.stringsToArrayList;
import static cc.broz.j_cs_refresh.TestUtils.longsToArrayList;


public abstract class SortTester
    extends TestCase
{

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public SortTester(String testName)
    {
        super(testName);
    }

    public void assertSortsAs(int[] expected,
                              int[] source) {
		ArrayList<Integer> arr = intsToArrayList(source);
		getSorter().sort(arr);
        assertEquals(intsToArrayList(expected),
                     arr);
    }

    public void assertSortsAs(long[] expected,
                              long[] source) {
		ArrayList<Long> arr = longsToArrayList(source);		
		getSorter().sort(arr);
        assertEquals(longsToArrayList(expected),
					 arr);
    }

    public void assertSortsAs(String[] expected,
                              String[] source) {
		ArrayList<String> arr = stringsToArrayList(source);
		getSorter().sort(arr);
        assertEquals(stringsToArrayList(expected),
                     arr);
    }

    public abstract Sorter getSorter();

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

    public void testActualFiveElementSortLongs()
    {
        assertSortsAs(new long[] {1, 2, 3, 4, 5},
                      new long[] {2, 1, 3, 5, 4});
    }

    public void testActualFiveElementSortStrings()
    {
        assertSortsAs(new String[] {"a", "b", "bar", "c", "foo"},
                      new String[] {"foo", "bar", "a", "b", "c"});
    }
}
