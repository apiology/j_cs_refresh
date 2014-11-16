package cc.broz.j_cs_refresh;

import java.util.ArrayList;
import java.util.Collection;
import org.apache.commons.lang3.ArrayUtils;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Assorted utility methods
 */
public class TestUtils
{
    public static ArrayList<Integer> intsToArrayList(int[] arr) {
        Collection<Integer> coll = Arrays.asList(ArrayUtils.toObject(arr));
        return new ArrayList<Integer>(coll);
    }

    public static ArrayList<String> stringsToArrayList(String... strings) {
        return new ArrayList<String>(Arrays.asList(strings));
    }

    public static ArrayList<Integer> intsToArrayList(Integer... ints) {
        return new ArrayList<Integer>(Arrays.asList(ints));
    }

    public static ArrayList<MyLong> longsToArrayList(long[] arr) {
        Collection<Long> coll = Arrays.asList(ArrayUtils.toObject(arr));
		return new ArrayList<MyLong>(coll.stream().map(l -> new MyLong(l))
									 .collect(Collectors.toList()));
    }
}
