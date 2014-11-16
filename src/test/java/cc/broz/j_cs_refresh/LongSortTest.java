package cc.broz.j_cs_refresh;

import java.util.Collection;

public class LongSortTest {

    public static junit.framework.Test suite() {
        junit.framework.TestSuite suite = new junit.framework.TestSuite();
        addTests(suite, new RadixSort());
        return suite;
    }

    public static void addTests(junit.framework.TestSuite suite, Sorter<Long> s) {
        TestMethodFinder.addToSuite(suite, LongSortTester.class,
                                    methodName -> new LongSortTester(s, methodName));
        //TestMethodFinder.addToSuite(suite, IntegerSortTester.class,
        //                          methodName -> new IntegerSortTester(s, methodName));
    }
}
