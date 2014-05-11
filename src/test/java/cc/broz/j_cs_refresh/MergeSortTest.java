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

    public ArrayList<Integer> toArrayList(int[] arr) {
        Collection<Integer> coll = Arrays.asList(ArrayUtils.toObject(arr));
        return new ArrayList<Integer>(coll);
    }

    public ArrayList<Integer> toArrayList(Integer... ints) {
        return new ArrayList<Integer>(Arrays.asList(ints));
    }

    public <I extends Comparable> ArrayList<I>
                      mergeSort(ArrayList<I> arr) {
        int size = arr.size();
        ArrayList<I> ret = new ArrayList<I>(size);
        if (size == 0) {
            return ret;
        }
        ret.add(arr.get(0));
        for (int i = 1; i < arr.size(); i++) {
            I insertableItem = arr.get(i);
            mergeSortInsert(insertableItem, ret);
        }
        return ret;
    }

    <I extends Comparable> void mergeSortInsert(I newCandidateItem,
                                                ArrayList<I> sortedList) {
        int indexOfEmptySpace = sortedList.size();
        sortedList.add(null);
        for( ; indexOfEmptySpace >= 0; indexOfEmptySpace--) {
            if (indexOfEmptySpace == 0) {
                sortedList.set(indexOfEmptySpace, newCandidateItem);
            } else {
                I existingCandidateItem =
                    sortedList.get(indexOfEmptySpace - 1);
                if (existingCandidateItem.compareTo(newCandidateItem) > 0) {
                    sortedList.set(indexOfEmptySpace, existingCandidateItem);
                } else {
                    sortedList.set(indexOfEmptySpace, newCandidateItem);
                    break;
                }
            }
        }
    }

    public void assertSortsAs(int[] expected,
                              int[] source) {
        assertEquals(toArrayList(expected), mergeSort(toArrayList(source)));
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
