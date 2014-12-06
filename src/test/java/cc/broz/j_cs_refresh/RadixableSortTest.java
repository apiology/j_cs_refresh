package cc.broz.j_cs_refresh;

import java.util.Collection;

public class RadixableSortTest {

    public static junit.framework.Test suite() {
        junit.framework.TestSuite suite = new junit.framework.TestSuite();
        TestMethodFinder.addToSuite(suite,
                                    LongSortTester.class,
                                    methodName -> new LongSortTester(new RadixSort(9),
                                                                     methodName));
        TestMethodFinder.addToSuite(suite,
                                    IntegerSortTester.class,
                                    methodName -> new IntegerSortTester(new RadixSort(9),
                                                                        methodName));
        TestMethodFinder.addToSuite(suite,
                                    StringSortTester.class,
                                    methodName -> new StringSortTester(new RadixSort(52),
                                                                       methodName));
        return suite;
    }
}
