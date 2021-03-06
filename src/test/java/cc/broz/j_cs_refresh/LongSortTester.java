package cc.broz.j_cs_refresh;

import java.util.ArrayList;
import junit.framework.TestCase;
import static cc.broz.j_cs_refresh.TestUtils.intsToArrayList;
import static cc.broz.j_cs_refresh.TestUtils.stringsToArrayList;
import static cc.broz.j_cs_refresh.TestUtils.longsToArrayList;

public class LongSortTester extends junit.framework.TestCase
{

    Sorter<? super MyLong> sorter;
    
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public LongSortTester(Sorter<? super MyLong> sorter, String methodToTest)
    {
        super(methodToTest);
        this.sorter = sorter;
    }

    public void assertSortsAs(long[] expected,
                              long[] source) {
        ArrayList<MyLong> arr = longsToArrayList(source);
        sorter.sort(arr);
        assertEquals(longsToArrayList(expected),
                     arr);
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
}
