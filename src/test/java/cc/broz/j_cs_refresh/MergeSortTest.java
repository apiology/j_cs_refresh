package cc.broz.j_cs_refresh;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Arrays;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.apache.commons.lang3.ArrayUtils;

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

    public ArrayList<Integer> intsToArrayList(int[] arr) {
        Collection<Integer> coll = Arrays.asList(ArrayUtils.toObject(arr));
        return new ArrayList<Integer>(coll);
    }

    public ArrayList<String> stringsToArrayList(String... strings) {
        return new ArrayList<String>(Arrays.asList(strings));
    }

    public ArrayList<Integer> intsToArrayList(Integer... ints) {
        return new ArrayList<Integer>(Arrays.asList(ints));
    }

    public ArrayList<Long> longsToArrayList(long[] arr) {
        Collection<Long> coll = Arrays.asList(ArrayUtils.toObject(arr));
        return new ArrayList<Long>(coll);
    }


    public void assertSortsAs(int[] expected,
                              int[] source) {
        assertEquals(intsToArrayList(expected),
                     MergeSort.mergeSort(intsToArrayList(source)));
    }

    public void assertSortsAs(long[] expected,
                              long[] source) {
        assertEquals(longsToArrayList(expected),
                     MergeSort.mergeSort(longsToArrayList(source)));
    }

    public void assertSortsAs(String[] expected,
                              String[] source) {
        assertEquals(stringsToArrayList(expected),
                     MergeSort.mergeSort(stringsToArrayList(source)));
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
