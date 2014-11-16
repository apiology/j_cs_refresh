package cc.broz.j_cs_refresh;

import java.util.ArrayList;
import junit.framework.TestCase;
import static cc.broz.j_cs_refresh.TestUtils.intsToArrayList;
import static cc.broz.j_cs_refresh.TestUtils.stringsToArrayList;
import static cc.broz.j_cs_refresh.TestUtils.longsToArrayList;

public class StringSortTester extends junit.framework.TestCase
{

    private ComparableSorter sorter;
    
    public ComparableSorter getSorter() {
        return sorter;
    }

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public StringSortTester(ComparableSorter sorter, String methodName)
    {
        super(methodName);
        this.sorter = sorter;
    }

    public void assertSortsAs(String[] expected,
                              String[] source) {
        ArrayList<String> arr = stringsToArrayList(source);
        getSorter().sort(arr);
        assertEquals(stringsToArrayList(expected),
                     arr);
    }

    public void testActualFiveElementSortStrings()
    {
        assertSortsAs(new String[] {"a", "b", "bar", "c", "foo"},
                      new String[] {"foo", "bar", "a", "b", "c"});
    }
}
