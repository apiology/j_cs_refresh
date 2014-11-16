package cc.broz.j_cs_refresh;

import java.util.ArrayList;
import junit.framework.TestCase;
import static cc.broz.j_cs_refresh.TestUtils.intsToArrayList;
import static cc.broz.j_cs_refresh.TestUtils.stringsToArrayList;
import static cc.broz.j_cs_refresh.TestUtils.longsToArrayList;

// XXX Integer vs Number
public class IntegerSortTester extends junit.framework.TestCase
{

	Sorter<? super Integer> sorter;
	
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public IntegerSortTester(Sorter<? super Integer> sorter, String methodToTest)
    {
		super(methodToTest);
		this.sorter = sorter;
    }

	public void assertSortsAs(int[] expected,
                              int[] source) {
		ArrayList<Integer> arr = intsToArrayList(source);
		sorter.sort(arr);
        assertEquals(intsToArrayList(expected),
					 arr);
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

}
