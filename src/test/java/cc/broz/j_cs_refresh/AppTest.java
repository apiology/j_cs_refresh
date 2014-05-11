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
public class AppTest
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    public ArrayList<Integer> toArrayList(int[] arr) {
        Collection<Integer> coll = Arrays.asList(ArrayUtils.toObject(arr));
        return new ArrayList<Integer>(coll);
    }

    public ArrayList<Integer> toArrayList(Integer... ints) {
        return new ArrayList<Integer>(Arrays.asList(ints));
    }

    public ArrayList<Integer> mergeSort(ArrayList<Integer> arr) {
        int size = arr.size();
        ArrayList<Integer> ret = new ArrayList<Integer>(size);
        if (size == 0) {
            return ret;
        }
        ret.add(arr.get(0));
        for (int i = 1; i < arr.size(); i++) {
            int insertableItem = arr.get(i);
            mergeSortInsert(insertableItem, ret);
        }
        return ret;
    }

    void mergeSortInsert(int newCandidateItem, ArrayList<Integer> sortedList) {
        int indexOfEmptySpace = sortedList.size();
        sortedList.add(-1);
        for( ; indexOfEmptySpace >= 0; indexOfEmptySpace--) {
            if (indexOfEmptySpace == 0) {
                sortedList.set(indexOfEmptySpace, newCandidateItem);
            } else {
                int existingCandidateItem =
                    sortedList.get(indexOfEmptySpace - 1);
                if (existingCandidateItem > newCandidateItem) {
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
