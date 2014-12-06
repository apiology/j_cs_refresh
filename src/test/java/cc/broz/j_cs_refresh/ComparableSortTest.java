package cc.broz.j_cs_refresh;

import java.util.Collection;

public class ComparableSortTest {

    public static junit.framework.Test suite() {
        junit.framework.TestSuite suite = new junit.framework.TestSuite();
        addTests(suite, new MergeSort2());
        addTests(suite, new HeapSort(new JDKMinHeapFactory()));
        addTests(suite, new QuickSort2());
        addTests(suite, new InsertionSort());
        addTests(suite, new MergeSort());
        addTests(suite, new HeapSort(new VinceMinHeap2Factory()));
        addTests(suite, new HeapSort(new VinceMinHeapFactory()));
        addTests(suite, new QuickSort());
        addTests(suite, new VinceRealHeapSort2());
        addTests(suite, new InsertionSort2());
        return suite;
    }

    public static void addTests(junit.framework.TestSuite suite, ComparableSorter s) {
        // Integer is Comparable...
        TestMethodFinder.addToSuite(suite, IntegerSortTester.class,
                                    methodName ->
                                      new IntegerSortTester(
                                        new ComparableSorterToSorterAdapter<MyInteger>(s),
                                        methodName));
        TestMethodFinder.addToSuite(suite,
                                    LongSortTester.class,
                                    methodName ->
                                      new LongSortTester(
                                          new ComparableSorterToSorterAdapter<MyLong>(s),
                                          methodName));
        TestMethodFinder.addToSuite(suite, StringSortTester.class,
                                    methodName ->
                                       new StringSortTester(
                                           new ComparableSorterToSorterAdapter<MyString>(s),
                                           methodName));
    }
}
